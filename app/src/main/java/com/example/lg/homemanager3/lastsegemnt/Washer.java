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

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import static com.example.lg.homemanager3.MainActivity.laundrydata;

/**
 * Created by LG on 10/22/2016.
 */

public class Washer extends Activity {
    private Button mButton;
    private ToggleButton mToggleButton;
    private ToggleButton mToggleButton2;
    private TextView mwashercycle;
    private TextView mwasherType;
    Laundry laundrydata = new Laundry();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.washer_layout);
        mButton = (Button) findViewById(R.id.WasherSetid);
        mToggleButton = (ToggleButton) findViewById(R.id.WasherRunningToggleid);
        mToggleButton2 = (ToggleButton) findViewById(R.id.WasherDoorClosedToggle);
        mwashercycle = (TextView) findViewById(R.id.WasherCycleValueid);
        mwasherType = (TextView) findViewById(R.id.WasherCycleTypeToggleid);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (mToggleButton.isChecked()) {
                    laundrydata.setClothesWasherIsRunning(true);


                } else {
                    laundrydata.setClothesWasherIsRunning(false);

                }
                if (mToggleButton2.isChecked()) {
                    laundrydata.setClothesWasherDoorIsClosed(true);


                } else {
                    laundrydata.setClothesWasherDoorIsClosed(false);

                }
                Toast.makeText(getApplicationContext(), "Updated", Toast.LENGTH_LONG).show();
            }
        });
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
                            laundrydata = getlaundryDetails(jsonData);
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
        mwasherType.setText(laundrydata.getClothesWasherCycleType());
        mwashercycle.setText(laundrydata.getClothesWasherCycleSize());
    }


    private Laundry getlaundryDetails(String jsonData) throws JSONException {
        JSONObject  laundry= new JSONObject(jsonData);
        JSONObject laundryz = laundry.getJSONObject("appliances").getJSONObject("washer");
        Laundry laundryking = new Laundry();
        laundryking.setClothesWasherCycleType(laundryz.getString("clothesWasherCycleType"));
        laundryking.setClothesWasherCycleSize(laundryz.getString("clothesWasherCycleSize"));
        return laundryking;
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
