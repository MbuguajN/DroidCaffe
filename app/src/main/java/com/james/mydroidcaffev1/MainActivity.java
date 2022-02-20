package com.james.mydroidcaffev1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TableLayout;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //inflate your toolbar
        Toolbar toolbar = findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);
        drawer=findViewById(R.id.drawer_layout);

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle( this, drawer,toolbar,R.string.navigation_drawer_open
        , R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();




        //create instance of the tab layout and add the tabs
        TabLayout tabLayout = findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText(R.string.tab_label_1));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.tab_label_2));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.tab_label_3));
        //set the tab to fill the layout
        tabLayout.setTabGravity(tabLayout.GRAVITY_FILL);
        //USE THE PAGER ADAPTER TO MANAGE SCREENS
        //CREATE AN INSTANCE OF THE VIEW PAGER
        final ViewPager viewpager = findViewById(R.id.view_pager);
        //create an instance of the pageadapter
        final PageAdapter pageAdapter = new PageAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewpager.setAdapter(pageAdapter);
        //srt the adapter to the viewpager

        viewpager.setAdapter(pageAdapter);
        //set listener for clicks

        viewpager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewpager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.nav_fast_food:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new FastFoodFragment()).commit();
                break;
            case R.id.nav_drinks:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new drinksFragment()).commit();
                break;
            case R.id.nav_delivery:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new delivery_fragment()).commit();
                break;
            case R.id.nav_share:
                Toast.makeText( this, "share", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_about_us:
                Toast.makeText( this, "about us", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_contact:
                Toast.makeText( this, "contact us", Toast.LENGTH_SHORT).show();
                break;
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    @Override
    public void onBackPressed() {
        if(drawer.isDrawerOpen((GravityCompat.START))){
         drawer.closeDrawer(GravityCompat.START);
        }else {
            super.onBackPressed();
        }
    }
}