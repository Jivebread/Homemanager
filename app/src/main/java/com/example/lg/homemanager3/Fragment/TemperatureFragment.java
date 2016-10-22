package com.example.lg.homemanager3.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lg.homemanager3.R;

import static android.R.attr.fragment;

/**
 * Created by Team Simon on 10/21/2016.
 */

public class TemperatureFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.temperaturefragment, container, false);
    }
}
