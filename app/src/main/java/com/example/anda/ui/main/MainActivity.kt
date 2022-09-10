package com.example.anda.ui.main

import android.Manifest
import android.annotation.SuppressLint
import android.content.pm.PackageManager.PERMISSION_GRANTED
import android.graphics.drawable.BitmapDrawable
import android.location.Location
import android.os.Build
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.anda.R
import com.example.anda.data.entities.MapList
import com.example.anda.databinding.ActivityMainBinding
import com.example.anda.ui.BaseActivity
import com.example.anda.ui.main.dictionary.DictionaryFragment
import com.example.anda.ui.main.home.HomeFragment
import com.example.anda.ui.main.map.MapFragment
import com.example.anda.ui.main.map.MapListRVAdapter
import com.example.anda.ui.main.mypage.MypageFragment
import com.google.android.gms.location.*
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.*


class MainActivity: BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate),OnMapReadyCallback {
    private var listMapDatas = ArrayList<MapList>()
    private lateinit var mMap:GoogleMap
    private var myLocationMarker : Marker? = null

    var moveToMe:Boolean = false

    override fun initAfterBinding() {
        initBottomNavigation()
        applyRV()
        invisibleImg()
        if(!isPermitted()){
            ActivityCompat.requestPermissions(this,permissions,PERM_FLAG)//권한 요청
        }
        settingOnClick()
    }
    private fun applyRV() {
        listMapDatas.apply {
            add(MapList("김안과병원", "서울특별시 영등포구1", "ab", 5f))
            add(MapList("김병원", "서울특별시 영등포구2", "cd", 2f))
            add(MapList("안과병원", "서울특별시 영등포구3", "ef", 2f))
            add(MapList("과병원", "서울특별시 영등포구4", "gh", 2.5f))
            add(MapList("안병원", "서울특별시 영등포구5", "ij", 4f))
            add(MapList("안과원", "서울특별시 영등포구6", "jl", 1f))
            add(MapList("김안과병원", "서울특별시 영등포구7", "mn", 3.5f))
            add(MapList("김a과병원", "서울특별시 영등포구8", "op", 4.5f))
            add(MapList("김안fa과병원", "서울특별시 영등포구9", "qr", 3f))
            add(MapList("김안과hha병원", "서울특별시 영등포구10", "st", 3.5f))
        }
        val mapListRVAdapter = MapListRVAdapter(listMapDatas)
        binding.mapListItemRv.adapter = mapListRVAdapter
        binding.mapListItemRv.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }

    //이미지 변환
     private fun settingOnClick(){
        //내 위치로 이동
        binding.mainMapMylocation.setOnClickListener{
            moveToMe = true
        }
        //라식
        binding.mapLasikBtn.setOnClickListener {
            findLasik()
        }
        //라섹
        binding.mapLasekBtn.setOnClickListener {
            findLasek()
        }
        //스마일라식
        val smileImgResId = R.drawable.map_smile_default_btn
        var smileResId = smileImgResId
        binding.mapSmileBtn.setImageResource(smileImgResId)
        binding.mapSmileBtn.setOnClickListener {
            Log.d("이미지변경", "성공!!")
            smileResId =
                if (smileResId == R.drawable.map_smile_default_btn)
                    R.drawable.map_smile_selected_btn
                else
                    R.drawable.map_smile_default_btn
            binding.mapSmileBtn.setImageResource(smileResId)
            findSmile()
        }
        //렌즈삽입술
        binding.mapLensBtn.setOnClickListener {
            Log.d("이미지변경", "성공!!")
            smileResId =
                if (smileResId == R.drawable.map_smile_default_btn)
                    R.drawable.map_smile_selected_btn
                else
                    R.drawable.map_smile_default_btn
            binding.mapSmileBtn.setImageResource(smileResId)
            findLens()
        }
        //안과
        binding.mapOphthalmologyBtn.setOnClickListener {
            Log.d("이미지변경", "성공!!")
            smileResId =
                if (smileResId == R.drawable.map_smile_default_btn)
                    R.drawable.map_smile_selected_btn
                else
                    R.drawable.map_smile_default_btn
            binding.mapSmileBtn.setImageResource(smileResId)
            findOphtha()
        }
        //목록보기
         // 열기
         binding.mapListDefaultBtn.setOnClickListener {
             Log.d("이미지변경", "성공!!")
             binding.mapListSelectedBtn.visibility = View.VISIBLE
             binding.mapListItemRv.visibility = View.VISIBLE
             binding.mapListDefaultBtn.visibility = View.GONE
         }
         //닫기
         binding.mapListSelectedBtn.setOnClickListener {
             Log.d("이미지변경", "성공!!")
             binding.mapListSelectedBtn.visibility = View.GONE
             binding.mapListItemRv.visibility = View.GONE
             binding.mapListDefaultBtn.visibility = View.VISIBLE
         }

    }

