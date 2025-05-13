package com.example.rollthedice_5binf

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main3)

        val esito = intent.getStringExtra("ESITO")
        val textViewTitle = findViewById<TextView>(R.id.esito_textView)
        textViewTitle.text = esito
        val numerocoretto = intent.getIntExtra("ESTRAZIONE",-1)
        val textView = findViewById<TextView>(R.id.num_gen)
        textView.text= "il numero estratto è :  $numerocoretto"




    }
}