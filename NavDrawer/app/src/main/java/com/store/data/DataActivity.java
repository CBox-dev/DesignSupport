package com.store.data;

import android.support.annotation.NonNull;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.NavigationView.OnNavigationItemSelectedListener;
import android.support.design.widget.TabLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class DataActivity extends AppCompatActivity implements OnNavigationItemSelectedListener
{
    private Toolbar mToolbar;
    private NavigationView mNavigationView;
    private DrawerLayout mDrawer;
    private TabLayout mTabLayout;
    private ViewPager mPager;
    private SampleAdapter mAdapter;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_store);
        //Toolbar
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        //DrawerLayout
        mDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        //ActionBarDrawerToggle
        final ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, mDrawer, mToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mDrawer.setDrawerListener(toggle);
        toggle.syncState();
        //NavigationView
        mNavigationView = (NavigationView) findViewById(R.id.nav_view);
        mNavigationView.setNavigationItemSelectedListener(this);
        
        //ViewPager
        mAdapter = new SampleAdapter(this, getSupportFragmentManager());
        mPager = (ViewPager)findViewById(R.id.id_viewpager);
        mPager.setAdapter(mAdapter);
        //Tablayout
        mTabLayout = (TabLayout)findViewById(R.id.tab_layout);
        mTabLayout.setupWithViewPager(mPager);
        mTabLayout.setTabMode(TabLayout.MODE_FIXED);
        mTabLayout.setTabTextColors(getResources().getColor(android.R.color.white), getResources().getColor(R.color.candidate_recommended));
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig)
    {
        super.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item)
    {
        switch(item.getItemId()){
           case R.id.nav_home:
               break;
            case R.id.nav_favorite:
                break;
            case R.id.nav_search:
                break;   
            case R.id.nav_new:
                break;
            case R.id.nav_info:
                break; 
            case R.id.nav_exit:
                DataActivity.this.finish();
                break;   
       }
        mDrawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_data_store, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch(item.getItemId()){
            case R.id.action_close:
                item.setChecked(!item.isChecked());

                if (item.isChecked()) {
                    mAdapter.setPageCount(3);
                    mTabLayout.setTabMode(TabLayout.MODE_FIXED);
                }
                else {
                    mAdapter.setPageCount(10);
                    mTabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
                }

                mAdapter.notifyDataSetChanged();

                if (mPager.getCurrentItem()>=3) {
                    mPager.setCurrentItem(2);
                }
                
                break;
        }
        return super.onOptionsItemSelected(item);
    }
    
    
    @Override
    public void onBackPressed() {
        
        if (mDrawer.isDrawerOpen(GravityCompat.START)) {
            mDrawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}
