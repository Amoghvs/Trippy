package com.example.dell.trippy;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.widget.TextView;

public class popup extends AppCompatActivity {
float distance;
    float result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup);

        SharedPreferences data = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        String dis = data.getString("distance","");
        int res = data.getInt("pp",0);



        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;
        int height = dm.heightPixels;
        getWindow().setLayout((int)(width*.8),(int)(height*.6));

        //SharedPreferences data = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        //int ans = data.getInt("pp",0);

        final TextView restext=(TextView)findViewById(R.id.resv);
        distance = Float.parseFloat(dis);
        result = (Float)distance*res;

        restext.setText(String.valueOf(result));

    }


}
