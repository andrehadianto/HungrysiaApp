package com.example.andre.hungrysiaapp;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

public class SelectionActivity extends AppCompatActivity {
    private ImageButton dinner_button;
    private ImageButton supper_button;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection);

        dinner_button = findViewById(R.id.dinner_button);
        supper_button = findViewById(R.id.supper_button);

        dinner_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toDinnerActivity = new Intent(SelectionActivity.this,DinnerActivity.class);
                startActivity(toDinnerActivity);
            }
        });

        supper_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toSupperActivity = new Intent(SelectionActivity.this,SupperActivity.class);
                startActivity(toSupperActivity);
            }
        });
    }
}
