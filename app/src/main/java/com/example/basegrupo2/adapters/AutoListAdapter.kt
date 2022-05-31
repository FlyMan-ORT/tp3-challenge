package com.example.basegrupo2.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.basegrupo2.R
import com.example.basegrupo2.entities.Auto
import com.example.basegrupo2.holders.AutoHolder

class AutoListAdapter(
    private var autosList: MutableList<Auto>,
    val onItemClick: (Int) -> Boolean
) : RecyclerView.Adapter<AutoHolder>() {

    override fun getItemCount(): Int {
        return autosList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AutoHolder {
        val view =  LayoutInflater.from(parent.context).inflate(R.layout.item_auto,parent,false)
        return (AutoHolder(view))
    }

    override fun onBindViewHolder(holder: AutoHolder, position: Int) {

        holder.setName(autosList[position].marca + " - " + autosList[position].color)

        holder.getCardLayout().setOnClickListener{
            onItemClick(position)
        }
    }

    fun setData(newData: ArrayList<Auto>) {
        this.autosList = newData
        this.notifyDataSetChanged()
    }
}