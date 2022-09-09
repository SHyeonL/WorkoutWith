package com.opensw.mainscreen

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.opensw.mainscreen.databinding.FragmentEditProfileBinding
import com.opensw.mainscreen.mainscreen.MajorScreen


class EditProfileFragment : Fragment() {

    lateinit var binding : FragmentEditProfileBinding
    lateinit var majorScreen: MajorScreen
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        majorScreen?.hideNavBar(true)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEditProfileBinding.inflate(inflater, container, false)
        binding.btnEditComplete.setOnClickListener {
            majorScreen?.test()
        }
        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        majorScreen = context as MajorScreen
    }

    override fun onDestroy() {
        Log.d("프래그먼트 종료", "프래그먼트 종료")
        super.onDestroy()
        majorScreen?.hideNavBar(false)
    }
}