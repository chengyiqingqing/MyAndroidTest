package com.meitu.sww.testcustomviewcollection;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.meitu.sww.testcustomviewcollection.canvasoperate.CanvasOperateActivity;
import com.meitu.sww.testcustomviewcollection.draw.DrawActivity;
import com.meitu.sww.testcustomviewcollection.messure.ViewMeasureActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.button_measure)
    Button buttonTest;
    @BindView(R.id.button_draw)
    Button buttonDraw;
    @BindView(R.id.button_operate)
    Button buttonOperate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();
        initListener();
    }

    private void initListener() {
        buttonTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ViewMeasureActivity.class);
                startActivity(intent);
            }
        });
        buttonDraw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToPage(DrawActivity.class);
            }
        });
        buttonOperate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToPage(CanvasOperateActivity.class);
            }
        });
    }

    private void initView() {
        ButterKnife.bind(this);
    }

    public void goToPage(Class cls) {
        Intent intent = new Intent(MainActivity.this, cls);
        startActivity(intent);
    }

}
