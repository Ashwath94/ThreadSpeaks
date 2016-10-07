package hyderabad.threadspeaks;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import hyderabad.threadspeaks.FeaturesRecycler.FeaturesAdapter;
import hyderabad.threadspeaks.FeaturesRecycler.FeaturesDataModel;

/**
 * Created by Pavithran on 25-09-2016.
 */
public class SelectFeatures extends AppCompatActivity {

    private Toolbar toolbar;
    private RecyclerView recyclerView;
    private FeaturesAdapter adapter;
    private List<FeaturesDataModel> featuresList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_madifyfeatures);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        toolbar.setTitleTextColor(Color.WHITE);
        getSupportActionBar().setTitle("");


        final Drawable upArrow = getResources().getDrawable(R.drawable.abc_ic_ab_back_material);
        upArrow.setColorFilter(getResources().getColor(R.color.icons), PorterDuff.Mode.SRC_ATOP);
        getSupportActionBar().setHomeAsUpIndicator(upArrow);


        recyclerView = (RecyclerView) findViewById(R.id.features_recycler);

        featuresList = new ArrayList<>();
        adapter = new FeaturesAdapter(this, featuresList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

        prepareFeatures();
    }

    public void prepareFeatures() {
        FeaturesDataModel f = new FeaturesDataModel("Sleeves", false);
        featuresList.add(f);
        f = new FeaturesDataModel("Sleeves", false);
        featuresList.add(f);
        f = new FeaturesDataModel("Sleeves", false);
        featuresList.add(f);
        f = new FeaturesDataModel("Sleeves", false);
        featuresList.add(f);
        f = new FeaturesDataModel("Sleeves", false);
        featuresList.add(f);
        f = new FeaturesDataModel("Sleeves", false);
        featuresList.add(f);
        f = new FeaturesDataModel("Sleeves", false);
        featuresList.add(f);
        f = new FeaturesDataModel("neck", false);

        featuresList.add(f);
        f = new FeaturesDataModel("Sleeves", false);
        featuresList.add(f);
        f = new FeaturesDataModel("Sleeves", false);
        featuresList.add(f);
        f = new FeaturesDataModel("Sleeves", false);
        featuresList.add(f);
        f = new FeaturesDataModel("Sleeves", false);
        featuresList.add(f);
        f = new FeaturesDataModel("Sleeves", false);
        featuresList.add(f);
        f = new FeaturesDataModel("Sleeves", false);
        featuresList.add(f);
        f = new FeaturesDataModel("Sleeves", false);
        featuresList.add(f);
        f = new FeaturesDataModel("Sleeves", false);

        featuresList.add(f);
        f = new FeaturesDataModel("Sleeves", false);
        featuresList.add(f);
        f = new FeaturesDataModel("Sleeves", false);
        featuresList.add(f);
        f = new FeaturesDataModel("Sleeves", false);
        featuresList.add(f);
        f = new FeaturesDataModel("Sleeves", false);
        featuresList.add(f);
        f = new FeaturesDataModel("Sleeves", false);
        featuresList.add(f);
        f = new FeaturesDataModel("Sleeves", false);
        featuresList.add(f);
        f = new FeaturesDataModel("Sleeves", false);
        featuresList.add(f);
        f = new FeaturesDataModel("neck", false);

        featuresList.add(f);
        f = new FeaturesDataModel("neck", false);
        featuresList.add(f);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.category_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.notification) {
            Toast.makeText(SelectFeatures.this, "Notification", Toast.LENGTH_SHORT).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
