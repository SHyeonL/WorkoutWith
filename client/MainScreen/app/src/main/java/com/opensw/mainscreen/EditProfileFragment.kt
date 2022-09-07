package com.opensw.mainscreen

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.opensw.mainscreen.databinding.FragmentEditProfileBinding
import com.opensw.mainscreen.mainscreen.MajorScreen


class EditProfileFragment : Fragment() {

    lateinit var binding : FragmentEditProfileBinding
    lateinit var majorScreen: MajorScreen

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEditProfileBinding.inflate(inflater, container, false)
        binding.btnEditComplete.setOnClickListener {
            majorScreen?.goBack()
            majorScreen?.showNavBar()
        }
        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        majorScreen = context as MajorScreen
    }
}