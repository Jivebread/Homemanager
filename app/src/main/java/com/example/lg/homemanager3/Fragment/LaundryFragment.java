package com.example.lg.homemanager3.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lg.homemanager3.R;

/**
 * Created by Team Simon on 10/21/2016.
 */

public class LaundryFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        List_Laundry_fragment fragment = new List_Laundry_fragment();
        FragmentManager fragmentManager =getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.placeholder2, fragment);
        fragmentTransaction.commit();
        return inflater.inflate(R.layout.laundryfragment, container, false);
    }
}
