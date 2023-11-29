package com.example.kotlinproject

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toolbar
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import coil.load


class DetailScreen : Fragment() {
    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val window = activity?.window
        window?.statusBarColor = resources.getColor(R.color.white)

        val view = inflater.inflate(R.layout.fragment_detail_screen, container, false)
        val itemTitle = arguments?.getString("ITEM_TITLE", "")
        val itemDescription = arguments?.getString("ITEM_DESCRIPTION", "")
        val itemPrice = arguments?.getDouble("ITEM_PRICE", 0.0)
        val itemImage = arguments?.getString("ITEM_IMAGE", "")
        val itemBrand = arguments?.getString("ITEM_BRAND", "")
        val itemCategory = arguments?.getString("ITEM_CATEGORY", "")

        val itemImageView = view.findViewById<ImageView>(R.id.itemImageView)
        val titleTextView = view.findViewById<TextView>(R.id.titleTextView)
        val descriptionTextView = view.findViewById<TextView>(R.id.descriptionTextView)
        val priceTextView = view.findViewById<TextView>(R.id.priceTextView)
        val brandTextView = view.findViewById<TextView>(R.id.brandTextView)
        val categoryTextView = view.findViewById<TextView>(R.id.categoryTextView)

        itemImageView.load(itemImage)
        titleTextView.text = itemTitle
        descriptionTextView.text = "Details:\n\t\t\t$itemDescription"
        priceTextView.text = "$" + itemPrice.toString()
        brandTextView.text = "Brand:\t$itemBrand"
        categoryTextView.text = "Category:\t$itemCategory"

        return view
    }


}
