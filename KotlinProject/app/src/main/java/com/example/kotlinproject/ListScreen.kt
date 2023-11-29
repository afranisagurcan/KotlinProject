package com.example.kotlinproject

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinproject.adapter.ItemAdapter
import com.example.kotlinproject.service.ApiService
import com.example.kotlinproject.utils.Post
import com.example.kotlinproject.utils.constants.Urls.BASE_URL
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.math.ceil

class ListScreen : Fragment() {
    private var currentPage = 1

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_list_screen, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //addNewItem()
        getAllProducts()
    }

    /*private fun addNewItem() {
        val button = view?.findViewById<Button>(R.id.newItemButton)
        button?.setOnClickListener {
            val transaction = (context as AppCompatActivity).supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container, AddingScreen())
            transaction.addToBackStack("HomeScreen")
            transaction.commit()
        }
    }*/

    private fun getAllProducts() {

        val api = Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)

        api.getProducts().enqueue(object : Callback<List<Post>> {
            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        val pageData = paginateList(it, currentPage)

                        val recyclerView = view?.findViewById<RecyclerView>(R.id.recycler_view)

                        recyclerView?.adapter = ItemAdapter(requireContext(), pageData)

                        setupPaginationButtons(response)

                        for (product in pageData) {
                            Log.i("CHECK_RESPONSE", "onResponse: ${product.brand}")
                        }
                    }
                }
            }

            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                Log.i("CHECK_RESPONSE", "onResponse: ${t.message}")
            }
        })

    }

    private fun setupPaginationButtons(response: Response<List<Post>>) {
        val previousButton = view?.findViewById<Button>(R.id.previous_button)
        val nextButton = view?.findViewById<Button>(R.id.next_button)
        val pageNumberText = view?.findViewById<TextView>(R.id.page_number)

        pageNumberText?.text = currentPage.toString()

        previousButton?.visibility = if (currentPage > 1) View.VISIBLE else View.GONE
        nextButton?.visibility =
            if (currentPage < calculateTotalPageCount(response.body()?.size ?: 0)) View.VISIBLE else View.GONE

        previousButton?.setOnClickListener {
            if (currentPage > 1) {
                currentPage -= 1
                getAllProducts()
            }
        }

        nextButton?.setOnClickListener {
            if (currentPage < calculateTotalPageCount(response.body()?.size ?: 0)) {
                currentPage += 1
                getAllProducts()
            }
        }
    }

    private fun calculateTotalPageCount(totalItemCount: Int): Int {
        return ceil((totalItemCount.toDouble() / 7)).toInt()
    }

    private fun paginateList(list: List<Post>, pageNumber: Int): List<Post> {
        val startIndex = (pageNumber - 1) * 7
        val endIndex = minOf(pageNumber * 7, list.size)
        return list.subList(startIndex, endIndex)
    }

}