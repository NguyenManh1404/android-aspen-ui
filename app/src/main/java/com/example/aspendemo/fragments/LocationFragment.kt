package com.example.aspendemo.fragments

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.aspendemo.CardAdapter
import com.example.aspendemo.CardItem
import com.example.aspendemo.DetailActivity
import com.example.aspendemo.R
import com.example.aspendemo.databinding.FragmentLocationBinding


class LocationFragment : Fragment() {

    private var _binding: FragmentLocationBinding? = null
    private val binding get() = _binding!!
    private var popularList: MutableList<CardItem> = mutableListOf()
    private var myAdapter: CardAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentLocationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        popularList.run {
            add(CardItem(R.drawable.popular, "Home Stay", 4.1, true))
            add(CardItem(R.drawable.welcomebg, "Alley Place", 5.0, true))
            add(CardItem(R.drawable.popular, "Home Stay", 4.1, false))
            add(CardItem(R.drawable.welcomebg, "Alley Place", 5.0, true))
            add(CardItem(R.drawable.popular, "Home Stay", 4.1))
            add(CardItem(R.drawable.welcomebg, "Alley Place", 5.0))
            add(CardItem(R.drawable.popular, "Home Stay", 4.1))
            add(CardItem(R.drawable.welcomebg, "Alley Place", 5.0))
        }


        binding?.recyclerViewPopular?.run {
            myAdapter = CardAdapter(popularList)
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = myAdapter
        }

        myAdapter?.notifyDataSetChanged()

        initListener()
    }


    private fun initListener() {
        myAdapter?.onClickItem = {
            Toast.makeText(context, "Its a toast! $it.title", Toast.LENGTH_SHORT).show()


            startActivity(
                Intent(context, DetailActivity::class.java).apply {

                    Log.d("ddd", this.toString())
                    // you can add values(if any) to pass to the next class or avoid using `.apply`
                    putExtra("cardItem", it)

                }
            )

        }

        myAdapter?.onClickFavorite = {
            Toast.makeText(context, "Its a toast! Favorite ${it.title}", Toast.LENGTH_SHORT).show()
        }


    }

}