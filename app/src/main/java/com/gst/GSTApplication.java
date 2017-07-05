package com.gst;

import android.app.Activity;
import android.app.Application;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;

import com.gst.activities.MainActivity;

/**
 * Created by mind on 1/7/17.
 */

public class GSTApplication extends Application {


    public static boolean isAppActive = false;
    public static GSTApplication GSTApp;

    public static boolean isGPSSettingsOn;
    private double currentLat = 0, currentLong = 0;
    private Location location;
    private LocationManager locationManager;
    public boolean isNetwork;
    public static boolean isLocationOn;
    //    Criteria criteria;
    public static synchronized GSTApplication getInstance()
    {
        return GSTApp;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        GSTApp = GSTApplication.this;
//        criteria = new Criteria();

        registerActivityLifecycleCallbacks(activityLifecycleCallbacks);
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        unregisterActivityLifecycleCallbacks(activityLifecycleCallbacks);
    }

    public Activity currentActivity;
    public ActivityLifecycleCallbacks activityLifecycleCallbacks = new ActivityLifecycleCallbacks() {
        @Override
        public void onActivityCreated(Activity activity, Bundle savedInstanceState) {

        }

        @Override
        public void onActivityStarted(Activity activity) {
            if (activity instanceof MainActivity)
            {
                isAppActive = true;
                currentActivity = activity;
            }
        }

        @Override
        public void onActivityResumed(Activity activity) {

            if (activity instanceof MainActivity)
            {
                isAppActive = true;
                currentActivity = activity;
            }

        }

        @Override
        public void onActivityPaused(Activity activity) {
            if (activity instanceof MainActivity)
            {
                isAppActive = false;
                currentActivity = null;
            }
        }

        @Override
        public void onActivityStopped(Activity activity) {
            if (activity instanceof MainActivity)
            {
                isAppActive = false;
                currentActivity = null;
            }
        }

        @Override
        public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

        }

        @Override
        public void onActivityDestroyed(Activity activity) {
            if (activity instanceof MainActivity)
            {
                isAppActive = false;
            }
        }
    };


/*    // pass context to Calligraphy
    @Override
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(context));
    }*/

}
