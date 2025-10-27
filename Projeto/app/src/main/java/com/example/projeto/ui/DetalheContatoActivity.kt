package com.example.projeto.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.net.toUri
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.projeto.R
import com.example.projeto.databinding.ActivityDetalheContatoBinding
import com.example.projeto.model.Comercio

class DetalheContatoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetalheContatoBinding
    private lateinit var comercio : Comercio

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetalheContatoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loadData()
        setupViews()
        setupListeners()
    }

    private fun loadData() {
        comercio = intent.getSerializableExtra("comercio", Comercio::class.java) as Comercio
    }

    private fun setupViews() {
        binding.tvNome.text = comercio.nome
        binding.tvTelefone.text = comercio.telefone
        binding.tvEndereco.text = comercio.endereco
        binding.tvDescricao.text = comercio.descricao
        binding.imgFoto.setImageResource(comercio.foto)
    }

    private fun setupListeners() {
        binding.btnLigar.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = "tel:${comercio.telefone}".toUri()
            startActivity(intent)
        }
        binding.btnVoltar.setOnClickListener {
            finish()
        }
    }

}