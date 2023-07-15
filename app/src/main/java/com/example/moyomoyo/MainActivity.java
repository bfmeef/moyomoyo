package com.example.moyomoyo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
    private FragmentManager fragmentManager = getSupportFragmentManager();
    private MainMenuHome fragmentHome = new MainMenuHome();
    private MainMenuStudyRoom fragmentStudyRoom = new MainMenuStudyRoom();
    private MainMenuGroup fragmentGroup = new MainMenuGroup();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.menu_frame_layout, fragmentHome).commitAllowingStateLoss();

        BottomNavigationView bottomNavigationView = findViewById(R.id.menu_bottom_navigation);
        bottomNavigationView.setOnItemSelectedListener(new ItemSelectedListener());
    }

    class ItemSelectedListener implements NavigationBarView.OnItemSelectedListener {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem){
            FragmentTransaction transaction = fragmentManager.beginTransaction();

            switch(menuItem.getItemId()) {
                case R.id.menu_home:
                    transaction.replace(R.id.menu_frame_layout, fragmentHome).commitAllowingStateLoss();
                    break;
                case R.id.menu_study_room:
                    transaction.replace(R.id.menu_frame_layout, fragmentStudyRoom).commitAllowingStateLoss();
                    break;
                case R.id.menu_group:
                    transaction.replace(R.id.menu_frame_layout, fragmentGroup).commitAllowingStateLoss();
                    break;
            }

            return true;
        }
    }
}