package com.example.acamica.recyclegrid;

import android.support.annotation.NonNull;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements MainFragment.OnItemSelectedListener, NavigationView.OnNavigationItemSelectedListener {

    public static final String FIRST_FRAGMENT_TAG = "FirstFragmentTag";
    public static final String SECOND_FRAGMENT_TAG = "SecondFragmentTag";
    public static final String THIRD_FRAGMENT_TAG = "ThirdFragmentTag";
    private DrawerLayout drawerLayout;
    private int navigationItemSelectedId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        if(toolbar != null){
            setSupportActionBar(toolbar);
        }

        CollapsingToolbarLayout collapsingToolbarLayout = findViewById(R.id.collapsing_toolbar_layout);

        if (collapsingToolbarLayout != null){
            collapsingToolbarLayout.setTitle(getBaseContext().getString(R.string.toolbar_title));
        }

        FloatingActionButton floatingActionButton = findViewById(R.id.floating_action_button);
        if(floatingActionButton != null){
            floatingActionButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.d("MainActivity", "Selected favorite");
                    Snackbar.make(view, getBaseContext().getString(R.string.added_to_favorites), Snackbar.LENGTH_SHORT).setAction("Action", null).show();
                }
            });
        }

        drawerLayout = findViewById(R.id.drawer_layout);
        if(drawerLayout != null){
            ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open_navigation_drawer, R.string.close_navigation_drawer);
            drawerLayout.addDrawerListener(toggle);
            toggle.syncState();
        }
        NavigationView navigationView = findViewById(R.id.navigation_view);
        if(navigationView != null){
            navigationView.setNavigationItemSelectedListener(this);
        }

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.fragment_holder, new MainFragment(), FIRST_FRAGMENT_TAG);
        transaction.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_home:
                Toast.makeText(MainActivity.this, R.string.home_message, Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_search:
                Toast.makeText(MainActivity.this, R.string.search_message, Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_settings:
                Toast.makeText(MainActivity.this, R.string.settings_message, Toast.LENGTH_SHORT).show();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemSelected(int id) {
        Log.d("MainActivity", "Item selected: " + id);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id != navigationItemSelectedId) {
            navigationItemSelectedId = id;
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            switch (navigationItemSelectedId) {
                case R.id.navigation_item_1:
                    transaction.replace(R.id.fragment_holder, new MainFragment(), FIRST_FRAGMENT_TAG);
                    break;
                case R.id.navigation_item_2:
                    transaction.replace(R.id.fragment_holder, new TabSelectorFragment(), SECOND_FRAGMENT_TAG);
                    break;
                case R.id.navigation_item_3:
                    transaction.replace(R.id.fragment_holder, new MainFragment(), THIRD_FRAGMENT_TAG);
                    break;
            }
            transaction.commit();
            drawerLayout.closeDrawer(GravityCompat.START);
            return true;
        } else {
            return true;
        }
    }
}
