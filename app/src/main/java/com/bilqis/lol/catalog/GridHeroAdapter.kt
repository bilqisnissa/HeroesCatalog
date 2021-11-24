package com.bilqis.lol.catalog

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.item_grid.view.*

class GridHeroAdapter internal constructor (var listHero : ArrayList<Hero>) : RecyclerView.Adapter<GridHeroAdapter.ViewHolder>() {
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var ivGridProfile: ImageView = itemView.iv_grid_image
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GridHeroAdapter.ViewHolder {
        val view : View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_grid, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listHero.size
    }

    override fun onBindViewHolder(holder: GridHeroAdapter.ViewHolder, position: Int) {
        Glide.with(holder.itemView.context).load(listHero[position].imageProfile)
            .apply(RequestOptions().override(350, 550))
            .into(holder.ivGridProfile)
    }
}