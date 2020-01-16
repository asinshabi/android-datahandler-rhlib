package me.asinshabi.runtimehandler.datahandler;

import android.util.Log;

public class DataLog {

    public static boolean LOGGING = true;
    public static String TAG = "DataBase";

    public static void out(int type, String message){
        switch (type){
            case Log.DEBUG: Log.d(TAG, message);
            case Log.ERROR: Log.e(TAG, message);
            case Log.WARN: Log.w(TAG, message);
            case Log.INFO: Log.i(TAG, message);
            default: Log.wtf(TAG, message);
        }
    }
}
