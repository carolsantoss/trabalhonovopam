package com.example.trabalhodepam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.widget.TextView;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;

import java.io.IOException;
import java.util.List;

public class cartaz extends AppCompatActivity {

    private static final int REQUEST_LOCATION_PERMISSION = 345;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cartaz);
        Ultimalocalizacao();
    }

    public void Ultimalocalizacao() {
        if ((ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED)) {
            ActivityCompat.requestPermissions(
                    this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                    REQUEST_LOCATION_PERMISSION);
        }
        try
        {
            FusedLocationProviderClient flpClient;
            flpClient = LocationServices.getFusedLocationProviderClient(this);
            Task<Location> task = flpClient.getLastLocation();
            task.addOnSuccessListener(new OnSuccessListener<Location>() {
                @Override
                public void onSuccess(Location location) {
                    Geocoder geocoder = new Geocoder(getApplicationContext());
                    List<Address> addresses;
                    if(location==null)return;
                    try {
                        Address address= geocoder.getFromLocation( location.getLatitude(), location.getLongitude(), 1).get(0);
                        resultlocalizacao(address);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        catch(Exception e){
        }
    }

    public void resultlocalizacao (Address address){
        TextView txt = (TextView) findViewById(R.id.txtlocalizacaoreal);

        txt.setText(address.getAddressLine(0));
    }
}