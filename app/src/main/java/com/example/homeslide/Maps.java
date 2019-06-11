package com.example.homeslide;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class Maps extends FragmentActivity implements
        GoogleMap.OnMarkerClickListener,
        OnMapReadyCallback{

    private GoogleMap mMap;
    private Marker inimarker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng yogyakarta = new LatLng (-7.795765, 110.368321);
        inimarker = mMap.addMarker(new MarkerOptions().position(yogyakarta)
                .title("Marker in Yogyakarta")
                .snippet("Testing"));
        LatLng jasminecakery = new LatLng (-7.769978, 110.368680);
        LatLng rmurnimonjali = new LatLng (-7.7691571,110.3686683);
        mMap.addMarker (new MarkerOptions ().position (yogyakarta).title ("Marker in Yogyakarta"));
        mMap.addMarker (new MarkerOptions ().position (jasminecakery).title ("Jasmine Cakery (Cake & Bakery)"));
        mMap.addMarker (new MarkerOptions ().position (rmurnimonjali).title ("Roti Murni Monjali"));
        googleMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {
                inimarker = mMap.addMarker(new MarkerOptions()
                .position(latLng)
                .title("ini marker baru")
                .snippet("Hallo Tester"));
            }
        });
        mMap.setOnMarkerClickListener(this);
        mMap.moveCamera (CameraUpdateFactory.newLatLngZoom (yogyakarta, 15));
    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        Toast.makeText(this, marker.getTitle()+"Done",
                Toast.LENGTH_SHORT).show();
        return false;
    }
}