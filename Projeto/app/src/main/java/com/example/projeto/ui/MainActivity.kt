package com.example.projeto.ui

import android.content.Intent
import com.example.projeto.R
import com.example.projeto.model.Comercio
import com.example.projeto.adapter.ComercioAdapter
import com.example.projeto.databinding.ActivityMainBinding
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var comercios: List<Comercio>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        loadData()
        setupViews()
        setupListeners()
    }
    fun loadData(){
        comercios = listOf(
            Comercio(
                R.drawable.alves,
                getString(R.string.alves_automoveis),
                getString(R.string.alves_automoveis_address),
                getString(R.string.alves_automoveis_phone),
                getString(R.string.alves_automoveis_description),
            ),
            Comercio(
                R.drawable.imperio,
                getString(R.string.imperio),
                getString(R.string.imperio_address),
                getString(R.string.imperio_phone),
                getString(R.string.imperio_description),
            ),
            Comercio(
                R.drawable.roby,
                getString(R.string.agro),
                getString(R.string.agro_address),
                getString(R.string.agro_phone),
                getString(R.string.agro_description),
            ),
            Comercio(
                R.drawable.amarelinha,
                getString(R.string.amarelinha),
                getString(R.string.amarelinha_address),
                getString(R.string.amarelinha_phone),
                getString(R.string.amarelinha_description),
            ),
            Comercio(
                R.drawable.box,
                getString(R.string.box),
                getString(R.string.box_address),
                getString(R.string.box_phone),
                getString(R.string.box_description),
            ),
            Comercio(
                R.drawable.sammart,
                getString(R.string.sam_mart),
                getString(R.string.sam_mart_address),
                getString(R.string.sam_mart_phone),
                getString(R.string.sam_mart_description),
            )
        ).sortedBy { it.nome }
    }
    fun setupViews(){
        val adapter = ComercioAdapter(this, comercios)
        binding.listViewContatos.adapter = adapter
    }
    fun setupListeners() {
        binding.listViewContatos.setOnItemClickListener { _, _, position, _ ->
            val intent = Intent(this, DetalheContatoActivity::class.java)
            intent.putExtra("comercio", comercios[position])

            startActivity(intent)
        }
    }
}