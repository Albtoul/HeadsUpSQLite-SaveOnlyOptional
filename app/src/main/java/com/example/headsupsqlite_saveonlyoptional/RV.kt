package com.example.headsupsqlite_saveonlyoptional

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.headsupsqlite_saveonlyoptional.databinding.CelibrityRowBinding

class RV(val celibritylist: ArrayList<List<String>>): RecyclerView.Adapter<RV.Holder>() {
    class Holder(val bind:CelibrityRowBinding):RecyclerView.ViewHolder(bind.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
       return Holder(CelibrityRowBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val celebrity = celibritylist[position]
        holder.bind.apply {
            for(index in celebrity) {
                textView.text = celibritylist[position].toString()
            }


        }
    }
        override fun getItemCount() = celibritylist.size


    }