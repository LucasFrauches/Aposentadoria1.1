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

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        // Configura o Spinner
        val generos = listOf("Masculino", "Feminino")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, generos)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinner.adapter = adapter



        // Listener do botão
        binding.buttonCalcular.setOnClickListener {
            val sexo = binding.spinner.selectedItem as String
            var idade = binding.editIdade.text.toString().toLongOrNull()
            var resultado: Long = 0
            if (idade != null) {
                if (sexo.trim()=="Masculino"){
                    if (idade <= 64){
                        resultado = 65 - idade
                        binding.textResultado.text = "Faltam $resultado anos para você se aposentar"
                    }
                    else{
                        binding.textResultado.text = "Já chegou o momento de aposentar coroa!!"
                    }

                }
                else{
                    if (idade <= 61){
                        resultado = 62 - idade
                        binding.textResultado.text = "Faltam $resultado anos para você se aposentar"

                    }
                    else{
                        binding.textResultado.text = "Já chegou o momento de aposentar !!" }
                }


            }
        }
    }
}