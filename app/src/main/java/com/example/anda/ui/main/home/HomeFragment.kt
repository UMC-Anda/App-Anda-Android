package com.example.anda.ui.main.home

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.widget.ViewPager2
import com.example.anda.R
import com.example.anda.data.entities.ReviewLasek
import com.example.anda.data.entities.ReviewLasik
import com.example.anda.data.entities.ReviewNearOphthalmology
import com.example.anda.data.entities.ReviewOphthalmology
import com.example.anda.databinding.FragmentHomeBinding
import com.example.anda.ui.BaseFragment
import com.example.anda.ui.main.MainActivity
import com.example.anda.ui.main.dictionary.SymptomFragment


class HomeFragment(): BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {

    private var reviewLasekDatas = ArrayList<ReviewLasek>()
    private var reviewLasikDatas = ArrayList<ReviewLasik>()
    private var reviewOphthalmologyDatas = ArrayList<ReviewOphthalmology>()
    private var reviewNearOphthalmologyDatas = ArrayList<ReviewNearOphthalmology>()

    override fun initAfterBinding(){



        binding.homeAddMyreviewIv.setOnClickListener {
            (context as MainActivity).supportFragmentManager.beginTransaction()
                .replace(R.id.nav_host_fragment_container, AddReviewFragment())
                .commitAllowingStateLoss()
        }



        //데이터 리스트 생성 더미 데이터
        //라섹
        reviewLasekDatas.apply {
            add(ReviewLasek("김안과병원","서울특별시 영등포구",3f,"설명 자세히 해주시고, 솔직히 많이 무서웠는데 시술 전부터 무섭지 않게 긴장 풀어주셔서 너무 좋았어요."))
            add(ReviewLasek("안다 병원","서울특별시 마포구",5f,"너무 좋았습니다"))
            add(ReviewLasek("모른다 병원","서울특별시 광진구",2.5f,"붉은색 푸른색 그 사이 3초 그 짧은 시간 노란색 빛을 내는 저기 저 신호등이"))
            add(ReviewLasek("알걸 명원","서울특별시 강서구",1f,"잘 지냈지? 조금은 어색해 요즘 좋아 보여 인사 나누며 사실 궁금한 게 너무 많았는데 반가움에 멍해졌죠"))
            add(ReviewLasek("알라 병원","서울특별시 용산구", 4.5f, "뭐 하고 있었니? 늦었지만 잠시 나올래? 너의 집 골목에 있는 놀이터에 앉아 있어"))
        }
        //라식
        reviewLasikDatas.apply {
            add(ReviewLasik("안다 병원","서울특별시 마포구",5f,"너무 좋았습니다"))
            add(ReviewLasik("알걸 명원","서울특별시 강서구",1f,"잘 지냈지? 조금은 어색해 요즘 좋아 보여 인사 나누며 사실 궁금한 게 너무 많았는데 반가움에 멍해졌죠"))
            add(ReviewLasik("김안과병원","서울특별시 영등포구",3f,"설명 자세히 해주시고, 솔직히 많이 무서웠는데 시술 전부터 무섭지 않게 긴장 풀어주셔서 너무 좋았어요."))
            add(ReviewLasik("알라 병원","서울특별시 용산구", 4.5f, "뭐 하고 있었니? 늦었지만 잠시 나올래? 너의 집 골목에 있는 놀이터에 앉아 있어"))
            add(ReviewLasik("모른다 병원","서울특별시 광진구",2.5f,"붉은색 푸른색 그 사이 3초 그 짧은 시간 노란색 빛을 내는 저기 저 신호등이"))
        }
        //안과
        reviewOphthalmologyDatas.apply {
            add(ReviewOphthalmology("alla 병원","서울특별시 용산구", 4.5f, "뭐 하고 있었니? 늦었지만 잠시 나올래? 너의 집 골목에 있는 놀이터에 앉아 있어"))
            add(ReviewOphthalmology("alger 명원","서울특별시 강서구",1f,"잘 지냈지? 조금은 어색해 요즘 좋아 보여 인사 나누며 사실 궁금한 게 너무 많았는데 반가움에 멍해졌죠"))
            add(ReviewOphthalmology("anda 병원","서울특별시 마포구",5f,"너무 좋았습니다"))
            add(ReviewOphthalmology("kimangha 병원","서울특별시 영등포구",3f,"설명 자세히 해주시고, 솔직히 많이 무서웠는데 시술 전부터 무섭지 않게 긴장 풀어주셔서 너무 좋았어요."))
            add(ReviewOphthalmology("morenda 병원","서울특별시 광진구",2.5f,"붉은색 푸른색 그 사이 3초 그 짧은 시간 노란색 빛을 내는 저기 저 신호등이"))
        }
        //근처 안과
        reviewNearOphthalmologyDatas.apply {
            add(ReviewNearOphthalmology("kimangha 병원","서울특별시 영등포구",3f,"설명 자세히 해주시고, 솔직히 많이 무서웠는데 시술 전부터 무섭지 않게 긴장 풀어주셔서 너무 좋았어요."))
            add(ReviewNearOphthalmology("anda 병원","서울특별시 마포구",5f,"너무 좋았습니다"))
            add(ReviewNearOphthalmology("morenda 병원","서울특별시 광진구",2.5f,"붉은색 푸른색 그 사이 3초 그 짧은 시간 노란색 빛을 내는 저기 저 신호등이"))
            add(ReviewNearOphthalmology("alger 명원","서울특별시 강서구",1f,"잘 지냈지? 조금은 어색해 요즘 좋아 보여 인사 나누며 사실 궁금한 게 너무 많았는데 반가움에 멍해졌죠"))
            add(ReviewNearOphthalmology("alla 병원","서울특별시 용산구", 4.5f, "뭐 하고 있었니? 늦었지만 잠시 나올래? 너의 집 골목에 있는 놀이터에 앉아 있어"))
        }


        //라섹 데이터 입력
        val reviewLasekRVAdapter = ReviewLasekRVAdapter(reviewLasekDatas)
        binding.homeLasekReviewRv.adapter = reviewLasekRVAdapter
        binding.homeLasekReviewRv.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

        //라식 데이터 입력
        val reviewLasikRVAdapter = ReviewLasikRVAdapter(reviewLasikDatas)
        binding.homeLasikReviewRv.adapter = reviewLasikRVAdapter
        binding.homeLasikReviewRv.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

        //안과 데이터 입력
        val reviewOphthalmologyRVAdapter = ReviewOphthalmologyRVAdapter(reviewOphthalmologyDatas)
        binding.homeOphthalmologyReviewRv.adapter = reviewOphthalmologyRVAdapter
        binding.homeOphthalmologyReviewRv.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

        //근처 안과 데이터 입력
        val reviewNearOphthalmologyRVAdapter = ReviewNearOphthalmologyRVAdapter(reviewNearOphthalmologyDatas)
        binding.homeNearOphthalmologyReviewRv.adapter = reviewNearOphthalmologyRVAdapter
        binding.homeNearOphthalmologyReviewRv.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)


        val homebannerAdapter = HomeBannerVPAdapter(this)
        homebannerAdapter.addFragment(HomeBannerFragment(R.drawable.home_banneranner_1))
        homebannerAdapter.addFragment(HomeBannerFragment(R.drawable.home_banneranner_2))
        homebannerAdapter.addFragment(HomeBannerFragment(R.drawable.home_banneranner_3))
        binding.homeInfobannerVp.adapter = homebannerAdapter
        binding.homeInfobannerVp.orientation = ViewPager2.ORIENTATION_HORIZONTAL
    }




}