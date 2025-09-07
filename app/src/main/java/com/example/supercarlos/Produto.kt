package com.example.supercarlos

class Produto(
    val codigo: Int,
    val nome: String,
    val preco: Float,
    private val marca: Marca,
    private val genero: Genero
){
    fun getMarca(): Marca = this.marca;
    fun getGenero(): Genero = this.genero;
};