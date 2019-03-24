package com.meitu.sww.testoverdraw;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.meitu.sww.testoverdraw.base.BaseActivity;

public class MainActivity extends BaseActivity {

    private static final String TAG = "MainActivity";
    private int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();
        addFragment();
    }

    public void addFragment(){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        MyFragment myFragment = MyFragment.getInstance("myFragment");
        fragmentTransaction.replace(R.id.frame_layout,myFragment);
        fragmentTransaction.commitAllowingStateLoss();
    }

    public void controller(View view) {
        Log.e(TAG, "controller: "+ i);
        if (i%2==0){
            findViewById(R.id.text_left).setVisibility(View.VISIBLE);
            findViewById(R.id.text_right).setVisibility(View.GONE);
        }else if (i%3==0){
            findViewById(R.id.text_left).setVisibility(View.GONE);
            findViewById(R.id.text_right).setVisibility(View.VISIBLE);
        }else if (i%5==0){
            findViewById(R.id.text_left).setVisibility(View.GONE);
            findViewById(R.id.text_right).setVisibility(View.GONE);
        }else {
            findViewById(R.id.text_left).setVisibility(View.VISIBLE);
            findViewById(R.id.text_right).setVisibility(View.VISIBLE);
        }
        i++;
    }

}
