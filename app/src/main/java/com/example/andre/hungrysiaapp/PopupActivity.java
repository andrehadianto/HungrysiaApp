package com.example.andre.hungrysiaapp;

import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class PopupActivity extends Activity {
    private ImageView image_item_thumbnail;
    private TextView text_item_name;
    private TextView text_item_price;
    private EditText edittext_quantity;
    private Button button_add_qty;
    private Button button_minus_qty;
    private int quantity;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;
        int height = dm.heightPixels;
        getWindow().setLayout((int)(0.8*width),(int)(0.8*height));

        Intent fromMenu = getIntent();
        int item_thumbnail = fromMenu.getExtras().getInt("THUMBNAIL");
        String item_name = fromMenu.getExtras().getString("NAME");
        Double item_price = fromMenu.getExtras().getDouble("PRICE");

        image_item_thumbnail = findViewById(R.id.popup_thumbnail);
        text_item_name = findViewById(R.id.popup_name);
        text_item_price = findViewById(R.id.popup_price);
        edittext_quantity = findViewById(R.id.popup_quantity_edittext);
        button_add_qty = findViewById(R.id.popup_add_button);
        button_minus_qty = findViewById(R.id.popup_minus_button);

        image_item_thumbnail.setImageResource(item_thumbnail);
        text_item_name.setText(item_name);
        text_item_price.setText("$"+item_price.toString());
        edittext_quantity.setText("0", TextView.BufferType.EDITABLE);

        button_add_qty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quantity = Integer.parseInt(edittext_quantity.getText().toString());
                quantity+=1;
                edittext_quantity.setText(""+quantity,TextView.BufferType.EDITABLE);
            }
        });
        button_minus_qty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quantity = Integer.parseInt(edittext_quantity.getText().toString());
                if (quantity>0) {
                    quantity -= 1;
                    edittext_quantity.setText(""+quantity,TextView.BufferType.EDITABLE);
                }
            }
        });
    }
}
