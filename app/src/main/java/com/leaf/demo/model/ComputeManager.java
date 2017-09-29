package com.leaf.demo.model;

import android.text.Editable;

/**
 * Created by ye on 2017/9/29.
 */

public class ComputeManager {

    public String compute(Editable text1, Editable text2) {
        int value1 = Integer.parseInt(text1.toString());
        int value2 = Integer.parseInt(text2.toString());
        int result = value1 + value2;
        return "" + result;
    }
}
