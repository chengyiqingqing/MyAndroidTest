package com.meitu.sww.testpermissionapply;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.annimon.stream.Stream;
import com.annimon.stream.function.Consumer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ShaoWenWen
 * @date 2019/5/10
 */
public class PermissionTestActivity extends AppCompatActivity {

    private static final int MY_PERMISSIONS_REQUEST_CALL_PHONE = 1;
    private static final int MY_PERMISSIONS_REQUEST_CALL_CAMERA = 2;

    String[] permissions = new String[]{
            Manifest.permission.CAMERA,
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.CALL_PHONE
    };
    // 声明一个集合，在后面的代码中用来存储用户拒绝授权的权
    List<String> mPermissionList = new ArrayList<>();

    private Map<String, Boolean> map = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public int index = 0;

    public void permissionApply(View view) {
        //检查版本是否大于M
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            mPermissionList.clear();
            map.clear();
            for (int i = 0; i < permissions.length; i++) {
                if (ContextCompat.checkSelfPermission(this, permissions[i]) != PackageManager.PERMISSION_GRANTED) {
                    mPermissionList.add(permissions[i]);
                } else {
                    map.put(permissions[i], true);
                }
            }
            if (mPermissionList.isEmpty()) {//未授予的权限为空，表示都授予了
                Toast.makeText(this, "已经授权", Toast.LENGTH_LONG).show();
            } else {//请求权限方法
                permissionArray = mPermissionList.toArray(new String[mPermissionList.size()]);//将List转为数组
                ActivityCompat.requestPermissions(this, permissionArray, MY_PERMISSIONS_REQUEST_CALL_CAMERA);
            }
        }
    }

    String[] permissionArray;

    private static final String TAG = "sww_test";

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissionss, int[] grantResults) {
        if (requestCode == MY_PERMISSIONS_REQUEST_CALL_CAMERA) {
            for (int i = 0; i < grantResults.length; i++) {
                Log.e(TAG, "onRequestPermissionsResult: " + permissionss[i] + " "
                        + (grantResults[i] == PackageManager.PERMISSION_GRANTED));
                map.put(permissionss[i], (grantResults[i] == PackageManager.PERMISSION_GRANTED));
                if (map.size() == grantResults.length)
                    Stream.of(map).forEach(new Consumer<Map.Entry<String, Boolean>>() {
                        @Override
                        public void accept(Map.Entry<String, Boolean> stringBooleanEntry) {
                            Log.e(TAG, "accept: " + stringBooleanEntry.getKey() + "  " + stringBooleanEntry.getValue());
                        }
                    });
            }
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    private void showToast(String string) {
        Toast.makeText(this, string, Toast.LENGTH_LONG).show();
    }

}

