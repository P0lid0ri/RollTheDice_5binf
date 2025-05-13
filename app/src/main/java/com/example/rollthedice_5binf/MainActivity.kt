package com.example.rollthedice_5binf

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        var btnRoll =  findViewById<Button>(R.id.buttonRoll)
        var text = findViewById<TextView>(R.id.textViewTitle)


        btnRoll.setOnClickListener(View.OnClickListener {
            var numero = estrazioneNumero()
            var mioToast = Toast.makeText(this, "DADO LANCIATO !!! $numero", Toast.LENGTH_LONG)
            mioToast.show()
            lanciaIntent(numero)
        })


    }
    private fun estrazioneNumero():Int {
        return (1..6).random()
    }
    private fun lanciaIntent (numero:Int){
        var intent = Intent(this,MainActivity2::class.java)
        intent.putExtra("NUMERO" , numero)
        startActivity(intent)

    }



}
