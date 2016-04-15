package com.example.zp.myapplication.fragment;

import android.app.Fragment;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.example.zp.myapplication.R;

/**
 * Created by ZHANGPING129 on 2016-02-02.
 */
public class WebViewFragment extends BaseFragment {
    private WebView mWebView;
    private ZpWebViewClient mWebviewClient;
    private ZpWebChromeClient mWebChromClient;
    private ProgressBar mProgressbar;
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mView=inflater.inflate(R.layout.fragment_webview,null);
        return mView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if(!isCreated){
            isCreated=true;
            mWebView=(WebView)mView.findViewById(R.id.webView);
            mProgressbar=(ProgressBar)mView.findViewById(R.id.wb_progress);
            initWebview();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    private void initWebview(){
        mWebChromClient= new ZpWebChromeClient();
        mWebviewClient= new ZpWebViewClient();
        WebSettings settings =mWebView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setSupportZoom(true);
        settings.setBuiltInZoomControls(true);
        settings.setDisplayZoomControls(false);
        settings.setDefaultTextEncodingName("utf-8");
        settings.setAllowFileAccess(true);//用于上传本地文件
        settings.setAllowContentAccess(true);
        settings.setAllowFileAccessFromFileURLs(true);
        settings.setAllowUniversalAccessFromFileURLs(true);
        mWebView.setWebViewClient(mWebviewClient);
        mWebView.setWebChromeClient(mWebChromClient);
        mWebView.loadUrl("http://www.51cto.com/");
        mWebView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                return true;
            }
        });
    }

    class ZpWebViewClient extends WebViewClient{
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }

    }
    class ZpWebChromeClient extends WebChromeClient{
        @Override
        public void onShowCustomView(View view, CustomViewCallback callback) {
            super.onShowCustomView(view, callback);
        }

        @Override
        public void onHideCustomView() {
            super.onHideCustomView();
        }

        @Override
        public void onProgressChanged(WebView view, int newProgress) {
            super.onProgressChanged(view, newProgress);
            if(newProgress>0&&newProgress<100){
                mProgressbar.setVisibility(View.VISIBLE);
            }else if(newProgress==100){
                mProgressbar.setVisibility(View.GONE);
            }
        }
    }

}
