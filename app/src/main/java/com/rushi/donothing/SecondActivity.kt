package com.rushi.donothing

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class SecondActivity : AppCompatActivity() {
   private lateinit var userName: EditText
   private lateinit var userAge: EditText
   private  lateinit var sp: SharedPreferences
   private lateinit var spe: SharedPreferences.Editor
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val userName1 = intent.getStringExtra("USER")
        val textView = findViewById<TextView>(R.id.SecondText)
        textView.text = "welcome $userName1"
        userName = findViewById(R.id.saUserName)
        userAge= findViewById(R.id.saUserAge)
        sp = getSharedPreferences("USER_NAME", MODE_PRIVATE)
        spe = sp.edit()
        val saveBtn = findViewById<Button>(R.id.saSave)
        saveBtn.setOnClickListener {
            val name = userName.text.toString()
            val age  = userAge.text.toString()
            if(name == ""){
                Toast.makeText(this@SecondActivity,
                    "Please Enter UserName",Toast.LENGTH_LONG).show()
            }else if(age ==""){
                Toast.makeText(this@SecondActivity,
                    "Please Enter Age",Toast.LENGTH_LONG).show()
            }else{
                spe.apply{
                    putString("USER_NAME", name)
                    putString("USER_AGE", age)
                    commit()
                }
                Toast.makeText(this@SecondActivity,
                    "Saved Successfully",Toast.LENGTH_LONG).show()
            }
        }
    }
    override fun onPause() {
        super.onPause()
    }
    override fun onResume(){
        super.onResume()
        val name = sp.getString("USER_NAME","")
        val age = sp.getString("USER_AGE","")
        userName.setText(name)
        userAge.setText(age)

    }


}