package com.example.homeslide;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class InfoActivity_1 extends AppCompatActivity {

    ImageView iniimage;
    TextView inijudul;
    TextView inidesc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_info_1);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            int gambar = extras.getInt("gambarkonten");
            String judul = extras.getString("judulkonten");
            String desc = extras.getString("konten");
            //The key argument here must match that used in the other activity

            //Deklarasi + nyambungin dengan View ID
            iniimage = (ImageView)findViewById(R.id.imageInfo);
            inijudul = (TextView)findViewById(R.id.titleInfo);
            inidesc = (TextView)findViewById(R.id.descInfo);

            iniimage.setImageResource(gambar);
            inijudul.setText(judul);
            inidesc.setText(desc);
        }

    }
}
