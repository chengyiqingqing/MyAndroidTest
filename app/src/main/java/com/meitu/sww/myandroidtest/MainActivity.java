package com.meitu.sww.myandroidtest;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "sww";

    private ViewPager viewPager;
    private List<Fragment> fragmentList = new ArrayList<>();
    private MyFragmentPagerAdapter myFragmentPagerAdapter;
    private Button buttonClick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initListener();
        initData();
    }

    private void initView() {
        viewPager = findViewById(R.id.view_pager);
        buttonClick = findViewById(R.id.button_click);
    }

    private int i = 1;

    private void initListener() {
        buttonClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                fragmentList.clear();
                i++;
                if (i==2){
//                    fragmentList.add(MyFragment.getInstance("threeFragment"+i));
//                    fragmentList.add(1,MyFragment.getInstance("forthFragment"+i));
                }
                Log.e(TAG, "onClick: ---------------------正序-------------------------" );
                for (int i=0;i<fragmentList.size();i++){
                    Log.e(TAG, "onClick: "+ ((MyFragment)fragmentList.get(i)).getFragmentName());
                }
                Collections.reverse(fragmentList);
                Log.e(TAG, "onClick: ---------------------反序-------------------------" );
                for (int i=0;i<fragmentList.size();i++){
                    Log.e(TAG, "onClick: "+ ((MyFragment)fragmentList.get(i)).getFragmentName());
                }
                myFragmentPagerAdapter.notifyDataSetChanged();
            }
        });
    }

    private void initData() {
        fragmentList.add(MyFragment.getInstance("oneFragment"));
        fragmentList.add(MyFragment.getInstance("twoFragment"));
        fragmentList.add(MyFragment.getInstance("threeFragment"+i));
        fragmentList.add(1,MyFragment.getInstance("forthFragment"+i));
        myFragmentPagerAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager(),fragmentList);
        viewPager.setAdapter(myFragmentPagerAdapter);
    }

}
