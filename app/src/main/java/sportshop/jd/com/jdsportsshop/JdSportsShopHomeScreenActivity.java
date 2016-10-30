package sportshop.jd.com.jdsportsshop;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.annotation.RequiresPermission;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class JdSportsShopHomeScreenActivity extends AppCompatActivity
                implements OnMapReadyCallback
{

    MapView addressMapView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jd_sports_shop_home_screen);
        // load  the picture
        ImageView homeScreenView = (ImageView) this.findViewById(R.id.homeScreenImageView);
        homeScreenView.setImageResource(R.drawable.home_screen_sports);

        // get map view
        addressMapView = (MapView) findViewById(R.id.adressMapView);
        addressMapView.onCreate(savedInstanceState);
        addressMapView.getMapAsync(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (addressMapView !=null)
            addressMapView.onResume();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (addressMapView != null)
            addressMapView.onSaveInstanceState(outState);
    }



    @Override
    protected void onPause() {
        super.onPause();
        if (addressMapView != null)
            addressMapView.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (addressMapView != null)
            addressMapView.onDestroy();
    }


    @Override
    protected void onStop() {
        super.onStop();
    }

    @RequiresPermission(Manifest.permission.ACCESS_COARSE_LOCATION)
    @Override
    public void onMapReady(GoogleMap googleMap) {
        LatLng address = new LatLng(
                Double.parseDouble(getString(R.string.address_latitude)),
                Double.parseDouble(getString(R.string.address_longitude))
        );

        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(address,15));
        googleMap.addMarker(
                 new MarkerOptions()
                         .title(getString(R.string.app_name))
                         .position(address)

        );
    }
}
