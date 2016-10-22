package com.example.lg.homemanager3.model;

/**
 * Created by User0 on 10/21/2016.
 */

public class Laundry {

    // add cycle type and cycle time for washer/dryer?  is this an enum?

    private boolean clothesWasherIsRunning;
    private boolean clothesWasherDoorIsClosed;
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
