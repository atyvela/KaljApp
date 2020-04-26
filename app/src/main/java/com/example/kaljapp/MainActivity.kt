package com.example.kaljapp

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object {
        var weight = 0
        var male = false
        var female = false
        var limit = 0
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)





        male_button.setOnClickListener {
            female_button.setBackgroundResource(android.R.drawable.btn_default);
            male_button.setBackgroundColor(resources.getColor(R.color.colorPrimary))
            if(!male){
                male = true
                female = false

            }
        }
        female_button.setOnClickListener {
            male_button.setBackgroundResource(android.R.drawable.btn_default);
            female_button.setBackgroundColor(resources.getColor(R.color.colorPrimary))

            if(!female){
                female = true
                male = false
            }
        }

        weight_text.addTextChangedListener(object: TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
                var weight2 = weight_text.text.toString().toInt()
                weight = weight2

            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {


            }
        })

        max_text.addTextChangedListener(object: TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
                var limit2 = max_text.text.toString().toInt()
                limit = limit2

            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {


            }
        })

        start_button.setOnClickListener {

            val intent = Intent(applicationContext, DrinkActivity::class.java)
            if(male == true || female == true){
                if(weight != 0){
                    startActivity(intent)
                }
                else{
                    Toast.makeText(applicationContext,"You need to insert your weight before continuing", Toast.LENGTH_SHORT).show()
                    Toast.makeText(applicationContext,"You need to select gender before continuing", Toast.LENGTH_SHORT).show()
                }

            }else{
                Toast.makeText(applicationContext,"You need to select gender before continuing", Toast.LENGTH_SHORT).show()
            }


        }
    }
}
