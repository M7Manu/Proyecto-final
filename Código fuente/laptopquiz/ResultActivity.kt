package com.example.laptopquiz

import android.media.MediaPlayer
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random
import com.example.laptopquiz.R

class ResultActivity : AppCompatActivity() {

    private lateinit var txtResult: TextView
    private lateinit var imgLaptop: ImageView
    private val randomImages = arrayOf(
        R.drawable.ideapad,
        R.drawable.g15,
        R.drawable.nitro5,
        R.drawable.lenovoloq9,
        R.drawable.lenovoloq32gb1tb,
        R.drawable.msithina15,
        R.drawable.pavilion,
        R.drawable.thunderrobot911,
        R.drawable.thunderobotr16,
        R.drawable.thunderobotzero,
        R.drawable.thunderobotzeroultra,
        R.drawable.victus,
        R.drawable.victus32gb,
        R.drawable.victus1tbssd,
        R.drawable.zenbook,
        R.drawable.pavilion
    )
    private val handler = Handler(Looper.getMainLooper())
    private var elapsedTime = 0L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        txtResult = findViewById(R.id.txtResult)
        imgLaptop = findViewById(R.id.imgLaptop)

        // Oculta el texto mientras "busca"
        txtResult.text = ""

        // Inicia el efecto de carga
        startLoadingAnimation {
            // Después de 2 segundos, muestra el resultado real
            showFinalResult()
        }
    }

    private fun startLoadingAnimation(onFinish: () -> Unit) {
        val startTime = System.currentTimeMillis()
        val updateInterval = 100L

        val runnable = object : Runnable {
            override fun run() {
                val currentTime = System.currentTimeMillis()
                val elapsed = currentTime - startTime

                if (elapsed < 2000) {
                    val randomImage = randomImages[Random.nextInt(randomImages.size)]
                    imgLaptop.setImageResource(randomImage)
                    handler.postDelayed(this, updateInterval)
                } else {
                    onFinish()
                }
            }
        }
        handler.post(runnable)
    }

    private fun showFinalResult() {
        val engineering = intent.getStringExtra("engineering") ?: ""
        val priority = intent.getStringExtra("priority") ?: ""
        val ram = intent.getStringExtra("ram") ?: ""
        val storage = intent.getStringExtra("storage") ?: ""
        val screen = intent.getStringExtra("screen") ?: ""

        val (description, imageResId) = getRecommendation(engineering, priority, ram, storage, screen)
        txtResult.text = description
        imgLaptop.setImageResource(imageResId)
    }

    private fun getRecommendation(engineering: String, priority: String, ram: String, storage: String, screen: String): Pair<String, Int> {
        return when {
            engineering == "Sistemas" && priority == "CPU" && ram == "8GB" && storage == "512 GB" && screen == "1920x1080" ->
                Pair("HP Victus 15\nRyzen 5, RX 6550M, $ram RAM, $storage, pantalla de $screen. Incluso teniendo especificaciones bajas, por su rango de precio es bastante buena, o incluso la llamaria la mejor calidad precio, donde nunca se quedara corta",
                    R.drawable.victus)
            engineering == "Sistemas" && priority == "CPU" && ram == "16GB" && storage == "512 GB" && screen == "1920x1080" ->
                Pair("Lenovo LOQ 9na Gen\ni5-12450hx, RTX 3050, $ram RAM, $storage, pantalla de $screen. tiene un poder mas grande por la memoria ram, ya que es lo mas recomendable actualmente para cualquier cosa, gaming, emulador",
                    R.drawable.lenovoloq9)
            engineering == "Sistemas" && priority == "CPU" && ram == "32GB" && storage == "512 GB" && screen == "1920x1080" ->
                Pair("HP victus\ni5 12450h, RTX 3050, $ram RAM, $storage, pantalla de $screen. tiene el mas grande poder en la memoria ram, aunque este un poco mas limitada por los anteriores componentes tiene la capacidad de abrir varios programas a la vez",
                    R.drawable.victus32gb)
            engineering == "Sistemas" && priority == "CPU" && ram == "8GB" && storage == "1 TB" && screen == "1920x1080" ->
                Pair("HP victus\nRyzen 5, RTX 4060, $ram RAM, $storage, pantalla de $screen. Perfecta para almacenar muchos archivos e instalar bastantes, aunque con un poder recomendable",
                    R.drawable.victus1tbssd)
            engineering == "Sistemas" && priority == "CPU" && ram == "16GB" && storage == "1 TB" && screen == "1920x1080" ->
                Pair("MSI thin a15\nRyzen 7, RTX 4050, $ram RAM, $storage, pantalla de $screen. Perfecta para tener muchos archivos y tener muchas aplicaciones abiertas,con un poder recomendable",
                    R.drawable.msithina15)
            engineering == "Sistemas" && priority == "CPU" && ram == "32GB" && storage == "1 TB" && screen == "1920x1080" ->
                Pair("lenovo LOQ\nRyzen 5, RTX 3050, $ram RAM, $storage, pantalla de $screen. Mucho espacio para todo programas, y bastante memoria RAM para tener varios programas abiertos, super recomendable",
                    R.drawable.lenovoloq32gb1tb)
            engineering == "Sistemas" && priority == "CPU" && ram == "8GB" && storage == "512 GB" && screen == "2560x1440" ->
                Pair("Thunderobot 911x\ni7 13620h, RTX 4060, $ram RAM, $storage, pantalla de $screen. Con una resolucion bastante destacada para poder ver todo de manera mas clara, aunque puede que presente algunos retrasos por el hardware",
                    R.drawable.thunderrobot911)
            engineering == "Sistemas" && priority == "CPU" && ram == "16GB" && storage == "512 GB" && screen == "2560x1440" ->
                Pair("Thunderobot 911x plus\ni7 13620h, RTX 4060, $ram RAM, $storage, pantalla de $screen. Con una resolucion bastante destacada y una gran capacidad de multitarea para muchos programas",
                    R.drawable.thunderrobot911)
            engineering == "Sistemas" && priority == "CPU" && ram == "32GB" && storage == "512 GB" && screen == "2560x1440" ->
                Pair("Thunderobot zero\ni9 13900hx, RTX 4060, $ram RAM, $storage, pantalla de $screen. Capaz de abrir varios programas sin alguna traba, o falta de espacio para abrir programas.",
                    R.drawable.thunderobotzero)
            engineering == "Sistemas" && priority == "CPU" && ram == "8GB" && storage == "1 TB" && screen == "2560x1440" ->
                Pair("Thunderobot R16\ni7 14650 hx, RTX 4060, $ram RAM, $storage, pantalla de $screen. Con mucho almacenamiento para cualquier tipo de programa, o archivos pesado.",
                    R.drawable.thunderobotr16)
            engineering == "Sistemas" && priority == "CPU" && ram == "16GB" && storage == "1 TB" && screen == "2560x1440" ->
                Pair("Thunderobot R16\nRyzen 7, RTX 4060, $ram RAM, $storage, pantalla de $screen. Una laptop calidad precio aunque un poco mas cara, con capacidad de todo",
                    R.drawable.thunderobotr16)
            engineering == "Sistemas" && priority == "CPU" && ram == "32GB" && storage == "1 TB" && screen == "2560x1440" ->
                Pair("Thunderobot zero ultra\ni9 14900hx, RTX 4060, $ram RAM, $storage, pantalla de $screen. Es todo terreno en cualquier aspecto, demasiado buena para ser verdad, pero lo bueno cuesta",
                    R.drawable.thunderobotzeroultra)




            engineering == "Sistemas" && priority == "GPU" && ram == "8GB" && storage == "512 GB" && screen == "1920x1080" ->
                Pair("HP Victus 15\nRyzen 5, RX 6550M, $ram RAM, $storage, pantalla de $screen. Incluso teniendo especificaciones bajas, por su rango de precio es bastante buena, o incluso la llamaria la mejor calidad precio, donde nunca se quedara corta",
                    R.drawable.victus)
            engineering == "Sistemas" && priority == "GPU" && ram == "16GB" && storage == "512 GB" && screen == "1920x1080" ->
                Pair("Lenovo LOQ 9na Gen\ni5-12450hx, RTX 3050, $ram RAM, $storage, pantalla de $screen. tiene un poder mas grande por la memoria ram, ya que es lo mas recomendable actualmente para cualquier cosa, gaming, emulador",
                    R.drawable.lenovoloq9)
            engineering == "Sistemas" && priority == "GPU" && ram == "32GB" && storage == "512 GB" && screen == "1920x1080" ->
                Pair("HP victus\ni5 12450h, RTX 3050, $ram RAM, $storage, pantalla de $screen. tiene el mas grande poder en la memoria ram, aunque este un poco mas limitada por los anteriores componentes tiene la capacidad de abrir varios programas a la vez",
                    R.drawable.victus32gb)
            engineering == "Sistemas" && priority == "GPU" && ram == "8GB" && storage == "1 TB" && screen == "1920x1080" ->
                Pair("HP victus\nRyzen 5, RTX 4060, $ram RAM, $storage, pantalla de $screen. Perfecta para almacenar muchos archivos e instalar bastantes, aunque con un poder recomendable",
                    R.drawable.victus1tbssd)
            engineering == "Sistemas" && priority == "GPU" && ram == "16GB" && storage == "1 TB" && screen == "1920x1080" ->
                Pair("MSI thin a15\nRyzen 7, RTX 4050, $ram RAM, $storage, pantalla de $screen. Perfecta para tener muchos archivos y tener muchas aplicaciones abiertas,con un poder recomendable",
                    R.drawable.msithina15)
            engineering == "Sistemas" && priority == "GPU" && ram == "32GB" && storage == "1 TB" && screen == "1920x1080" ->
                Pair("lenovo LOQ\nRyzen 5, RTX 3050, $ram RAM, $storage, pantalla de $screen. Mucho espacio para todo programas, y bastante memoria RAM para tener varios programas abiertos, super recomendable",
                    R.drawable.lenovoloq32gb1tb)
            engineering == "Sistemas" && priority == "GPU" && ram == "8GB" && storage == "512 GB" && screen == "2560x1440" ->
                Pair("Thunderobot 911x\ni7 13620h, RTX 4060, $ram RAM, $storage, pantalla de $screen. Con una resolucion bastante destacada para poder ver todo de manera mas clara, aunque puede que presente algunos retrasos por el hardware",
                    R.drawable.thunderrobot911)
            engineering == "Sistemas" && priority == "GPU" && ram == "16GB" && storage == "512 GB" && screen == "2560x1440" ->
                Pair("Thunderobot 911x plus\ni7 13620h, RTX 4060, $ram RAM, $storage, pantalla de $screen. Con una resolucion bastante destacada y una gran capacidad de multitarea para muchos programas",
                    R.drawable.thunderrobot911)
            engineering == "Sistemas" && priority == "GPU" && ram == "32GB" && storage == "512 GB" && screen == "2560x1440" ->
                Pair("Thunderobot zero\ni9 13900hx, RTX 4060, $ram RAM, $storage, pantalla de $screen. Capaz de abrir varios programas sin alguna traba, o falta de espacio para abrir programas.",
                    R.drawable.thunderobotzero)
            engineering == "Sistemas" && priority == "GPU" && ram == "8GB" && storage == "1 TB" && screen == "2560x1440" ->
                Pair("Thunderobot R16\ni7 14650 hx, RTX 4060, $ram RAM, $storage, pantalla de $screen. Con mucho almacenamiento para cualquier tipo de programa, o archivos pesado.",
                    R.drawable.thunderobotr16)
            engineering == "Sistemas" && priority == "GPU" && ram == "16GB" && storage == "1 TB" && screen == "2560x1440" ->
                Pair("Thunderobot R16\nRyzen 7, RTX 4060, $ram RAM, $storage, pantalla de $screen. Una laptop calidad precio aunque un poco mas cara, con capacidad de todo",
                    R.drawable.thunderobotr16)
            engineering == "Sistemas" && priority == "GPU" && ram == "32GB" && storage == "1 TB" && screen == "2560x1440" ->
                Pair("Thunderobot zero ultra\ni9 14900hx, RTX 4060, $ram RAM, $storage, pantalla de $screen. Es todo terreno en cualquier aspecto, demasiado buena para ser verdad, pero lo bueno cuesta",
                    R.drawable.thunderobotzeroultra)




            engineering == "Sistemas" && priority == "CG" && ram == "8GB" && storage == "512 GB" && screen == "1920x1080" ->
                Pair("HP Victus 15\nRyzen 5, RX 6550M, $ram RAM, $storage, pantalla de $screen. Incluso teniendo especificaciones bajas, por su rango de precio es bastante buena, o incluso la llamaria la mejor calidad precio, donde nunca se quedara corta",
                    R.drawable.victus)
            engineering == "Sistemas" && priority == "CG" && ram == "16GB" && storage == "512 GB" && screen == "1920x1080" ->
                Pair("Lenovo LOQ 9na Gen\ni5-12450hx, RTX 3050, $ram RAM, $storage, pantalla de $screen. tiene un poder mas grande por la memoria ram, ya que es lo mas recomendable actualmente para cualquier cosa, gaming, emulador",
                    R.drawable.lenovoloq9)
            engineering == "Sistemas" && priority == "CG" && ram == "32GB" && storage == "512 GB" && screen == "1920x1080" ->
                Pair("HP victus\ni5 12450h, RTX 3050, $ram RAM, $storage, pantalla de $screen. tiene el mas grande poder en la memoria ram, aunque este un poco mas limitada por los anteriores componentes tiene la capacidad de abrir varios programas a la vez",
                    R.drawable.victus32gb)
            engineering == "Sistemas" && priority == "CG" && ram == "8GB" && storage == "1 TB" && screen == "1920x1080" ->
                Pair("HP victus\nRyzen 5, RTX 4060, $ram RAM, $storage, pantalla de $screen. Perfecta para almacenar muchos archivos e instalar bastantes, aunque con un poder recomendable",
                    R.drawable.victus1tbssd)
            engineering == "Sistemas" && priority == "CG" && ram == "16GB" && storage == "1 TB" && screen == "1920x1080" ->
                Pair("MSI thin a15\nRyzen 7, RTX 4050, $ram RAM, $storage, pantalla de $screen. Perfecta para tener muchos archivos y tener muchas aplicaciones abiertas,con un poder recomendable",
                    R.drawable.msithina15)
            engineering == "Sistemas" && priority == "CG" && ram == "32GB" && storage == "1 TB" && screen == "1920x1080" ->
                Pair("lenovo LOQ\nRyzen 5, RTX 3050, $ram RAM, $storage, pantalla de $screen. Mucho espacio para todo programas, y bastante memoria RAM para tener varios programas abiertos, super recomendable",
                    R.drawable.lenovoloq32gb1tb)
            engineering == "Sistemas" && priority == "CG" && ram == "8GB" && storage == "512 GB" && screen == "2560x1440" ->
                Pair("Thunderobot 911x\ni7 13620h, RTX 4060, $ram RAM, $storage, pantalla de $screen. Con una resolucion bastante destacada para poder ver todo de manera mas clara, aunque puede que presente algunos retrasos por el hardware",
                    R.drawable.thunderrobot911)
            engineering == "Sistemas" && priority == "CG" && ram == "16GB" && storage == "512 GB" && screen == "2560x1440" ->
                Pair("Thunderobot 911x plus\ni7 13620h, RTX 4060, $ram RAM, $storage, pantalla de $screen. Con una resolucion bastante destacada y una gran capacidad de multitarea para muchos programas",
                    R.drawable.thunderrobot911)
            engineering == "Sistemas" && priority == "CG" && ram == "32GB" && storage == "512 GB" && screen == "2560x1440" ->
                Pair("Thunderobot zero\ni9 13900hx, RTX 4060, $ram RAM, $storage, pantalla de $screen. Capaz de abrir varios programas sin alguna traba, o falta de espacio para abrir programas.",
                    R.drawable.thunderobotzero)
            engineering == "Sistemas" && priority == "CG" && ram == "8GB" && storage == "1 TB" && screen == "2560x1440" ->
                Pair("Thunderobot R16\ni7 14650 hx, RTX 4060, $ram RAM, $storage, pantalla de $screen. Con mucho almacenamiento para cualquier tipo de programa, o archivos pesado.",
                    R.drawable.thunderobotr16)
            engineering == "Sistemas" && priority == "CG" && ram == "16GB" && storage == "1 TB" && screen == "2560x1440" ->
                Pair("Thunderobot R16\nRyzen 7, RTX 4060, $ram RAM, $storage, pantalla de $screen. Una laptop calidad precio aunque un poco mas cara, con capacidad de todo",
                    R.drawable.thunderobotr16)
            engineering == "Sistemas" && priority == "CG" && ram == "32GB" && storage == "1 TB" && screen == "2560x1440" ->
                Pair("Thunderobot zero ultra\ni9 14900hx, RTX 4060, $ram RAM, $storage, pantalla de $screen. Es todo terreno en cualquier aspecto, demasiado buena para ser verdad, pero lo bueno cuesta",
                    R.drawable.thunderobotzeroultra)









            engineering == "Arquitectura" && priority == "CPU" && ram == "8GB" && storage == "512 GB" && screen == "1920x1080" ->
                Pair("HP Victus 15\nRyzen 5, RX 6550M, $ram RAM, $storage, pantalla de $screen. Incluso teniendo especificaciones bajas, por su rango de precio es bastante buena, o incluso la llamaria la mejor calidad precio, donde nunca se quedara corta",
                    R.drawable.victus)
            engineering == "Arquitectura" && priority == "CPU" && ram == "16GB" && storage == "512 GB" && screen == "1920x1080" ->
                Pair("Lenovo LOQ 9na Gen\ni5-12450hx, RTX 3050, $ram RAM, $storage, pantalla de $screen. tiene un poder mas grande por la memoria ram, ya que es lo mas recomendable actualmente para cualquier cosa, gaming, emulador",
                    R.drawable.lenovoloq9)
            engineering == "Arquitectura" && priority == "CPU" && ram == "32GB" && storage == "512 GB" && screen == "1920x1080" ->
                Pair("HP victus\ni5 12450h, RTX 3050, $ram RAM, $storage, pantalla de $screen. tiene el mas grande poder en la memoria ram, aunque este un poco mas limitada por los anteriores componentes tiene la capacidad de abrir varios programas a la vez",
                    R.drawable.victus32gb)
            engineering == "Arquitectura" && priority == "CPU" && ram == "8GB" && storage == "1 TB" && screen == "1920x1080" ->
                Pair("HP victus\nRyzen 5, RTX 4060, $ram RAM, $storage, pantalla de $screen. Perfecta para almacenar muchos archivos e instalar bastantes, aunque con un poder recomendable",
                    R.drawable.victus1tbssd)
            engineering == "Arquitectura" && priority == "CPU" && ram == "16GB" && storage == "1 TB" && screen == "1920x1080" ->
                Pair("MSI thin a15\nRyzen 7, RTX 4050, $ram RAM, $storage, pantalla de $screen. Perfecta para tener muchos archivos y tener muchas aplicaciones abiertas,con un poder recomendable",
                    R.drawable.msithina15)
            engineering == "Arquitectura" && priority == "CPU" && ram == "32GB" && storage == "1 TB" && screen == "1920x1080" ->
                Pair("lenovo LOQ\nRyzen 5, RTX 3050, $ram RAM, $storage, pantalla de $screen. Mucho espacio para todo programas, y bastante memoria RAM para tener varios programas abiertos, super recomendable",
                    R.drawable.lenovoloq32gb1tb)
            engineering == "Arquitectura" && priority == "CPU" && ram == "8GB" && storage == "512 GB" && screen == "2560x1440" ->
                Pair("Thunderobot 911x\ni7 13620h, RTX 4060, $ram RAM, $storage, pantalla de $screen. Con una resolucion bastante destacada para poder ver todo de manera mas clara, aunque puede que presente algunos retrasos por el hardware",
                    R.drawable.thunderrobot911)
            engineering == "Arquitectura" && priority == "CPU" && ram == "16GB" && storage == "512 GB" && screen == "2560x1440" ->
                Pair("Thunderobot 911x plus\ni7 13620h, RTX 4060, $ram RAM, $storage, pantalla de $screen. Con una resolucion bastante destacada y una gran capacidad de multitarea para muchos programas",
                    R.drawable.thunderrobot911)
            engineering == "Arquitectura" && priority == "CPU" && ram == "32GB" && storage == "512 GB" && screen == "2560x1440" ->
                Pair("Thunderobot zero\ni9 13900hx, RTX 4060, $ram RAM, $storage, pantalla de $screen. Capaz de abrir varios programas sin alguna traba, o falta de espacio para abrir programas.",
                    R.drawable.thunderobotzero)
            engineering == "Arquitectura" && priority == "CPU" && ram == "8GB" && storage == "1 TB" && screen == "2560x1440" ->
                Pair("Thunderobot R16\ni7 14650 hx, RTX 4060, $ram RAM, $storage, pantalla de $screen. Con mucho almacenamiento para cualquier tipo de programa, o archivos pesado.",
                    R.drawable.thunderobotr16)
            engineering == "Arquitectura" && priority == "CPU" && ram == "16GB" && storage == "1 TB" && screen == "2560x1440" ->
                Pair("Thunderobot R16\nRyzen 7, RTX 4060, $ram RAM, $storage, pantalla de $screen. Una laptop calidad precio aunque un poco mas cara, con capacidad de todo",
                    R.drawable.thunderobotr16)
            engineering == "Arquitectura" && priority == "CPU" && ram == "32GB" && storage == "1 TB" && screen == "2560x1440" ->
                Pair("Thunderobot zero ultra\ni9 14900hx, RTX 4060, $ram RAM, $storage, pantalla de $screen. Es todo terreno en cualquier aspecto, demasiado buena para ser verdad, pero lo bueno cuesta",
                    R.drawable.thunderobotzeroultra)




            engineering == "Arquitectura" && priority == "GPU" && ram == "8GB" && storage == "512 GB" && screen == "1920x1080" ->
                Pair("HP Victus 15\nRyzen 5, RX 6550M, $ram RAM, $storage, pantalla de $screen. Incluso teniendo especificaciones bajas, por su rango de precio es bastante buena, o incluso la llamaria la mejor calidad precio, donde nunca se quedara corta",
                    R.drawable.victus)
            engineering == "Arquitectura" && priority == "GPU" && ram == "16GB" && storage == "512 GB" && screen == "1920x1080" ->
                Pair("Lenovo LOQ 9na Gen\ni5-12450hx, RTX 3050, $ram RAM, $storage, pantalla de $screen. tiene un poder mas grande por la memoria ram, ya que es lo mas recomendable actualmente para cualquier cosa, gaming, emulador",
                    R.drawable.lenovoloq9)
            engineering == "Arquitectura" && priority == "GPU" && ram == "32GB" && storage == "512 GB" && screen == "1920x1080" ->
                Pair("HP victus\ni5 12450h, RTX 3050, $ram RAM, $storage, pantalla de $screen. tiene el mas grande poder en la memoria ram, aunque este un poco mas limitada por los anteriores componentes tiene la capacidad de abrir varios programas a la vez",
                    R.drawable.victus32gb)
            engineering == "Arquitectura" && priority == "GPU" && ram == "8GB" && storage == "1 TB" && screen == "1920x1080" ->
                Pair("HP victus\nRyzen 5, RTX 4060, $ram RAM, $storage, pantalla de $screen. Perfecta para almacenar muchos archivos e instalar bastantes, aunque con un poder recomendable",
                    R.drawable.victus1tbssd)
            engineering == "Arquitectura" && priority == "GPU" && ram == "16GB" && storage == "1 TB" && screen == "1920x1080" ->
                Pair("MSI thin a15\nRyzen 7, RTX 4050, $ram RAM, $storage, pantalla de $screen. Perfecta para tener muchos archivos y tener muchas aplicaciones abiertas,con un poder recomendable",
                    R.drawable.msithina15)
            engineering == "Arquitectura" && priority == "GPU" && ram == "32GB" && storage == "1 TB" && screen == "1920x1080" ->
                Pair("lenovo LOQ\nRyzen 5, RTX 3050, $ram RAM, $storage, pantalla de $screen. Mucho espacio para todo programas, y bastante memoria RAM para tener varios programas abiertos, super recomendable",
                    R.drawable.lenovoloq32gb1tb)
            engineering == "Arquitectura" && priority == "GPU" && ram == "8GB" && storage == "512 GB" && screen == "2560x1440" ->
                Pair("Thunderobot 911x\ni7 13620h, RTX 4060, $ram RAM, $storage, pantalla de $screen. Con una resolucion bastante destacada para poder ver todo de manera mas clara, aunque puede que presente algunos retrasos por el hardware",
                    R.drawable.thunderrobot911)
            engineering == "Arquitectura" && priority == "GPU" && ram == "16GB" && storage == "512 GB" && screen == "2560x1440" ->
                Pair("Thunderobot 911x plus\ni7 13620h, RTX 4060, $ram RAM, $storage, pantalla de $screen. Con una resolucion bastante destacada y una gran capacidad de multitarea para muchos programas",
                    R.drawable.thunderrobot911)
            engineering == "Arquitectura" && priority == "GPU" && ram == "32GB" && storage == "512 GB" && screen == "2560x1440" ->
                Pair("Thunderobot zero\ni9 13900hx, RTX 4060, $ram RAM, $storage, pantalla de $screen. Capaz de abrir varios programas sin alguna traba, o falta de espacio para abrir programas.",
                    R.drawable.thunderobotzero)
            engineering == "Arquitectura" && priority == "GPU" && ram == "8GB" && storage == "1 TB" && screen == "2560x1440" ->
                Pair("Thunderobot R16\ni7 14650 hx, RTX 4060, $ram RAM, $storage, pantalla de $screen. Con mucho almacenamiento para cualquier tipo de programa, o archivos pesado.",
                    R.drawable.thunderobotr16)
            engineering == "Arquitectura" && priority == "GPU" && ram == "16GB" && storage == "1 TB" && screen == "2560x1440" ->
                Pair("Thunderobot R16\nRyzen 7, RTX 4060, $ram RAM, $storage, pantalla de $screen. Una laptop calidad precio aunque un poco mas cara, con capacidad de todo",
                    R.drawable.thunderobotr16)
            engineering == "Arquitectura" && priority == "GPU" && ram == "32GB" && storage == "1 TB" && screen == "2560x1440" ->
                Pair("Thunderobot zero ultra\ni9 14900hx, RTX 4060, $ram RAM, $storage, pantalla de $screen. Es todo terreno en cualquier aspecto, demasiado buena para ser verdad, pero lo bueno cuesta",
                    R.drawable.thunderobotzeroultra)




            engineering == "Arquitectura" && priority == "CG" && ram == "8GB" && storage == "512 GB" && screen == "1920x1080" ->
                Pair("HP Victus 15\nRyzen 5, RX 6550M, $ram RAM, $storage, pantalla de $screen. Incluso teniendo especificaciones bajas, por su rango de precio es bastante buena, o incluso la llamaria la mejor calidad precio, donde nunca se quedara corta",
                    R.drawable.victus)
            engineering == "Arquitectura" && priority == "CG" && ram == "16GB" && storage == "512 GB" && screen == "1920x1080" ->
                Pair("Lenovo LOQ 9na Gen\ni5-12450hx, RTX 3050, $ram RAM, $storage, pantalla de $screen. tiene un poder mas grande por la memoria ram, ya que es lo mas recomendable actualmente para cualquier cosa, gaming, emulador",
                    R.drawable.lenovoloq9)
            engineering == "Arquitectura" && priority == "CG" && ram == "32GB" && storage == "512 GB" && screen == "1920x1080" ->
                Pair("HP victus\ni5 12450h, RTX 3050, $ram RAM, $storage, pantalla de $screen. tiene el mas grande poder en la memoria ram, aunque este un poco mas limitada por los anteriores componentes tiene la capacidad de abrir varios programas a la vez",
                    R.drawable.victus32gb)
            engineering == "Arquitectura" && priority == "CG" && ram == "8GB" && storage == "1 TB" && screen == "1920x1080" ->
                Pair("HP victus\nRyzen 5, RTX 4060, $ram RAM, $storage, pantalla de $screen. Perfecta para almacenar muchos archivos e instalar bastantes, aunque con un poder recomendable",
                    R.drawable.victus1tbssd)
            engineering == "Arquitectura" && priority == "CG" && ram == "16GB" && storage == "1 TB" && screen == "1920x1080" ->
                Pair("MSI thin a15\nRyzen 7, RTX 4050, $ram RAM, $storage, pantalla de $screen. Perfecta para tener muchos archivos y tener muchas aplicaciones abiertas,con un poder recomendable",
                    R.drawable.msithina15)
            engineering == "Arquitectura" && priority == "CG" && ram == "32GB" && storage == "1 TB" && screen == "1920x1080" ->
                Pair("lenovo LOQ\nRyzen 5, RTX 3050, $ram RAM, $storage, pantalla de $screen. Mucho espacio para todo programas, y bastante memoria RAM para tener varios programas abiertos, super recomendable",
                    R.drawable.lenovoloq32gb1tb)
            engineering == "Arquitectura" && priority == "CG" && ram == "8GB" && storage == "512 GB" && screen == "2560x1440" ->
                Pair("Thunderobot 911x\ni7 13620h, RTX 4060, $ram RAM, $storage, pantalla de $screen. Con una resolucion bastante destacada para poder ver todo de manera mas clara, aunque puede que presente algunos retrasos por el hardware",
                    R.drawable.thunderrobot911)
            engineering == "Arquitectura" && priority == "CG" && ram == "16GB" && storage == "512 GB" && screen == "2560x1440" ->
                Pair("Thunderobot 911x plus\ni7 13620h, RTX 4060, $ram RAM, $storage, pantalla de $screen. Con una resolucion bastante destacada y una gran capacidad de multitarea para muchos programas",
                    R.drawable.thunderrobot911)
            engineering == "Arquitectura" && priority == "CG" && ram == "32GB" && storage == "512 GB" && screen == "2560x1440" ->
                Pair("Thunderobot zero\ni9 13900hx, RTX 4060, $ram RAM, $storage, pantalla de $screen. Capaz de abrir varios programas sin alguna traba, o falta de espacio para abrir programas.",
                    R.drawable.thunderobotzero)
            engineering == "Arquitectura" && priority == "CG" && ram == "8GB" && storage == "1 TB" && screen == "2560x1440" ->
                Pair("Thunderobot R16\ni7 14650 hx, RTX 4060, $ram RAM, $storage, pantalla de $screen. Con mucho almacenamiento para cualquier tipo de programa, o archivos pesado.",
                    R.drawable.thunderobotr16)
            engineering == "Arquitectura" && priority == "CG" && ram == "16GB" && storage == "1 TB" && screen == "2560x1440" ->
                Pair("Thunderobot R16\nRyzen 7, RTX 4060, $ram RAM, $storage, pantalla de $screen. Una laptop calidad precio aunque un poco mas cara, con capacidad de todo",
                    R.drawable.thunderobotr16)
            engineering == "Arquitectura" && priority == "CG" && ram == "32GB" && storage == "1 TB" && screen == "2560x1440" ->
                Pair("Thunderobot zero ultra\ni9 14900hx, RTX 4060, $ram RAM, $storage, pantalla de $screen. Es todo terreno en cualquier aspecto, demasiado buena para ser verdad, pero lo bueno cuesta",
                    R.drawable.thunderobotzeroultra)










            engineering == "Mecatronica" && priority == "CPU" && ram == "8GB" && storage == "512 GB" && screen == "1920x1080" ->
                Pair("HP Victus 15\nRyzen 5, RX 6550M, $ram RAM, $storage, pantalla de $screen. Incluso teniendo especificaciones bajas, por su rango de precio es bastante buena, o incluso la llamaria la mejor calidad precio, donde nunca se quedara corta",
                    R.drawable.victus)
            engineering == "Mecatronica" && priority == "CPU" && ram == "16GB" && storage == "512 GB" && screen == "1920x1080" ->
                Pair("Lenovo LOQ 9na Gen\ni5-12450hx, RTX 3050, $ram RAM, $storage, pantalla de $screen. tiene un poder mas grande por la memoria ram, ya que es lo mas recomendable actualmente para cualquier cosa, gaming, emulador",
                    R.drawable.lenovoloq9)
            engineering == "Mecatronica" && priority == "CPU" && ram == "32GB" && storage == "512 GB" && screen == "1920x1080" ->
                Pair("HP victus\ni5 12450h, RTX 3050, $ram RAM, $storage, pantalla de $screen. tiene el mas grande poder en la memoria ram, aunque este un poco mas limitada por los anteriores componentes tiene la capacidad de abrir varios programas a la vez",
                    R.drawable.victus32gb)
            engineering == "Mecatronica" && priority == "CPU" && ram == "8GB" && storage == "1 TB" && screen == "1920x1080" ->
                Pair("HP victus\nRyzen 5, RTX 4060, $ram RAM, $storage, pantalla de $screen. Perfecta para almacenar muchos archivos e instalar bastantes, aunque con un poder recomendable",
                    R.drawable.victus1tbssd)
            engineering == "Mecatronica" && priority == "CPU" && ram == "16GB" && storage == "1 TB" && screen == "1920x1080" ->
                Pair("MSI thin a15\nRyzen 7, RTX 4050, $ram RAM, $storage, pantalla de $screen. Perfecta para tener muchos archivos y tener muchas aplicaciones abiertas,con un poder recomendable",
                    R.drawable.msithina15)
            engineering == "Mecatronica" && priority == "CPU" && ram == "32GB" && storage == "1 TB" && screen == "1920x1080" ->
                Pair("lenovo LOQ\nRyzen 5, RTX 3050, $ram RAM, $storage, pantalla de $screen. Mucho espacio para todo programas, y bastante memoria RAM para tener varios programas abiertos, super recomendable",
                    R.drawable.lenovoloq32gb1tb)
            engineering == "Mecatronica" && priority == "CPU" && ram == "8GB" && storage == "512 GB" && screen == "2560x1440" ->
                Pair("Thunderobot 911x\ni7 13620h, RTX 4060, $ram RAM, $storage, pantalla de $screen. Con una resolucion bastante destacada para poder ver todo de manera mas clara, aunque puede que presente algunos retrasos por el hardware",
                    R.drawable.thunderrobot911)
            engineering == "Mecatronica" && priority == "CPU" && ram == "16GB" && storage == "512 GB" && screen == "2560x1440" ->
                Pair("Thunderobot 911x plus\ni7 13620h, RTX 4060, $ram RAM, $storage, pantalla de $screen. Con una resolucion bastante destacada y una gran capacidad de multitarea para muchos programas",
                    R.drawable.thunderrobot911)
            engineering == "Mecatronica" && priority == "CPU" && ram == "32GB" && storage == "512 GB" && screen == "2560x1440" ->
                Pair("Thunderobot zero\ni9 13900hx, RTX 4060, $ram RAM, $storage, pantalla de $screen. Capaz de abrir varios programas sin alguna traba, o falta de espacio para abrir programas.",
                    R.drawable.thunderobotzero)
            engineering == "Mecatronica" && priority == "CPU" && ram == "8GB" && storage == "1 TB" && screen == "2560x1440" ->
                Pair("Thunderobot R16\ni7 14650 hx, RTX 4060, $ram RAM, $storage, pantalla de $screen. Con mucho almacenamiento para cualquier tipo de programa, o archivos pesado.",
                    R.drawable.thunderobotr16)
            engineering == "Mecatronica" && priority == "CPU" && ram == "16GB" && storage == "1 TB" && screen == "2560x1440" ->
                Pair("Thunderobot R16\nRyzen 7, RTX 4060, $ram RAM, $storage, pantalla de $screen. Una laptop calidad precio aunque un poco mas cara, con capacidad de todo",
                    R.drawable.thunderobotr16)
            engineering == "Mecatronica" && priority == "CPU" && ram == "32GB" && storage == "1 TB" && screen == "2560x1440" ->
                Pair("Thunderobot zero ultra\ni9 14900hx, RTX 4060, $ram RAM, $storage, pantalla de $screen. Es todo terreno en cualquier aspecto, demasiado buena para ser verdad, pero lo bueno cuesta",
                    R.drawable.thunderobotzeroultra)




            engineering == "Mecatronica" && priority == "GPU" && ram == "8GB" && storage == "512 GB" && screen == "1920x1080" ->
                Pair("HP Victus 15\nRyzen 5, RX 6550M, $ram RAM, $storage, pantalla de $screen. Incluso teniendo especificaciones bajas, por su rango de precio es bastante buena, o incluso la llamaria la mejor calidad precio, donde nunca se quedara corta",
                    R.drawable.victus)
            engineering == "Mecatronica" && priority == "GPU" && ram == "16GB" && storage == "512 GB" && screen == "1920x1080" ->
                Pair("Lenovo LOQ 9na Gen\ni5-12450hx, RTX 3050, $ram RAM, $storage, pantalla de $screen. tiene un poder mas grande por la memoria ram, ya que es lo mas recomendable actualmente para cualquier cosa, gaming, emulador",
                    R.drawable.lenovoloq9)
            engineering == "Mecatronica" && priority == "GPU" && ram == "32GB" && storage == "512 GB" && screen == "1920x1080" ->
                Pair("HP victus\ni5 12450h, RTX 3050, $ram RAM, $storage, pantalla de $screen. tiene el mas grande poder en la memoria ram, aunque este un poco mas limitada por los anteriores componentes tiene la capacidad de abrir varios programas a la vez",
                    R.drawable.victus32gb)
            engineering == "Mecatronica" && priority == "GPU" && ram == "8GB" && storage == "1 TB" && screen == "1920x1080" ->
                Pair("HP victus\nRyzen 5, RTX 4060, $ram RAM, $storage, pantalla de $screen. Perfecta para almacenar muchos archivos e instalar bastantes, aunque con un poder recomendable",
                    R.drawable.victus1tbssd)
            engineering == "Mecatronica" && priority == "GPU" && ram == "16GB" && storage == "1 TB" && screen == "1920x1080" ->
                Pair("MSI thin a15\nRyzen 7, RTX 4050, $ram RAM, $storage, pantalla de $screen. Perfecta para tener muchos archivos y tener muchas aplicaciones abiertas,con un poder recomendable",
                    R.drawable.msithina15)
            engineering == "Mecatronica" && priority == "GPU" && ram == "32GB" && storage == "1 TB" && screen == "1920x1080" ->
                Pair("lenovo LOQ\nRyzen 5, RTX 3050, $ram RAM, $storage, pantalla de $screen. Mucho espacio para todo programas, y bastante memoria RAM para tener varios programas abiertos, super recomendable",
                    R.drawable.lenovoloq32gb1tb)
            engineering == "Mecatronica" && priority == "GPU" && ram == "8GB" && storage == "512 GB" && screen == "2560x1440" ->
                Pair("Thunderobot 911x\ni7 13620h, RTX 4060, $ram RAM, $storage, pantalla de $screen. Con una resolucion bastante destacada para poder ver todo de manera mas clara, aunque puede que presente algunos retrasos por el hardware",
                    R.drawable.thunderrobot911)
            engineering == "Mecatronica" && priority == "GPU" && ram == "16GB" && storage == "512 GB" && screen == "2560x1440" ->
                Pair("Thunderobot 911x plus\ni7 13620h, RTX 4060, $ram RAM, $storage, pantalla de $screen. Con una resolucion bastante destacada y una gran capacidad de multitarea para muchos programas",
                    R.drawable.thunderrobot911)
            engineering == "Mecatronica" && priority == "GPU" && ram == "32GB" && storage == "512 GB" && screen == "2560x1440" ->
                Pair("Thunderobot zero\ni9 13900hx, RTX 4060, $ram RAM, $storage, pantalla de $screen. Capaz de abrir varios programas sin alguna traba, o falta de espacio para abrir programas.",
                    R.drawable.thunderobotzero)
            engineering == "Mecatronica" && priority == "GPU" && ram == "8GB" && storage == "1 TB" && screen == "2560x1440" ->
                Pair("Thunderobot R16\ni7 14650 hx, RTX 4060, $ram RAM, $storage, pantalla de $screen. Con mucho almacenamiento para cualquier tipo de programa, o archivos pesado.",
                    R.drawable.thunderobotr16)
            engineering == "Mecatronica" && priority == "GPU" && ram == "16GB" && storage == "1 TB" && screen == "2560x1440" ->
                Pair("Thunderobot R16\nRyzen 7, RTX 4060, $ram RAM, $storage, pantalla de $screen. Una laptop calidad precio aunque un poco mas cara, con capacidad de todo",
                    R.drawable.thunderobotr16)
            engineering == "Mecatronica" && priority == "GPU" && ram == "32GB" && storage == "1 TB" && screen == "2560x1440" ->
                Pair("Thunderobot zero ultra\ni9 14900hx, RTX 4060, $ram RAM, $storage, pantalla de $screen. Es todo terreno en cualquier aspecto, demasiado buena para ser verdad, pero lo bueno cuesta",
                    R.drawable.thunderobotzeroultra)




            engineering == "Mecatronica" && priority == "CG" && ram == "8GB" && storage == "512 GB" && screen == "1920x1080" ->
                Pair("HP Victus 15\nRyzen 5, RX 6550M, $ram RAM, $storage, pantalla de $screen. Incluso teniendo especificaciones bajas, por su rango de precio es bastante buena, o incluso la llamaria la mejor calidad precio, donde nunca se quedara corta",
                    R.drawable.victus)
            engineering == "Mecatronica" && priority == "CG" && ram == "16GB" && storage == "512 GB" && screen == "1920x1080" ->
                Pair("Lenovo LOQ 9na Gen\ni5-12450hx, RTX 3050, $ram RAM, $storage, pantalla de $screen. tiene un poder mas grande por la memoria ram, ya que es lo mas recomendable actualmente para cualquier cosa, gaming, emulador",
                    R.drawable.lenovoloq9)
            engineering == "Mecatronica" && priority == "CG" && ram == "32GB" && storage == "512 GB" && screen == "1920x1080" ->
                Pair("HP victus\ni5 12450h, RTX 3050, $ram RAM, $storage, pantalla de $screen. tiene el mas grande poder en la memoria ram, aunque este un poco mas limitada por los anteriores componentes tiene la capacidad de abrir varios programas a la vez",
                    R.drawable.victus32gb)
            engineering == "Mecatronica" && priority == "CG" && ram == "8GB" && storage == "1 TB" && screen == "1920x1080" ->
                Pair("HP victus\nRyzen 5, RTX 4060, $ram RAM, $storage, pantalla de $screen. Perfecta para almacenar muchos archivos e instalar bastantes, aunque con un poder recomendable",
                    R.drawable.victus1tbssd)
            engineering == "Mecatronica" && priority == "CG" && ram == "16GB" && storage == "1 TB" && screen == "1920x1080" ->
                Pair("MSI thin a15\nRyzen 7, RTX 4050, $ram RAM, $storage, pantalla de $screen. Perfecta para tener muchos archivos y tener muchas aplicaciones abiertas,con un poder recomendable",
                    R.drawable.msithina15)
            engineering == "Mecatronica" && priority == "CG" && ram == "32GB" && storage == "1 TB" && screen == "1920x1080" ->
                Pair("lenovo LOQ\nRyzen 5, RTX 3050, $ram RAM, $storage, pantalla de $screen. Mucho espacio para todo programas, y bastante memoria RAM para tener varios programas abiertos, super recomendable",
                    R.drawable.lenovoloq32gb1tb)
            engineering == "Mecatronica" && priority == "CG" && ram == "8GB" && storage == "512 GB" && screen == "2560x1440" ->
                Pair("Thunderobot 911x\ni7 13620h, RTX 4060, $ram RAM, $storage, pantalla de $screen. Con una resolucion bastante destacada para poder ver todo de manera mas clara, aunque puede que presente algunos retrasos por el hardware",
                    R.drawable.thunderrobot911)
            engineering == "Mecatronica" && priority == "CG" && ram == "16GB" && storage == "512 GB" && screen == "2560x1440" ->
                Pair("Thunderobot 911x plus\ni7 13620h, RTX 4060, $ram RAM, $storage, pantalla de $screen. Con una resolucion bastante destacada y una gran capacidad de multitarea para muchos programas",
                    R.drawable.thunderrobot911)
            engineering == "Mecatronica" && priority == "CG" && ram == "32GB" && storage == "512 GB" && screen == "2560x1440" ->
                Pair("Thunderobot zero\ni9 13900hx, RTX 4060, $ram RAM, $storage, pantalla de $screen. Capaz de abrir varios programas sin alguna traba, o falta de espacio para abrir programas.",
                    R.drawable.thunderobotzero)
            engineering == "Mecatronica" && priority == "CG" && ram == "8GB" && storage == "1 TB" && screen == "2560x1440" ->
                Pair("Thunderobot R16\ni7 14650 hx, RTX 4060, $ram RAM, $storage, pantalla de $screen. Con mucho almacenamiento para cualquier tipo de programa, o archivos pesado.",
                    R.drawable.thunderobotr16)
            engineering == "Mecatronica" && priority == "CG" && ram == "16GB" && storage == "1 TB" && screen == "2560x1440" ->
                Pair("Thunderobot R16\nRyzen 7, RTX 4060, $ram RAM, $storage, pantalla de $screen. Una laptop calidad precio aunque un poco mas cara, con capacidad de todo",
                    R.drawable.thunderobotr16)
            engineering == "Mecatronica" && priority == "CG" && ram == "32GB" && storage == "1 TB" && screen == "2560x1440" ->
                Pair("Thunderobot zero ultra\ni9 14900hx, RTX 4060, $ram RAM, $storage, pantalla de $screen. Es todo terreno en cualquier aspecto, demasiado buena para ser verdad, pero lo bueno cuesta",
                    R.drawable.thunderobotzeroultra)










            engineering == "Animacion" && priority == "CPU" && ram == "8GB" && storage == "512 GB" && screen == "1920x1080" ->
                Pair("HP Victus 15\nRyzen 5, RX 6550M, $ram RAM, $storage, pantalla de $screen. Incluso teniendo especificaciones bajas, por su rango de precio es bastante buena, o incluso la llamaria la mejor calidad precio, donde nunca se quedara corta",
                    R.drawable.victus)
            engineering == "Animacion" && priority == "CPU" && ram == "16GB" && storage == "512 GB" && screen == "1920x1080" ->
                Pair("Lenovo LOQ 9na Gen\ni5-12450hx, RTX 3050, $ram RAM, $storage, pantalla de $screen. tiene un poder mas grande por la memoria ram, ya que es lo mas recomendable actualmente para cualquier cosa, gaming, emulador",
                    R.drawable.lenovoloq9)
            engineering == "Animacion" && priority == "CPU" && ram == "32GB" && storage == "512 GB" && screen == "1920x1080" ->
                Pair("HP victus\ni5 12450h, RTX 3050, $ram RAM, $storage, pantalla de $screen. tiene el mas grande poder en la memoria ram, aunque este un poco mas limitada por los anteriores componentes tiene la capacidad de abrir varios programas a la vez",
                    R.drawable.victus32gb)
            engineering == "Animacion" && priority == "CPU" && ram == "8GB" && storage == "1 TB" && screen == "1920x1080" ->
                Pair("HP victus\nRyzen 5, RTX 4060, $ram RAM, $storage, pantalla de $screen. Perfecta para almacenar muchos archivos e instalar bastantes, aunque con un poder recomendable",
                    R.drawable.victus1tbssd)
            engineering == "Animacion" && priority == "CPU" && ram == "16GB" && storage == "1 TB" && screen == "1920x1080" ->
                Pair("MSI thin a15\nRyzen 7, RTX 4050, $ram RAM, $storage, pantalla de $screen. Perfecta para tener muchos archivos y tener muchas aplicaciones abiertas,con un poder recomendable",
                    R.drawable.msithina15)
            engineering == "Animacion" && priority == "CPU" && ram == "32GB" && storage == "1 TB" && screen == "1920x1080" ->
                Pair("lenovo LOQ\nRyzen 5, RTX 3050, $ram RAM, $storage, pantalla de $screen. Mucho espacio para todo programas, y bastante memoria RAM para tener varios programas abiertos, super recomendable",
                    R.drawable.lenovoloq32gb1tb)
            engineering == "Animacion" && priority == "CPU" && ram == "8GB" && storage == "512 GB" && screen == "2560x1440" ->
                Pair("Thunderobot 911x\ni7 13620h, RTX 4060, $ram RAM, $storage, pantalla de $screen. Con una resolucion bastante destacada para poder ver todo de manera mas clara, aunque puede que presente algunos retrasos por el hardware",
                    R.drawable.thunderrobot911)
            engineering == "Animacion" && priority == "CPU" && ram == "16GB" && storage == "512 GB" && screen == "2560x1440" ->
                Pair("Thunderobot 911x plus\ni7 13620h, RTX 4060, $ram RAM, $storage, pantalla de $screen. Con una resolucion bastante destacada y una gran capacidad de multitarea para muchos programas",
                    R.drawable.thunderrobot911)
            engineering == "Animacion" && priority == "CPU" && ram == "32GB" && storage == "512 GB" && screen == "2560x1440" ->
                Pair("Thunderobot zero\ni9 13900hx, RTX 4060, $ram RAM, $storage, pantalla de $screen. Capaz de abrir varios programas sin alguna traba, o falta de espacio para abrir programas.",
                    R.drawable.thunderobotzero)
            engineering == "Animacion" && priority == "CPU" && ram == "8GB" && storage == "1 TB" && screen == "2560x1440" ->
                Pair("Thunderobot R16\ni7 14650 hx, RTX 4060, $ram RAM, $storage, pantalla de $screen. Con mucho almacenamiento para cualquier tipo de programa, o archivos pesado.",
                    R.drawable.thunderobotr16)
            engineering == "Animacion" && priority == "CPU" && ram == "16GB" && storage == "1 TB" && screen == "2560x1440" ->
                Pair("Thunderobot R16\nRyzen 7, RTX 4060, $ram RAM, $storage, pantalla de $screen. Una laptop calidad precio aunque un poco mas cara, con capacidad de todo",
                    R.drawable.thunderobotr16)
            engineering == "Animacion" && priority == "CPU" && ram == "32GB" && storage == "1 TB" && screen == "2560x1440" ->
                Pair("Thunderobot zero ultra\ni9 14900hx, RTX 4060, $ram RAM, $storage, pantalla de $screen. Es todo terreno en cualquier aspecto, demasiado buena para ser verdad, pero lo bueno cuesta",
                    R.drawable.thunderobotzeroultra)




            engineering == "Animacion" && priority == "GPU" && ram == "8GB" && storage == "512 GB" && screen == "1920x1080" ->
                Pair("HP Victus 15\nRyzen 5, RX 6550M, $ram RAM, $storage, pantalla de $screen. Incluso teniendo especificaciones bajas, por su rango de precio es bastante buena, o incluso la llamaria la mejor calidad precio, donde nunca se quedara corta",
                    R.drawable.victus)
            engineering == "Animacion" && priority == "GPU" && ram == "16GB" && storage == "512 GB" && screen == "1920x1080" ->
                Pair("Lenovo LOQ 9na Gen\ni5-12450hx, RTX 3050, $ram RAM, $storage, pantalla de $screen. tiene un poder mas grande por la memoria ram, ya que es lo mas recomendable actualmente para cualquier cosa, gaming, emulador",
                    R.drawable.lenovoloq9)
            engineering == "Animacion" && priority == "GPU" && ram == "32GB" && storage == "512 GB" && screen == "1920x1080" ->
                Pair("HP victus\ni5 12450h, RTX 3050, $ram RAM, $storage, pantalla de $screen. tiene el mas grande poder en la memoria ram, aunque este un poco mas limitada por los anteriores componentes tiene la capacidad de abrir varios programas a la vez",
                    R.drawable.victus32gb)
            engineering == "Animacion" && priority == "GPU" && ram == "8GB" && storage == "1 TB" && screen == "1920x1080" ->
                Pair("HP victus\nRyzen 5, RTX 4060, $ram RAM, $storage, pantalla de $screen. Perfecta para almacenar muchos archivos e instalar bastantes, aunque con un poder recomendable",
                    R.drawable.victus1tbssd)
            engineering == "Animacion" && priority == "GPU" && ram == "16GB" && storage == "1 TB" && screen == "1920x1080" ->
                Pair("MSI thin a15\nRyzen 7, RTX 4050, $ram RAM, $storage, pantalla de $screen. Perfecta para tener muchos archivos y tener muchas aplicaciones abiertas,con un poder recomendable",
                    R.drawable.msithina15)
            engineering == "Animacion" && priority == "GPU" && ram == "32GB" && storage == "1 TB" && screen == "1920x1080" ->
                Pair("lenovo LOQ\nRyzen 5, RTX 3050, $ram RAM, $storage, pantalla de $screen. Mucho espacio para todo programas, y bastante memoria RAM para tener varios programas abiertos, super recomendable",
                    R.drawable.lenovoloq32gb1tb)
            engineering == "Animacion" && priority == "GPU" && ram == "8GB" && storage == "512 GB" && screen == "2560x1440" ->
                Pair("Thunderobot 911x\ni7 13620h, RTX 4060, $ram RAM, $storage, pantalla de $screen. Con una resolucion bastante destacada para poder ver todo de manera mas clara, aunque puede que presente algunos retrasos por el hardware",
                    R.drawable.thunderrobot911)
            engineering == "Animacion" && priority == "GPU" && ram == "16GB" && storage == "512 GB" && screen == "2560x1440" ->
                Pair("Thunderobot 911x plus\ni7 13620h, RTX 4060, $ram RAM, $storage, pantalla de $screen. Con una resolucion bastante destacada y una gran capacidad de multitarea para muchos programas",
                    R.drawable.thunderrobot911)
            engineering == "Animacion" && priority == "GPU" && ram == "32GB" && storage == "512 GB" && screen == "2560x1440" ->
                Pair("Thunderobot zero\ni9 13900hx, RTX 4060, $ram RAM, $storage, pantalla de $screen. Capaz de abrir varios programas sin alguna traba, o falta de espacio para abrir programas.",
                    R.drawable.thunderobotzero)
            engineering == "Animacion" && priority == "GPU" && ram == "8GB" && storage == "1 TB" && screen == "2560x1440" ->
                Pair("Thunderobot R16\ni7 14650 hx, RTX 4060, $ram RAM, $storage, pantalla de $screen. Con mucho almacenamiento para cualquier tipo de programa, o archivos pesado.",
                    R.drawable.thunderobotr16)
            engineering == "Animacion" && priority == "GPU" && ram == "16GB" && storage == "1 TB" && screen == "2560x1440" ->
                Pair("Thunderobot R16\nRyzen 7, RTX 4060, $ram RAM, $storage, pantalla de $screen. Una laptop calidad precio aunque un poco mas cara, con capacidad de todo",
                    R.drawable.thunderobotr16)
            engineering == "Animacion" && priority == "GPU" && ram == "32GB" && storage == "1 TB" && screen == "2560x1440" ->
                Pair("Thunderobot zero ultra\ni9 14900hx, RTX 4060, $ram RAM, $storage, pantalla de $screen. Es todo terreno en cualquier aspecto, demasiado buena para ser verdad, pero lo bueno cuesta",
                    R.drawable.thunderobotzeroultra)




            engineering == "Animacion" && priority == "CG" && ram == "8GB" && storage == "512 GB" && screen == "1920x1080" ->
                Pair("HP Victus 15\nRyzen 5, RX 6550M, $ram RAM, $storage, pantalla de $screen. Incluso teniendo especificaciones bajas, por su rango de precio es bastante buena, o incluso la llamaria la mejor calidad precio, donde nunca se quedara corta",
                    R.drawable.victus)
            engineering == "Animacion" && priority == "CG" && ram == "16GB" && storage == "512 GB" && screen == "1920x1080" ->
                Pair("Lenovo LOQ 9na Gen\ni5-12450hx, RTX 3050, $ram RAM, $storage, pantalla de $screen. tiene un poder mas grande por la memoria ram, ya que es lo mas recomendable actualmente para cualquier cosa, gaming, emulador",
                    R.drawable.lenovoloq9)
            engineering == "Animacion" && priority == "CG" && ram == "32GB" && storage == "512 GB" && screen == "1920x1080" ->
                Pair("HP victus\ni5 12450h, RTX 3050, $ram RAM, $storage, pantalla de $screen. tiene el mas grande poder en la memoria ram, aunque este un poco mas limitada por los anteriores componentes tiene la capacidad de abrir varios programas a la vez",
                    R.drawable.victus32gb)
            engineering == "Animacion" && priority == "CG" && ram == "8GB" && storage == "1 TB" && screen == "1920x1080" ->
                Pair("HP victus\nRyzen 5, RTX 4060, $ram RAM, $storage, pantalla de $screen. Perfecta para almacenar muchos archivos e instalar bastantes, aunque con un poder recomendable",
                    R.drawable.victus1tbssd)
            engineering == "Animacion" && priority == "CG" && ram == "16GB" && storage == "1 TB" && screen == "1920x1080" ->
                Pair("MSI thin a15\nRyzen 7, RTX 4050, $ram RAM, $storage, pantalla de $screen. Perfecta para tener muchos archivos y tener muchas aplicaciones abiertas,con un poder recomendable",
                    R.drawable.msithina15)
            engineering == "Animacion" && priority == "CG" && ram == "32GB" && storage == "1 TB" && screen == "1920x1080" ->
                Pair("lenovo LOQ\nRyzen 5, RTX 3050, $ram RAM, $storage, pantalla de $screen. Mucho espacio para todo programas, y bastante memoria RAM para tener varios programas abiertos, super recomendable",
                    R.drawable.lenovoloq32gb1tb)
            engineering == "Animacion" && priority == "CG" && ram == "8GB" && storage == "512 GB" && screen == "2560x1440" ->
                Pair("Thunderobot 911x\ni7 13620h, RTX 4060, $ram RAM, $storage, pantalla de $screen. Con una resolucion bastante destacada para poder ver todo de manera mas clara, aunque puede que presente algunos retrasos por el hardware",
                    R.drawable.thunderrobot911)
            engineering == "Animacion" && priority == "CG" && ram == "16GB" && storage == "512 GB" && screen == "2560x1440" ->
                Pair("Thunderobot 911x plus\ni7 13620h, RTX 4060, $ram RAM, $storage, pantalla de $screen. Con una resolucion bastante destacada y una gran capacidad de multitarea para muchos programas",
                    R.drawable.thunderrobot911)
            engineering == "Animacion" && priority == "CG" && ram == "32GB" && storage == "512 GB" && screen == "2560x1440" ->
                Pair("Thunderobot zero\ni9 13900hx, RTX 4060, $ram RAM, $storage, pantalla de $screen. Capaz de abrir varios programas sin alguna traba, o falta de espacio para abrir programas.",
                    R.drawable.thunderobotzero)
            engineering == "Animacion" && priority == "CG" && ram == "8GB" && storage == "1 TB" && screen == "2560x1440" ->
                Pair("Thunderobot R16\ni7 14650 hx, RTX 4060, $ram RAM, $storage, pantalla de $screen. Con mucho almacenamiento para cualquier tipo de programa, o archivos pesado.",
                    R.drawable.thunderobotr16)
            engineering == "Animacion" && priority == "CG" && ram == "16GB" && storage == "1 TB" && screen == "2560x1440" ->
                Pair("Thunderobot R16\nRyzen 7, RTX 4060, $ram RAM, $storage, pantalla de $screen. Una laptop calidad precio aunque un poco mas cara, con capacidad de todo",
                    R.drawable.thunderobotr16)
            engineering == "Animacion" && priority == "CG" && ram == "32GB" && storage == "1 TB" && screen == "2560x1440" ->
                Pair("Thunderobot zero ultra\ni9 14900hx, RTX 4060, $ram RAM, $storage, pantalla de $screen. Es todo terreno en cualquier aspecto, demasiado buena para ser verdad, pero lo bueno cuesta",
                    R.drawable.thunderobotzeroultra)

            else ->
                Pair("💻 Lenovo IdeaPad\nIntel i5, 8GB RAM, 256GB SSD, pantalla de $screen.", R.drawable.ideapad)
        }
    }
}
