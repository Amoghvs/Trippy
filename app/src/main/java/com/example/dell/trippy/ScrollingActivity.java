package com.example.dell.trippy;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ScrollingActivity extends AppCompatActivity {

    ImageView myImgView;
    String title,hint,lat,lng;
    NestedScrollView nestedScrollView;
    TextView abttext,name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_scrolling);

        String data = getIntent().getExtras().getString("city");

        myImgView = (ImageView) findViewById(R.id.img);

        abttext = (TextView) findViewById(R.id.abttxt);

        name = (TextView) findViewById(R.id.name);

        nestedScrollView = (NestedScrollView) findViewById(R.id.content);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        final CollapsingToolbarLayout collapsingToolbarLayout =
                (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);

        collapsingToolbarLayout.setTitle(" ");


        switch (data){
            case "bang" :myImgView.setImageResource(R.drawable.blr);
                abttext.setText(getResources().getText(R.string.Bangalore));
                name.setText("Bangalore");
                title="Bangalore";
                hint = "c2";
                lat="12.9716";
                lng="77.5946";
                break;
            case "mum" :myImgView.setImageResource(R.drawable.mumbai);
                abttext.setText(getResources().getText(R.string.Bangalore));
                name.setText("Mumbai");
                title="Mumbai";
                hint = "c3";
                lat="19.0760";
                lng="72.8777";
                break;
            case "del" :myImgView.setImageResource(R.drawable.delhi);
                abttext.setText(getResources().getText(R.string.Bangalore));
                name.setText("Delhi");
                title="Delhi";
                hint = "c1";
                lat="28.7041";
                lng="77.1025";
                break;
            case "goa" :myImgView.setImageResource(R.drawable.goa);
                abttext.setText(getResources().getText(R.string.Bangalore));
                name.setText("Goa");
                title="Goa";
                hint = "c4";
                lat="15.2993";
                lng="74.1240";
                break;

        }


        SharedPreferences cd = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        cd.edit().putString("hint", hint).apply();


        setSupportActionBar(toolbar);




        AppBarLayout appBarLayout = (AppBarLayout) findViewById(R.id.app_bar);
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            boolean isShow = false;
            int scrollRange = -1;

            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (scrollRange == -1) {
                    scrollRange = appBarLayout.getTotalScrollRange();
                }
                if (scrollRange + verticalOffset == 0) {
                    collapsingToolbarLayout.setTitle(title);
                    isShow = true;
                } else if(isShow) {
                    collapsingToolbarLayout.setTitle(" ");//carefull there should a space between double quote otherwise it wont work
                    isShow = false;
                }
            }
        });




        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

        FloatingActionButton mafab = (FloatingActionButton) findViewById(R.id.mafab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ScrollingActivity.this,MenuAct.class);
                startActivity(i);
            }
        });


        mafab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:"+lat+","+lng));
                i.setClassName("com.google.android.apps.maps",
                        "com.google.android.maps.MapsActivity");
                startActivity(i);
            }
        });
    }
}
