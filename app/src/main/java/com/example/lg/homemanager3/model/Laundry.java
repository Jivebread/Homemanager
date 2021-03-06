package com.example.lg.homemanager3.model;

import com.example.lg.homemanager3.R;

/**
 * Created by LG on 10/22/2016.
 */

public class Laundry {
    // add cycle type and cycle time for washer/dryer?  is this an enum?
    public static String [] appliance = {"Washer","Dryer"};
    public static int [] resourcesIds = new int []{R.drawable.washingmachine,R.drawable.ryer};
    private boolean clothesWasherIsRunning;
    private boolean clothesWasherDoorIsClosed;
    private String clothesWasherCycleSize;
    private String clothesWasherCycleType;

    public String getClothesWasherCycleSize() {
        return clothesWasherCycleSize;
    }

    public void setClothesWasherCycleSize(String clothesWasherCycleSize) {
        this.clothesWasherCycleSize = clothesWasherCycleSize;
    }

    public String getClothesWasherCycleType() {
        return clothesWasherCycleType;
    }

    public void setClothesWasherCycleType(String clothesWasherCycleType) {
        this.clothesWasherCycleType = clothesWasherCycleType;
    }

    private boolean dryerIsRunning;
    private boolean dryerDoorIsClosed;

    public boolean isClothesWasherIsRunning() {
        return clothesWasherIsRunning;
    }

    public void setClothesWasherIsRunning(boolean clothesWasherIsRunning) {
        this.clothesWasherIsRunning = clothesWasherIsRunning;
    }

    public boolean isClothesWasherDoorIsClosed() {
        return clothesWasherDoorIsClosed;
    }

    public void setClothesWasherDoorIsClosed(boolean clothesWasherDoorIsClosed) {
        this.clothesWasherDoorIsClosed = clothesWasherDoorIsClosed;
    }

    public boolean isDryerIsRunning() {
        return dryerIsRunning;
    }

    public void setDryerIsRunning(boolean dryerIsRunning) {
        this.dryerIsRunning = dryerIsRunning;
    }

    public boolean isDryerDoorIsClosed() {
        return dryerDoorIsClosed;
    }

    public void setDryerDoorIsClosed(boolean dryerDoorIsClosed) {
        this.dryerDoorIsClosed = dryerDoorIsClosed;
    }
}

