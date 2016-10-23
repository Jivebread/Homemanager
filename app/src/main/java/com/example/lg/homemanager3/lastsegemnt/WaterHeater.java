package com.example.lg.homemanager3.lastsegemnt;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.example.lg.homemanager3.R;
import com.example.lg.homemanager3.model.Utility;

/**
 * Created by LG on 10/22/2016.
 */

public class WaterHeater extends Activity {

        private Button mButton;
        private ToggleButton mToggleButton;
        private  TextView Warning;

        Utility utility = new Utility();
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.waterheater_layout);
            mButton = (Button) findViewById(R.id.waterheaterset);
            mToggleButton = (ToggleButton) findViewById(R.id.WaterHeaterRunningToggleid);

           Warning = (TextView) findViewById(R.id.Warningid);


            mButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (mToggleButton.isChecked()) {
                        utility.setWaterHeaterisRunning(true);


                    } else {
                        utility.setWaterHeaterisRunning(false);

                    }




                }
            });




        }
}
