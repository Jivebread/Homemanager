package com.example.lg.homemanager3.lastsegemnt;

import android.app.Activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import android.widget.ToggleButton;

import com.example.lg.homemanager3.R;

import com.example.lg.homemanager3.model.Laundry;

/**
 * Created by LG on 10/22/2016.
 */

public class Dryer extends Activity {
    private Button mButton;
    private ToggleButton mToggleButton;
    private ToggleButton mToggleButton2;

    Laundry laundry = new Laundry();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dryer_layout);
            mButton = (Button) findViewById(R.id.DryerSetid);
            mToggleButton = (ToggleButton) findViewById(R.id.DryerCycleToggleid);
            mToggleButton2 = (ToggleButton) findViewById(R.id.DryerRunningToggleid);


            mButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (mToggleButton.isChecked()) {
                        laundry.setDryerDoorIsClosed(true);


                    } else {
                        laundry.setDryerDoorIsClosed(false);

                    }
                    if (mToggleButton2.isChecked()) {
                        laundry.setDryerIsRunning(true);


                    } else {
                        laundry.setDryerIsRunning(false);

                    }
                }
            });



    }
}
