package com.example.anda.ui.main

import android.widget.Toast
import androidx.navigation.fragment.NavHostFragment
import com.example.anda.R
import com.example.anda.databinding.ActivityMainBinding
import com.example.anda.ui.BaseActivity
import com.example.anda.ui.main.dictionary.DictionaryFragment
import com.example.anda.ui.main.home.HomeFragment
import com.example.anda.ui.main.map.MapFragment
import com.example.anda.ui.main.mypage.MypageFragment
import com.example.anda.ui.main.event.EventFragment


class MainActivity: BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate) {
    private lateinit var navHostFragment: NavHostFragment
    var backKeyPressedTime : Long = 0

    override fun initAfterBinding() {
        initBottomNavigation()
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
}