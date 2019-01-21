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
        dinnerMenu.add(new MenuItem("Mega Salted Egg Chicken Rice w Egg add Meat",7.00,R.drawable.mega_salted_egg_chicken));
        dinnerMenu.add(new MenuItem("Salted Egg Chicken Rice w Egg",6.00,R.drawable.egg_salted_egg_chicken));
        dinnerMenu.add(new MenuItem("Salted Egg Chicken  Rice",5.50,R.drawable.salted_egg_chicken));
        dinnerMenu.add(new MenuItem("Black Butter Chicken Rice w Egg",6.00,R.drawable.egg_black_butter_chicken));
        dinnerMenu.add(new MenuItem("Black Butter Chicken Rice",5.50,R.drawable.black_butter_chicken));
        dinnerMenu.add(new MenuItem("Yang Chow Fried Rice w Egg",6.50,R.drawable.egg_yangzhou_fried_rice));
        dinnerMenu.add(new MenuItem("Yang Chow Fried Rice ",5.50,R.drawable.yangzhou_fried_rice));
        dinnerMenu.add(new MenuItem("Salted Veg Fried Meat Rice",5.50,R.drawable.asdf));
        dinnerMenu.add(new MenuItem("Stewed Mixed Vegetable Rice",5.50,R.drawable.asdf));
        dinnerMenu.add(new MenuItem("Crispy Noodles",5.50,R.drawable.asdf));
        dinnerMenu.add(new MenuItem("Hongkong Mee",5.50,R.drawable.asdf));
        dinnerMenu.add(new MenuItem("Beef Hor Fan",5.50,R.drawable.asdf));
        dinnerMenu.add(new MenuItem("Fried Hor Fan (Vegetarian)",5.00,R.drawable.asdf));
        dinnerMenu.add(new MenuItem("Mee Goreng (Vegetarian)",5.00,R.drawable.asdf));

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.dinner_recyclerview);
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(this,dinnerMenu);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        recyclerView.setAdapter(recyclerViewAdapter);
    }
}
