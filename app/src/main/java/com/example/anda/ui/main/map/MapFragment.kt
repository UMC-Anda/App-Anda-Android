package com.example.anda.ui.main.map


import android.annotation.SuppressLint
import android.location.*
import android.os.Bundle
import android.os.Looper
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.anda.R
import com.example.anda.databinding.FragmentDictionaryBinding
import com.example.anda.databinding.FragmentMapBinding
import com.example.anda.ui.find.id.FindIdActivity
import com.example.anda.ui.login.LoginActivity
import com.example.anda.ui.login.LoginService
import com.example.anda.ui.login.model.LoginRequestBody
import com.example.anda.ui.login.model.LoginResponse
import com.example.anda.ui.main.MainActivity
import com.example.anda.ui.main.dictionary.SymptomFragment
import com.example.anda.ui.main.home.AddReviewFragment
import com.example.anda.ui.main.map.location.LocationView
import com.example.anda.ui.main.map.location.model.LocationResponse
import com.example.anda.ui.siginup.SignupActivity
import com.google.android.gms.location.*
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.maps.*
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions


class MapFragment() : Fragment(),OnMapReadyCallback {
    private lateinit var mapView : MapView
    private lateinit var mMap : GoogleMap

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_map,container,false)

        mapView = rootView.findViewById(R.id.mapFragment) as MapView
        mapView.onCreate(savedInstanceState)
        mapView.getMapAsync(this)
        return rootView
    }

    //지도 객체를 사용할 수 있을 때 자동으로 호출되는 함수
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        //fusedLocationClient = (activity as MainActivity).getFusedLocation()
        //setUpdateLocationLister()
    }
    override fun onStart() {
        super.onStart()
        mapView.onStart()
    }
    override fun onStop() {
        super.onStop()
        mapView.onStop()
    }

    override fun onResume() {
        super.onResume()
        mapView.onResume()
    }

    override fun onPause() {
        super.onPause()
        mapView.onPause()
    }

    override fun onLowMemory() {
        super.onLowMemory()
        mapView.onLowMemory()
    }

    override fun onDestroy() {
        super.onDestroy()
        mapView.onDestroy()
    }
/*
    lateinit var fusedLocationClient:FusedLocationProviderClient
    lateinit var locationCallback: LocationCallback

    @SuppressLint("MissingPermission")
    fun setUpdateLocationLister(){
        val locationRequest = LocationRequest.create()
        locationRequest.run {
            priority = LocationRequest.PRIORITY_HIGH_ACCURACY
        }
        locationCallback = object : LocationCallback() {
            override fun onLocationResult(locationResult: LocationResult) {
                locationResult?.let {
                    for ((i, location) in it.locations.withIndex()) {
                        Log.d("로케이션", "$i ${location.latitude}, ${location.longitude}")
                        (activity as MainActivity).findMyLocation(location)
                        setLastLocation(location)
                    }
                }
            }
        }
        //로케이션 요청 함수 호출(locationRequest, locationCallback)
        fusedLocationClient.requestLocationUpdates(locationRequest,locationCallback, Looper.myLooper())
    }

    fun setLastLocation(location : Location){
        val myLocation = LatLng(location.latitude, location.longitude)
        val markerOptions = MarkerOptions().position(myLocation).title("내 위치")
        val cameraOption = CameraPosition.Builder().target(myLocation).zoom(15.0f).build()
        val camera = CameraUpdateFactory.newCameraPosition(cameraOption)

        mMap.addMarker(markerOptions)
        mMap.moveCamera(camera)
    }
*/
}