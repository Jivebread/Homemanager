package com.example.lg.homemanager3.lastsegemnt;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.example.lg.homemanager3.R;
import com.example.lg.homemanager3.model.Kitchen;
import com.example.lg.homemanager3.model.Laundry;
import com.example.lg.homemanager3.model.Utility;

import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by LG on 10/22/2016.
 */

public class RefrigeratorActivity extends Activity {
    private Button mButton;
    private ToggleButton mToggleButton;
    private ToggleButton mToggleButton2;
    private TextView RefrigTemp;
    private TextView DesiredTemp;
    private TextView Filterremained;
    Kitchen kitchendata = new Kitchen();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.refrigerator_layout);
         RefrigTemp = (TextView) findViewById(R.id.textView24);
         DesiredTemp = (TextView) findViewById(R.id.textView25);
        Filterremained = (TextView) findViewById(R.id.textView26);
        mButton = (Button)findViewById(R.id.refrigeratorsetid);
        mToggleButton = (ToggleButton) findViewById(R.id.toggleButton7);
        mToggleButton2 = (ToggleButton) findViewById(R.id.toggleButton8);
       /* mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (mToggleButton.isChecked()) {
                    kitchendata.setFridgeDoorIsClosed(true);


                } else {
                    kitchendata.setFridgeDoorIsClosed(false);

                }
                if (mToggleButton2.isChecked()) {
                    kitchendata.setFridgeIsRunning(true);


                } else {
                    kitchendata.setFridgeIsRunning(false);

                }
                Toast.makeText(getApplicationContext(), "Updated", Toast.LENGTH_LONG).show();

            }
        });
        */
        if (isNetworkAvailable()) {
            String jsonUrl = "http://spectrum.troy.edu/CSClub/json/appliance_data_v04.json";
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder().url(jsonUrl).build();
            Call call = client.newCall(request);
            call.enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {

                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    String jsonData =response.body().string();
                    if(response.isSuccessful()){
                        try {
                            kitchendata = getkitchenDetails(jsonData);
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    updateDisplay();
                                }
                            });
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }
            });
        }
        else{
            Toast.makeText(this, "Network is unavailable",Toast.LENGTH_LONG).show();
        }

    }

    private void updateDisplay() {
        RefrigTemp.setText(kitchendata.getCurrentFridgeTemp()+"");
        DesiredTemp.setText(kitchendata.getDesiredFridgeTemp()+"");
        Filterremained.setText(kitchendata.getWaterFilterDaysRemaining()+"");
    }


    private Kitchen getkitchenDetails(String jsonData) throws JSONException {
        JSONObject kitchen = new JSONObject(jsonData);
        JSONObject kitchenz = kitchen.getJSONObject("fridge");
        Kitchen kitchenking = new Kitchen();
        kitchenking.setFridgeDoorIsClosed(kitchenz.getBoolean("fridgeDoorIsClose"));
        kitchenking.setFridgeIsRunning(kitchenz.getBoolean("fridgeIsRunning"));
        kitchenking.setCurrentFridgeTemp(kitchenz.getInt("currentFridgeTemp"));
        kitchenking.setDesiredFridgeTemp(kitchenz.getInt("desiredFridgeTemp"));
        kitchenking.setWaterFilterDaysRemaining(kitchenz.getInt("waterFilterDaysRemaining"));

        return kitchenking;
    }

    private boolean isNetworkAvailable() {
        ConnectivityManager manager = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = manager.getActiveNetworkInfo();
        boolean isAvailable = false;
        if (networkInfo != null && networkInfo.isConnected()){
            isAvailable = true;
        }
        return isAvailable;
    }











    }

