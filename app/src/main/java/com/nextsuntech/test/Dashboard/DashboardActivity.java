package com.nextsuntech.test.Dashboard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.nextsuntech.test.Dashboard.Fragments.CartFragment;
import com.nextsuntech.test.Dashboard.Fragments.HomeFragment;
import com.nextsuntech.test.Dashboard.Fragments.MenuFragment;
import com.nextsuntech.test.Dashboard.Fragments.ProfileFragment;
import com.nextsuntech.test.Dashboard.Fragments.SearchFragment;
import com.nextsuntech.test.R;

public class DashboardActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        replaceFragment(new HomeFragment());
        bottomNavigationView = findViewById(R.id.bottomNavigationView);



        bottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()){

                case R.id.home:
                    replaceFragment(new HomeFragment());
                    break;
                    case R.id.search:
                        replaceFragment(new SearchFragment());
                        break;
                       case R.id.cart:
                           replaceFragment(new CartFragment());
                            break;
                            case R.id.menu:
                                replaceFragment(new MenuFragment());
                                break;
                                case R.id.profile:
                                    replaceFragment(new ProfileFragment());
                                    break;

            }
            return true;
        });
    }

    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout,fragment);
        fragmentTransaction.commit();
    }
}