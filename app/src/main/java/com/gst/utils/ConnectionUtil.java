package com.gst.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.gst.GSTApplication;

public class ConnectionUtil {
    /*private Context _context;

    public ConnectionUtil(Context context) {
        this._context = context;
    }*/

    public static boolean isConnectingToInternet() {

        Context _context = GSTApplication.getInstance();

        ConnectivityManager connectivity = (ConnectivityManager) _context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivity != null) {
            NetworkInfo[] info = connectivity.getAllNetworkInfo();
            if (info != null)
                for (int i = 0; i < info.length; i++) {
                    if (info[i].getState() == NetworkInfo.State.CONNECTED) {
                        return true;
                    } else if (info[i].getState() == NetworkInfo.State.CONNECTING) {
                        return true;
                    }
                }
        }
        return false;
    }

}
