package com.example.acamica.recyclegrid;

import android.support.annotation.NonNull;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements MainFragment.OnItemSelectedListener, NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawerLayout;

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

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.action_home:
                Toast.makeText(MainActivity.this, "Going home", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_search:
                Toast.makeText(MainActivity.this, "This is your search", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_settings:
                Toast.makeText(MainActivity.this, "Settings not available", Toast.LENGTH_SHORT).show();
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

        switch (id){
            case R.id.navigation_item_1:
                Toast.makeText(MainActivity.this, R.string.navigation_item_1, Toast.LENGTH_SHORT).show();
                break;
            case R.id.navigation_item_2:
                Toast.makeText(MainActivity.this, R.string.navigation_item_2, Toast.LENGTH_SHORT).show();
                break;
            case R.id.navigation_item_3:
                Toast.makeText(MainActivity.this, R.string.navigation_item_3, Toast.LENGTH_SHORT).show();
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}
