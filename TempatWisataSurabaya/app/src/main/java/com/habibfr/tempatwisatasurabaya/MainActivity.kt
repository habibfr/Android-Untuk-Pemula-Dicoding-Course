package com.habibfr.tempatwisatasurabaya

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvWisata: RecyclerView
    private val listWisata = ArrayList<Wisata>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.title = "List Wisata di Surabaya"

        rvWisata = findViewById(R.id.rvWisata)
        rvWisata.setHasFixedSize(true)

        listWisata.addAll(getListWisata())
        showRecyclerList()
    }

    private fun getListWisata(): ArrayList<Wisata> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val listWisata = ArrayList<Wisata>()

        for (i in dataName.indices) {
            val wisata = Wisata(dataName[i], dataDescription[i], dataPhoto.getResourceId(i, -1))
            listWisata.add(wisata)
        }
        return listWisata
    }

    private fun showRecyclerList() {
        rvWisata.layoutManager = LinearLayoutManager(this)
        val listWisataAdapter = ListWisataAdapter(listWisata)
        rvWisata.adapter = listWisataAdapter

        listWisataAdapter.setOnItemClickCallback(object : ListWisataAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Wisata) {
                val intentToDetail = Intent(this@MainActivity, DetailActivity::class.java)
                intentToDetail.putExtra("WISATA", data)
                startActivity(intentToDetail)
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.action_about) {
            val intentToAbout = Intent(this@MainActivity, AboutActivity::class.java)
            startActivity(intentToAbout)
        }
        return super.onOptionsItemSelected(item)
    }


}