package com.opensw.mainscreen.mainscreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.opensw.mainscreen.R
import com.opensw.mainscreen.databinding.FragmentHomeBinding
import com.opensw.mainscreen.databinding.FragmentRankingBinding

class RankingFragment : Fragment() {

    lateinit var binding : FragmentRankingBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentRankingBinding.inflate(inflater, container, false)
        return binding?.root
    }
}