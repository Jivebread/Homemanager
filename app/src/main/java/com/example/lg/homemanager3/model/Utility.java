package com.example.lg.homemanager3.model;

import com.example.lg.homemanager3.R;

/**
 * Created by LG on 10/22/2016.
 */

public class Utility {
    public static String [] appliance = {"Water Heater","AirConditioner"};
    public static int [] resourcesIds = new int []{R.drawable.images,R.drawable.images};
    private boolean airConIsRunning;
    private int currentAirTemp;
    private int desiredAirTemp;

    private boolean waterHeaterisRunning;
    private boolean maintenaceAlert;
    private int waterTemp;
    private int gallonsUsed;

    private int co1BatteryLevel;
    private boolean co1Detected;

    private int FireBatteryLevel;
    private boolean FireDetected;

    public boolean isAirConIsRunning() {
        return airConIsRunning;
    }

    public void setAirConIsRunning(boolean airConIsRunning) {
        this.airConIsRunning = airConIsRunning;
    }

    public int getCurrentAirTemp() {
        return currentAirTemp;
    }

    public void setCurrentAirTemp(int currentAirTemp) {
        this.currentAirTemp = currentAirTemp;
    }

    public int getDesiredAirTemp() {
        return desiredAirTemp;
    }

    public void setDesiredAirTemp(int desiredAirTemp) {
        this.desiredAirTemp = desiredAirTemp;
    }

    public boolean isWaterHeaterisRunning() {
        return waterHeaterisRunning;
    }

    public void setWaterHeaterisRunning(boolean waterHeaterisRunning) {
        this.waterHeaterisRunning = waterHeaterisRunning;
    }

    public boolean isMaintenaceAlert() {
        return maintenaceAlert;
    }

    public void setMaintenaceAlert(boolean maintenaceAlert) {
        this.maintenaceAlert = maintenaceAlert;
    }

    public int getWaterTemp() {
        return waterTemp;
    }

    public void setWaterTemp(int waterTemp) {
        this.waterTemp = waterTemp;
    }

    public int getGallonsUsed() {
        return gallonsUsed;
    }

    public void setGallonsUsed(int gallonsUsed) {
        this.gallonsUsed = gallonsUsed;
    }

    public int getCo1BatteryLevel() {
        return co1BatteryLevel;
    }

    public void setCo1BatteryLevel(int co1BatteryLevel) {
        this.co1BatteryLevel = co1BatteryLevel;
    }

    public boolean isCo1Detected() {
        return co1Detected;
    }

    public void setCo1Detected(boolean co1Detected) {
        this.co1Detected = co1Detected;
    }

    public int getFireBatteryLevel() {
        return FireBatteryLevel;
    }

    public void setFireBatteryLevel(int fireBatteryLevel) {
        FireBatteryLevel = fireBatteryLevel;
    }

    public boolean isFireDetected() {
        return FireDetected;
    }

    public void setFireDetected(boolean fireDetected) {
        FireDetected = fireDetected;
    }

}
