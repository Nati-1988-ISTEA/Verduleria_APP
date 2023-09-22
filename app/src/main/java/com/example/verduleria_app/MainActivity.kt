package com.example.verduleria_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.Spinner
import android.widget.Toast


class MainActivity : AppCompatActivity() {

    private lateinit var spinner : Spinner
    private lateinit var  lisView: ListView
    private lateinit var  button: Button
    private var verdura : String? = null
    private var fruta : String? = null
    private var verduraEmoji : String? = null
    private var frutaEmoji : String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        spinner = findViewById(R.id.spinner_frutas)
        lisView = findViewById(R.id.lista_verduras)
        button = findViewById(R.id.Elegir_Button)

        val verduras = listOf("Lechuga", "Brocoli", "Papa", "Choclo", "Batata")
        val frutas = listOf("Aguacate" , "Banana" , "Mazana" , "Frutilla", "Naranja")

        val verdurasEmoji = listOf("\uD83E\uDD6C", "\uD83E\uDD66", "\uD83E\uDD54", "\uD83C\uDF3D", "\uD83C\uDF60")
        val frutasEmoji = listOf("\uD83E\uDD51" , "\uD83C\uDF4C" , "\uD83C\uDF4E" , "\uD83C\uDF53", "\uD83C\uDF4A")

        val adapterSpinner  = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, frutas)
        spinner.adapter = adapterSpinner

        val adapterListView  = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, verduras)
        lisView.adapter = adapterListView


        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, position :  Int, p3: Long) {
                fruta = frutas[position]
                frutaEmoji = frutasEmoji[position]


            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                // no nos preocupa cuando nada está seleccionado
            }

        }

        lisView.setOnItemClickListener {adapterView, view, position :Int, l->
            verdura = verduras[position]
            verduraEmoji = verdurasEmoji[position]
            Toast.makeText(this, verdura,Toast.LENGTH_LONG).show()
        }
        button.setOnClickListener{
            if (fruta != null) {
                val intent = Intent(this, MainActivity2::class.java)
                intent.putExtra("verdura", verdura)
                intent.putExtra("fruta", fruta)
                intent.putExtra("verduraEmoji", verduraEmoji)
                intent.putExtra("frutaEmoji", frutaEmoji)

                startActivity(intent)
            }
            else {
                Toast.makeText(this, "ingrese pais",Toast.LENGTH_LONG).show()
            }
        }


    }
}