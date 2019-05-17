package com.meitu.sww.testinheritrelation.inherit;

import android.util.Log;

/**
 * @author ShaoWenWen
 * @date 2019/5/16
 */
public class TestTarget extends TestOne{

    private static final String TAG = "TestTarget";

    @Override
    public void execute() {
        Log.e(TAG, "execute: TestTarget ------ " );
    }


    public void printStar(){
        Log.e(TAG, "printStar: star star" );
    }

    @Override
    public TestOne getTest() {
        // 创建父类 这里是要在MainActivity里强转为TestTarget报异常的。
//        return new TestOne();
        // 正常逻辑
        return new TestTarget();
    }
}