    private fun findLasik() {
        TODO("Not yet implemented")
    }

    private fun findLasek() {
        TODO("Not yet implemented")
    }

    private fun findSmile() {
        TODO("Not yet implemented")
    }

    private fun findLens() {
        TODO("Not yet implemented")
    }

    private fun findOphtha() {
        TODO("Not yet implemented")
    }

    private fun invisibleImg(){
        binding.mapLasekBtn.visibility = View.GONE
        binding.mapLasikBtn.visibility = View.GONE
        binding.mapLensBtn.visibility = View.GONE
        binding.mapSmileBtn.visibility = View.GONE
        binding.mapOphthalmologyBtn.visibility = View.GONE
        binding.mapListDefaultBtn.visibility = View.GONE
        binding.mapListItemRv.visibility = View.GONE
        binding.mapListSelectedBtn.visibility = View.GONE
        binding.mainMapMylocation.visibility = View.GONE
    }
    private fun visibleImg(){
        binding.mapLasekBtn.visibility = View.VISIBLE
        binding.mapLasikBtn.visibility = View.VISIBLE
        binding.mapLensBtn.visibility = View.VISIBLE
        binding.mapSmileBtn.visibility = View.VISIBLE
        binding.mapOphthalmologyBtn.visibility = View.VISIBLE
        binding.mapListDefaultBtn.visibility = View.VISIBLE
        binding.mainMapMylocation.visibility = View.VISIBLE
    }





    //위치 권한
    val permissions = arrayOf(Manifest.permission.ACCESS_FINE_LOCATION,Manifest.permission.ACCESS_COARSE_LOCATION)
    val PERM_FLAG = 99


