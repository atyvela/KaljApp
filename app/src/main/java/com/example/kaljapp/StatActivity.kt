package com.example.kaljapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kaljapp.DrinkActivity.Record
import kotlinx.android.synthetic.main.activity_stat.*

class StatActivity : AppCompatActivity() {


    var record = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stat)
        record = Record.currentRecord
        record_text.text = "%.2f".format(record)  + ".%"
        date_text.text = "in " + Record.formatted



    }

}
