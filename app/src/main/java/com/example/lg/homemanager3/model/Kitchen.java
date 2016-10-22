package com.example.lg.homemanager3.model;

import com.example.lg.homemanager3.R;

/**
 * Created by LG on 10/22/2016.
 */

public class Kitchen {
    public static String [] appliance = {"Refrigerator","Dish Washer" ,"Oven"};
    public static int [] resourcesIds = new int []{R.drawable.refrigerator,R.drawable.dishwasher,R.drawable.ven};
    private boolean fridgeIsRunning = false;
    private boolean fridgeDoorIsClosed = false;
    private int currentFridgeTemp = 0;
    private int desiredFridgeTemp = 0;
    private int waterFilterDaysRemaining = 0;

    private boolean ovenIsRunning = false;
    private boolean ovenDoorIsClosed = false;
    private int currentOvenTemp = 0;
    private int desiredOvenTemp = 0;

    private boolean dishWasherIsRunning = false;
    private boolean dishWasherDoorIsClosed = false;
    private String dishWasherCurrentCycle = " ";

    public boolean isFridgeIsRunning() {
        return fridgeIsRunning;
    }
    public boolean isFridgeDoorIsClosed() {
        return fridgeDoorIsClosed;
    }
    public int getCurrentFridgeTemp() {
        return currentFridgeTemp;
    }
    public int getDesiredFridgeTemp() {
        return desiredFridgeTemp;
    }
    public int getWaterFilterDaysRemaining() {
        return waterFilterDaysRemaining;
    }
    public void incrementDesiredFridgeTemp() {
        this.desiredFridgeTemp = this.desiredFridgeTemp + 1;}
    public void decrementDesiredFridgeTemp() {
        this.desiredFridgeTemp = this.desiredFridgeTemp - 1;}

    public boolean isOvenIsRunning() {return ovenIsRunning; }
    public boolean isOvenDoorIsClosed() {
        return ovenDoorIsClosed;
    }
    public int getCurrentOvenTemp() {
        return currentOvenTemp;
    }
    public int getDesiredOvenTemp() {
        return desiredOvenTemp;
    }
    public void setOvenIsRunning(boolean ovenIsRunning) {
        this.ovenIsRunning = ovenIsRunning;}
    public void incrementDesiredOvenTemp() {
        this.desiredOvenTemp = this.desiredOvenTemp + 25;}
    public void decrementDesiredOvenTemp() {
        this.desiredOvenTemp = this.desiredOvenTemp - 25;}

    public boolean isDishWasherIsRunning() {
        return dishWasherIsRunning;
    }
    public boolean isDishWasherDoorIsClosed() {return dishWasherDoorIsClosed; }
    public String getDishWasherCurrentCycle() {return dishWasherCurrentCycle; }
    public void setDishWasherIsRunning(boolean dishWasherIsRunning) {
        this.dishWasherIsRunning = dishWasherIsRunning;}
    public void setDishWasherCurrentCycle(String dishWasherCurrentCycle) {
        this.dishWasherCurrentCycle = dishWasherCurrentCycle;}

}
