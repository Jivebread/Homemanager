package com.example.lg.homemanager3.lastsegemnt;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.example.lg.homemanager3.R;
import com.example.lg.homemanager3.model.Kitchen;

/**
 * Created by LG on 10/22/2016.
 */

public class Oven extends Activity {
    private Button mButton;
    private ToggleButton mToggleButton;
    private ToggleButton mToggleButton2;
    private TextView ovenTemp;
    private TextView desiredoventemp;
    Kitchen kitchen = new Kitchen();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.oven_layout);

            ovenTemp    = (TextView) findViewById(R.id.RealCurrentTempid);
            desiredoventemp = (TextView) findViewById(R.id.DesiredOvenTempid);



            mButton = (Button)findViewById(R.id.ovensetid2);
            mToggleButton = (ToggleButton) findViewById(R.id.ClosedToggleid);
            mToggleButton2 = (ToggleButton) findViewById(R.id.RunningToggleid);
             ovenTemp.setText(kitchen.getCurrentOvenTemp()+"");
            desiredoventemp.setText(kitchen.getDesiredOvenTemp()+"");
            mButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (mToggleButton.isChecked()) {
                        kitchen.setOvenIsRunning(true);


                    } else {
                        kitchen.setOvenIsRunning(false);

                    }
                    if (mToggleButton2.isChecked()) {
                        kitchen.setOvenDoorIsClosed(true);


                    } else {
                        kitchen.setOvenDoorIsClosed(false);

                    }

                }
            });






        }



    }
