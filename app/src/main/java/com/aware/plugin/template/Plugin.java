package com.aware.plugin.template;

import android.content.Intent;
import android.hardware.SensorManager;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import com.aware.Magnetometer;

import com.aware.Aware;
import com.aware.Aware_Preferences;
import com.aware.utils.Aware_Plugin;

public class Plugin extends Aware_Plugin {

    static final String TEST = "asd";

    @Override
    public void onCreate() {
        super.onCreate();

        TAG = "Template";
        DEBUG = Aware.getSetting(this, Aware_Preferences.DEBUG_FLAG).equals("true");

        if (DEBUG) Log.d(TAG, "Template plugin running");

        Aware.setSetting(getApplicationContext(), Aware_Preferences.STATUS_MAGNETOMETER, true);
        //Aware.setSetting(getApplicationContext(), Aware_Preferences.FREQUENCY_MAGNETOMETER, SensorManager.SENSOR_DELAY_NORMAL);
        /*Aware.setSetting(getApplicationContext(), Aware_Preferences.STATUS_TELEPHONY, true);

        Aware.setSetting(getApplicationContext(), Aware_Preferences.STATUS_LOCATION_GPS, true);*/


        Intent newLabel = new Intent(Magnetometer.ACTION_AWARE_MAGNETOMETER_LABEL);
        newLabel.putExtra(Magnetometer.EXTRA_LABEL, "inside");
        sendBroadcast(newLabel);

        Intent applySettings = new Intent(Aware.ACTION_AWARE_REFRESH);
        sendBroadcast(applySettings);

    }


    @Override
    public void onDestroy() {
        super.onDestroy();

        if (DEBUG) Log.d(TAG, "Template plugin terminated");
        Aware.setSetting(getApplicationContext(), Aware_Preferences.STATUS_MAGNETOMETER, false);
        Aware.setSetting(getApplicationContext(), Aware_Preferences.STATUS_TELEPHONY, false);
        Aware.setSetting(getApplicationContext(), Aware_Preferences.STATUS_LOCATION_GPS, false);
        Intent applySettings = new Intent(Aware.ACTION_AWARE_REFRESH);
        sendBroadcast(applySettings);
        //Aware.setSetting(getApplicationContext(), Aware_Preferences.STATUS_MAGNETOMETER, false);
        //Aware.setSetting(getApplicationContext(), Aware_Preferences.STATUS_TELEPHONY, false);
    }

}
