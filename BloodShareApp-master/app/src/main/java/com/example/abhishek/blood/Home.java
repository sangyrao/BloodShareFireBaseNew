package com.example.abhishek.blood;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Home extends AppCompatActivity implements View.OnClickListener{
    Button search;
    Button signup;
    Button donor_list;
    Button about;
    Button contact;
    Button login;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        search = findViewById(R.id.search);
        signup = findViewById(R.id.signup);
        donor_list = findViewById(R.id.donor_list1);
        login = findViewById(R.id.login);
        about = findViewById(R.id.about);
        contact = findViewById(R.id.contact);

        search.setOnClickListener(this);
        signup.setOnClickListener(this);
        donor_list.setOnClickListener(this);
        contact.setOnClickListener(this);
        login.setOnClickListener(this);
        about.setOnClickListener(this);




    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        Intent intent;
        switch(id){
            case R.id.search :
                intent = new Intent(this,search.class);
                startActivity(intent);
                break;
            case R.id.login :
                //Yet to be implemented
                intent = new Intent(this,Login.class);
                startActivity(intent);
                break;
            case R.id.contact :
                intent = new Intent(this,contact.class);
                startActivity(intent);
                break;
            case R.id.about :
                intent = new Intent(this,about.class);
                startActivity(intent);
                break;
            case R.id.signup :
                intent = new Intent(this,signup.class);
                startActivity(intent);
                break;
            case R.id.donor_list1 :
                intent = new Intent(this,ViewListContents.class);
                startActivity(intent);
                break;

        }
    }
}
