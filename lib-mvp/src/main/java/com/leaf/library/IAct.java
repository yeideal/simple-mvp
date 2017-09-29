package com.leaf.library;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

/**
 * Created by ye on 2016/8/23.
 */
public interface IAct {
    Context getContext();

    Activity getActivity();

    void startActivity(Intent intent);

    void startActivityForResult(Intent intent, int requestCode);
}
