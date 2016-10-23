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

import org.w3c.dom.Text;

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
    Kitchen kitchen = new Kitchen();
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

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (mToggleButton.isChecked()) {
                    kitchen.setFridgeDoorIsClosed(true);


                } else {
                    kitchen.setFridgeDoorIsClosed(false);

                }
                if (mToggleButton2.isChecked()) {
                    kitchen.setFridgeIsRunning(true);


                } else {
                    kitchen.setFridgeIsRunning(false);

                }
                RefrigTemp.setText(kitchen.getCurrentFridgeTemp()+"");
                DesiredTemp.setText(kitchen.getDesiredFridgeTemp()+"");
            }
        });









    }
}
