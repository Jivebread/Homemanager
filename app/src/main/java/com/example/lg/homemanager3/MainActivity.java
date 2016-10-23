package com.example.lg.homemanager3;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

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

public class MainActivity extends AppCompatActivity {
    static public Kitchen kitchendata = new Kitchen();
    static public Laundry laundrydata = new Laundry();
    static public Utility utilitya = new Utility();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Menu");
        setSupportActionBar(toolbar);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText("Kitchen"));
        tabLayout.addTab(tabLayout.newTab().setText("Laundry"));
        tabLayout.addTab(tabLayout.newTab().setText("Temperature"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        final PagerAdapter adapter = new PagerAdapter
                (getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

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
                            kitchendata = getkitchenDetails(jsonData);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        try {
                            laundrydata = getlaundryDetails(jsonData);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        try {
                            utilitya = getutilDetails(jsonData);
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
    private Utility getutilDetails(String jsonData) throws JSONException{
        JSONObject utilitys = new JSONObject(jsonData);
        JSONObject utilityz = utilitys.getJSONObject("appliances").getJSONObject("waterHeater");
        Utility utilityking = new Utility();
        utilityking.setCurrentWaterTemp(utilityz.getInt("currentWaterTemp"));
        utilityking.setMaintenaceAlert(utilityz.getBoolean("maintenanceAlert"));
        utilityking.setWaterHeaterisRunning(utilityz.getBoolean("currentWaterTemp"));
        return utilityking;
    }
    private Laundry getlaundryDetails(String jsonData) throws JSONException {
        JSONObject  laundry= new JSONObject(jsonData);
        JSONObject laundryz = laundry.getJSONObject("appliances").getJSONObject("washer");
        Laundry laundryking = new Laundry();
        laundryking.setClothesWasherDoorIsClosed(laundryz.getBoolean("clothesWasherIsRunning"));
        laundryking.setClothesWasherIsRunning(laundryz.getBoolean("clothesWasherDoorIsClosed"));
        return laundryking;
    }


    private Kitchen getkitchenDetails(String jsonData) throws JSONException {
        JSONObject kitchen = new JSONObject(jsonData);
        JSONObject kitchenz = kitchen.getJSONObject("appliances").getJSONObject("fridge");
        Kitchen kitchenking = new Kitchen();

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
