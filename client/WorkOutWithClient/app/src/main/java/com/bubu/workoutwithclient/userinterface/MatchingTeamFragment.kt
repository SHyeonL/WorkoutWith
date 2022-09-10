package com.bubu.workoutwithclient.userinterface

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.bubu.workoutwithclient.databinding.FragmentMatchingTeamBinding

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
            recyclerProfile.layoutManager = GridLayoutManager(majorScreen, 5)

            btnCreateSchedule.setOnClickListener {
                val direction = MatchingTeamFragmentDirections.actionMatchingTeamFragmentToCreateScheduleFragment()
                findNavController().navigate(direction)
            }
            btnJoinSchedule.setOnClickListener {
                val direction = MatchingTeamFragmentDirections.actionMatchingTeamFragmentToJoinScheduleFragment()
                findNavController().navigate(direction)
            }
        }
        return binding?.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        majorScreen = context as MajorScreen
    }

    fun loadMatchingTeamData() : MutableList<MatchingTeam> {

        val data : MutableList<MatchingTeam> = mutableListOf()
        for(no in 1..30) {
            val title = "팀원 ${no}"
            var matchingTeam = MatchingTeam(title)
            data.add(matchingTeam)
        }
        return data
    }
}