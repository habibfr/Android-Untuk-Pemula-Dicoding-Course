package com.habibfr.my_intent_app

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat.RegisterReceiverFlags

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var txtResult: TextView

    @SuppressLint("SetTextI18n")
    private val resultLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == MoveForResultActivity.RESULT_CODE && result.data != null) {
            val selectedValue =
                result.data?.getIntExtra(MoveForResultActivity.EXTRA_SELECTED_VALUE, 0)
            txtResult.text = "Hasil : $selectedValue"
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnPindahActivity = findViewById<Button>(R.id.btnPindahActivity)
        btnPindahActivity.setOnClickListener(this)

        val btnPindahDenganData = findViewById<Button>(R.id.btnPindahDenganData)
        btnPindahDenganData.setOnClickListener(this)

        val btnPindahDenganObject = findViewById<Button>(R.id.btnPindahDenganObject)
        btnPindahDenganObject.setOnClickListener(this)

        val btnDialNumber = findViewById<Button>(R.id.btnDialNumber)
        btnDialNumber.setOnClickListener(this)

        val btnMoveToResult = findViewById<Button>(R.id.btnMoveToResult)
        btnMoveToResult.setOnClickListener(this)

        txtResult = findViewById<TextView>(R.id.txtResult)

    }


    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.btnPindahActivity -> {
                val moveIntent = Intent(this@MainActivity, MoveActivity::class.java)
                startActivity(moveIntent)
            }
            R.id.btnPindahDenganData -> {
                val moveWithData = Intent(this@MainActivity, MoveWithDataActivity::class.java)
                moveWithData.putExtra(MoveWithDataActivity.EXTRA_AGE, 20)
                moveWithData.putExtra(MoveWithDataActivity.EXTRA_NAME, "Habibfr Ganteng")
                startActivity(moveWithData)
            }
            R.id.btnPindahDenganObject -> {
                val moveWithObject = Intent(this@MainActivity, MoveWithObjectActivity::class.java)
                moveWithObject.putExtra(
                    MoveWithObjectActivity.EXTRA_PERSON,
                    Person("Habib", 20, "habib@gmail.com", "Surabaya")
                )
                startActivity(moveWithObject)

//                if banyak
//                var persons = ArrayList<Person>()
//                moveWithObject.putParcelableArrayListExtra(KEY,persons)
            }
            R.id.btnDialNumber -> {
                val number = "08123456789"
                val dialPhoneIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$number"))
                startActivity(dialPhoneIntent)
            }
            R.id.btnMoveToResult -> {
                val moveToResult = Intent(this@MainActivity, MoveForResultActivity::class.java)
                resultLauncher.launch(moveToResult)
            }
        }
    }


}