package com.example.laptopquiz

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.laptopquiz.R

class Question3Activity : AppCompatActivity() {
    private lateinit var engineering: String
    private lateinit var priority: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question3)

        engineering = intent.getStringExtra("engineering") ?: ""
        priority = intent.getStringExtra("priority") ?: ""

        findViewById<Button>(R.id.btn8gb).setOnClickListener {
            goToNext("8GB")
        }

        findViewById<Button>(R.id.btn16gb).setOnClickListener {
            goToNext("16GB")
        }

        findViewById<Button>(R.id.btn32gb).setOnClickListener {
            goToNext("32GB")
        }
    }

    private fun goToNext(ram: String) {
        val intent = Intent(this, Question4Activity::class.java)
        intent.putExtra("engineering", engineering)
        intent.putExtra("priority", priority)
        intent.putExtra("ram", ram)
        startActivity(intent)
    }
}
