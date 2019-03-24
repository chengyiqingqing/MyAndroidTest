package com.meitu.sww.myandroidtest;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

/**
 * @author ShaoWenWen
 * @date 2018/10/8
 */
public class MyFragment extends Fragment{

    private static final String FRAGMENT_NAME = "fragment_name";

    TextView textView;

    public static MyFragment getInstance(String fragmentName){
        MyFragment myFragment = new MyFragment();
        Bundle bundle = new Bundle();
        bundle.putString(FRAGMENT_NAME,fragmentName);
        myFragment.setArguments(bundle);
        return myFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_layout,null);
        textView =view.findViewById(R.id.text_one_fragment);
        Log.e("viewpager_test", "onCreateView: " );
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),getArguments().getString(FRAGMENT_NAME),Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }

    public String getFragmentName() {
        return getArguments().getString(FRAGMENT_NAME);
    }

    @Override
    public void onResume() {
        super.onResume();
        textView.setText(getArguments().getString(FRAGMENT_NAME));
    }



}
