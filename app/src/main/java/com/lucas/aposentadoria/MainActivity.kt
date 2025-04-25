package com.lucas.aposentadoria

import android.os.Bundle
import android.view.inputmethod.InputBinding
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.lucas.aposentadoria.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val itens = listOf(
            "Masculino", "Feminino"
        )

        //config adapter
        val adapter = ArrayAdapter(this,android.R.layout.simple_spinner_item,itens)

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item)

        binding.spinner.adapter = adapter

        binding.buttonCalcular.setOnCLickListener{
            val sexoSelecionado = binding.spinner.selectedItem as String
            var idade = binding.editTextIdade.text.toString().toLongOrNull()
            var resultado = Long

            if (idade != null){

                if (sexoSelecionado.trim()=="Masculino"){
                    resultado = 65 - idade
                }
                else{
                    resultado = 62 - idade
                }
                binding.textViewResultado.text="Faltam $resultado anos para você se aposentar"
            } else{
                binding.textViewResultado.text="Informe uma idade"
            }


        }
    }
}