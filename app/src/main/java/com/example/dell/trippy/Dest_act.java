package com.example.dell.trippy;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Dest_act extends AppCompatActivity {

    String lat, lng;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dest_act);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        lat = getIntent().getExtras().getString("lat");
        lng = getIntent().getExtras().getString("lng");

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("google.navigation:q="+lat+","+lng));
                //startActivity(intent);
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:"+lat+","+lng));
                i.setClassName("com.google.android.apps.maps",
                        "com.google.android.maps.MapsActivity");
                startActivity(i);

            }
        });

        String data = getIntent().getExtras().getString("web");

        WebView myWebView = (WebView) findViewById(R.id.web);
        myWebView.setWebViewClient(new WebViewClient());
        myWebView.loadUrl(data);
    }

}
