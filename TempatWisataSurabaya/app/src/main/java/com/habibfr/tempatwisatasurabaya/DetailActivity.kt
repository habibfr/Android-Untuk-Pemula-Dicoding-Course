package com.habibfr.tempatwisatasurabaya

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class DetailActivity : AppCompatActivity() {
    lateinit var txtName: TextView
    lateinit var txtDescription: TextView
    lateinit var imgWisata: ImageView
    lateinit var fabShare: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        supportActionBar?.title = "Detail Wisata"

        txtName = findViewById(R.id.txtNameWisata)
        txtDescription = findViewById(R.id.txtDescriptionWisata)
        imgWisata = findViewById(R.id.imgWisata)
        fabShare = findViewById(R.id.fabShare)

        val data = intent.getParcelableExtra<Wisata>("WISATA")
        txtName.text = data?.name.toString()
        txtDescription.text = data?.description.toString()
        imgWisata.setImageResource(data?.photo!!)

        fabShare.setOnClickListener {
            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/plain"
            intent.putExtra(Intent.EXTRA_TEXT, txtName.text.toString())
            startActivity(Intent.createChooser(intent, "Bagikan melalui"))
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

}