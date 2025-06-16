package com.example.laptopquiz

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.laptopquiz.R

class Question2Activity : AppCompatActivity() {
    private lateinit var engineering: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question2)

        engineering = intent.getStringExtra("engineering") ?: ""

        val btnCPU = findViewById<Button>(R.id.btnCPU)
        val btnGPU = findViewById<Button>(R.id.btnGPU)
        val btnCPUGPU = findViewById<Button>(R.id.btnCPUGPU)

        btnCPU.setOnClickListener {
            goToNext("CPU")
        }

        btnGPU.setOnClickListener {
            goToNext("GPU")
        }
        btnCPUGPU.setOnClickListener {
            goToNext("CG")
        }
    }

    private fun goToNext(priority: String) {
        val intent = Intent(this, Question3Activity::class.java)
        intent.putExtra("engineering", engineering)
        intent.putExtra("priority", priority)
        startActivity(intent)
    }
}
