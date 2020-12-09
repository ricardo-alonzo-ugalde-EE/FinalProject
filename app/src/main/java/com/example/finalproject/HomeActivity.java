package com.example.finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class HomeActivity extends AppCompatActivity {
    private DrawerLayout mDrawer;
    private androidx.appcompat.widget.Toolbar toolbar;
    private NavigationView nvDrawer;

    // Make sure to be using androidx.appcompat.app.ActionBarDrawerToggle version.
    private ActionBarDrawerToggle drawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);

        //layout color change
        Window window = HomeActivity.this.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.setStatusBarColor(ContextCompat.getColor(HomeActivity.this, R.color.colorAccent));

        // Set a Toolbar to replace the ActionBar.
        toolbar =  findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // This will display an Up icon (<-), we will replace it with hamburger later
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        // Find our drawer view
        mDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        nvDrawer = (NavigationView) findViewById(R.id.nvView);
        drawerToggle = setupDrawerToggle();
        drawerToggle.setDrawerIndicatorEnabled(true);
        drawerToggle.syncState();
        // Tie DrawerLayout events to the ActionBarToggle
        mDrawer.addDrawerListener(drawerToggle);
        // Setup drawer view
        setupDrawerContent(nvDrawer);
        ImageButton btn_home = (ImageButton) findViewById(R.id.about_button);
        btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(v.getContext(), MainActivity.class);
                startActivity(intent1);
            }
        });
        ImageButton btn_view = (ImageButton) findViewById(R.id.view_button);
        btn_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "Activity 2!", Toast.LENGTH_SHORT).show();
//                Intent intent2 = new Intent(v.getContext(), SlideActivity.class);
//                startActivity(intent2);
            }
        });
        ImageButton btn_master = (ImageButton) findViewById(R.id.master_button);
        btn_master.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "Activity 3!", Toast.LENGTH_SHORT).show();
//                Intent intent3 = new Intent(v.getContext(), MasterActivity.class);
//                startActivity(intent3);
            }
        });
    }

    private ActionBarDrawerToggle setupDrawerToggle() {
        return new ActionBarDrawerToggle(this, mDrawer, toolbar, R.string.drawer_open,  R.string.drawer_close);
    }

    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        selectDrawerItem(menuItem);
                        return true;
                    }
                });
    }

    public void selectDrawerItem(MenuItem menuItem) {
        switch(menuItem.getItemId()) {
            case R.id.nav_first_fragment:
                Intent intent1=new Intent(this, MainActivity.class);
                startActivity(intent1);
//                fragmentClass = MainActivity.class;
                break;
            case R.id.nav_second_fragment:
//                Intent intent2=new Intent(this, SlideActivity.class);
//                startActivity(intent2);
                Toast.makeText(this, "Activity 2! Again!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_third_fragment:
                Toast.makeText(this, "Activity 3! Again!", Toast.LENGTH_SHORT).show();
//                Intent intent3=new Intent(this, MasterActivity.class);
//                startActivity(intent3);
                break;
            default:
                Intent intent4=new Intent(this, MainActivity.class);
                startActivity(intent4);
        }

        menuItem.setChecked(true);
        // Set action bar title
        setTitle(menuItem.getTitle());
        // Close the navigation drawer
        mDrawer.closeDrawers();
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // The action bar home/up action should open or close the drawer.
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawer.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
