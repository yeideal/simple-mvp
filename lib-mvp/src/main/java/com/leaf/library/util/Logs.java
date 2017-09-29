package com.leaf.library.util;

import android.util.Log;

/**
 * Created by ye on 2017/9/29.
 */

public class Logs {
    private final static String TAG = "lf";

    public static void d(String msg) {
        Log.d(TAG, msg);
    }

    public static void e(String s, Throwable throwable) {
        Log.e(TAG, throwable.getMessage(), throwable);
    }
}
