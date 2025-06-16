package com.example.laptopquiz

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.laptopquiz.R

class Question4Activity : AppCompatActivity() {
    private lateinit var engineering: String
    private lateinit var priority: String
    private lateinit var ram: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question4)

        engineering = intent.getStringExtra("engineering") ?: ""
        priority = intent.getStringExtra("priority") ?: ""
        ram = intent.getStringExtra("ram") ?: ""

        findViewById<Button>(R.id.btnHDD).setOnClickListener {
            goToNext("512 GB")
        }

        findViewById<Button>(R.id.btnSSD).setOnClickListener {
            goToNext("1 TB")
        }
    }

    private fun goToNext(storage: String) {
        val intent = Intent(this, Question5Activity::class.java)
        intent.putExtra("engineering", engineering)
        intent.putExtra("priority", priority)
        intent.putExtra("ram", ram)
        intent.putExtra("storage", storage)
        startActivity(intent)
    }
}
