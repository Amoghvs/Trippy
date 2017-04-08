package com.example.dell.trippy;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    CardView bang,del,goa,mum;
    String hint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bang = (CardView) findViewById(R.id.bang);
        del = (CardView) findViewById(R.id.del);
        mum = (CardView) findViewById(R.id.mum);
        goa = (CardView) findViewById(R.id.goa);

    }

    public void onBangClick(View v){
        Intent i = new Intent(this,ScrollingActivity.class);
        ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(MainActivity.this,findViewById(R.id.imgblr),"imgtr");
        hint = "c2";
        SharedPreferences cd = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        cd.edit().putString("hint", hint).apply();
        startActivity(i,optionsCompat.toBundle());
    }

    public void onMumClick(View v){
        Intent i = new Intent(this,ScrollingActivity.class);
        ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(MainActivity.this,findViewById(R.id.imgmum),"imgtr");
        hint = "c2";
        SharedPreferences cd = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        cd.edit().putString("hint", hint).apply();
        startActivity(i,optionsCompat.toBundle());
    }

    public void onDelClick(View v){
        Intent i = new Intent(this,ScrollingActivity.class);
        ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(MainActivity.this,findViewById(R.id.imgdel),"imgtr");
        hint = "c2";
        SharedPreferences cd = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        cd.edit().putString("hint", hint).apply();
        startActivity(i,optionsCompat.toBundle());
    }

    public void onGoaClick(View v){
        Intent i = new Intent(this,ScrollingActivity.class);
        ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(MainActivity.this,findViewById(R.id.imggoa),"imgtr");
        hint = "c2";
        SharedPreferences cd = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        cd.edit().putString("hint", hint).apply();
        startActivity(i,optionsCompat.toBundle());
    }

    @Override
    public void finish() {
        super.finish();
    }
}

