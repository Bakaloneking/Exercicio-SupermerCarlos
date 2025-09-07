package com.example.supercarlos

class ItemProduto(
    private val codigo: Long,
    private val validade: Data,
    private val produto: Produto
){
    fun getProduto(): Produto = this.produto;
    fun getCodigo(): Long = this.codigo;

    fun getValidade(): Data = this.validade;
    fun valido(): Boolean{
        val hoje = Data.dataHoje();
        return this.validade.depois(hoje);
    };
};