package com.example.andre.hungrysiaapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class DinnerActivity extends AppCompatActivity {

    List<MenuItem> dinnerMenu;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dinner);

        dinnerMenu = new ArrayList<>();
        dinnerMenu.add(new MenuItem("Salted Egg Chicken with Rice",4.50,R.drawable.salted_egg_chicken));
        dinnerMenu.add(new MenuItem("Sweet and Sour Pork with Rice",5.00,R.drawable.sweet_and_sour_pork));
        dinnerMenu.add(new MenuItem("Fried Bee Hoon",4.00,R.drawable.fried_bee_hoon));

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.dinner_recyclerview);
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(this,dinnerMenu);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        recyclerView.setAdapter(recyclerViewAdapter);
    }
}
