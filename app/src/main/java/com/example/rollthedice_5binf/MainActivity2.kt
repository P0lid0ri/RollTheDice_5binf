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

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)

        val numeroEstratto = intent.getIntExtra("NUMERO", -1)
        val textViewTitle = findViewById<TextView>(R.id.textView_numero)
        textViewTitle.text = numeroEstratto.toString()

        val imageView = findViewById<ImageView>(R.id.image_dice)
        imageView.setImageResource(
            resources.getIdentifier("dice_face_$numeroEstratto", "drawable", packageName)
        )
        val resource = when (numeroEstratto){

            1 -> R.drawable.dice_face_1
            2 -> R.drawable.dice_face_2
            3 -> R.drawable.dice_face_3
            4 -> R.drawable.dice_face_4
            5 -> R.drawable.dice_face_5
            6 -> R.drawable.dice_face_6
            else -> {R.drawable.dices}

        }
        imageView.setImageResource(resource)
        val btnLancia = findViewById<Button>(R.id.button_win)

        btnLancia.setOnClickListener(View.OnClickListener {
            val mioToast = Toast.makeText(this, "Il Risultato è ..." ,Toast.LENGTH_LONG)
            mioToast.show()
            lanciasuIntent(numeroEstratto)
        })
    }
    private fun estraiNumero():Int{
        return (1..6).random()
    }
    private fun lanciasuIntent(numeroEstratto: Int,){
        val intent = Intent(this, MainActivity3::class.java)
        val numerogen= estraiNumero()
        val esito:String
        if(numeroEstratto == numerogen) {
            esito = "Complimenti...Hai vinto!!!"
        }else{
            esito= "Mi Dispiace...Hai perso :( "
        }
        intent.putExtra("ESITO",esito)
        intent.putExtra("ESTRAZIONE",numerogen)
        startActivity(intent)
    }
}