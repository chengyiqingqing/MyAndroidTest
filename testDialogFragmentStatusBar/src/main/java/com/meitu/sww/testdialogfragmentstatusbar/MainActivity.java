package com.meitu.sww.testdialogfragmentstatusbar;

import android.os.Bundle;
import android.view.View;

/**
 * DialogFragment弹起时Activity状态栏的颜色的设置
 */
public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        initTranslucentStatusBar(true,true);
        setContentView(R.layout.activity_main);
    }

    public void clickEvent(View view) {
        MyDialogFragment myDialogFragment = MyDialogFragment.getInstance();
        myDialogFragment.show(getSupportFragmentManager(),MyDialogFragment.TAG);
    }

}
