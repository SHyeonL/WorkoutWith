package com.opensw.mainscreen

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.opensw.mainscreen.databinding.FragmentMatchingStartBinding
import com.opensw.mainscreen.databinding.FragmentMatchingTeamBinding
import com.opensw.mainscreen.mainscreen.MajorScreen

class MatchingTeamFragment : Fragment() {

    lateinit var majorScreen: MajorScreen
    lateinit var binding : FragmentMatchingTeamBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMatchingTeamBinding.inflate(inflater, container, false)
        val data : MutableList<MatchingTeam> = loadMatchingTeamData()
        var adapter = MatchingTeamAdapter()
        adapter.listMatchingTeamData = data
        with(binding) {
            recyclerProfile.adapter = adapter
            recyclerProfile.layoutManager = GridLayoutManager(majorScreen, 3)
        }
        return binding?.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        majorScreen = context as MajorScreen
    }

    fun loadMatchingTeamData() : MutableList<MatchingTeam> {

        val data : MutableList<MatchingTeam> = mutableListOf()
        for(no in 1..10) {
            val title = "팀원 ${no}"
            var matchingTeam = MatchingTeam(title)
            data.add(matchingTeam)
        }
        return data
    }
}