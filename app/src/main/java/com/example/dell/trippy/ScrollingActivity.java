package com.example.dell.trippy;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ScrollingActivity extends AppCompatActivity {

    ImageView myImgView;
    String title,hint;
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
                break;
            case "mum" :myImgView.setImageResource(R.drawable.mumbai);
                abttext.setText(getResources().getText(R.string.Bangalore));
                name.setText("Mumbai");
                title="Mumbai";
                hint = "c3";
                break;
            case "del" :myImgView.setImageResource(R.drawable.delhi);
                abttext.setText(getResources().getText(R.string.Bangalore));
                name.setText("Delhi");
                title="Delhi";
                hint = "c1";
                break;
            case "goa" :myImgView.setImageResource(R.drawable.goa);
                abttext.setText(getResources().getText(R.string.Bangalore));
                name.setText("Goa");
                title="Goa";
                hint = "c4";
                break;

        }


        //SharedPreferences cd = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        //cd.edit().putString("hint", hint).apply();


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
        FloatingActionButton trfab = (FloatingActionButton) findViewById(R.id.trfab);
        FloatingActionButton wefab = (FloatingActionButton) findViewById(R.id.wefab);
        FloatingActionButton mafab = (FloatingActionButton) findViewById(R.id.mafab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Go to menu", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        trfab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ScrollingActivity.this,TransportAct.class);
                startActivity(i);
            }
        });

        wefab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ScrollingActivity.this,WebActivity.class);
                i.putExtra("website","fb");
                startActivity(i);
            }
        });

        mafab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Go to maps", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
}
