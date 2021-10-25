package com.example.headsupsqlite_saveonlyoptional

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

lateinit var bt:Button
lateinit var bt2:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bt=findViewById(R.id.button)
        bt2=findViewById(R.id.button2)
        bt.setOnClickListener {
            var intent = Intent(applicationContext, MainActivity2::class.java)
            startActivity(intent) }
        bt2.setOnClickListener {
            var intent = Intent(applicationContext, MainActivity3::class.java)
            startActivity(intent) }


    }

}//end class