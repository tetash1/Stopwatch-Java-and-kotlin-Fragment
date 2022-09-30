package com.nahidnafiz.myintentjavatokotlin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class Main extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    BooksFragment booksFragment = new BooksFragment();
    ComunacationFragment comunacationFragment = new ComunacationFragment();
    IronwillFragment ironwillFragment = new IronwillFragment();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);


        bottomNavigationView  = findViewById(R.id.bottom_navigation);
        getSupportFragmentManager().beginTransaction().replace(R.id.container,ironwillFragment).commit();

        BadgeDrawable badgeDrawable = bottomNavigationView.getOrCreateBadge(R.id.book_menu);
        badgeDrawable.setVisible(true);
        badgeDrawable.setNumber(8);

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.book_menu:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,booksFragment).commit();
                        return true;
                    case R.id.ironwill_manu:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,ironwillFragment).commit();
                        return true;
                    case R.id.database:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,comunacationFragment).commit();
                        return true;
                }

                return false;
            }
        });



    }
}