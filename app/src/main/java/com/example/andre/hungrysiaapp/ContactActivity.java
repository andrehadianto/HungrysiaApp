package com.example.andre.hungrysiaapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ContactActivity extends AppCompatActivity {
    private TextView text_name;
    private EditText edittext_name;
    private TextView text_phone;
    private EditText editText_phone;
    private TextView text_cohort;
    private Spinner spinner_cohort;
    private Button button_contact_next;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        text_name = findViewById(R.id.name_text);
        edittext_name = findViewById(R.id.name_edittext);
        text_phone = findViewById(R.id.phone_text);
        editText_phone = findViewById(R.id.phone_edittext);
        text_cohort = findViewById(R.id.cohort_text);
        spinner_cohort = findViewById(R.id.cohort_spinner);
        button_contact_next = findViewById(R.id.contact_next_button);

        final String[] cohorts_ = {"Select your cohort","F01","F02","F03","F04","F05","F06","F07","F08","F09","F10","ASD","EPD","ESD","ISTD"};
        List<String> cohorts = new ArrayList<>(Arrays.asList(cohorts_));
        ArrayAdapter<String> adapter_cohorts = new ArrayAdapter<String>(ContactActivity.this,android.R.layout.simple_spinner_item,cohorts);
        adapter_cohorts.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_cohort.setAdapter(adapter_cohorts);

        button_contact_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String string_phone = text_phone.getText().toString();
                if (string_phone.charAt(0)!=8 && string_phone.charAt(0)!=9){
                    Toast.makeText(ContactActivity.this,"Invalid phone number",Toast.LENGTH_LONG);
                }
            }
        });
    }
}
