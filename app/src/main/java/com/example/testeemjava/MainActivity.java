package com.example.testeemjava;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.example.testeemjava.fragments.Home;
import com.example.testeemjava.fragments.Menu;
import com.example.testeemjava.fragments.Search;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private BottomNavigationView bottomNavigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.bottom_navigation);
       bottomNavigationView.setOnNavigationItemSelectedListener(this);
        Intent i = getIntent();

        User user  = (User) i.getSerializableExtra("user");
        Log.d("user", "nome" + user.getName());
        showFragment(new Home());

    }

    public void showFragment(Fragment fragment){
        getSupportFragmentManager ()
                .beginTransaction ()
                .replace (R.id.frame_layout_home, fragment)
                .commit ();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        switch(menuItem.getItemId()){

            case(R.id.ic_home):
                showFragment(new Home());
                break;

            case(R.id.ic_search):
                showFragment(new Search());
                break;

            case(R.id.ic_menu):
                showFragment(new Menu());
                break;


        }
        return true;
    }
}
