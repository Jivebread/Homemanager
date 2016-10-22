package com.example.lg.homemanager3;



import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lg.homemanager3.model.Kitchen;
import com.example.lg.homemanager3.model.Laundry;

/**
 * Created by LG on 10/21/2016.
 */

public class ListLaundryAdapter extends RecyclerView.Adapter {
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

                return Laundry.appliance.length  ;

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

                    mTextView.setText(Laundry.appliance[position]);
                    mImageView.setImageResource(Laundry.resourcesIds[position]);
            }





        @Override
        public void onClick(View view) {

        }
    }
}