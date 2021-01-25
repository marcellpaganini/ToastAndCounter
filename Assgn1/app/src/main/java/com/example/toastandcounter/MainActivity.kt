package com.example.toastandcounter

import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.toastandcounter.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val btnUp: Button = binding.btnUp
        btnUp.setOnClickListener { countUpClick() }
        val btnDown: Button = binding.btnDown
        btnDown.setOnClickListener { countDownClick() }
        val btnToast: Button = binding.btnToast
        btnToast.setOnClickListener { showToast() }
    }

    private var counter: Int = 0
    private fun countUpClick(){
        counter +=1
        val textView: TextView = binding.textView
        textView.text = counter.toString()
    }

    private fun countDownClick(){
        counter -=1
        val textView: TextView = binding.textView
        textView.text = counter.toString()
    }

    private fun showToast() {
        Toast.makeText(this, "Hello $counter", Toast.LENGTH_SHORT).show()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.putInt("count", counter)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        counter=savedInstanceState.getInt("count")
        binding.textView.text = counter.toString()
        }
}