package com.example.laptopquiz

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.laptopquiz.R

class Question5Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question5)

        val engineering = intent.getStringExtra("engineering") ?: ""
        val priority = intent.getStringExtra("priority") ?: ""
        val ram = intent.getStringExtra("ram") ?: ""
        val storage = intent.getStringExtra("storage") ?: ""

        fun goToResult(screen: String) {
            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("engineering", engineering)
            intent.putExtra("priority", priority)
            intent.putExtra("ram", ram)
            intent.putExtra("storage", storage)
            intent.putExtra("screen", screen)
            startActivity(intent)
        }

        findViewById<Button>(R.id.btn13).setOnClickListener { goToResult("1920x1080")

        }
        findViewById<Button>(R.id.btn15).setOnClickListener { goToResult("2560x1440")

        }

    }
}
