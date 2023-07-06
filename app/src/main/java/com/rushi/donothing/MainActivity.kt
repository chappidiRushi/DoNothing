package com.rushi.donothing

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val textView = findViewById<TextView>(R.id.mainText)
        val textInput = findViewById<EditText>(R.id.mainInput)
        val btn = findViewById<Button>(R.id.mainButton)
        val nextBtn = findViewById<Button>(R.id.nextBtn)
        val bmiButton = findViewById<Button>(R.id.calculateBmiBtn)

        var updatedName = ""
        btn.setOnClickListener {
            updatedName = textInput.text.toString()
            if (updatedName ==""){
                Toast.makeText(this@MainActivity, "Please Enter a Name",
                    Toast.LENGTH_LONG).show()
                nextBtn.visibility = INVISIBLE
            }else{
                updatedName = "Hello $updatedName"
                textView.text = updatedName
                textInput.text.clear()
                nextBtn.visibility = VISIBLE
            }
            }
        nextBtn.setOnClickListener{
            val nextIntent = Intent(this, SecondActivity::class.java)
//            val updatedName = textInput.text.toString()

            nextIntent.putExtra("USER",updatedName)
            startActivity(nextIntent)
        }
        bmiButton.setOnClickListener{
            val bmiIntent = Intent(this, BmiActivity::class.java)
//            val updatedName = textInput.text.toString()

//            nextIntent.putExtra("USER",updatedName)
            startActivity(bmiIntent)
        }
    }
}