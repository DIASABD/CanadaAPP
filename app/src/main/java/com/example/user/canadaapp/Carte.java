package com.example.user.canadaapp;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;


public class Carte extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carte);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {

        mMap = googleMap;

        find_region();

    }


    // fonction qui permet d'afficher la carte par rapport a la province.
    public void find_region() {

        ListActuAdapter.MainActivity mainActivity = new ListActuAdapter.MainActivity();
        String[] tabProv = mainActivity.nomProvinces;
        int u = mainActivity.getIndexClick();
        String maProv = tabProv[u];
        float zoomLevel = 5.0f;


        switch (maProv) {

            case "Alberta":
                LatLng alberta = new LatLng(53.9332706, -116.5765035);
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(alberta, zoomLevel));
                break;

            case "Ile du Prince Edouard":
                LatLng ipe = new LatLng(46.510712, -63.416813599999955);
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(ipe, zoomLevel));
                break;

            case "Manitoba":
                LatLng manitoba = new LatLng(53.760861, -98.813876);
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(manitoba, zoomLevel));
                break;

            case "Nouvelle Ecosse":
                LatLng ne = new LatLng(44.68198659999999, -63.74431100000004);
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(ne, zoomLevel));
                break;

            case "Nouveau Brunswick":
                LatLng nb = new LatLng(46.5653163, -66.4619164);
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(nb, zoomLevel));
                break;

            case "Nunavut":
                LatLng nunavut = new LatLng(70.299771, -83.107577);
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(nunavut, 4.0f));
                break;

            case "Ontario":
                LatLng ontario = new LatLng(51.253775, -85.32321389999998);
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(ontario, zoomLevel));
                break;

            case "Saskachewan":
                LatLng sas = new LatLng(52.9399159, -106.4508639);
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(sas, zoomLevel));
                break;

            case "Terre Neuve et Labrardor":
                LatLng tnel = new LatLng(53.1355091, -57.66043639999998);
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(tnel, zoomLevel));
                break;

            case "Territoires du Nord Ouest":
                LatLng tdno = new LatLng(64.825544, -124.845733);
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(tdno, zoomLevel));
                break;

            case "Quebec":
                LatLng qc = new LatLng(52.9399159, -73.5491361);
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(qc, zoomLevel));
                break;

            case "Yukon":
                LatLng yu = new LatLng(64.282327, -135);
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(yu, zoomLevel));
                break;

            case "Colombie Britannique":
                LatLng cb = new LatLng(53.726668, -127.647621);
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(cb, zoomLevel));
                break;


        }
    }


}