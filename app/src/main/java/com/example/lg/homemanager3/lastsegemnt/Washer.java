package com.example.lg.homemanager3.lastsegemnt;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.example.lg.homemanager3.R;
import com.example.lg.homemanager3.model.Laundry;

/**
 * Created by LG on 10/22/2016.
 */

public class Washer extends Activity {
    private Button mButton;
    private ToggleButton mToggleButton;
    private ToggleButton mToggleButton2;

    Laundry laundry = new Laundry();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.washer_layout);
        mButton = (Button) findViewById(R.id.WasherSetid);
        mToggleButton = (ToggleButton) findViewById(R.id.WasherRunningToggleid);
        mToggleButton2 = (ToggleButton) findViewById(R.id.WasherDoorClosedToggle);


        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (mToggleButton.isChecked()) {
                    laundry.setClothesWasherIsRunning(true);


                } else {
                    laundry.setClothesWasherIsRunning(false);

                }
                if (mToggleButton2.isChecked()) {
                    laundry.setClothesWasherDoorIsClosed(true);


                } else {
                    laundry.setClothesWasherDoorIsClosed(false);

                }
            }
        });

    }
}