package com.example.lg.homemanager3;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.lg.homemanager3.Fragment.KitchenFragment;
import com.example.lg.homemanager3.Fragment.LaundryFragment;
import com.example.lg.homemanager3.Fragment.TemperatureFragment;

/**
 * Created by Team Simon on 10/21/2016.
 */

public class PagerAdapter extends FragmentStatePagerAdapter {
    private int mNumOfTabs;

    public PagerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs= NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                KitchenFragment tab1 = new KitchenFragment();
                return tab1;
            case 1:
                LaundryFragment tab2 = new LaundryFragment();
                return tab2;
            case 2:
                TemperatureFragment tab3 = new TemperatureFragment();
                return tab3;
            default:
                return null;

    }


}

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}