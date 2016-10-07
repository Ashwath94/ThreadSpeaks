package hyderabad.threadspeaks;

import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.NavigationView;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import hyderabad.threadspeaks.ArrivalRecycler.ArivalDataModel;
import hyderabad.threadspeaks.ArrivalRecycler.ArrivalAdapter;
import hyderabad.threadspeaks.CategoryRecycler.CategoryAdapter;
import hyderabad.threadspeaks.CategoryRecycler.CategoryDataModel;
import me.relex.circleindicator.CircleIndicator;

/**
 * Created by Pavithran on 24-09-2016.
 */
public class HomePage extends AppCompatActivity {
    private RecyclerView recyclerView,recyclerView_category;
    private ArrivalAdapter adapter;
    private CategoryAdapter category_adapter;
    private List<ArivalDataModel> arrivalList;
    private List<CategoryDataModel> categoryList;
    private DrawerLayout drawerLayout;
    private Toolbar toolbar;
    private static ViewPager mPager;
    private static int currentPage = 0;
    private static int NUM_PAGES = 0;
    private static final Integer[] IMAGES= {R.mipmap.backdp,R.mipmap.dp};
    private ArrayList<Integer> ImagesArray = new ArrayList<Integer>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        //Tool Bar
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("ThreadSpeaks");
        toolbar.setTitleTextColor(Color.WHITE);

        //Navigation Drawer
        initNavigationDrawer();

        //View Pager
       init();

        //Arrivals Recycler View

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        arrivalList = new ArrayList<>();
        adapter = new ArrivalAdapter(this, arrivalList);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(mLayoutManager);
        //recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(10), true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

        prepareArrivals();

        //CategoryRecycler View

        recyclerView_category = (RecyclerView) findViewById(R.id.recycler_view_categories);

        categoryList = new ArrayList<>();
        category_adapter = new CategoryAdapter(this, categoryList);

        RecyclerView.LayoutManager LayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false);
        recyclerView_category.setLayoutManager(LayoutManager);
        //recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(10), true));
        recyclerView_category.setItemAnimator(new DefaultItemAnimator());
        recyclerView_category.setAdapter(adapter);

        prepareCategory();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.notification) {
            Toast.makeText(HomePage.this, "Notification", Toast.LENGTH_SHORT).show();
            return true;
        }
        else if (id == R.id.search) {
            Toast.makeText(HomePage.this, "Search", Toast.LENGTH_SHORT).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    private void init() {
        for(int i=0;i<IMAGES.length;i++)
            ImagesArray.add(IMAGES[i]);

        mPager = (ViewPager) findViewById(R.id.pager);


        mPager.setAdapter(new SlidingImage_Adapter(HomePage.this,ImagesArray));

        CircleIndicator indicator = (CircleIndicator) findViewById(R.id.indicator);
        indicator.setViewPager(mPager);

        //mAdapter.registerDataSetObserver(indicator.getDataSetObserver());
    }


    public void initNavigationDrawer() {

        NavigationView navigationView = (NavigationView)findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {

                int id = menuItem.getItemId();

                switch (id) {
                    case R.id.home:
                        Toast.makeText(getApplicationContext(), "Home", Toast.LENGTH_SHORT).show();
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.myprofile:
                        Toast.makeText(getApplicationContext(), "My Profile", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.measurement:
                        Toast.makeText(getApplicationContext(), "Measurements", Toast.LENGTH_SHORT).show();
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.logout:
                        Toast.makeText(getApplicationContext(), "Logout", Toast.LENGTH_SHORT).show();
                        drawerLayout.closeDrawers();
                        break;
                }
                return true;
            }
        });

        //To access Navigation View Header
        View header = navigationView.getHeaderView(0);

        drawerLayout = (DrawerLayout)findViewById(R.id.drawer);

        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.drawer_open,R.string.drawer_close){

            @Override
            public void onDrawerClosed(View v){
                super.onDrawerClosed(v);
            }

            @Override
            public void onDrawerOpened(View v) {
                super.onDrawerOpened(v);
            }
        };
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
    }



    private void prepareArrivals() {
        int[] covers = new int[]{
                R.mipmap.backdp
        };

        ArivalDataModel a = new ArivalDataModel(covers[0], "Kurtis");
        arrivalList.add(a);
        a = new ArivalDataModel(covers[0], "Sherwanis");
        arrivalList.add(a);

        a = new ArivalDataModel(covers[0], "Pyjamas");
        arrivalList.add(a);

        a = new ArivalDataModel(covers[0], "Jeans");
        arrivalList.add(a);

        a = new ArivalDataModel(covers[0], "Sherwanis");
        arrivalList.add(a);

        a = new ArivalDataModel(covers[0], "Pyjamas");
        arrivalList.add(a);

        a = new ArivalDataModel(covers[0], "Jeans");
        arrivalList.add(a);

        a = new ArivalDataModel(covers[0], "Sherwanis");
        arrivalList.add(a);

        a = new ArivalDataModel(covers[0], "Pyjamas");
        arrivalList.add(a);

        a = new ArivalDataModel(covers[0], "Jeans");
        arrivalList.add(a);

    }

    private void prepareCategory() {
        int[] covers = new int[]{
                R.mipmap.backdp
        };

        CategoryDataModel a = new CategoryDataModel(covers[0], "Kurtis");
        categoryList.add(a);
        a = new CategoryDataModel(covers[0], "Sherwanis");
        categoryList.add(a);

        a = new CategoryDataModel(covers[0], "Pyjamas");
        categoryList.add(a);

        a = new CategoryDataModel(covers[0], "Jeans");
        categoryList.add(a);

        a = new CategoryDataModel(covers[0], "Sherwanis");
        categoryList.add(a);

        a = new CategoryDataModel(covers[0], "Pyjamas");
        categoryList.add(a);

        a = new CategoryDataModel(covers[0], "Jeans");
        categoryList.add(a);

        a = new CategoryDataModel(covers[0], "Sherwanis");
        categoryList.add(a);

        a = new CategoryDataModel(covers[0], "Pyjamas");
        categoryList.add(a);

        a = new CategoryDataModel(covers[0], "Jeans");
        categoryList.add(a);

    }

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