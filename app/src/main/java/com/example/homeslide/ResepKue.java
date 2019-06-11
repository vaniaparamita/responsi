package com.example.homeslide;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;


import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


import java.util.ArrayList;

public class ResepKue extends AppCompatActivity implements ResepAdapter.OnItemClickListener {
    DatabaseReference reference;
    RecyclerView recyclerView;
    ArrayList<Resep> list;
    ResepAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_info_kue);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager (this));

        list = new ArrayList<Resep>();
        reference = FirebaseDatabase.getInstance().getReference().child("Resep");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot dataSnapshots: dataSnapshot.getChildren()){
                    Resep i = dataSnapshots.getValue(Resep.class);
                    list.add(i);
                }
                adapter = new ResepAdapter(ResepKue.this, list);
                recyclerView.setAdapter(adapter);
                adapter.setOnItemListener(ResepKue.this);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(ResepKue.this, "test", Toast.LENGTH_SHORT).show();
            }
        });


    }

    @Override
    public void onItemClick(int position) {
        Intent resepIntent = new Intent(this, ResepActivity_1.class);
        Resep clickedItem = list.get(position);

        startActivity(resepIntent);
    }
}


