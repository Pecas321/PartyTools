package com.example.partytools

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class F_Cerca : AppCompatActivity(), OnMapReadyCallback {
    private lateinit var map: GoogleMap
    private lateinit var placesApiService: PlacesApiService
    private val apiKey = "AIzaSyAT5IvjiPnmzpwq8fdyZ0NydgFbNbtm8pI"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fiestas_cerca)

        val buttonVolver = findViewById<ImageView>(R.id.Volver_fiestascerca)
        buttonVolver.setOnClickListener {
            val intent = Intent(this, Fiestas::class.java)
            startActivity(intent)
        }

        // Inicializa el fragmento del mapa
        val mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        // Configurar Retrofit para Places API
        val retrofit = Retrofit.Builder()
            .baseUrl("https://maps.googleapis.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        placesApiService = retrofit.create(PlacesApiService::class.java)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        map = googleMap
        enableMyLocation()
        loadNearbyBars()
    }

    private fun enableMyLocation() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
            ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), 1)
        } else {
            map.isMyLocationEnabled = true
        }
    }

    private fun loadNearbyBars() {
        val fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)
        fusedLocationClient.lastLocation.addOnSuccessListener { location ->
            if (location != null) {
                val currentLocation = LatLng(location.latitude, location.longitude)
                map.moveCamera(CameraUpdateFactory.newLatLngZoom(currentLocation, 15f))

                val locationString = "${location.latitude},${location.longitude}"
                val radius = 2000 // Radio de búsqueda en metros

                placesApiService.getNearbyBars(locationString, radius, "bar", apiKey)
                    .enqueue(object : Callback<PlacesResponse> {
                        override fun onResponse(call: Call<PlacesResponse>, response: Response<PlacesResponse>) {
                            if (response.isSuccessful) {
                                response.body()?.results?.forEach { place ->
                                    val barLocation = LatLng(place.geometry.location.lat, place.geometry.location.lng)
                                    map.addMarker(MarkerOptions().position(barLocation).title(place.name))
                                }
                            }
                        }

                        override fun onFailure(call: Call<PlacesResponse>, t: Throwable) {
                            t.printStackTrace()
                        }
                    })
            }
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == 1 && grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            enableMyLocation()
        }
    }
}
