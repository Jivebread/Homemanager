package com.example.lg.homemanager3.lastsegemnt;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.example.lg.homemanager3.R;
import com.example.lg.homemanager3.model.Kitchen;
import com.example.lg.homemanager3.model.Utility;

/**
 * Created by LG on 10/22/2016.
 */

public class DishWasher extends Activity {
    private Button mButton;
    private ToggleButton mToggleButton;
    private ToggleButton mToggleButton2;
    Kitchen kitchen = new Kitchen();
    private TextView Cycleid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dishwasher_layout);


            TextView WasherDoorClosedid = (TextView) findViewById(R.id.WasherDoorClosedid);
            Cycleid = (TextView) findViewById(R.id.Cycleid);

            TextView DishWasherRunningid = (TextView) findViewById(R.id.DishWasherRunningid);

            mButton = (Button) findViewById(R.id.WasherSetid);
            mToggleButton = (ToggleButton) findViewById(R.id.WasherDoorClosedtoggleid);
        mToggleButton2 = (ToggleButton) findViewById(R.id.WasherRunningid);
        Cycleid.setText(kitchen.getDishWasherCurrentCycle());
            mButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (mToggleButton.isChecked()) {
                        kitchen.setDishWasherIsRunning(true);


                    } else {
                        kitchen.setDishWasherIsRunning(false);

                    }
                    if (mToggleButton2.isChecked()) {
                        kitchen.setDishWasherIsRunning(true);


                    } else {
                        kitchen.setDishWasherIsRunning(false);

                    }
                }
            });






        }
    }