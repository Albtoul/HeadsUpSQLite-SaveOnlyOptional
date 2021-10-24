package com.example.headsupsqlite_saveonlyoptional

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    lateinit var bt1:Button
    lateinit var bt2:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bt1=findViewById(R.id.button)
        bt2=findViewById(R.id.button2)
        bt1.setOnClickListener {
            var intent = Intent(applicationContext, MainActivity2::class.java)
            startActivity(intent) }

    }
}