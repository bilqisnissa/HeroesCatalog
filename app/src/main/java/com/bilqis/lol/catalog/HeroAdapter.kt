package com.bilqis.lol.catalog

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.item_list.view.*

class HeroAdapter(val listDataHero : ArrayList<Hero>) :
    RecyclerView.Adapter<HeroAdapter.ViewHolder>() {

    inner class ViewHolder(itemView : View) :RecyclerView.ViewHolder(itemView) {
        var tvName: TextView = itemView.tv_name
        var tvDetail: TextView = itemView.tv_detail
        var ivProfile: ImageView = itemView.iv_profile

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroAdapter.ViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_list, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listDataHero.size
    }

    override fun onBindViewHolder(holder: HeroAdapter.ViewHolder, position: Int) {
        val hero = listDataHero[position]

        Glide.with(holder.itemView.context).load(hero.imageProfile)
            .apply(RequestOptions().override(60, 60))
            .into(holder.ivProfile)
        holder.tvName.text = hero.name
        holder.tvDetail.text = hero.detail
    }
}