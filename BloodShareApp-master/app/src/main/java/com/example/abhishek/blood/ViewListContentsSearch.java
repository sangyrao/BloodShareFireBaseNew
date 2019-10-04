package com.example.abhishek.blood;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Mitch on 2016-05-13.
 */
public class ViewListContentsSearch extends AppCompatActivity {
    private DatabaseReference mDatabase;
    private ListView mUserList;
    private List<String> mUserNames = new ArrayList<>();
    String city;
    String blood;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewsearchlist);
        String arr[] = {"A","B","C","D","E"};
        try{
            Bundle bundle = getIntent().getExtras();
            city = bundle.getString("city");
            blood = bundle.getString("blood");
        }
        catch(Exception e){
            e.printStackTrace();
        }

        mDatabase = FirebaseDatabase.getInstance().getReference();
        mUserList = (ListView)findViewById(R.id.display);
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,mUserNames);
        mUserList.setAdapter(arrayAdapter);
        mDatabase.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                //String value = dataSnapshot.getValue(String.class);
                for (DataSnapshot ds: dataSnapshot.getChildren()) {
                    User u = ds.getValue(User.class);
                    if(u.City.equals(city) && u.BloodGrp.equals(blood)){
                        mUserNames.add("Name: " + u.Name);
                        mUserNames.add("City: " + u.City);
                        mUserNames.add("BloodGroup: " + u.BloodGrp);
                        mUserNames.add("Mobile: " + u.Mobile);
                        mUserNames.add("Gender: " + u.Gender);
                        mUserNames.add("==============================");
                        arrayAdapter.notifyDataSetChanged();
                    }

                }
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


    }
}

