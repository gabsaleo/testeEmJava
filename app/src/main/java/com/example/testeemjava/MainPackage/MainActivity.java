package com.example.testeemjava.MainPackage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.example.testeemjava.AddPetPackage.AddPet;
import com.example.testeemjava.R;
import com.example.testeemjava.HomePackage.Home;
import com.example.testeemjava.SearchPackage.Search;
import com.example.testeemjava.fragments.Menu;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements MainContract.View {

    private BottomNavigationView bottomNavigationView;
    private Fragment AddPet;
    private View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showFragment(new Home(this));
        bottomNavigationView = findViewById(R.id.bottom_navigation);
       bottomNavigationView.setOnNavigationItemSelectedListener( menuItem -> {
            identifyItemClicked(menuItem);
            return true;
       });


    }

    public void showFragment(Fragment fragment){
        getSupportFragmentManager ()
                .beginTransaction ()
                .replace (R.id.frame_layout_home, fragment)
                .commit ();
    }

    public void identifyItemClicked(MenuItem menuItem) {
        switch(menuItem.getItemId()){

            case(R.id.ic_home):
                showFragment(new Home(this));
                break;
            case(R.id.ic_add_pet):
                showFragment(new AddPet(this));
                break;

            case(R.id.ic_search):
                showFragment(new Search(this));
                break;

            case(R.id.ic_menu):
                showFragment(new Menu());
                break;


        }
    }

}
