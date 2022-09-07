package com.opensw.mainscreen.mainscreen

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.opensw.mainscreen.MyCustomDialog
import com.opensw.mainscreen.R
import com.opensw.mainscreen.databinding.FragmentMyProfileBinding
import com.opensw.mainscreen.databinding.RecyclerMypostBinding

open class MyProfileFragment : Fragment() {

    lateinit var majorScreen: MajorScreen
    lateinit var binding : FragmentMyProfileBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentMyProfileBinding.inflate(inflater, container, false)
        val data : MutableList<MyPost> = loadMyPostData()
        var adapter = MyPostAdapter()
        adapter.listMyPostData = data

        with(binding) {
            RecyclerMyPost.adapter = adapter
            RecyclerMyPost.layoutManager = LinearLayoutManager(majorScreen)
        }
        binding.profileImage.setOnClickListener {
            val dialog = MyCustomDialog(majorScreen)
            dialog.showDia()
        }
        binding.btnEditProfile.setOnClickListener {
            majorScreen?.goEditProfileFragment()
            majorScreen?.hideNavBar()
        }
        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        majorScreen = context as MajorScreen
    }

    fun loadMyPostData() : MutableList<MyPost> {

        val data : MutableList<MyPost> = mutableListOf()
        for(no in 1..100) {
            val title = "제목 ${no}"
            val content = "내용 ${no}"
            val date = System.currentTimeMillis()

            var myPost = MyPost(title, content, date)

            data.add(myPost)
        }
        return data
    }
}