package com.example.bottomnavigationbarviewsample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.bottomnavigationbarviewsample.databinding.ActivityMainBinding;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // hide toolbar
        getSupportActionBar().hide();

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setCurrentFragment();


    }

    private void setCurrentFragment() {

        binding.bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment currFragment = null;
                switch(item.getItemId()){
                    case R.id.home:
                        currFragment = new HomeFragment();
                        break;
                    case R.id.notification:
                        currFragment = new NotificationFragment();
                        break;
                    case R.id.add:
                        currFragment = new AddFragment();
                        break;
                    case R.id.search:
                        currFragment = new SearchFragment();
                        break;
                    case R.id.profile:
                        currFragment = new ProfileFragment();
                        break;

                }
                getSupportFragmentManager().beginTransaction().replace(binding.fragmentContainer.getId(),currFragment).commit();
                return true;
            }
        });
    }
}