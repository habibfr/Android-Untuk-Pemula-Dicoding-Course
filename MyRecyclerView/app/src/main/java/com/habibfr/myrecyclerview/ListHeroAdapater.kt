package com.habibfr.myrecyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.habibfr.myrecyclerview.databinding.ItemRowHeroBinding

class ListHeroAdapter(private val listHero: ArrayList<Hero>) :
    RecyclerView.Adapter<ListHeroAdapter.ListViewHolder>() {
    class ListViewHolder(var binding: ItemRowHeroBinding) : RecyclerView.ViewHolder(binding.root)
//    {
//        val imgPhoto: ImageView = itemView.findViewById(R.id.imgItemPhoto)
//        val txtName: TextView = itemView.findViewById(R.id.txtItemName)
//        val txtDescription: TextView = itemView.findViewById(R.id.txtItemDescription)
//    }

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
//        val view: View =
//            LayoutInflater.from(parent.context).inflate(R.layout.item_row_hero, parent, false)
//        return ListViewHolder(view)

        val binding = ItemRowHeroBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return listHero.size
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, description, photo) = listHero[position]

//        holder.imgPhoto.setImageResource(photo)

//        holder.txtName.text = name
//        holder.txtDescription.text = description
//        Glide.with(holder.itemView.context)
//            .load(photo)
//            .into(holder.imgPhoto);

//        holder.itemView.setOnClickListener() {
//            Toast.makeText(
//                holder.itemView.context,
//                "Kamu memilih " + listHero[holder.adapterPosition].name,
//                Toast.LENGTH_SHORT
//            ).show()
//        }
//        holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(listHero[holder.adapterPosition]) }

        holder.binding.txtItemName.text = name
        holder.binding.txtItemDescription.text = description

        Glide.with(holder.itemView.context).load(photo).into(holder.binding.imgItemPhoto)
        holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(listHero[holder.adapterPosition]) }
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Hero)
    }
}