    //main activity
    private lateinit var navHostFragment: NavHostFragment
    var backKeyPressedTime : Long = 0



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
                    invisibleImg()
                    supportFragmentManager.beginTransaction().replace(R.id.nav_host_fragment_container,HomeFragment()).commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }
                R.id.mapFragment->{
                    visibleImg()
                    supportFragmentManager.beginTransaction().replace(R.id.nav_host_fragment_container,MapFragment()).commitAllowingStateLoss()
                    mapOpen()
                    return@setOnItemSelectedListener true
                }
                R.id.dictionaryFragment->{
                    invisibleImg()
                    supportFragmentManager.beginTransaction().replace(R.id.nav_host_fragment_container,DictionaryFragment()).commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }
                R.id.mypageFragment->{
                    invisibleImg()
                    supportFragmentManager.beginTransaction().replace(R.id.nav_host_fragment_container,MypageFragment()).commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }
            }
            false
        }
    }


    //google map activity

    private fun mapOpen() {
        val mapFragment =  supportFragmentManager
            .findFragmentById(R.id.main_map_fragment) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }



    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        val cameraOption = CameraPosition.Builder().target(LatLng(37.5666805,126.9784147)).zoom(10.0f).build()
        val camera = CameraUpdateFactory.newCameraPosition(cameraOption)
        mMap.moveCamera(camera)
        moveToMe = true
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)
        setUpdateLocationListener()
    }

    private fun setMyMarker(latitude: Double, longitude:Double) {
        //마커 설정
        myLocationMarker?.remove()
        val location = LatLng(latitude, longitude)
        var bitmapDrawable: BitmapDrawable =
            getDrawable(R.drawable.main_map_mylocation_img) as BitmapDrawable
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            bitmapDrawable = getDrawable(R.drawable.main_map_mylocation_img) as BitmapDrawable
        } else {
            bitmapDrawable =
                resources.getDrawable(R.drawable.main_map_mylocation_img) as BitmapDrawable
        }
        val discriptor = BitmapDescriptorFactory.fromBitmap(bitmapDrawable.bitmap)
        val markerOption = MarkerOptions().position(location).icon(discriptor)
        myLocationMarker = mMap.addMarker(markerOption)!!
        Log.d("마커표시","성공!")
        if(moveToMe) {
            val cameraOption = CameraPosition.Builder().target(location).zoom(20.0f).build()
            val camera = CameraUpdateFactory.newCameraPosition(cameraOption)
            mMap.animateCamera(camera)
            Log.d("카메라이동", "성공!")
            moveToMe = false
        }
    }

    private fun setOphthaMarker(latitude: Double, longitude:Double) {
        //마커 설정
        myLocationMarker?.remove()
        val location = LatLng(latitude + 0.05, longitude + 0.05)
        var bitmapDrawable: BitmapDrawable =
            getDrawable(R.drawable.map_ophtha_location_icon) as BitmapDrawable
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            bitmapDrawable = getDrawable(R.drawable.map_ophtha_location_icon) as BitmapDrawable
        } else {
            bitmapDrawable =
                resources.getDrawable(R.drawable.map_ophtha_location_icon) as BitmapDrawable
        }
        val discriptor = BitmapDescriptorFactory.fromBitmap(bitmapDrawable.bitmap)
        val markerOption = MarkerOptions().position(location).title("안과 위치(예시)").icon(discriptor)
        myLocationMarker = mMap.addMarker(markerOption)!!
        Log.d("마커표시","성공!")
    }


    lateinit var fusedLocationClient: FusedLocationProviderClient
    lateinit var locationCallback: LocationCallback

    @SuppressLint("MissingPermission")
    fun setUpdateLocationListener(){
        val locationRequest = LocationRequest.create()
        locationRequest.run {
            priority = LocationRequest.PRIORITY_HIGH_ACCURACY
            interval = 1000
        }
        locationCallback = object : LocationCallback() {
            override fun onLocationResult(locationResult: LocationResult) {
                locationResult?.let {
                    for ((i, location) in it.locations.withIndex()) {
                        Log.d("로케이션", "$i ${location.latitude}, ${location.longitude}")
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
        setMyMarker(myLocation.latitude, myLocation.longitude)
        setOphthaMarker(myLocation.latitude, myLocation.longitude)
    }

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



    //Location Activity
//    lateinit var bindingLocation : FragmentMapBinding
//    lateinit var myLocation : Location
//    override fun onClick(v: View?) {
//        if (v == null) return
//
//        when (v) {
////            bindingLocation.mapLasekBtn -> findLasek()
////            bindingLocation.mapLasikBtn -> findLasik()
////            bindingLocation.mapSmileBtn -> findSmile()
////            bindingLocation.mapLensBtn -> findLens()
////            bindingLocation.mapOphthalmologyBtn -> findOphthalmology()
//        }
//    }
//
//    fun findMyLocation(location : Location) {
//        myLocation = location
//        val userinfo = LocationRequestBody(location.longitude.toFloat(), location.latitude.toFloat(), 5f)
//        val service = LocationService(this, userinfo)
//        service.tryLocation()
//    }
////    private fun findLasek() {
////        val email = bindingLocation.loginIdEt.text.toString()
////        val password = bindingLocation.loginPasswordEt.text.toString()
////        val userinfo = LoginRequestBody(email, password)
////
////        val service = LoginService(this, userinfo)
////        service.tryLogin()
////    }
////    private fun findLasik() {
////        val email = bindingLocation.loginIdEt.text.toString()
////        val password = bindingLocation.loginPasswordEt.text.toString()
////        val userinfo = LoginRequestBody(email, password)
////
////        val service = LoginService(this, userinfo)
////        service.tryLogin()
////    }
////    private fun findSmile() {
////        val email = bindingLocation.loginIdEt.text.toString()
////        val password = bindingLocation.loginPasswordEt.text.toString()
////        val userinfo = LoginRequestBody(email, password)
////
////        val service = LoginService(this, userinfo)
////        service.tryLogin()
////    }
////    private fun findOphthalmology() {
////        val email = bindingLocation.loginIdEt.text.toString()
////        val password = bindingLocation.loginPasswordEt.text.toString()
////        val userinfo = LoginRequestBody(email, password)
////
////        val service = LoginService(this, userinfo)
////        service.tryLogin()
////    }
////    private fun findLens() {
////        val email = bindingLocation.loginIdEt.text.toString()
////        val password = bindingLocation.loginPasswordEt.text.toString()
////        val userinfo = LoginRequestBody(email, password)
////
////        val service = LoginService(this, userinfo)
////        service.tryLogin()
////    }
//
//    override fun onLocationLoading() {
//        bindingLocation.mapLoadingPb.visibility = View.VISIBLE
//    }
//
//
//    override fun onLocationSuccess(response: LocationResponse) {
//        bindingLocation.mapLoadingPb.visibility = View.GONE
//        Log.d("위치찾기", "성공!")
//    }
//
//    override fun onLocationFailure(code: Int, message: String) {
//        Log.d("위치찾기", "실패!")
//        bindingLocation.mapLoadingPb.visibility = View.GONE
//        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
//    }

}