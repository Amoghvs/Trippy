package com.example.dell.trippy;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
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
    String CName,city;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        overridePendingTransition(R.animator.left_in, R.animator.left_out);

        SharedPreferences cd = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        CName = cd.getString("hint", "");


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
            case "rent" :
                switch (CName) {
                    case "c1":
                        website = "https://zoomcar.com/delhi/";
                        break;
                    case "c2":
                        website = "https://zoomcar.com/bangalore/";
                        break;
                    case "c3":
                        website = "https://zoomcar.com/mumbai/";
                        break;
                    case "c4":
                        website = "http://www.goaholidayhomes.com/cars/";
                        break;
                }

                break;

            case "ex" :
                switch (CName) {
                    case "c1":
                        website = "https://in.bookmyshow.com/delhi/experiences";
                        break;
                    case "c2":
                        website = "https://in.bookmyshow.com/bengaluru/experiences";
                        break;
                    case "c3":
                        website = "https://in.bookmyshow.com/mumbai/experiences";
                        break;
                    case "c4":
                        website = "https://in.bookmyshow.com/goa/experiences";
                        break;
                }

                break;


            case "ub" : website = "https://m.uber.com/"; break;
            case "oyo" : switch (CName) {
                case "c1":
                    website = "https://www.oyorooms.com/oyos-in-delhi";
                    break;
                case "c2":
                    website = "https://www.oyorooms.com/hotels-in-bangalore/";
                    break;
                case "c3":
                    website = "https://www.oyorooms.com/hotels-in-mumbai/";
                    break;
                case "c4":
                    website = "https://www.oyorooms.com/hotels-in-goa/";
                    break;
            }
                break;

            case "zo" : switch (CName) {
                case "c1":
                    website = "https://www.zomato.com/ncr";
                    break;
                case "c2":
                    website = "https://www.zomato.com/bangalore/";
                    break;
                case "c3":
                    website = "https://www.zomato.com/mumbai";
                    break;
                case "c4":
                    website = "https://www.zomato.com/goa";
                    break;
            }
                break;



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