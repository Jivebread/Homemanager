package com.example.lg.homemanager3;



import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lg.homemanager3.lastsegemnt.AirConditioner;
import com.example.lg.homemanager3.lastsegemnt.DishWasher;
import com.example.lg.homemanager3.lastsegemnt.Oven;
import com.example.lg.homemanager3.lastsegemnt.RefrigeratorActivity;
import com.example.lg.homemanager3.lastsegemnt.WaterHeater;
import com.example.lg.homemanager3.model.Kitchen;
import com.example.lg.homemanager3.model.Utility;

/**
 * Created by LG on 10/21/2016.
 */

public class ListTemperatureAdapter extends RecyclerView.Adapter {
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

                return Utility.appliance.length  ;

    }
    private class ListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView mTextView;
        public ImageView mImageView;
        public ListViewHolder(View itemView) {

            super(itemView);
            mTextView = (TextView) itemView.findViewById(R.id.item_name);
            mImageView = (ImageView) itemView.findViewById(R.id.item_image);
            itemView.setOnClickListener(this);
        }
        public void bindView (int position){

                    mTextView.setText(Utility.appliance[position]);
                    mImageView.setImageResource(Utility.resourcesIds[position]);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String name = mTextView.getText().toString();
                    Intent intent= new Intent();
                    if (name == "Water Heater")
                        intent = new Intent(itemView.getContext(), WaterHeater.class);
                    else if (name == "Air Conditioner")
                        intent = new Intent(itemView.getContext(), AirConditioner.class);


                    intent.putExtra("NAME",name);
                    itemView.getContext().startActivity(intent);

                }
            });
            }





        @Override
        public void onClick(View view) {

        }
    }
}