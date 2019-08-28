package com.example.testeemjava;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<Animal> animalList = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inputList();

        recyclerView = findViewById(R.id.recyclerView);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(gridLayoutManager);
        Adapter adapter = new Adapter(animalList);
        recyclerView.setAdapter(adapter);

    }

    private void inputList() {
        if(animalList == null){
            animalList = new ArrayList<Animal>();
            animalList.add(new Animal("Astolfo", R.drawable.beagle));
            animalList.add(new Animal("Mel", R.drawable.dog_grande));
            animalList.add(new Animal("Caixinha", R.drawable.doguineo));
        }
    }

}
