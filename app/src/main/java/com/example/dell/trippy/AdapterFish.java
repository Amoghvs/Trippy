package com.example.dell.trippy;

/**
 * Created by anuj on 7/4/17.
 */

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.Collections;
import java.util.List;

public class AdapterFish extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private LayoutInflater inflater;
    List<DataFish> data= Collections.emptyList();
    DataFish current;
    public String CName,url;
    int currentPos=0;

    // create constructor to innitilize context and data sent from MainActivity
    public AdapterFish(Context context, List<DataFish> data){
        this.context=context;
        inflater= LayoutInflater.from(context);
        this.data=data;
    }

    // Inflate the layout when viewholder created
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=inflater.inflate(R.layout.container_fish, parent,false);
        MyHolder holder=new MyHolder(view);
        return holder;
    }

    // Bind data
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {

        // Get current position of item in recyclerview to bind data and assign values from list
        final MyHolder myHolder= (MyHolder) holder;
        DataFish current=data.get(position);
        myHolder.Cityname.setText(current.fishName);

        SharedPreferences cd = PreferenceManager.getDefaultSharedPreferences(context);
         CName = cd.getString("hint", "");



        Picasso.with(context).load(current.fishImage).into(myHolder.Cityimg);

        myHolder.Cityimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                switch (CName){

                    case "c1": if (position==0){
                        Intent i = new Intent(context,Dest_act.class);
                        i.putExtra("web","https://en.wikipedia.org/wiki/India_Gate");
                        i.putExtra("lat","28.6129");
                        i.putExtra("lng","77.2295");
                        context.startActivity(i);
                    }
                    else if (position==1){
                        Intent i = new Intent(context,Dest_act.class);
                        i.putExtra("web","https://en.wikipedia.org/wiki/Red_Fort");
                        i.putExtra("lat","28.6562");
                        i.putExtra("lng","77.2410");
                        context.startActivity(i);
                    }
                    else if (position==2){
                        Intent i = new Intent(context,Dest_act.class);
                        i.putExtra("web","https://en.wikipedia.org/wiki/Qutb_Minar");
                        i.putExtra("lat","28.5244");
                        i.putExtra("lng","77.1855");
                        context.startActivity(i);
                    }
                    else if (position==3){
                        Intent i = new Intent(context,Dest_act.class);
                        i.putExtra("web","https://en.wikipedia.org/wiki/Lotus_Temple");
                        i.putExtra("lat","28.5535");
                        i.putExtra("lng","77.2588");
                        context.startActivity(i);
                    }
                    else {
                        Intent i = new Intent(context,Dest_act.class);
                        i.putExtra("web","https://en.wikipedia.org/wiki/Gurudwara_Bangla_Sahib");
                        i.putExtra("lat","28.6264°");
                        i.putExtra("lng","77.2091");
                        context.startActivity(i);
                    }
                    break;

                    case "c2":if (position==0){
                        Intent i = new Intent(context,Dest_act.class);
                        i.putExtra("web","https://en.wikipedia.org/wiki/Lal_Bagh");
                        i.putExtra("lat","12.9507");
                        i.putExtra("lng","77.5848");
                        context.startActivity(i);
                    }
                    else if (position==1){
                        Intent i = new Intent(context,Dest_act.class);
                        i.putExtra("web","https://en.wikipedia.org/wiki/Nandi_Hills,_India");
                        i.putExtra("lat","13.3702");
                        i.putExtra("lng","77.6835");
                        context.startActivity(i);
                    }
                    else if (position==2){
                        Intent i = new Intent(context,Dest_act.class);
                        i.putExtra("web","https://en.wikipedia.org/wiki/Mysore_Palace");
                        i.putExtra("lat","12.3051");
                        i.putExtra("lng","76.6551");
                        context.startActivity(i);
                    }
                    else if (position==3){
                        Intent i = new Intent(context,Dest_act.class);
                        i.putExtra("web","https://en.wikipedia.org/wiki/Orion_Mall");
                        i.putExtra("lat","13.0108");
                        i.putExtra("lng","77.5549");
                        context.startActivity(i);
                    }
                    else {
                        Intent i = new Intent(context,Dest_act.class);
                        i.putExtra("web","https://en.wikipedia.org/wiki/Dodda_Ganeshana_Gudi");
                        i.putExtra("lat","12.9429");
                        i.putExtra("lng","77.5683");
                        context.startActivity(i);
                    }
                    break;

                    case "c3":if (position==0){
                        Intent i = new Intent(context,Dest_act.class);
                        i.putExtra("web","https://en.wikipedia.org/wiki/Gateway_of_India");
                        i.putExtra("lat","18.9220");
                        i.putExtra("lng","72.8347");
                        context.startActivity(i);
                    }
                    else if (position==1){
                        Intent i = new Intent(context,Dest_act.class);
                        i.putExtra("web","https://en.wikipedia.org/wiki/Siddhivinayak_Temple,_Mumbai");
                        i.putExtra("lat","19.0188");
                        i.putExtra("lng","72.8339");
                        context.startActivity(i);
                    }
                    else if (position==2){
                        Intent i = new Intent(context,Dest_act.class);
                        i.putExtra("web","https://en.wikipedia.org/wiki/Marine_Drive,_Mumbai");
                        i.putExtra("lat","18.944");
                        i.putExtra("lng","72.823");
                        context.startActivity(i);
                    }
                    else if (position==3){
                        Intent i = new Intent(context,Dest_act.class);
                        i.putExtra("web","https://en.wikipedia.org/wiki/Nariman_Point");
                        i.putExtra("lat","18.9256");
                        i.putExtra("lng","72.8242");
                        context.startActivity(i);
                    }
                    else {
                        Intent i = new Intent(context,Dest_act.class);
                        i.putExtra("web","https://en.wikipedia.org/wiki/Basilica_of_Our_Lady_of_the_Mount,_Bandra");
                        i.putExtra("lat","19.0465");
                        i.putExtra("lng","72.8224");
                        context.startActivity(i);
                    }
                        break;
                    case "c4":if (position==0){
                        Intent i = new Intent(context,Dest_act.class);
                        i.putExtra("web","https://en.wikipedia.org/wiki/Agonda");
                        i.putExtra("lat","15.0456");
                        i.putExtra("lng","73.9889");
                        context.startActivity(i);
                    }
                    else if (position==1){
                        Intent i = new Intent(context,Dest_act.class);
                        i.putExtra("web","https://en.wikipedia.org/wiki/Palolem_Beach");
                        i.putExtra("lat","15.0100");
                        i.putExtra("lng","74.0232");
                        context.startActivity(i);
                    }
                    else if (position==2){
                        Intent i = new Intent(context,Dest_act.class);
                        i.putExtra("web","https://en.wikipedia.org/wiki/Basilica_of_Bom_Jesus");
                        i.putExtra("lat","15.5009");
                        i.putExtra("lng","73.9116");
                        context.startActivity(i);
                    }
                    else if (position==3){
                        Intent i = new Intent(context,Dest_act.class);
                        i.putExtra("web","https://en.wikipedia.org/wiki/Dudhsagar_Falls");
                        i.putExtra("lat","15.3144");
                        i.putExtra("lng","74.3143");
                        context.startActivity(i);
                    }
                    else {
                        Intent i = new Intent(context,Dest_act.class);
                        i.putExtra("web","https://en.wikipedia.org/wiki/Benaulim");
                        i.putExtra("lat","15.2437");
                        i.putExtra("lng","73.9448");
                        context.startActivity(i);
                    }
                        break;


                }

            }
        });

    }

    // return total item from List
    @Override
    public int getItemCount() {
        return data.size();
    }


    class MyHolder extends RecyclerView.ViewHolder{

        TextView Cityname;
        ImageView Cityimg;


        // create constructor to get widget reference
        public MyHolder(View itemView) {
            super(itemView);
            Cityname= (TextView) itemView.findViewById(R.id.city_name);
            Cityimg= (ImageView) itemView.findViewById(R.id.img);

        }

    }

}