package com.meitu.sww.testcommondialog;

import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private static final int PERMISSIONS_REQUEST_CODE = 1;

    private DeepLinkInterceptDialog deepLinkInterceptDialog;
    private DeepLinkToast deepLinkToast;

    HashMap<String, String> hashMap = new HashMap<>();
    List<String> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clickit(View view) {
//        showList();
        showToast();
    }

    public void showList() {
        hashMap.clear();
        list.clear();
        list.add("哈哈哈1111");
        list.add("哈哈哈2222");
        list.add("哈哈哈3333");
        Log.e(TAG, "showList: " + list.size());
        onRequestPermissionsResult(PERMISSIONS_REQUEST_CODE, list.toArray(new String[list.size()]), new int[list.size()]);
    }

    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == PERMISSIONS_REQUEST_CODE)
            for (int index = 0; index < grantResults.length; index++) {
                hashMap.put(permissions[index], String.valueOf(grantResults[index] == PackageManager.PERMISSION_GRANTED));
            }
        Set<Map.Entry<String, String>> set = hashMap.entrySet();
        for (Map.Entry<String, String> entry : set) {
            Log.e(TAG, "onRequestPermissionsResult: " + entry.getKey() + " ------ " + entry.getValue());
        }
    }

    public void showToast() {
        deepLinkToast = new DeepLinkToast(MainActivity.this);
        deepLinkToast.setTextToastTip(ContentType.ToastShowCountDown, 3000, false,
                new CountDownTextView.ICountDownTimeOver() {
                    @Override
                    public void countDownTimeOver() {
                        Toast.makeText(MainActivity.this, "哈哈哈", Toast.LENGTH_SHORT).show();
                    }
                });
        deepLinkToast.show();
    }

    public void showDialog() {
        deepLinkInterceptDialog = new DeepLinkInterceptDialog.Builder(MainActivity.this)
                .setMessage("即将离开美颜相机 \n 前往第三方应用")
                .setPositiveButtonText("允许")
                .setNegativeButtonText("取消")
                .setCountDownTime(4000)
                .setCancelable(false)
                .setPositiveButtonClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                    }
                })
                .setNegativeButtonClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                    }
                })
                .create();
        deepLinkInterceptDialog.show();
    }

}
