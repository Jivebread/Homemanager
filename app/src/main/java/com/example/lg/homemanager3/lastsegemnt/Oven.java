package com.example.lg.homemanager3.lastsegemnt;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.lg.homemanager3.R;

/**
 * Created by LG on 10/22/2016.
 */

public class Oven extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.oven_layout);
        Intent intent = getIntent();
        String name = intent.getStringExtra("NAME");
        TextView mtextView = (TextView) findViewById(R.id.textView3);
        mtextView.setText("Oven");



    }
}