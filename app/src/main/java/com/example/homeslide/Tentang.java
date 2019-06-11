package com.example.homeslide;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Tentang extends AppCompatActivity {
    private Button lets;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_tentang);
        lets = findViewById(R.id.lets);

        lets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent (Tentang.this, MainActivity.class));
            }
        });
    }
}
