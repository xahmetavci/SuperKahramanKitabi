package com.ahmetavci.superkahramankitabi

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //Veri Hazırlık Aşaması

        var superKahramanListesi = ArrayList<String>()
        superKahramanListesi.add("Captain America")
        superKahramanListesi.add("Iron Man")
        superKahramanListesi.add("Superman")
        superKahramanListesi.add("Thor")

        //Verimsiz Tanımlamalar

        /*
        val captainamericaBitmap = BitmapFactory.decodeResource(applicationContext.resources, R.drawable.captainamerica)
        val ironmanBitmap = BitmapFactory.decodeResource(applicationContext.resources, R.drawable.ironman)
        val supermanBitmap = BitmapFactory.decodeResource(applicationContext.resources, R.drawable.superman)
        val thorBitmap = BitmapFactory.decodeResource(applicationContext.resources, R.drawable.thor)

        var superKahramanGorselleri = ArrayList<Bitmap>()
        superKahramanGorselleri.add(captainamericaBitmap)
        superKahramanGorselleri.add(ironmanBitmap)
        superKahramanGorselleri.add(supermanBitmap)
        superKahramanGorselleri.add(thorBitmap)
        */

        //Verimli Tanımlamalar
        val captainDrawableId = R.drawable.captainamerica //int bir değer veriyor. Bildiğimiz Integer bir değer tanımlıyoruz.
        val ironmanDrawableId = R.drawable.ironman
        val supermanDrawableId = R.drawable.superman
        val thorDrawableId = R.drawable.thor

        var superKahramanDrawableListesi = ArrayList<Int>()
        superKahramanDrawableListesi.add(captainDrawableId)
        superKahramanDrawableListesi.add(ironmanDrawableId)
        superKahramanDrawableListesi.add(supermanDrawableId)
        superKahramanDrawableListesi.add(thorDrawableId)
        //Artık Integer bir değerimi alıp gönül rahatlığı ile singleton ile uğraşmadan karşı tarafa yollayabilirim

        //Adapter

        var recycler = findViewById<RecyclerView>(R.id.recyclerView)

        val layoutManager = LinearLayoutManager(this)
        recycler.layoutManager = layoutManager

        val adapter = RecyclerAdapter(superKahramanListesi, superKahramanDrawableListesi)
        recycler.adapter =adapter

    }
}