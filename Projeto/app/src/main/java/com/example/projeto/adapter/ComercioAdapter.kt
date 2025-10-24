package com.example.projeto.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.projeto.R
import com.example.projeto.databinding.ItemServicoBinding
import com.example.projeto.model.Comercio

class ComercioAdapter(
    context: Context,
    private val lista: List<Comercio>
) : ArrayAdapter<Comercio>(context, 0, lista) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val binding: ItemServicoBinding
        val itemView: View
        if (convertView == null) {
            binding = ItemServicoBinding.inflate(LayoutInflater.from(context), parent, false)
            itemView = binding.root
            itemView.tag = binding
        } else {
            itemView = convertView
            binding = itemView.tag as ItemServicoBinding
        }
        val comercio = lista[position]
        binding.imgFoto.setImageResource(comercio.foto)
        binding.tvNome.text = comercio.nome
        binding.tvTelefone.text = comercio.telefone
        binding.tvDescricao.text = comercio.descricao
        return itemView
    }
}