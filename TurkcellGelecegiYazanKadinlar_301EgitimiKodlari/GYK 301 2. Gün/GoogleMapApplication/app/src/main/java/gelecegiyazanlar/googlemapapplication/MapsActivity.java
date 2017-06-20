package gelecegiyazanlar.googlemapapplication;

import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.EditText;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    public  void onSearch(View view) throws IOException {
        EditText konum = (EditText)findViewById(R.id.editTextLokasyon);
        String location = konum.getText().toString();
        List<Address> konumlistemiz =null;

        if (location != null || !location.equals("")) //Lokasyon bilgisi boş değilse
        {
            Geocoder geocoder = new Geocoder(this); //Aldığımız yerin koordinatlarını üretir
            //Konum listemize koordinatları ekledik
            konumlistemiz = geocoder.getFromLocationName(location, 1);
            //Konumlistemizdeki ilk elemanı getir ve address e at.
            Address address = konumlistemiz.get(0);
            //konumları atıyoruz.
            LatLng sydney = new LatLng(address.getLatitude(), address.getLongitude());
            mMap.addMarker(new MarkerOptions().position(sydney).title("Konum"));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));//Harita alanını güncelliyoruz.

        }



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
    public void onMapReady(GoogleMap googleMap) { //İlk çalışma anında aldığı lokasyon
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);//Konumları atıyoruz
        mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE); //Harita tipini belirliyoruz. Uydu görüntüsü tercih ettik.
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));//Konumun başlığını belirlediğimiz kısım
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney)); //Güncelleme işlemi için.
    }
}
