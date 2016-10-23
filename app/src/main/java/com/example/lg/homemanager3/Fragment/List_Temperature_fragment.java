package com.example.lg.homemanager3.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.lg.homemanager3.ListTemperatureAdapter;
import com.example.lg.homemanager3.R;

/**
 * Created by LG on 10/22/2016.
 */

public class List_Temperature_fragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_list,container,false);
        RecyclerView recyclerview = (RecyclerView) view.findViewById(R.id.listRecyclerView);
        ListTemperatureAdapter listAdapter = new ListTemperatureAdapter();
        recyclerview.setAdapter(listAdapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerview.setLayoutManager(layoutManager);
        return view;
    }
}
