package com.example.lg.homemanager3.lastsegemnt;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.example.lg.homemanager3.R;
import com.example.lg.homemanager3.model.Utility;

/**
 * Created by LG on 10/22/2016.
 */

public class AirConditioner extends Activity {
    private Button mButton;
    private ToggleButton mToggleButton;
    Utility utility = new Utility();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.airconditioner_layout);


        TextView AirConRunnigid = (TextView) findViewById(R.id.AirConRunnigid);
        TextView DesiredAirTempid = (TextView) findViewById(R.id.DesiredAirTempid);
        TextView AirFilterDaysid = (TextView) findViewById(R.id.AirFilterDaysid);
        TextView CurrentAirTempid = (TextView) findViewById(R.id.CurrentAirTempid);
        TextView FilterDaysLeftValueid = (TextView) findViewById(R.id.FilterDaysLeftValueid);
        TextView DesiredAirTempValueid = (TextView) findViewById(R.id.DesiredAirTempValueid);
        mButton = (Button) findViewById(R.id.AirConSetid);
        mToggleButton = (ToggleButton) findViewById(R.id.AirConRunningToggleid);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (mToggleButton.isChecked()) {
                    utility.setAirConIsRunning(true);


                } else {
                    utility.setAirConIsRunning(false);

                }
            }
        });
        CurrentAirTempid.setText(utility.getCurrentAirTemp()+"");
        DesiredAirTempValueid.setText(utility.getDesiredAirTemp()+"");
        FilterDaysLeftValueid.setText(utility.getAirConFilterDaysRemaining()+"");
        AirConRunnigid.setText(utility.getCurrentAirTemp()+"");
        CurrentAirTempid.setText(utility.getCurrentAirTemp()+"");




    }
}
