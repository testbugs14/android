package com.example.allinone;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity5 extends AppCompatActivity {

    Button btn;
    LocationManager locationManager;
    LocationListener locationListener;
    Double lat, log;
    TextView txtv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        btn = (Button)findViewById(R.id.button12);
        txtv = (TextView)findViewById(R.id.textView4);

        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        locationListener = new LocationListener() {
            @Override
            public void onLocationChanged(@NonNull Location location) {
                lat = location.getLatitude();
                log = location.getLongitude();
            }
            @Override
            public void onStatusChanged(String s, int i, Bundle bundle){

            }

            @Override
            public void onProviderEnabled(String s){

            }
            @Override
            public void onProviderDisabled(String s){

            }
        };
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            return;
        }
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 2000, 5, locationListener);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                    Toast.makeText(getApplicationContext(),"Hello world", Toast.LENGTH_LONG);
                    Toast.makeText(getApplicationContext(), "Latitude " + lat + " -- Longitude " + log, Toast.LENGTH_LONG).show();
                    txtv.setText("Latitude : "+lat+" Longitude : "+log);
            }
        });


    }

}