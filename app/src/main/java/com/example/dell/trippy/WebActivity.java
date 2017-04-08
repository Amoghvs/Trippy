package com.example.dell.trippy;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.GeolocationPermissions;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebActivity extends AppCompatActivity {

    WebView mainWebView;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        overridePendingTransition(R.animator.left_in, R.animator.left_out);


        String data = getIntent().getExtras().getString("website");
        String website = "http://www.google.com";


        mainWebView = (WebView) findViewById(R.id.webView1);

        WebSettings webSettings = mainWebView.getSettings();
        mainWebView.setWebChromeClient(new GeoWebChromeClient());
        webSettings.setJavaScriptEnabled(true);
        mainWebView.getSettings().setGeolocationEnabled(true);
        mainWebView.setWebViewClient(new MyCustomWebViewClient());
        mainWebView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);


        switch (data){
            case "fb" : website = "https://www.zoomcar.com/bangalore/"; break;
            case "tw" : website = "https://twitter.com/login"; break;
            case "in" : website = "https://www.instagram.com/accounts/login/"; break;
            case "ln" : website = "https://in.linkedin.com/"; break;
            case "qu" : website = "https://www.quora.com/"; break;
            case "ne" : website = "http://www.thehindu.com/news/"; break;
            case "do" : website = "https://www.practo.com/"; break;
            case "ub" : website = "https://m.uber.com/"; break;
            case "ho" : website = "https://www.oyorooms.com/"; break;



            default: break;
        }
        mainWebView.loadUrl(website);
    }

    public class GeoWebChromeClient extends WebChromeClient {
        private static final String TAG = "MyActivity";
        @Override
        public void onGeolocationPermissionsShowPrompt(final String origin, final GeolocationPermissions.Callback callback) {
            Log.i(TAG, "onGeolocationPermissionsShowPrompt()");

            final boolean remember = false;
            AlertDialog.Builder builder = new AlertDialog.Builder(WebActivity.this);
            builder.setTitle("Locations Permission");
            builder.setMessage("Would like to use your Current Location ")
                    .setCancelable(true).setPositiveButton("Allow", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    // origin, allow, remember
                    callback.invoke(origin, true, remember);
                }
            }).setNegativeButton("Don't Allow", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    // origin, allow, remember
                    callback.invoke(origin, false, remember);
                }
            });
            AlertDialog alert = builder.create();
            alert.show();
        }
    }



    private class MyCustomWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }




    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (event.getAction() == KeyEvent.ACTION_DOWN) {
            switch (keyCode) {
                case KeyEvent.KEYCODE_BACK:
                    if (mainWebView.canGoBack()) {
                        mainWebView.goBack();
                    } else {
                        onBackPressed();
                    }
                    return true;
            }

        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.animator.right_in, R.animator.right_out);
    }




}