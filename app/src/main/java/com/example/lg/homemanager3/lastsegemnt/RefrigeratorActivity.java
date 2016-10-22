package com.example.lg.homemanager3.lastsegemnt;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.lg.homemanager3.R;

import static android.R.attr.name;
import static com.example.lg.homemanager3.R.string.Kitchen;

/**
 * Created by LG on 10/22/2016.
 */

public class RefrigeratorActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.refrigerator_layout);
        Intent intent = getIntent();
        String name = intent.getStringExtra("NAME");
            TextView mtextView = (TextView) findViewById(R.id.textView2);
            mtextView.setText("Refrigerator");



    }
}
