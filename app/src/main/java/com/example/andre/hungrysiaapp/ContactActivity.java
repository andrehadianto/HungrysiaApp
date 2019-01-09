package com.example.andre.hungrysiaapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
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
    private EditText edittext_phone;
    private TextView text_cohort;
    private Spinner spinner_cohort;
    private Button button_contact_next;

    private SharedPreferences mPreferences;
    public static final String NAME_KEY = "name_key";
    public static final String PHONE_KEY = "phone_key";
    public static final String COHORT_KEY = "cohort_key";
    private SharedPreferences.Editor mEditor;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        text_name = findViewById(R.id.name_text);
        edittext_name = findViewById(R.id.name_edittext);
        text_phone = findViewById(R.id.phone_text);
        edittext_phone = findViewById(R.id.phone_edittext);
        text_cohort = findViewById(R.id.cohort_text);
        spinner_cohort = findViewById(R.id.cohort_spinner);
        button_contact_next = findViewById(R.id.contact_next_button);

        mPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        mEditor = mPreferences.edit();

        edittext_name.setText(mPreferences.getString(NAME_KEY,""));
        edittext_phone.setText(mPreferences.getString(PHONE_KEY,""));
        spinner_cohort.setSelection(mPreferences.getInt(COHORT_KEY,-1));


        final String[] cohorts_ = {"Select your cohort","F01","F02","F03","F04","F05","F06","F07","F08","F09","F10","ASD","EPD","ESD","ISTD"};
        List<String> cohorts = new ArrayList<>(Arrays.asList(cohorts_));
        ArrayAdapter<String> adapter_cohorts = new ArrayAdapter<String>(ContactActivity.this,android.R.layout.simple_spinner_item,cohorts);
        adapter_cohorts.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_cohort.setAdapter(adapter_cohorts);

        button_contact_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String string_name = edittext_name.getText().toString();
                String string_phone = edittext_phone.getText().toString();
                String string_cohort = spinner_cohort.getSelectedItem().toString();
                if (string_name.isEmpty()){
                    edittext_name.setError("Name field is required!");
                }
                else if (string_phone.isEmpty()){
                    edittext_phone.setError("Phone number is required!");
                }
                else if (string_phone.length() != 8 | !(string_phone.startsWith("8") || string_phone.startsWith("9"))){
                    edittext_phone.setError("Invalid phone number!");
                }
                else if (string_cohort.equals(cohorts_[0])){
                    Toast.makeText(ContactActivity.this,"Invalid cohort",Toast.LENGTH_LONG).show();
                }
                else{
                    mEditor.putString(NAME_KEY,edittext_name.getText().toString());
                    mEditor.putString(PHONE_KEY,edittext_phone.getText().toString());
                    mEditor.putInt(COHORT_KEY,spinner_cohort.getSelectedItemPosition());
                    mEditor.apply();

                    Log.i("debugspinner",""+spinner_cohort.getSelectedItemPosition());
                    Intent toSelection = new Intent(ContactActivity.this,SelectionActivity.class);
                    startActivity(toSelection);
                }
            }
        });
    }
}
