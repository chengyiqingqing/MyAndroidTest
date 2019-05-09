package com.meitu.sww.myviewaddandremove;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private LinearLayout relativeContainer;
    private Button buttonLeft;
    private Button buttonRight;
    private AnimationView animationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initListener();
    }

    private void initView() {
        relativeContainer = findViewById(R.id.relative_container);
        buttonLeft = findViewById(R.id.button_left);
        buttonRight = findViewById(R.id.button_right);
//        animationView = findViewById(R.id.animation_view);
        stringArray = new String[3];
        stringArray[0] = "1111";
        stringArray[1] = "2222";
        stringArray[2] = "3333";
        stringList.add(stringArray[0]);
        stringList.add(stringArray[1]);
        stringList.add(stringArray[2]);
    }

    String[] stringArray;
    List<String> stringList = new ArrayList<>();
    private void initListener() {
        buttonLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                animationView = new AnimationView(MainActivity.this);
//                relativeContainer.addView(animationView);
//                animationView.startAnimation();
//                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("mtec.hbgc://mtui/web?url=http://pre.wallet.meitu.com/members/info")));

//                testStringArray(stringArray);
//                testStringArray(stringList.toArray(new String[stringList.size()]));
                
            }
        });
        buttonRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                animationView.endAnimation();
                relativeContainer.removeAllViews();
            }
        });
    }

    private void testStringArray(String... stringArray) {
        for (int index = 0; index < stringArray.length; index++) {
            Log.e("String_sww", "onClick: " + stringArray[index]);
        }
    }

}
