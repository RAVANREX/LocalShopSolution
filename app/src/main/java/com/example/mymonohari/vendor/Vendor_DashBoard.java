package com.example.mymonohari.vendor;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.WindowManager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.mymonohari.R;
import com.google.android.material.navigation.NavigationView;

import org.jetbrains.annotations.NotNull;

public class Vendor_DashBoard  extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {


    //<------------------------NavigationView Hooks------------------------------------->
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.vendor_dashboard);


        /////////////////// NavigationView ////////////////////////////////

        //<------------------------Hooks------------------------------------->
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_view);
        toolbar = findViewById(R.id.my_toolbar);
        //<---------------------Tool Bar as Our Action Bar-------------------->
        setSupportActionBar(toolbar);
        //<-----------------Navigation Menu------------------------------->
        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new Vendor_Fragment_DashBoard()).commit();
        navigationView.setNavigationItemSelectedListener(this);

        /////////////////// END \NavigationView ////////////////////////////////



    }


    @Override
    public boolean onNavigationItemSelected(@NonNull @NotNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.vendor_dashboard:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new Vendor_Fragment_DashBoard()).commit();
                break;
            case R.id.vendor_profile:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new Vendor_Fragment_Profile()).commit();
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}
