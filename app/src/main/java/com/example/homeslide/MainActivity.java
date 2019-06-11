package com.example.homeslide;

import android.annotation.SuppressLint;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ImageView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;



public class MainActivity extends AppCompatActivity {
    CarouselView carouselView;
    int[] sampleImages = {R.drawable.roti, R.drawable.jjj, R.drawable.kkkkk};
    private FirebaseAuth.AuthStateListener authListener;
    private FirebaseAuth auth;
    private CardView info,resep,tentang,maps,signout;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);
        carouselView = findViewById(R.id.carouselView);
        carouselView.setPageCount(sampleImages.length);
        carouselView.setImageListener(imageListener);

        info = findViewById(R.id.info);
        tentang = findViewById(R.id.tentang);
        resep = findViewById(R.id.resep);
        maps = findViewById(R.id.maps);
        signout = findViewById (R.id.signout);
        auth = FirebaseAuth.getInstance ();
        authListener = new FirebaseAuth.AuthStateListener(){
            @Override
            public void onAuthStateChanged (@NonNull FirebaseAuth firebaseAuth){

                FirebaseUser user = firebaseAuth.getCurrentUser ();
                if(user==null){
                    startActivity (new Intent (MainActivity.this,
                            SplashActivity.class));
                    finish();
                }
            }


        };
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel channel =
                    new NotificationChannel("MyNotifications", "MyNotifications", NotificationManager
                    .IMPORTANCE_DEFAULT);

            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }

        signout.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                signOut();
            }
        });

        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, InfoKue.class));
            }
        });
        resep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ResepKue.class));
            }
        });
        tentang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Tentang.class));
            }
        });
        maps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Maps.class));
            }
        });


    }
    public void signOut(){
        auth.signOut();
    }

    @Override
            public void onStart(){
            super.onStart();
        auth.addAuthStateListener (authListener);
    }


    @Override
    public void onStop(){
        super.onStop();
        if(auth!=null){
        auth.removeAuthStateListener(authListener);
    }}

    ImageListener imageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            imageView.setImageResource(sampleImages[position]);
        }
    };

}