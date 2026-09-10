package com.example.epicgmes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ImageAdapter(
    private val imagens: List<Int>,
    private val precos: List<String>
) : RecyclerView.Adapter<ImageAdapter.ImageViewHolder>() {

    class ImageViewHolder(
        val imageView: ImageView,
        val textViewPreco: TextView,
        itemView: View
    ) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ImageViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_carousel, parent, false)
        val imageView = view.findViewById<ImageView>(R.id.imageViewFoto)
        val textViewPreco = view.findViewById<TextView>(R.id.textViewPreco)
        return ImageViewHolder(imageView, textViewPreco, view)
    }

    override fun onBindViewHolder(
        holder: ImageViewHolder,
        position: Int
    ) {
        holder.imageView.setImageResource(imagens[position])
        holder.textViewPreco.text = precos[position]
    }

    override fun getItemCount(): Int {
        return imagens.size
    }
}
