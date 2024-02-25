package com.habibfr.my_intent_app

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MoveWithDataActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_AGE = "extra_age"
        const val EXTRA_NAME = "extra_name"
    }

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move_with_data)

        val txtDataReceived = findViewById<TextView>(R.id.txtDataReceived)

        val age = intent.getIntExtra(EXTRA_AGE, 0)
        val name = intent.getStringExtra(EXTRA_NAME)

        txtDataReceived.text = "Name : $name, Your age: $age"

    }
}