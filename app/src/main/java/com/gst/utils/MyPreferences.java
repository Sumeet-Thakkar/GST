package com.gst.utils;

import android.content.Context;
import android.content.SharedPreferences;


public class MyPreferences {


    public static String prefID = "GST";

    public static String getPref(Context mContext, String mPrefKey) {
        try {
            SharedPreferences prefs = mContext.getSharedPreferences(prefID, Context.MODE_PRIVATE);
            return prefs.getString(mPrefKey, "");
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static void setPref(Context mContext, String mPrefKey, String mPrefValue) {
        try {
            SharedPreferences.Editor editor = mContext.getSharedPreferences(prefID, Context.MODE_PRIVATE).edit();
            if (mPrefValue != null) {
                editor.remove(mPrefKey);
                editor.putString(mPrefKey, mPrefValue);
            } else {
                editor.remove(mPrefKey);
                editor.putString(mPrefKey, "");
            }
            editor.apply();
        } catch (Exception e) {

            e.printStackTrace();
        }
    }


}
