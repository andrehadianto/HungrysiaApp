package com.example.andre.hungrysiaapp;

        import android.os.Bundle;
        import android.support.v7.app.AppCompatActivity;
        import android.support.v7.widget.GridLayoutManager;
        import android.support.v7.widget.RecyclerView;

        import java.util.ArrayList;
        import java.util.List;

public class SupperActivity extends AppCompatActivity {

    List<MenuItem> supperMenu;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dinner);

        supperMenu = new ArrayList<>();
        supperMenu.add(new MenuItem("Yangzhou Fried Rice",4.00,R.drawable.yangzhou_fried_rice));
        supperMenu.add(new MenuItem("Hor Fun",4.50,R.drawable.hor_fun));
        supperMenu.add(new MenuItem("Bak Chor Mee",4.00,R.drawable.bak_chor_mee));

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.dinner_recyclerview);
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(this,supperMenu);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        recyclerView.setAdapter(recyclerViewAdapter);
    }
}
