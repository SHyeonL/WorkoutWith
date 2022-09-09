package com.opensw.mainscreen.mainscreen

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.opensw.mainscreen.R
import com.opensw.mainscreen.databinding.FragmentCommunityBinding

class  CommunityFragment : Fragment() {

    lateinit var majorScreen: MajorScreen
    lateinit var binding : FragmentCommunityBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCommunityBinding.inflate(inflater, container, false)
        val data : MutableList<Community> = loadCommunityData()
        var adapter = CommunityAdapter()
        adapter.listCommunityData = data
        with(binding) {
            RecyclerCommunity.adapter = adapter
            RecyclerCommunity.layoutManager = LinearLayoutManager(majorScreen)
        }
        return binding?.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        majorScreen = context as MajorScreen
    }

    fun loadCommunityData() : MutableList<Community> {

        val data : MutableList<Community> = mutableListOf()
        for(no in 1..100) {
            val title = "제목 ${no}"
            val content = "내용 ${no}"
            val editor = "작성자 ${no}"
            val date = System.currentTimeMillis()

            var community = Community(title, content, editor, date)

            data.add(community)
        }
        return data
    }
}