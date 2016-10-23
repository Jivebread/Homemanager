package com.example.lg.homemanager3.lastsegemnt;

import android.app.Activity;
import android.content.Context;
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

public class WaterHeater extends Activity {

    private Button mButton;
    private ToggleButton mToggleButton;
    private boolean maintenancealert;
    private boolean heaterrunning;
    private TextView currentTemp;

    private Utility utility = new Utility();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.waterheater_layout);
        mButton = (Button) findViewById(R.id.waterheaterset);
        mToggleButton = (ToggleButton) findViewById(R.id.WaterHeaterRunningToggleid);
        currentTemp = (TextView) findViewById(R.id.Warningid);
        
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (mToggleButton.isChecked()) {
                    utility.setWaterHeaterisRunning(true);


                } else {
                    utility.setWaterHeaterisRunning(false);

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
                    String jsonData = response.body().string();
                    if (response.isSuccessful()) {
                        try {
                            utility = getutilDetails(jsonData);
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
        } else {
            Toast.makeText(this, "Network is unavailable", Toast.LENGTH_LONG).show();
        }

    }

    private void updateDisplay() {
        currentTemp.setText(utility.getCurrentWaterTemp()+"");
    }

    private Utility getutilDetails(String jsonData) throws JSONException {
        JSONObject utilitys = new JSONObject(jsonData);
        JSONObject utilityz = utilitys.getJSONObject("appliances").getJSONObject("waterHeater");
        Utility utilityking = new Utility();
        utilityking.setCurrentWaterTemp(utilityz.getInt("currentWaterTemp"));
        utilityking.setMaintenaceAlert(utilityz.getBoolean("maintenanceAlert"));
        utilityking.setWaterHeaterisRunning(utilityz.getBoolean("currentWaterTemp"));
        return utilityking;
    }


    public boolean isNetworkAvailable() {
        ConnectivityManager manager = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = manager.getActiveNetworkInfo();
        boolean isAvailable = false;
        if (networkInfo != null && networkInfo.isConnected()) {
            isAvailable = true;
        }
        return isAvailable;
    }

}



