package com.meitu.sww.testprotobuf;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.sww.protobuf.test.LiveRankInfo;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    LiveRankInfo.Builder liveRankInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.text_view);
        liveRankInfo = LiveRankInfo.newBuilder();//parseFrom这个body.
        liveRankInfo.setRank("我的rank");
    }

    @Override
    protected void onResume() {
        super.onResume();
        textView.postDelayed(new Runnable() {
            @Override
            public void run() {
                textView.setText(liveRankInfo.getRank());
            }
        },3000);
    }

}
