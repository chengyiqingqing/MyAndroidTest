package com.meitu.sww.testinheritrelation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.meitu.sww.testinheritrelation.inherit.TestOne;
import com.meitu.sww.testinheritrelation.inherit.TestTarget;
import com.meitu.sww.testinheritrelation.inherit.TestTwo;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        test();
    }

    public void test(){
        // 这getTest() 要是创建父类转子类，肯定是要报异常的
        ((TestTarget) new TestTarget().getTest()).printStar();
    }

}
