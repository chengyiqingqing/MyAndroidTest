package com.meitu.sww.testinheritrelation.inherit;

import android.util.Log;

/**
 * @author ShaoWenWen
 * @date 2019/5/16
 */
public abstract class TestTwo implements TestThree {

    public void run(){
        execute();
    }

    @Override
    public void execute() {
        Log.e("TestTarget", "execute: 走了抽象的TestTwo" );
    }

    public void testTargetOne() {
        Log.e("TestTarget", "testTargetOne: " );
    }

    public void testTargetTwo() {
        Log.e("TestTarget", "testTargetTwo: " );
    }

}
