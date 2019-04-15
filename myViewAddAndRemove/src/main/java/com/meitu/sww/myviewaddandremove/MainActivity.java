package com.meitu.sww.myviewaddandremove;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

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
    }

    private void initListener() {
        buttonLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animationView = new AnimationView(MainActivity.this);
                relativeContainer.addView(animationView);
                animationView.startAnimation();
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

}
