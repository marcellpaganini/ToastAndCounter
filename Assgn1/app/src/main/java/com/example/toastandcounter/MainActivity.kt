package com.example.toastandcounter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnUp: Button = findViewById(R.id.btn_up)
        btnUp.setOnClickListener { countUpClick() }
        val btnDown: Button = findViewById(R.id.btn_down)
        btnDown.setOnClickListener { countDownClick() }
    }

    private var counter: Int = 0
    private fun countUpClick(){
        counter +=1
        val textView: TextView = findViewById(R.id.textView)
        textView.text = counter.toString()
    }

    private fun countDownClick(){
        counter -=1
        val textView: TextView = findViewById(R.id.textView)
        textView.text = counter.toString()
    }
}