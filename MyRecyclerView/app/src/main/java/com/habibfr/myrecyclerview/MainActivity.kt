package com.habibfr.myrecyclerview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvHero: RecyclerView
    private val list = ArrayList<Hero>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvHero = findViewById(R.id.rvHero)
        rvHero.setHasFixedSize(true)

        list.addAll(getListHero())
        showRecyclerList()
    }

    private fun getListHero(): ArrayList<Hero> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.getStringArray(R.array.data_photo)
        val listHero = ArrayList<Hero>()

        for (i in dataName.indices) {
            val hero = Hero(dataName[i], dataDescription[i], dataPhoto[i])
            listHero.add(hero)
        }
        return listHero
    }

    private fun showRecyclerList() {
        rvHero.layoutManager = LinearLayoutManager(this)
        val listHeroAdapter = ListHeroAdapater(list)
        rvHero.adapter = listHeroAdapter

        listHeroAdapter.setOnItemClickCallback(object : ListHeroAdapater.OnItemClickCallback {
            override fun onItemClicked(data: Hero) {
                val intentToDetail = Intent(this@MainActivity, DetailActivity::class.java)
                intentToDetail.putExtra("DATA", data)
                startActivity(intentToDetail)
            }
        })
    }

    private fun showSelectedHero(hero: Hero) {
        Toast.makeText(this, "Kamu memilih " + hero.name, Toast.LENGTH_SHORT).show()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_list -> {
                rvHero.layoutManager = LinearLayoutManager(this)
            }
            R.id.action_grid -> {
                rvHero.layoutManager = GridLayoutManager(this, 2)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}