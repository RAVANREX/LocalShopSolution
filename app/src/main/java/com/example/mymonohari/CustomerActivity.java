package com.example.mymonohari;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import org.jetbrains.annotations.NotNull;

public class CustomerActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    ActionBarDrawerToggle toggle;
    // Intent Values
    TextView shopName, shopOwner,distance;
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer);
        //<------------------------Hooks------------------------------------->
        drawerLayout = findViewById(R.id.cust_drawer_layout);
        navigationView = findViewById(R.id.cust_navigation_view);
        toolbar = findViewById(R.id.cust_tool_bar);
        //<---------------------Tool Bar as Our Action Bar-------------------->
        setSupportActionBar(toolbar);
        toolbar.inflateMenu(R.menu.toolbar_icon_menu);
        //<-----------------Navigation Menu------------------------------->
        navigationView.bringToFront();
        toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
//        toggle.setDrawerIndicatorEnabled(false);
//        toggle.setHomeAsUpIndicator(R.drawable.burger_tray);
        drawerLayout.addDrawerListener(toggle);
        navigationView.setNavigationItemSelectedListener(this);
//        <---------------Setting Text and Images------------------->
        shopName=findViewById(R.id.textView);
//        shopName.setText(getIntent().getStringExtra("ShopName"));

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.toolbar_icon_menu, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement

        if (id == R.id.dashboard_user) {

//            Intent intent = new Intent(this,SecondActivity.class);
//            this.startActivity(intent);
            item.setOnMenuItemClickListener(item1 -> {
                LoginFragment loginFragment = new LoginFragment();
                loginFragment.show(getSupportFragmentManager(), loginFragment.getTag());

                return true;
            });

        }
        if (id == R.id.dashboard_cart) {

//            Intent intent = new Intent(this,SecondActivity.class);
//            this.startActivity(intent);

            Toast.makeText(this, "Cart is Clicked", Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {//DRAWER LAYOUT

        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull @NotNull MenuItem item) {
        return true;
    }
}