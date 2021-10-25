package com.example.headsupsqlite_saveonlyoptional
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.isVisible

class MainActivity3 : AppCompatActivity() {
    lateinit var tvTimer:TextView

    lateinit var linear1:LinearLayout
    lateinit var btnStrat:Button
    lateinit var linear2:LinearLayout
    lateinit var tvRotate:TextView
    lateinit var linear3:LinearLayout
    lateinit var tvName:TextView
    lateinit var tv1:TextView
    lateinit var tv2:TextView
    lateinit var tv3:TextView
    var celebList= arrayListOf<List<String>>()
    var celeb=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        tvTimer=findViewById(R.id.tvTimer)
        linear1=findViewById(R.id.LL1)
        btnStrat=findViewById(R.id.btnStart)
        linear2=findViewById(R.id.LL2)
        tvRotate=findViewById(R.id.tvRotate)
        linear3=findViewById(R.id.LL3)
        tvName=findViewById(R.id.tvName)
        tv1=findViewById(R.id.tvT1)
        tv2=findViewById(R.id.tvT2)
        tv3=findViewById(R.id.tvT3)

        btnStrat.setOnClickListener(){
            linear1.visibility=View.GONE
            linear2.visibility=View.VISIBLE
            countDownTimer()
            getDBdata()
        }

    }

    fun countDownTimer(){
        object : CountDownTimer(6000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                tvTimer.setText("Time: " + millisUntilFinished / 1000)
            }
            override fun onFinish() {
                tvTimer.setText("Time: -")
                linear2.visibility=View.GONE
                linear3.visibility=View.GONE
                linear1.visibility=View.VISIBLE
            }
        }.start()
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)

        // Checks the orientation of the screen
        if (newConfig.orientation === Configuration.ORIENTATION_LANDSCAPE) {
            if (linear2.isVisible){
                linear2.visibility=View.GONE
                linear3.visibility=View.VISIBLE
                getCele()
            }
            Toast.makeText(this, "landscape", Toast.LENGTH_SHORT).show()
        } else if (newConfig.orientation === Configuration.ORIENTATION_PORTRAIT) {
            if (linear3.isVisible){
                linear2.visibility=View.VISIBLE
                linear3.visibility=View.GONE
                celeb++
            }
            Toast.makeText(this, "portrait", Toast.LENGTH_SHORT).show()
        }
    }//end onConfigurationChanged()



    fun getDBdata(){
        val dbHelper=DBHlpr(this)
        celebList.addAll(dbHelper.retrive())
        getCele()
    }

    fun getCele(){
        tvName.text=celebList[celeb][0]
        tv1.text=celebList[celeb][1]
        tv2.text=celebList[celeb][2]
        tv3.text=celebList[celeb][3]
    }

}//end class