package com.example.hackathonanda;

import android.Manifest;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap googleMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        this.googleMap = googleMap;

        LatLng latLng1 = new LatLng(37.50474520662763, 127.08778118676908);
        MarkerOptions markerOptions1 = new MarkerOptions().position(latLng1).title("24시 열린 의원");
        googleMap.addMarker(markerOptions1);

        LatLng latLng2 = new LatLng(37.502747753135786, 127.09799799734772);
        MarkerOptions markerOptions2 = new MarkerOptions().position(latLng2).title("올림픽 병원");
        googleMap.addMarker(markerOptions2);

        LatLng latLng3 = new LatLng(37.5113185408, 127.1017507699);
        MarkerOptions markerOptions3 = new MarkerOptions().position(latLng3).title("아이엠유의원");
        googleMap.addMarker(markerOptions3);

        LatLng latLng4 = new LatLng(37.50746595330222, 127.1096852190245);
        MarkerOptions markerOptions4 = new MarkerOptions().position(latLng4).title("빠른병원");
        googleMap.addMarker(markerOptions4);

        LatLng latLng5 = new LatLng(37.49911314029309, 127.11948453460472);
        MarkerOptions markerOptions5 = new MarkerOptions().position(latLng5).title("뉴스타트병원");
        googleMap.addMarker(markerOptions5);

        LatLng latLng6 = new LatLng(37.4796673949, 127.1249120491);
        MarkerOptions markerOptions6 = new MarkerOptions().position(latLng6).title("송파365의원");
        googleMap.addMarker(markerOptions6);

        LatLng latLng7 = new LatLng(37.4881325624879, 127.08515659273);
        MarkerOptions markerOptions7 = new MarkerOptions().position(latLng7).title("사용자 위치(가정)");
        googleMap.addMarker(markerOptions7);

        LatLng latLng8 = new LatLng(37.53694663241195, 127.12772754399131);
        MarkerOptions markerOptions8 = new MarkerOptions().position(latLng8).title("리더스병원");
        googleMap.addMarker(markerOptions8);

        LatLng latLng9 = new LatLng(37.53616270089999, 127.13268644569999);
        MarkerOptions markerOptions9 = new MarkerOptions().position(latLng9).title("365힐링의원");
        googleMap.addMarker(markerOptions9);

        LatLng latLng10= new LatLng(37.36767375191615 , 127.10768316037111);
        MarkerOptions markerOptions10 = new MarkerOptions().position(latLng10).title("산타마리24의원");
        googleMap.addMarker(markerOptions10);


        LatLng latLng0 = new LatLng(37.4881325624879, 127.08515659273);
        MarkerOptions markerOptions0 = new MarkerOptions().position(latLng0).title("사용자 위치(가정)");
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(latLng0));
        googleMap.moveCamera(CameraUpdateFactory.zoomTo(15));
        googleMap.addMarker(markerOptions0);


        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            googleMap.setMyLocationEnabled(true);
        } else {
            checkLocationPermissionWithRationale();
        }
    }

    public static final int MY_PERMISSIONS_REQUEST_LOCATION = 99;

    private void checkLocationPermissionWithRationale() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.ACCESS_FINE_LOCATION)) {
                new AlertDialog.Builder(this)
                        .setTitle("위치정보")
                        .setMessage("이 앱을 사용하기 위해서는 위치정보에 접근이 필요합니다. 위치정보 접근을 허용하여 주세요.")
                        .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, MY_PERMISSIONS_REQUEST_LOCATION);
                            }
                        }).create().show();
            } else {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, MY_PERMISSIONS_REQUEST_LOCATION);
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_LOCATION: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                        googleMap.setMyLocationEnabled(true);
                    }
                } else {
                    Toast.makeText(this, "permission denied", Toast.LENGTH_LONG).show();
                }
                return;
            }
        }
    }
}
