package com.example.anda.ui.main

import android.Manifest
import android.content.pm.PackageManager.PERMISSION_GRANTED
import android.util.Log
import android.view.View
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
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices


class MainActivity: BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate) {


    //이미지 변환
     private fun settingOnClick(){
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
        }
        //목록보기
        val listImgResId = R.drawable.map_list_default_btn
        var listResId = listImgResId
        binding.mapListBtn.setImageResource(listImgResId)
        binding.mapListBtn.setOnClickListener {
            Log.d("이미지변경", "성공!!")
            listResId =
                if (listResId == R.drawable.map_list_default_btn)
                    R.drawable.map_list_selected_btn
                else
                    R.drawable.map_list_default_btn
            binding.mapListBtn.setImageResource(listResId)
        }
    }
    private fun invisibleImg(){
        binding.mapLasekBtn.visibility = View.GONE
        binding.mapLasikBtn.visibility = View.GONE
        binding.mapLensBtn.visibility = View.GONE
        binding.mapSmileBtn.visibility = View.GONE
        binding.mapOphthalmologyBtn.visibility = View.GONE
        binding.mapListBtn.visibility = View.GONE
    }
    private fun visibleImg(){
        binding.mapLasekBtn.visibility = View.VISIBLE
        binding.mapLasikBtn.visibility = View.VISIBLE
        binding.mapLensBtn.visibility = View.VISIBLE
        binding.mapSmileBtn.visibility = View.VISIBLE
        binding.mapOphthalmologyBtn.visibility = View.VISIBLE
        binding.mapListBtn.visibility = View.VISIBLE
    }





    //위치 권한
    val permissions = arrayOf(Manifest.permission.ACCESS_FINE_LOCATION,Manifest.permission.ACCESS_COARSE_LOCATION)
    val PERM_FLAG = 99


    //main activity
    private lateinit var navHostFragment: NavHostFragment
    var backKeyPressedTime : Long = 0

    override fun initAfterBinding() {
        initBottomNavigation()
        invisibleImg()
        if(!isPermitted()){
            ActivityCompat.requestPermissions(this,permissions,PERM_FLAG)//권한 요청
        }
        settingOnClick()
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
                    invisibleImg()
                    supportFragmentManager.beginTransaction().replace(R.id.nav_host_fragment_container,HomeFragment()).commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }
                R.id.mapFragment->{
                    visibleImg()
                    supportFragmentManager.beginTransaction().replace(R.id.nav_host_fragment_container,MapFragment()).commitAllowingStateLoss()
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
    fun getFusedLocation(): FusedLocationProviderClient {
        val fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)
        return fusedLocationClient
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
    fun setUpdateLocationLister(): com.google.android.gms.location.LocationRequest {
        val locationRequest = com.google.android.gms.location.LocationRequest.create()
        return locationRequest
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