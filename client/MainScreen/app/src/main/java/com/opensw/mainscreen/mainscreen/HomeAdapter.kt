package com.opensw.mainscreen.mainscreen

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.opensw.mainscreen.OnItemClick
import com.opensw.mainscreen.databinding.FragmentHomeBinding
import com.opensw.mainscreen.databinding.RecyclerHomeBinding
import java.text.SimpleDateFormat

class HomeAdapter : RecyclerView.Adapter<Holder>() {

    var listData = mutableListOf<Memo>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = RecyclerHomeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val memo = listData.get(position)
        holder.setMemo(memo)
    }

    override fun getItemCount(): Int {
        return listData.size
    }
}

class Holder(val binding: RecyclerHomeBinding) : RecyclerView.ViewHolder(binding.root) {

    init {
        binding.root.setOnClickListener {

        }
    }

    fun setMemo(memo: Memo) {
        binding.textNo.text = "${memo.no}"
        binding.textTitle.text = memo.title

        var sdf = SimpleDateFormat("yyyy/MM/dd")
        var formattedDate = sdf.format(memo.timestamp)
        binding.textDate.text = formattedDate
    }
}