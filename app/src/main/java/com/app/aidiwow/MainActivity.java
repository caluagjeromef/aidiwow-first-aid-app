package com.app.aidiwow;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    BotFrag botFrag = new BotFrag();
    TipsFrag tipsFrag = new TipsFrag();
    QuizFrag quizFrag = new QuizFrag();
    MapsFrag mapsFrag = new MapsFrag();
    MiscFrag miscFrag = new MiscFrag();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottom_navigation);

        getSupportFragmentManager().beginTransaction().replace(R.id.container,botFrag).commit();

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.nav_bot:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,botFrag).commit();
                        return true;
                    case R.id.nav_tips:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,tipsFrag).commit();
                        return true;
                    case R.id.nav_quiz:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,quizFrag).commit();
                        return true;
                    case R.id.nav_map:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,mapsFrag).commit();
                        return true;
                    case R.id.nav_misc:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,miscFrag).commit();
                        return true;
                }

                return false;
            }

        });
    }
}