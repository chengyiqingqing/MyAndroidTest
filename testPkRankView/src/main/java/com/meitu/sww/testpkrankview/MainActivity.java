package com.meitu.sww.testpkrankview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private PkRankView pkRankView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pkRankView = findViewById(R.id.pk_rank_view);
        pkRankView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,PkRankActivity.class));
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        pkRankView.updateView();
//        ((PkRankView) findViewById(R.id.pk_rank_view)).setBackgound();
        //((PkRankAnimView)findViewById(R.id.pk_rank_anim_view)).startScaleAnim();
    }

}
