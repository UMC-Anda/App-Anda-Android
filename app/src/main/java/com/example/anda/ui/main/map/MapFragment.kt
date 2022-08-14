package com.example.anda.ui.main.map


import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.anda.R
import com.example.anda.databinding.FragmentMapBinding
import com.google.android.gms.maps.*
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions


class MapFragment : Fragment(),OnMapReadyCallback {
    private lateinit var mapView : MapView

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
    override fun onMapReady(map: GoogleMap) {
        val point = LatLng(37.514655, 126.979974)
        map.addMarker(MarkerOptions().position(point).title("현위치"))
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(point,12f))
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

}