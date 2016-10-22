package com.example.lg.homemanager3;



import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.lg.homemanager3.Fragment.KitchenFragment;
import com.example.lg.homemanager3.Fragment.LaundryFragment;
import com.example.lg.homemanager3.Fragment.List_fragment;
import com.example.lg.homemanager3.Fragment.OnFragmentSelectedInterface;
import com.example.lg.homemanager3.Fragment.TemperatureFragment;
import com.example.lg.homemanager3.Fragment.ViewPagerFragment;
import com.example.lg.homemanager3.model.Kitchen;
import com.example.lg.homemanager3.model.Laundry;
import com.example.lg.homemanager3.model.Utility;

import org.w3c.dom.Text;

import static android.R.id.list;
import static com.example.lg.homemanager3.PagerAdapter.tabposition;
import static java.security.AccessController.getContext;

/**
 * Created by LG on 10/21/2016.
 */

public class ListAdapter extends RecyclerView.Adapter {
    private final OnFragmentSelectedInterface mListener;
    public ListAdapter(OnFragmentSelectedInterface listener){
        mListener = listener;
    };
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((ListViewHolder) holder).bindView(position );
    }

    @Override
    public int getItemCount() {

                return Kitchen.appliance.length ;

    }
    private class ListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView mTextView;
        public ImageView mImageView;
        private int mIndex;
        public ListViewHolder(View itemView) {

            super(itemView);
            mTextView = (TextView) itemView.findViewById(R.id.item_name);
            mImageView = (ImageView) itemView.findViewById(R.id.item_image);
            itemView.setOnClickListener(this);
        }
        public void bindView (int position){
                    mIndex = position;
                    mTextView.setText(Kitchen.appliance[position]);
                    mImageView.setImageResource(Kitchen.resourcesIds[position]);
                    itemView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent intent = new Intent(itemView.getContext(), RefrigeratorActivity.class);
                            itemView.getContext().startActivity(intent);

                        }
                    });
            }








        @Override
        public void onClick(View view) {
        mListener.onListFragmentSelected(mIndex);
        }
    }
}