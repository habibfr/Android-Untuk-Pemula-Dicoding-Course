package com.habibfr.tempatwisatasurabaya

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.habibfr.tempatwisatasurabaya.databinding.ItemRowWisataBinding

class ListWisataAdapter(val listWisata: ArrayList<Wisata>) :
    RecyclerView.Adapter<ListWisataAdapter.ListViewHolder>() {
    class ListViewHolder(var binding: ItemRowWisataBinding) : RecyclerView.ViewHolder(binding.root)

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding =
            ItemRowWisataBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ListViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return listWisata.size
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, desc, photo) = listWisata[position]

        holder.binding.txtItemName.text = name
        holder.binding.txtItemDescription.text = desc

        holder.binding.imgItemPhoto.setImageResource(photo)
        holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(listWisata[holder.adapterPosition]) }
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Wisata)
    }
}