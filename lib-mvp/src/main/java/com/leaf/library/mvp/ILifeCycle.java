package com.leaf.library.mvp;

import android.content.Intent;
import android.os.Bundle;

/**
 * Created by ye on 2017/3/30.
 */

public interface ILifeCycle {
    void initParam(Bundle extras);

    void onCreate(Bundle savedInstanceState, Bundle extras);

    void onDestroy();

    void onPause();

    void onResume();

    void onSaveInstanceState(Bundle outState);

    void onStart();

    void onStop();

    void onNewIntent(Intent intent);

    void onActivityResult(int requestCode, int resultCode, Intent data);
}
