package com.example.projeto.model

import java.io.Serializable

data class Comercio(
    val foto: Int,
    val nome: String,
    val endereco: String,
    val telefone: String,
    val descricao: String
) : Serializable