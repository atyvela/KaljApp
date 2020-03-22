package com.example.kaljapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_drink.*
import kotlinx.android.synthetic.main.activity_main.*

class DrinkActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drink)



        map_button.setOnClickListener {
            val intent = Intent(applicationContext, MapActivity::class.java)
            startActivity(intent)
        }

        stat_button.setOnClickListener {
            val intent = Intent(applicationContext, StatActivity::class.java)
            startActivity(intent)
        }
    }
}
