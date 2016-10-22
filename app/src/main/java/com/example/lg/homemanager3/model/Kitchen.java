package com.example.lg.homemanager3.model;

import com.example.lg.homemanager3.R;

/**
 * Created by LG on 10/22/2016.
 */

public class Kitchen {
    public static String [] appliance = {"Refrigerator","Dish washer" ,"Oven"};
    public static int [] resourcesIds = new int []{R.drawable.images,R.drawable.images,R.drawable.images};
        private boolean fridgeIsRunning;
        private boolean fridgeDoorIsClosed;
        private int currentFridgeTemp;
        private int desiredFridgeTemp;
        private int waterFilterDaysRemaining;

        private boolean ovenIsOn;
        private boolean ovenDoorIsClosed;
        private int currentOvenTemp;
        private int desiredOvenTemp;

                private boolean dishWasherIsRunning;
            private boolean dishWasherDoorIsClosed;
            private int rinseAgentDaysRemaining;

                public boolean isFridgeIsRunning() {
                return fridgeIsRunning;
            }

                public void setFridgeIsRunning(boolean fridgeIsRunning) {
                this.fridgeIsRunning = fridgeIsRunning;
            }

                public boolean isFridgeDoorIsClosed() {
                return fridgeDoorIsClosed;
            }

                public void setFridgeDoorIsClosed(boolean fridgeDoorIsClosed) {
                this.fridgeDoorIsClosed = fridgeDoorIsClosed;
            }

                public int getCurrentFridgeTemp() {
                return currentFridgeTemp;
            }

                public void setCurrentFridgeTemp(int currentFridgeTemp) {
                this.currentFridgeTemp = currentFridgeTemp;
            }

                public int getDesiredFridgeTemp() {
                return desiredFridgeTemp;
            }

                public void setDesiredFridgeTemp(int desiredFridgeTemp) {
                this.desiredFridgeTemp = desiredFridgeTemp;
            }

                public int getWaterFilterDaysRemaining() {
                return waterFilterDaysRemaining;
            }

                public void setWaterFilterDaysRemaining(int waterFilterDaysRemaining) {
                this.waterFilterDaysRemaining = waterFilterDaysRemaining;
            }

                public boolean isOvenIsOn() {
                return ovenIsOn;
            }
        public void setOvenIsOn(boolean ovenIsOn) {
                this.ovenIsOn = ovenIsOn;
            }

                public boolean isOvenDoorIsClosed() {
                return ovenDoorIsClosed;
            }

                public void setOvenDoorIsClosed(boolean ovenDoorIsClosed) {
                this.ovenDoorIsClosed = ovenDoorIsClosed;
            }

                public int getCurrentOvenTemp() {
                return currentOvenTemp;
            }

                public void setCurrentOvenTemp(int currentOvenTemp) {
                this.currentOvenTemp = currentOvenTemp;
            }

                public int getDesiredOvenTemp() {
                return desiredOvenTemp;
            }

                public void setDesiredOvenTemp(int desiredOvenTemp) {
                this.desiredOvenTemp = desiredOvenTemp;
            }

                public boolean isDishWasherIsRunning() {
                return dishWasherIsRunning;
            }

                public void setDishWasherIsRunning(boolean dishWasherIsRunning) {
                this.dishWasherIsRunning = dishWasherIsRunning;
            }

                public boolean isDishWasherDoorIsClosed() {
                return dishWasherDoorIsClosed;
            }

                public void setDishWasherDoorIsClosed(boolean dishWasherDoorIsClosed) {
                this.dishWasherDoorIsClosed = dishWasherDoorIsClosed;
            }

                public int getRinseAgentDaysRemaining() {
                return rinseAgentDaysRemaining;
            }

                public void setRinseAgentDaysRemaining(int rinseAgentDaysRemaining) {
                this.rinseAgentDaysRemaining = rinseAgentDaysRemaining;
            }
}
