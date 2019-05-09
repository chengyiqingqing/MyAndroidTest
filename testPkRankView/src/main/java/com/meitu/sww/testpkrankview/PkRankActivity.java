package com.meitu.sww.testpkrankview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * @author ShaoWenWen
 * @date 2019/4/29
 */
public class PkRankActivity extends AppCompatActivity {

    private PkRankView pkRankView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_scheme);
        pkRankView = findViewById(R.id.pk_rank_view);
    }

    @Override
    protected void onResume() {
        super.onResume();
        pkRankView.updateView();
//        ((PkRankView) findViewById(R.id.pk_rank_view)).setBackgound();
        //((PkRankAnimView)findViewById(R.id.pk_rank_anim_view)).startScaleAnim();
    }

}
