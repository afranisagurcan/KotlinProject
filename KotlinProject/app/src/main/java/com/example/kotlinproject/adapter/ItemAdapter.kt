
package com.example.kotlinproject.adapter

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.kotlinproject.DetailScreen
import com.example.kotlinproject.HomeScreen
import com.example.kotlinproject.R
import com.example.kotlinproject.utils.Post


class ItemAdapter(
    private val context: Context,
    private val dataset: List<Post>
) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    class ItemViewHolder(private val view: View): RecyclerView.ViewHolder(view) {

        val imageView: ImageView = view.findViewById(R.id.item_image)
        val titleView: TextView = view.findViewById(R.id.item_title)
        val expView: TextView = view.findViewById(R.id.item_price)
        val button: Button = view.findViewById(R.id.arrow);
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_adapter, parent, false)

        return ItemViewHolder(adapterLayout)
    }
    override fun getItemCount(): Int {
        return dataset.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]
        holder.titleView.text = item.title
        holder.expView.text = "$" + item.price.toString()
        holder.imageView.load(item.image)

        holder.button.setOnClickListener {
            val detailFragment = DetailScreen()
            val bundle = Bundle()

            bundle.putInt("ITEM_ID", item.id_)
            bundle.putString("ITEM_TITLE", item.title)
            bundle.putString("ITEM_DESCRIPTION", item.description)
            bundle.putDouble("ITEM_PRICE", item.price)
            bundle.putString("ITEM_IMAGE", item.image)
            bundle.putString("ITEM_BRAND", item.brand)
            bundle.putString("ITEM_CATEGORY", item.category)

            detailFragment.arguments = bundle

            val transaction = (context as AppCompatActivity).supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container, detailFragment)
            transaction.addToBackStack("HomeScreen")
            transaction.commit()
        }


    }

}
