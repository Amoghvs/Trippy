package com.example.dell.trippy;


import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.List;


public class AlbumsAdapter extends RecyclerView.Adapter<AlbumsAdapter.MyViewHolder> {

    private Context mContext;
    private List<Album> albumList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public ImageView thumbnail, overflow;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            thumbnail = (ImageView) view.findViewById(R.id.thumbnail);
        }
    }


    public AlbumsAdapter(Context mContext, List<Album> albumList) {
        this.mContext = mContext;
        this.albumList = albumList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.album_card, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        Album album = albumList.get(position);
        holder.title.setText(album.getName());

        // loading album cover using Glide library
        Glide.with(mContext).load(album.getThumbnail()).into(holder.thumbnail);

        holder.thumbnail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (position == 0) {
                    Intent i = new Intent(mContext, Places_to_visit.class);
                    mContext.startActivity(i);

                }

                if (position == 1) {
                    Intent i = new Intent(mContext, TransportAct.class);
                    mContext.startActivity(i);

                }

                if (position == 2) {
                    Intent i = new Intent(mContext, WebActivity.class);
                    i.putExtra("website","oyo");
                    mContext.startActivity(i);

                }

                if (position == 3) {
                    Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:12.9716,77.5946"));
                    i.setClassName("com.google.android.apps.maps",
                            "com.google.android.maps.MapsActivity");
                    mContext.startActivity(i);

                }


                if (position == 4) {
                    Intent i = new Intent(mContext, WebActivity.class);
                    i.putExtra("website","ex");
                    mContext.startActivity(i);

                }

                if (position == 5) {
                    Toast.makeText(mContext,"Coming Soon",Toast.LENGTH_SHORT).show();

                }

                if (position == 6) {
                    Intent i = new Intent(mContext, WebActivity.class);
                    i.putExtra("website","zo");
                    mContext.startActivity(i);

                }

                if (position == 7) {
                    Intent i = new Intent(mContext, WebActivity.class);
                    i.putExtra("website","rent");
                    mContext.startActivity(i);

                }

                if (position==8){
                    Toast.makeText(mContext,"Coming Soon ",Toast.LENGTH_SHORT).show();
                }

                if (position == 9) {
                    Intent i = new Intent(mContext, Main2Activity.class);
                    mContext.startActivity(i);

                }
            }
        });


    }



    @Override
    public int getItemCount() {
        return albumList.size();
    }
}
