package com.example.hp.firebaseandupdate;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> Names;
    ArrayList<Integer> Age;
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=(RecyclerView)findViewById(R.id.recycleView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        Names=new ArrayList<>();
        Age=new ArrayList<>();

        //Task-2---Data from firebase and updation also possible incase at backend data gets changed
        FirebaseDatabase database=FirebaseDatabase.getInstance();

        for(int i=1001;i<=1010;i++)
        {
            final DatabaseReference myRef=database.getReferenceFromUrl("https://fir-andupdate.firebaseio.com/USER/"+i);
            myRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    String string=dataSnapshot.child("Name").getValue(String.class);
                    Integer age=dataSnapshot.child("Age").getValue(Integer.class);
                    Names.add(string);
                    Age.add(age);
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }
        /*Task1----Hardcoded Data--
        Names.add("Muskan");
        Names.add("Monica");
        Names.add("Kanika");
        Names.add("Arushi");
        Names.add("Shweta");
        Names.add("Sam");
        Names.add("Ravi");
        Names.add("Shikha");
        Names.add("Karan");
        Names.add("jack");

        Age.add(20);
        Age.add(30);
        Age.add(19);
        Age.add(19);
        Age.add(19);
        Age.add(18);
        Age.add(15);
        Age.add(35);
        Age.add(30);
        Age.add(17);*/

        adapter=new AdapterClass(Names,Age);
        recyclerView.setAdapter(adapter);


    }
}
