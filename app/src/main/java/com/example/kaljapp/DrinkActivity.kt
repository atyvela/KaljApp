package com.example.kaljapp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.kaljapp.MainActivity.Companion
import kotlinx.android.synthetic.main.activity_drink.*
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import kotlin.concurrent.fixedRateTimer



class DrinkActivity : AppCompatActivity() {

    companion object Record{
        var currentRecord = 0.0
        var formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy")
        var current = LocalDateTime.now()
        var formatted = ""

    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drink)
        var drinkAmount = 0.0
        var burnedAmount = 0.0
        var genderMultiplier = 0.0

        var bac = 0.0

        if(Companion.female){
            genderMultiplier = 0.55
        }
        if(Companion.male){
            genderMultiplier = 0.68
        }

        limitText.text ="your limit is " + Companion.limit.toDouble().toString() + " %"



        fixedRateTimer("timer",false,0,60000){
            this@DrinkActivity.runOnUiThread {
                if(bac > 0){
                    bac -= (0.15 / 60)
                }
                burnedAmount += Companion.weight / (10 * 60)
                burnedAmount_text.text = "of which you have burned " +burnedAmount.toString() + " units"
                bac_text.text="%.2f".format(bac)  + ".%"


            }
        }

        beer1_button.setOnClickListener {
            drinkAmount +=1

            if(drinkAmount == 1.0){
                DrinksAmount_text.text = "you have consumed total of " +drinkAmount.toString() +" unit of alcohol"
            }
            else{
                DrinksAmount_text.text = "you have consumed total of " + drinkAmount.toString() +" units of alcohol"
            }

            bac += ((1*12) /(Companion.weight  *1000 * genderMultiplier)) *1000

            if(bac > Companion.limit && Companion.limit.toInt() != 0){
                Toast.makeText(applicationContext,"Warning! you have just exceeded your limit!",Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(applicationContext,"You just drunk 0.33l of beer!",Toast.LENGTH_SHORT).show()
            }
            bac_text.text="%.2f".format(bac) + ".%"

            if(bac > currentRecord){
                currentRecord = bac

                formatted = current.format(formatter)
            }
        }
        beer2_button.setOnClickListener {
            drinkAmount += 1.5

            if(drinkAmount == 1.0){
                DrinksAmount_text.text = "you have consumed total of " +drinkAmount.toString() +" unit of alcohol"
            }
            else{
                DrinksAmount_text.text = "you have consumed total of " + drinkAmount.toString() +" units of alcohol"
            }


            bac += ((1.5 *12) /(Companion.weight  *1000 * genderMultiplier)) *1000
            if(bac > Companion.limit && Companion.limit.toInt() != 0 ){
                Toast.makeText(applicationContext,"Warning! you have just exceeded your limit!",Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(applicationContext,"You just drunk 0.5l of beer!",Toast.LENGTH_SHORT).show()
            }
            bac_text.text="%.2f".format(bac)  + ".%"
            if(bac > currentRecord){
                currentRecord = bac
            }
        }
        wine_button.setOnClickListener {
            drinkAmount +=1

            if(drinkAmount == 1.0){
                DrinksAmount_text.text = "you have consumed total of " +drinkAmount.toString() +" unit of alcohol"
            }
            else{
                DrinksAmount_text.text = "you have consumed total of " + drinkAmount.toString() +" units of alcohol"
            }

            bac += ((1 *12) /(Companion.weight  *1000 * genderMultiplier)) *1000

            if(bac > Companion.limit && Companion.limit.toInt() != 0){
                Toast.makeText(applicationContext,"Warning! you have just exceeded your limit!",Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(applicationContext,"You just drunk a glass of wine!",Toast.LENGTH_SHORT).show()
            }
            bac_text.text="%.2f".format(bac)  + ".%"
            if(bac > currentRecord){
                currentRecord = bac
            }
        }
        shot_button.setOnClickListener {
            drinkAmount +=1

            if(drinkAmount == 1.0){
                DrinksAmount_text.text = "you have consumed total of " +drinkAmount.toString() +" unit of alcohol"
            }
            else{
                DrinksAmount_text.text = "you have consumed total of " + drinkAmount.toString() +" units of alcohol"
            }

            bac += ((1 *12) /(Companion.weight  *1000 * genderMultiplier)) *1000
            if(bac > Companion.limit && Companion.limit.toInt() != 0){
                Toast.makeText(applicationContext,"Warning! you have just exceeded your limit!",Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(applicationContext,"You just drunk a shot!",Toast.LENGTH_SHORT).show()
            }
            bac_text.text="%.2f".format(bac)  + ".%"
            if(bac > currentRecord){
                currentRecord = bac
            }
        }

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
