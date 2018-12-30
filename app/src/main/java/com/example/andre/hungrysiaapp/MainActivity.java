//1  secret code
package com.example.andre.hungrysiaapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView text_secretcode;
    private EditText edittext_secretcode;
    private String string_secretcode = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text_secretcode = findViewById(R.id.secretcode_text);
        edittext_secretcode = findViewById(R.id.secretcode_edittext);

        edittext_secretcode.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after){}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable s) {
                string_secretcode = edittext_secretcode.getText().toString();
                if (string_secretcode == getResources().getString(R.string.secret_code)){
                    Intent toContact = new Intent(MainActivity.this,ContactActivity.class);
                    startActivity(toContact);
                }
            }
        });
    }
}