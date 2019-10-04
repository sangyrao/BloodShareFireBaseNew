package com.example.abhishek.blood;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class search extends AppCompatActivity implements  View.OnClickListener {
    EditText city;
    EditText blood;
    Button search_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search);
        city = findViewById(R.id.city_search);
        blood = findViewById(R.id.blood);

        search_btn = findViewById(R.id.search_bt);
        search_btn.setOnClickListener(this);


    }


    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.search_bt:
                String city1 = city.getText().toString();
                String blood1 = blood.getText().toString();
                Intent intent = new Intent(getApplicationContext(),ViewListContentsSearch.class);
                intent.putExtra("city", city1);
                intent.putExtra("blood", blood1);
                startActivity(intent);
                break;
                default:

        }
    }
}


