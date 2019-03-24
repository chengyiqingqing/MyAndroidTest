package com.meitu.sww.testdialogfragmentstatusbar;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

/**
 * @author ShaoWenWen
 * @date 2019/1/3
 */
public class MyDialogFragment extends DialogFragment {

    public static final String TAG = "MyDialogFragment";
    private View root;
    private TextView textView;

    public static MyDialogFragment getInstance(){
        MyDialogFragment myDialogFragment = new MyDialogFragment();
        Bundle bundle = new Bundle();
        myDialogFragment.setArguments(bundle);
        return myDialogFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NORMAL, R.style.test_dialog_theme);
    }

    @SuppressLint("MissingBraces")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setViewDialogParams();
        if (root != null){
            ViewGroup parents = (ViewGroup) root.getParent();
            if (parents!=null) parents.removeView(root);
            return root;
        }
        root = inflater.inflate(R.layout.fragment_dialog,container,false);
        textView = root.findViewById(R.id.text_view);
        return root;
    }

    @Override
    public void onStart() {
        super.onStart();
        // TODO: 设置dialog窗体的大小 by ShaoWenWen 2019/1/3
         if (getDialog().getWindow() != null) {
            getDialog().getWindow().setLayout(DevicesUtils.screenWidth, DevicesUtils.getScreenHeight(getActivity()));
        }
        // TODO: 设置dialog窗体外蒙层的透明度设置 by ShaoWenWen 2019/1/3
        Window window = getDialog().getWindow();
        WindowManager.LayoutParams windowParams = window.getAttributes();
        windowParams.dimAmount = 0.0f;//主要是这句代码，颜色深浅；1.0表示完全不透明，0.0表示没有变暗
        window.setAttributes(windowParams);
        setParams(textView);
    }

    @Override
    public void onResume() {
        super.onResume();
        // TODO: 设置activity的状态栏颜色 by ShaoWenWen 2019/1/3
        ((BaseActivity) getActivity()).initTranslucentStatusBar(false, true);
    }

    public void setParams(View view){
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width = ViewGroup.LayoutParams.MATCH_PARENT;
        layoutParams.height = DevicesUtils.getScreenHeight(getActivity())/2;
        view.setLayoutParams(layoutParams);
    }

    public void setViewDialogParams() {
        WindowManager.LayoutParams params;
        if (getDialog().getWindow() != null) {
            params = (getDialog().getWindow()).getAttributes();
            params.gravity = Gravity.CENTER;
            params.dimAmount = 0.0f;
            getDialog().getWindow().setAttributes(params);
            getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);
            getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ((BaseActivity) getActivity()).removeStatusView();
    }

}
