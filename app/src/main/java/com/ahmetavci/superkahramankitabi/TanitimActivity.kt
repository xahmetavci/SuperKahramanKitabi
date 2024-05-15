package com.ahmetavci.superkahramankitabi

import android.graphics.BitmapFactory
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class TanitimActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_tanitim)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val intent = intent //buraya bir intent ile geliniyorsa o intenti almamızı sağlıyor
        val secilenKahramanIsmi = intent.getStringExtra("superKahramanIsmi")
        var kahramanTextim = findViewById<TextView>(R.id.textView)
        kahramanTextim.text = secilenKahramanIsmi

        val secilenKahramanGorseli = intent.getIntExtra("superKahramanGorseli",0)
        val bitmap = BitmapFactory.decodeResource(applicationContext.resources, secilenKahramanGorseli)

        var image = findViewById<ImageView>(R.id.imageView)
        image.setImageBitmap(bitmap)

        /*
        val secilenKahraman = SingletonClass.SecilenKahraman
        val secilenGorsel = secilenKahraman.gorsel
        var image = findViewById<ImageView>(R.id.imageView)
        image.setImageBitmap(secilenGorsel)
        */
    }
}