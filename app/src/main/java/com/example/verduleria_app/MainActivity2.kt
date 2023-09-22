package com.example.verduleria_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {
    private lateinit var tvFruta : TextView
    private lateinit var tvVerdura : TextView
    private lateinit var tvFrutaEmoji : TextView
    private lateinit var tvVerduraEmoji : TextView
    private lateinit var btnVolver: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val result = intent.extras
        val verdura = result?.getString("verdura") ?: "sin verdura"
        val fruta = result?.getString("fruta") ?: "sin fruta"
        val verduraEmoji = result?.getString("verduraEmoji") ?: "sin verdura"
        val frutaEmoji = result?.getString("frutaEmoji") ?: "sin fruta"

        tvFruta = findViewById(R.id.textView_fruta)
        tvVerdura = findViewById(R.id.textView_verdura)
        btnVolver = findViewById(R.id.button_Volver)
        tvFrutaEmoji = findViewById(R.id.frutaEmoji)
        tvVerduraEmoji = findViewById(R.id.verduraEmoji)


        tvVerdura.text = verdura
        tvFruta.text = fruta
        tvFrutaEmoji.text = frutaEmoji
        tvVerduraEmoji.text = verduraEmoji

        btnVolver.setOnClickListener{
            val intent = Intent(this, MainActivity :: class.java)
            startActivity(intent)
        }

    }
}