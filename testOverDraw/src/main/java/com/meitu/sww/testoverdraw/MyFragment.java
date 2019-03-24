package com.meitu.sww.testoverdraw;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * @author ShaoWenWen
 * @date 2018/10/8
 */
public class MyFragment extends Fragment{

    private static final String TAG = "MyFragment";
    private static final String FRAGMENT_NAME = "fragment_name";
    private View root;
    private WebView webView;

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
        root = inflater.inflate(R.layout.fragment_layout,null);
        Log.e("viewpager_test", "onCreateView: " );
        return root;
    }

    @Override
    public void onResume() {
        super.onResume();
        initView();
    }

    private void initView() {
        ViewStub stubText = root.findViewById(R.id.view_stub_demo_text);
        //这个stubText只能初始化一次。再次初始化时，将会为null。
        if (stubText!=null){
            stubText.inflate();
            TextView textView = root.findViewById(R.id.viewstub_demo_textview);
            textView.setText("The tree of liberty");
        }
        ViewStub stubImage = root.findViewById(R.id.view_stub_demo_image);
        if (stubImage!=null){
            stubImage.inflate();
            ImageView imageView = root.findViewById(R.id.viewstub_demo_imageview);
            imageView.setImageResource(R.drawable.ic_launcher_background);
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.e(TAG, "onClick: 已经点击");
                }
            });
        }
        ViewStub stubWeb = root.findViewById(R.id.view_stub_demo_web);
        if (stubWeb!=null){
            stubWeb.inflate();
            webView = root.findViewById(R.id.web_view);
            initWebViewClient();
        }
    }

    public void initWebViewClient(){
        WebSettings webSettings = webView.getSettings();
        //设置WebView属性，能够执行Javascript脚本
        webSettings.setJavaScriptEnabled(true);
        //设置可以访问文件
        webSettings.setAllowFileAccess(true);
        //设置支持缩放
        webSettings.setBuiltInZoomControls(true);
        //加载需要显示的网页
        webView.loadUrl("https://www.baidu.com");
        //设置Web视图
        webView.setWebViewClient(new MyWebViewClient ());
    }

    private class MyWebViewClient extends WebViewClient{

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }

        /*@Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            view.loadUrl(request.getUrl().toString());
            return super.shouldOverrideUrlLoading(view, request);
        }*/

    }

}
