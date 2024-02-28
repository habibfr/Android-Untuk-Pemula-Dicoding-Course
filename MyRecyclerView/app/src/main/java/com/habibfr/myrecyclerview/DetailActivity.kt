package com.habibfr.myrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class DetailActivity : AppCompatActivity() {

    lateinit var txtName: TextView
    lateinit var txtDescription: TextView
    lateinit var imgHero: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        // Aktifkan tombol kembali (back button)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        txtName = findViewById(R.id.txtNameHero)
        txtDescription = findViewById(R.id.txtDescriptionHero)
        imgHero = findViewById(R.id.imgHero)

        val data = intent.getParcelableExtra<Hero>("DATA")
        txtName.text = data?.name.toString()
        txtDescription.text = data?.description.toString()
        data?.photo?.let { Log.d("d", it) }

        Glide.with(this@DetailActivity)
            .load(data?.photo.toString())
            .into(imgHero);
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}