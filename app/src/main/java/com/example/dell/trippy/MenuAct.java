package com.example.dell.trippy;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.github.clans.fab.FloatingActionMenu;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MenuAct extends AppCompatActivity {

    private RecyclerView recyclerView;
    private AlbumsAdapter adapter;
    private List<Album> albumList;
    ImageView slidingimage;
    public int index=0;
    public String CName;

    ArrayList<String> slid= new ArrayList<String>();

    FloatingActionMenu materialDesignFAM;
    com.github.clans.fab.FloatingActionButton floatingActionButton1;
    com.github.clans.fab.FloatingActionButton floatingActionButton2;

    com.github.clans.fab.FloatingActionButton floatingActionButton3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        SharedPreferences cd = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        CName = cd.getString("hint", "");


        if (CName.equals("c1")){

            slid.add("https://s22.postimg.org/me6tty85d/Delhi1_opt.jpg");
            slid.add("http://inspiretourism.com/wp-content/uploads/2013/11/Delhi1.jpg");
            slid.add("http://www.indovacations.net/english/images/jama-masjid-delhi[1].jpg");
        }

        else if (CName.equals("c2")){

            slid.add("https://www.makemytrip.com/travel-guide/media/dg_image/bangalore/thumb/Lagislature-Building_19_158_bangalore_938_410.jpg");
            slid.add("http://images.worthview.com/wp-content/uploads/2012/12/Nandi-hills-above-clouds-photos.jpg");
            slid.add("https://www.karnataka.com/wp-content/uploads/2014/04/sankey-tank-wiki.jpg");
             }

        else if (CName.equals("c3")){

            slid.add("http://travelplay.in/wp-content/uploads/2015/02/gateway-of-india-travel-play-02.jpg");
            slid.add("http://www.nationsonline.org/gallery/India/Taj-Mahal-Palace-Hotel-Mumbai.jpg");
            slid.add("http://www.tourism-of-india.com/pictures/travel_guide/mumbai-647.jpeg");
        }
        else {

            slid.add("http://firstouting.in/wp-content/uploads/2016/10/GOA-TRAVEL-GUIDE.jpg");
            slid.add("https://www.holidify.com/blog/wp-content/uploads/2016/01/goa-1.jpg");
            slid.add("http://www.thomascook.in/tcportal/honeymoon-destinations/images/gallery_org/goa_galimg1_1_big.jpg");
        }



        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarr);
        setSupportActionBar(toolbar);

        initCollapsingToolbar();

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        albumList = new ArrayList<>();
        adapter = new AlbumsAdapter(this, albumList);

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(10), true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

        prepareAlbums();

        try {

            final Handler mHandler = new Handler();

            final Runnable mUpdateResults = new Runnable() {
                public void run() {

                    AnimateandSlideShow();

                }
            };

            int delay = 2000; // delay

            int period = 2000; // repeat

            Timer timer = new Timer();

            timer.scheduleAtFixedRate(new TimerTask() {

                public void run() {

                    mHandler.post(mUpdateResults);

                }

            }, delay, period);

            Glide.with(this).load(R.drawable.trippy).into((ImageView) findViewById(R.id.backdrop));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Initializing collapsing toolbar
     * Will show and hide the toolbar title on scroll
     */


    private void AnimateandSlideShow() {


        slidingimage = (ImageView) findViewById(R.id.backdrop);
        Glide.with(getApplicationContext()).load(slid.get(index)).into(slidingimage);
        index++;

        if (index == 3) {
            index = 0;
        }
        Animation rotateimage = AnimationUtils.loadAnimation(this, android.R.anim.fade_in);
        slidingimage.startAnimation(rotateimage);
    }
    private void initCollapsingToolbar() {
        final CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle(" ");
        AppBarLayout appBarLayout = (AppBarLayout) findViewById(R.id.appbar);
        appBarLayout.setExpanded(true);

        // hiding & showing the title when toolbar expanded & collapsed
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            boolean isShow = false;
            int scrollRange = -1;

            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (scrollRange == -1) {
                    scrollRange = appBarLayout.getTotalScrollRange();

                }
                if (scrollRange + verticalOffset == 0) {
                    collapsingToolbar.setTitle(getString(R.string.app_name));
                    isShow = true;

                    materialDesignFAM = (FloatingActionMenu) findViewById(R.id.material_design_android_floating_action_menu);
                    floatingActionButton1 = (com.github.clans.fab.FloatingActionButton) findViewById(R.id.material_design_floating_action_menu_item1);
                    floatingActionButton2 = (com.github.clans.fab.FloatingActionButton) findViewById(R.id.material_design_floating_action_menu_item2);
                    floatingActionButton3 = (com.github.clans.fab.FloatingActionButton) findViewById(R.id.material_design_floating_action_menu_item3);

                    
                    floatingActionButton1.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {
                            //TODO something when floating action menu first item clicked
                            Intent i = new Intent(getApplicationContext(),MainActivity.class);
                            startActivity(i);
                        }
                    });
                    floatingActionButton2.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {
                            //TODO something when floating action menu second item clicked

                        }
                    });
                    floatingActionButton3.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {
                            //TODO something when floating action menu third item clicked

                        }
                    });

                } else if (isShow) {
                    collapsingToolbar.setTitle(" ");
                    materialDesignFAM.close(true);
                    isShow = false;
                }
            }

        });
    }

    /**
     * Adding few albums for testing
     */
    private void prepareAlbums() {
        int[] covers = new int[]{
                R.drawable.ptv,
                R.drawable.trpt,
                R.drawable.hotels,
                R.drawable.navig,
                R.drawable.exper,
                R.drawable.pubtpt,
                R.drawable.rest,
                R.drawable.carrent,
                R.drawable.shopping,
                R.drawable.medical,
                R.drawable.rest};

        Album a = new Album("Places to visit", 13, covers[0]);
        albumList.add(a);

        a = new Album("Transportation", 8, covers[1]);
        albumList.add(a);

        a = new Album("Hotels", 11, covers[2]);
        albumList.add(a);

        a = new Album("Maps", 12, covers[3]);
        albumList.add(a);

        a = new Album("Experiences", 14, covers[4]);
        albumList.add(a);

        a = new Album("Public transport", 1, covers[5]);
        albumList.add(a);

        a = new Album("Rest", 11, covers[6]);
        albumList.add(a);

        a = new Album("Car rental", 14, covers[7]);
        albumList.add(a);

        a = new Album("Shopping", 11, covers[8]);
        albumList.add(a);

        a = new Album("Health and emergencies", 17, covers[9]);
        albumList.add(a);

        adapter.notifyDataSetChanged();
    }

    /**
     * RecyclerView item decoration - give equal margin around grid item
     */
    public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

        private int spanCount;
        private int spacing;
        private boolean includeEdge;

        public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
            this.spanCount = spanCount;
            this.spacing = spacing;
            this.includeEdge = includeEdge;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            int position = parent.getChildAdapterPosition(view); // item position
            int column = position % spanCount; // item column

            if (includeEdge) {
                outRect.left = spacing - column * spacing / spanCount; // spacing - column * ((1f / spanCount) * spacing)
                outRect.right = (column + 1) * spacing / spanCount; // (column + 1) * ((1f / spanCount) * spacing)

                if (position < spanCount) { // top edge
                    outRect.top = spacing;
                }
                outRect.bottom = spacing; // item bottom
            } else {
                outRect.left = column * spacing / spanCount; // column * ((1f / spanCount) * spacing)
                outRect.right = spacing - (column + 1) * spacing / spanCount; // spacing - (column + 1) * ((1f /    spanCount) * spacing)
                if (position >= spanCount) {
                    outRect.top = spacing; // item top
                }
            }
        }
    }

    /**
     * Converting dp to pixel
     */
    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }
}
