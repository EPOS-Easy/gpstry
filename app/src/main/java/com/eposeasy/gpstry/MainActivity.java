package com.eposeasy.gpstry;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

public class MainActivity extends Activity implements LocationListener, View.OnClickListener {
    private LocationManager locationManager;
    Button btnLogout;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView lblAltitude = (TextView) findViewById(R.id.labAltitude);
        TextView textAltitude = (TextView) findViewById(R.id.textAltitude);

        TextView lblLongitued = (TextView) findViewById(R.id.lblLongitued);
        TextView textLongitued = (TextView) findViewById(R.id.textLongitued);

        // Button logout
        btnLogout = (Button) findViewById(R.id.btnLogout);
        btnLogout.setOnClickListener(this);

        //get Gps location service LocationManager object
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (R.id.btnLogout == id) {
            Toast.makeText(getApplicationContext(), "Button has pressed",
                    Toast.LENGTH_LONG).show();
        }
    }


    @Override
    public void onLocationChanged(Location location) {
        String str = "Latitude: " + location.getLatitude() + "Longitude: " + location.getLongitude();
        Toast.makeText(getBaseContext(), str, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onProviderDisabled(String provider) {/******** Called when User off Gps *********/
        Toast.makeText(getBaseContext(), "Gps turned off ", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onProviderEnabled(String provider)
       { /******** Called when User on Gps  *********/
        Toast.makeText(getBaseContext(), "Gps turned on ", Toast.LENGTH_LONG).show();}

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {}


}
