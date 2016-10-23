package com.example.lg.homemanager3.model;

import com.example.lg.homemanager3.R;

/**
 * Created by LG on 10/22/2016.
 */

public class Utility {
    public static String [] appliance = {"Water Heater","Air Conditioner"};
    public static int [] resourcesIds = new int []{R.drawable.waterheater,R.drawable.airconditioner};
    // add cycle type and cycle time for washer/dryer?  is this an enum?

    private boolean airConIsRunning = false;
    private int currentAirTemp = 0;
    private int desiredAirTemp = 0;
    private int airConFilterDaysRemaining = 0;

    private boolean waterHeaterisRunning = false;
    private boolean maintenaceAlert = false;
    private int currentWaterTemp = 0;

    private boolean coDetectorisRunning = false;
    private int coBatteryLevel = 0;
    private boolean coDetected = false;

    private boolean fireDetectorisRunning = false;
    private int fireBatteryLevel = 0;
    private boolean fireDetected = false;

    public void setCurrentAirTemp(int currentAirTemp) {
        this.currentAirTemp = currentAirTemp;
    }

    public void setDesiredAirTemp(int desiredAirTemp) {
        this.desiredAirTemp = desiredAirTemp;
    }

    public void setAirConFilterDaysRemaining(int airConFilterDaysRemaining) {
        this.airConFilterDaysRemaining = airConFilterDaysRemaining;
    }

    public void setMaintenaceAlert(boolean maintenaceAlert) {
        this.maintenaceAlert = maintenaceAlert;
    }

    public void setCurrentWaterTemp(int currentWaterTemp) {
        this.currentWaterTemp = currentWaterTemp;
    }

    public int getAirConFilterDaysRemaining() {return airConFilterDaysRemaining;}
    public boolean isCoDetectorisRunning() {return coDetectorisRunning;}
    public boolean isFireDetectorisRunning() {return fireDetectorisRunning;}
    public boolean isAirConIsRunning() {
        return airConIsRunning;
    }
    public int getCurrentAirTemp() {
        return currentAirTemp;
    }
    public int getDesiredAirTemp() {
        return desiredAirTemp;
    }
    public int getCoBatteryLevel() {
        return coBatteryLevel;
    }
    public boolean isCoDetected() {
        return coDetected;
    }
    public int getFireBatteryLevel() {
        return fireBatteryLevel;
    }
    public boolean isFireDetected() {
        return fireDetected;
    }

    public boolean isWaterHeaterisRunning() {
        return waterHeaterisRunning;
    }
    public boolean isMaintenaceAlert() {
        return maintenaceAlert;
    }
    public int getCurrentWaterTemp() {
        return currentWaterTemp;
    }

    public void setAirConIsRunning(boolean airConIsRunning) {
        this.airConIsRunning = airConIsRunning;}
    public void incrementDesiredAirTemp() {
        this.desiredAirTemp = this.desiredAirTemp + 1;}
    public void decrementDesiredAirTemp() {
        this.desiredAirTemp = this.desiredAirTemp - 1;}
    public void setWaterHeaterisRunning(boolean waterHeaterisRunning) {
        this.waterHeaterisRunning = waterHeaterisRunning;}
}