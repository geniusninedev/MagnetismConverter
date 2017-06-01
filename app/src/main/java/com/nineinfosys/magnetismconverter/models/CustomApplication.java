package com.nineinfosys.magnetismconverter.models;

import android.support.multidex.MultiDex;
import android.support.multidex.MultiDexApplication;

import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.firebase.client.Firebase;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by Supriya on 20-04-2017.
 */

public class CustomApplication extends MultiDexApplication {

    @Override
    public void onCreate() {
        super.onCreate();

        Firebase.setAndroidContext(this);
        FacebookSdk.sdkInitialize(getApplicationContext());
        AppEventsLogger.activateApp(this);
        FirebaseDatabase.getInstance().setPersistenceEnabled(true);
        MultiDex.install(this);

    }

}
