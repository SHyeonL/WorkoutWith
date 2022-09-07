package com.opensw.mainscreen.mainscreen

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.opensw.mainscreen.databinding.RecyclerCommunityBinding
import java.text.SimpleDateFormat

class CommunityAdapter : RecyclerView.Adapter<CommunityHolder>() {

	var listCommunityData = mutableListOf<Community>()
	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommunityHolder {
		val binding = RecyclerCommunityBinding.inflate(LayoutInflater.from(parent.context), parent, false)
		return CommunityHolder(binding)
	}

	override fun onBindViewHolder(holder: CommunityHolder, position: Int) {
		val community = listCommunityData.get(position)
		holder.setCommunity(community)
	}

	override fun getItemCount(): Int {
		return listCommunityData.size
	}
}

class CommunityHolder(val binding: RecyclerCommunityBinding) : RecyclerView.ViewHolder(binding.root) {

	init {
		binding.root.setOnClickListener {
			Toast.makeText(binding.root.context
				,"클릭된 아이템=${binding.textCommunityTitle.text}"
				,Toast.LENGTH_LONG).show()
		}
	}

	fun setCommunity(community: Community) {
		binding.textCommunityTitle.text = community.title
		binding.textCommunityContent.text = community.content
		binding.textCommunityEditor.text = community.editor

		var sdf = SimpleDateFormat("yyyy/MM/dd")
		var formattedData = sdf.format(community.editTime)
		binding.textCommunityTime.text = formattedData
	}
}