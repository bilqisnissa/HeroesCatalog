package com.bilqis.lol.catalog

import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.card_item.view.*

class CardHeroAdapter internal constructor(private val listHero:ArrayList<Hero>) : RecyclerView.Adapter<CardHeroAdapter.ViewHolder> () {

    class ViewHolder(itemView : View) : RecyclerView.ViewHolder (itemView) {
        var ivCard :ImageView = itemView.iv_cv
        var tvNameCard : TextView = itemView.tv_name_card
        var tvDetailCard : TextView = itemView.tv_detail_card
        var btnFav : Button = itemView.btn_favorite_card
        var btnShare : Button = itemView.btn_share_card
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardHeroAdapter.ViewHolder {
        val view : View = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_item,parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listHero.size
    }

    override fun onBindViewHolder(holder: CardHeroAdapter.ViewHolder, position: Int) {
        val hero = listHero[position]
        //buat nge set gambar
        Glide.with(holder.itemView.context).load(hero.imageProfile)
            .apply(RequestOptions().override(350,550))
            .into(holder.ivCard)
        //text
        holder.tvNameCard.text = hero.name
        holder.tvDetailCard.text = hero.detail

        //button
        holder.btnFav.setOnClickListener {
            Toast.makeText(
                holder.itemView.context, "Add to your Favorite "
                        + listHero[holder.adapterPosition].name, Toast.LENGTH_SHORT).show()
        }
        holder.btnShare.setOnClickListener{
            Toast.makeText(holder.itemView.context,"You are Share "
                    +listHero[holder.adapterPosition].name, Toast.LENGTH_SHORT).show()
        }
        holder.itemView.setOnClickListener { Toast.makeText(holder.itemView.context,
        "Kamu Memilih" + listHero[holder.adapterPosition].name,
            Toast.LENGTH_SHORT).show() }
    }

}