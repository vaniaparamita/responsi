package com.example.homeslide;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.net.URL;

public class ResepActivity_1 extends AppCompatActivity {

    ImageView iniimage;
    TextView inijudul, iniintruksi, inibahan;
    TextView inikota;
    TextView inidesc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_resep_1);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String gambar = extras.getString("gambarkonten");
            String judul = extras.getString("judulkonten");
            String kota = extras.getString("kotakonten");
            String deskripsi = extras.getString("deskripsi");
            String bahan = extras.getString("bahan");
            String intruksi = extras.getString("intruksi");
            //The key argument here must match that used in the other activity

            //Deklarasi + nyambungin dengan View ID
            iniimage = (ImageView)findViewById(R.id.gambar_resep);
            inijudul = (TextView)findViewById(R.id.judul_resep);
            inikota = (TextView)findViewById(R.id.kota_resep);
            inidesc = (TextView)findViewById(R.id.ket_resep);
            inibahan = (TextView)findViewById(R.id.isi_bahan);
            iniintruksi = (TextView)findViewById(R.id.isi_intruksi);

            Picasso.get().load(gambar).into(iniimage);

            inijudul.setText(judul);
            inikota.setText(kota);
            inidesc.setText(deskripsi);
            inibahan.setText(bahan);
            iniintruksi.setText(intruksi);
        }
    }
}