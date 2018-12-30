//1  secret code
package com.example.andre.hungrysiaapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView text_secretcode;
    private EditText edittext_secretcode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text_secretcode = findViewById(R.id.secretcode_text);
        edittext_secretcode = findViewById(R.id.secretcode_edittext);
    }

}