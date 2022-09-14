package com.bubu.workoutwithclient.userinterface.match

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bubu.workoutwithclient.databinding.MatchTeamRecyclerBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

data class MatchTeam(var userId: String, var profilePic : Bitmap)

class MatchTeamAdapter(context: Context) : RecyclerView.Adapter<MatchTeamAdapter.MatchingTeamHolder>() {

    var mContext = context
    var listMatchingTeamData = mutableListOf<MatchTeam>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MatchingTeamHolder {
        val binding =
            MatchTeamRecyclerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MatchingTeamHolder(binding)
    }

    override fun onBindViewHolder(holder: MatchingTeamHolder, position: Int) {
        val matchingTeam = listMatchingTeamData[position]
        holder.setMatchingTeam(matchingTeam)
    }

    override fun getItemCount(): Int {
        return listMatchingTeamData.size
    }


    inner class MatchingTeamHolder(val binding: MatchTeamRecyclerBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            binding.root.setOnClickListener {
                val intent = Intent(mContext, MatchUserProfileActivity::class.java)
                Log.d("bindingIntent",binding.textListTitle.text.toString())
                intent.putExtra("targetId",binding.textListTitle.text.toString())
                mContext.startActivity(intent)
            }
        }

        fun setMatchingTeam(matchingTeam: MatchTeam) {
            CoroutineScope(Dispatchers.Main).launch {
                binding.profilePicture.setImageBitmap(matchingTeam.profilePic)
                binding.textListTitle.text = matchingTeam.userId
            }
        }
    }
}