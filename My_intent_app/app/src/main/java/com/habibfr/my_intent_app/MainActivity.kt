package com.habibfr.my_intent_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity(), View.OnClickListener {
    companion object {
        const val EXTRA_AGE = "extra_age"
        const val EXTRA_NAME = "extra_name"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnPindahActivity = findViewById<Button>(R.id.btnPindahActivity)
        btnPindahActivity.setOnClickListener(this)

        val btnPindahDenganData = findViewById<Button>(R.id.btnPindahDenganData)
        btnPindahDenganData.setOnClickListener(this)

    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.btnPindahActivity -> {
                val moveIntent = Intent(this@MainActivity, MoveActivity::class.java)
                startActivity(moveIntent)
            }
            R.id.btnPindahDenganData ->{
                val moveWithData = Intent(this@MainActivity, MoveWithDataActivity::class.java)
                moveWithData.putExtra(MoveWithDataActivity.EXTRA_AGE, 20)
                moveWithData.putExtra(MoveWithDataActivity.EXTRA_NAME, "Habibfr Ganteng")
                startActivity(moveWithData)
            }
        }
    }
}