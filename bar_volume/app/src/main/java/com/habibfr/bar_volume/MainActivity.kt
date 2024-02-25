package com.habibfr.bar_volume

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var etPanjang: EditText;
    private lateinit var etLebar: EditText;
    private lateinit var etTinggi: EditText;
    private lateinit var btnHitung: Button;
    private lateinit var txtHasil: TextView;

    companion object {
        private const val STATE_RESULT = "state_result"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etPanjang = findViewById(R.id.etPanjang);
        etLebar = findViewById(R.id.etLebar);
        etTinggi = findViewById(R.id.etTinggi);
        btnHitung = findViewById(R.id.btnHitung)
        txtHasil = findViewById(R.id.txtHasil)

        btnHitung.setOnClickListener(this)

        if (savedInstanceState != null) {
            val result = savedInstanceState.getString(STATE_RESULT)
            txtHasil.text = result
        }
    }

    override fun onClick(p0: View?) {
        if (p0?.id == R.id.btnHitung) {
            val panjang = etPanjang.text.toString().trim()
            val lebar = etLebar.text.toString().trim()
            val tinggi = etTinggi.text.toString().trim()


            var isValueEmpty = false

            if (panjang.isEmpty()) {
                isValueEmpty = true
                etPanjang.error = "Field panjang tidak boleh kosong!"
            }
            if (lebar.isEmpty()) {
                isValueEmpty = true
                etLebar.error = "Field lebar tidak boleh kosong!"
            }
            if (panjang.isEmpty()) {
                isValueEmpty = true
                etTinggi.error = "Field tinggi tidak boleh kosong!"
            }

            if (!isValueEmpty) {
                val hasil = panjang.toDouble() * lebar.toDouble() * tinggi.toDouble()
                txtHasil.text = hasil.toString()
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(STATE_RESULT, txtHasil.text.toString())
    }
}