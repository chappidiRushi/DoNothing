package com.rushi.donothing

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main);
        val textView = findViewById<TextView>(R.id.mainText);
        val textInput = findViewById<EditText>(R.id.mainInput);
        val btn = findViewById<Button>(R.id.mainButton);
        btn.setOnClickListener {
            val updatedName = textInput.text.toString();
            if (updatedName ==""){
                Toast.makeText(this@MainActivity, "Please Enter a Name", Toast.LENGTH_LONG).show()

            }else{
                val message = "Hello $updatedName";
                textView.text = message;
                textInput.text.clear();

            }
            }
    }
}