package com.example.headsupsqlite_saveonlyoptional

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity2 : AppCompatActivity() {
    lateinit var ed1:EditText
    lateinit var ed2:EditText
    lateinit var ed3:EditText
    lateinit var ed4:EditText
    lateinit var bt:Button
    lateinit var rc: RecyclerView

    var s1=""
    var s2=""
    var s3=""
    var s4=""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        ed1=findViewById(R.id.editTextTextPersonName)
        ed2=findViewById(R.id.editTextTextPersonName2)
        ed3=findViewById(R.id.editTextTextPersonName3)
        ed4=findViewById(R.id.editTextTextPersonName4)
        rc=findViewById(R.id.RVv)
        bt=findViewById(R.id.button3)


        bt.setOnClickListener {
         s1=ed1.text.toString()
         s2=ed2.text.toString()
         s3=ed3.text.toString()
         s4=ed4.text.toString()
            var dbhr =DBHlpr(applicationContext)

   var stst= dbhr.save(s1,s2,s3,s4)
    Toast.makeText(applicationContext, "data add"+stst, Toast.LENGTH_SHORT).show()
    val x=dbhr.retrive()
            rc.adapter=RV(x)
            rc.layoutManager= LinearLayoutManager(this)

}


    }

}