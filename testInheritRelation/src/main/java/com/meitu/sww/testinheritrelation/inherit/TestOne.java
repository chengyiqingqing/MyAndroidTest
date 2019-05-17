package com.meitu.sww.testinheritrelation.inherit;

import android.util.Log;

/**
 * @author ShaoWenWen
 * @date 2019/5/16
 */
public class TestOne extends TestTwo {

    @Override
    public void execute() {
        Log.e("TestTarget", "execute: TestOne ------ ");
    }

    public TestOne getTest() {
        return new TestOne();
    }

}
