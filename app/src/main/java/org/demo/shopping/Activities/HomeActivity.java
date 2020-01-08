package org.demo.shopping.Activities;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.widget.ImageView;
import android.widget.TextView;

import org.demo.shopping.R;

public class HomeActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    TextView categoryname;
    Toolbar toolbar;
    ImageView cartscreen;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("");
        categoryname=findViewById(R.id.categoryname);
        toolbar.setNavigationIcon(getDrawable(R.drawable.ic_navigationicon));
        cartscreen = findViewById(R.id.cartscreen);

        cartscreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this,CartActivity.class));
            }
        });

//        FloatingActionButton fab = findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener()
//        {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_defaultfragment,
                R.id.nav_womenfootwear, R.id.nav_mensfootwear, R.id.nav_womencasualwear,
                R.id.nav_mencasualwear, R.id.nav_womenformalwear, R.id.nav_menformalwear,R.id.nav_wishlist)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        navController.addOnDestinationChangedListener(new NavController.OnDestinationChangedListener() {
            @Override
            public void onDestinationChanged(@NonNull NavController controller, @NonNull NavDestination destination, @Nullable Bundle arguments) {

                if (destination.getId() == R.id.nav_defaultfragment)

                {
                    categoryname.setText("Home Screen");
                    toolbar.setTitle("");
                    toolbar.setNavigationIcon(getDrawable(R.drawable.ic_navigationicon));
                }
                if (destination.getId() == R.id.nav_womenfootwear)

                {
                    categoryname.setText("Women’s footwear");
                    toolbar.setTitle("");
                    toolbar.setNavigationIcon(getDrawable(R.drawable.ic_navigationicon));
                }
                if (destination.getId() == R.id.nav_mensfootwear)

                {
                    categoryname.setText("Men’s footwear");
                    toolbar.setTitle("");
                    toolbar.setNavigationIcon(getDrawable(R.drawable.ic_navigationicon));
                }
                if (destination.getId() == R.id.nav_womencasualwear)

                {
                    categoryname.setText("Women’s casualwear");
                    toolbar.setTitle("");
                    toolbar.setNavigationIcon(getDrawable(R.drawable.ic_navigationicon));
                }
                if (destination.getId() == R.id.nav_mencasualwear)

                {
                    categoryname.setText("Men’s casualwear");
                    toolbar.setTitle("");
                    toolbar.setNavigationIcon(getDrawable(R.drawable.ic_navigationicon));
                }
                if (destination.getId() == R.id.nav_womenformalwear)

                {
                    categoryname.setText("Women’s formalwear");
                    toolbar.setTitle("");
                    toolbar.setNavigationIcon(getDrawable(R.drawable.ic_navigationicon));
                }
                if (destination.getId() == R.id.nav_menformalwear)

                {
                    toolbar.setTitle("");
                    categoryname.setText("Men’s formalwear");
                    toolbar.setNavigationIcon(getDrawable(R.drawable.ic_navigationicon));
                }
                if (destination.getId() == R.id.nav_wishlist)

                {
                    categoryname.setText("WishList");
                    toolbar.setTitle("");
                    toolbar.setNavigationIcon(getDrawable(R.drawable.ic_navigationicon));
                }
            }
        });
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.home, menu);
//        return true;
//    }
    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}
