package com.example.laptopquiz

import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.laptopquiz.R

class MainActivity : AppCompatActivity() {

    private lateinit var diceSound: MediaPlayer
    private lateinit var inicio: MediaPlayer
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        inicio = MediaPlayer.create(this, R.raw.wii)
        inicio.start()
        inicio.isLooping = true



        diceSound = MediaPlayer.create(this, R.raw.sonic)
        diceSound.setVolume(8.9f, 8.9f)


        val btnSistemas = findViewById<Button>(R.id.btnSistemas)
        val btnCivil = findViewById<Button>(R.id.btnCivil)
        val btnMecanica = findViewById<Button>(R.id.btnMecanica)
        val btnAnimacion = findViewById<Button>(R.id.btnAnimacion)

        btnSistemas.setOnClickListener {
            diceSound.start() // Reproducir el sonido al presionar el botón
            diceSound.isLooping = true
            inicio.pause()

            startNextActivity("Sistemas")
        }

        btnCivil.setOnClickListener {
            diceSound.start() // Reproducir el sonido al presionar el botón
            diceSound.isLooping = true
            inicio.pause()

            startNextActivity("Arquitectura")
        }

        btnMecanica.setOnClickListener {
            diceSound.start() // Reproducir el sonido al presionar el botón
            diceSound.isLooping = true
            inicio.pause()

            startNextActivity("Mecatronica")
        }
        btnAnimacion.setOnClickListener {
            diceSound.start() // Reproducir el sonido al presionar el botón
            diceSound.isLooping = true
            inicio.pause()

            startNextActivity("Animacion")
        }
    }

    private fun startNextActivity(engineering: String) {
        val intent = Intent(this, Question2Activity::class.java)
        intent.putExtra("engineering", engineering)
        startActivity(intent)
    }

}
