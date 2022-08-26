package com.example.anda.ui.main

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.content.pm.PackageManager.PERMISSION_GRANTED
import android.location.Location
import android.location.LocationRequest
import android.os.Build
import android.os.Looper
import android.util.Log
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.NavHostFragment
import com.example.anda.R
import com.example.anda.databinding.ActivityMainBinding
import com.example.anda.ui.BaseActivity
import com.example.anda.ui.main.dictionary.DictionaryFragment
import com.example.anda.ui.main.home.HomeFragment
import com.example.anda.ui.main.map.MapFragment
import com.example.anda.ui.main.mypage.MypageFragment
import com.example.anda.ui.main.event.EventFragment
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationResult
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment


class MainActivity: BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate) {
    //위치 권한
    val permissions = arrayOf(Manifest.permission.ACCESS_FINE_LOCATION,Manifest.permission.ACCESS_COARSE_LOCATION)
    val PERM_FLAG = 99


    //main activity
    private lateinit var navHostFragment: NavHostFragment
    var backKeyPressedTime : Long = 0

    override fun initAfterBinding() {
        initBottomNavigation()
        if(!isPermitted()){
            ActivityCompat.requestPermissions(this,permissions,PERM_FLAG)//권한 요청
        }

    }

    override fun onBackPressed() {
        // 뒤로가기 버튼 클릭
        if(System.currentTimeMillis() - backKeyPressedTime >=2000 ) {
            backKeyPressedTime = System.currentTimeMillis()
            Toast.makeText(getApplicationContext(),"뒤로가기 버튼을 한번 더 누르면 종료됩니다.",Toast.LENGTH_LONG).show()
        } else {
            finish() //액티비티 종료
        }
    }

    private fun initBottomNavigation(){

        supportFragmentManager.beginTransaction().replace(R.id.nav_host_fragment_container,HomeFragment()).commitAllowingStateLoss()

        binding.mainBottomNavigation.setOnItemSelectedListener { item->
            when(item.itemId){
                R.id.homeFragment->{
                    supportFragmentManager.beginTransaction().replace(R.id.nav_host_fragment_container,HomeFragment()).commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }
                R.id.eventFragment->{
                    supportFragmentManager.beginTransaction().replace(R.id.nav_host_fragment_container,EventFragment()).commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }
                R.id.mapFragment->{
                    supportFragmentManager.beginTransaction().replace(R.id.nav_host_fragment_container,MapFragment()).commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }
                R.id.dictionaryFragment->{
                    supportFragmentManager.beginTransaction().replace(R.id.nav_host_fragment_container,DictionaryFragment()).commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }
                R.id.mypageFragment->{
                    supportFragmentManager.beginTransaction().replace(R.id.nav_host_fragment_container,MypageFragment()).commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }
            }
            false
        }
    }


    fun getFusedLocation(): FusedLocationProviderClient {
        val fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)
        return fusedLocationClient
    }
    //google map activity
    fun isPermitted() : Boolean{
        for(perm in permissions){
            if(ContextCompat.checkSelfPermission(this, perm) != PERMISSION_GRANTED){
                return false
            }
        }
        return true
    }


    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when(requestCode){
            PERM_FLAG->{
                var check = true
                for(grant in grantResults){
                    if(grant != PERMISSION_GRANTED){
                        check = false
                        break
                    }
                }
                if(!check){
                    Toast.makeText(this, "권한을 승인해야지만 앱을 사용할 수 있습니다.", Toast.LENGTH_LONG).show()
                    finish()
                }
            }
        }
    }
    fun setUpdateLocationLister(): com.google.android.gms.location.LocationRequest {
        val locationRequest = com.google.android.gms.location.LocationRequest.create()
        return locationRequest
    }

}