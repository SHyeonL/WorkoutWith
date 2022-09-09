package com.opensw.mainscreen

import android.R
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.navigation.fragment.findNavController
import com.opensw.mainscreen.databinding.FragmentMatchingStartBinding
import com.opensw.mainscreen.mainscreen.MajorScreen

class MatchingStartFragment : Fragment() {

    lateinit var majorScreen: MajorScreen
    lateinit var binding: FragmentMatchingStartBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMatchingStartBinding.inflate(inflater, container, false)
        var selectRegion = listOf("- 선택하세요 -", "서울", "대전", "대구", "부산")
        var regionAdapter = ArrayAdapter<String>(majorScreen, R.layout.simple_list_item_1, selectRegion)

        binding.spinnerRegion.adapter = regionAdapter

        var selectSports = listOf("- 선택하세요 -", "축구", "야구", "수영", "싸이클링")
        var sportsAdapter = ArrayAdapter<String>(majorScreen, R.layout.simple_list_item_1, selectSports)

        binding.spinnerSports.adapter = sportsAdapter

        binding.btnBackToHome.setOnClickListener {
            majorScreen?.showNavBar()
            val direction = MatchingStartFragmentDirections.actionMatchingStartFragmentToHomeFragment()
            findNavController().navigate(direction)
        }
        binding.btnMatchingStart.setOnClickListener {
            val direction = MatchingStartFragmentDirections.actionMatchingStartFragmentToMatchingTeamFragment()
            findNavController().navigate(direction)
        }

        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        majorScreen = context as MajorScreen
    }

}