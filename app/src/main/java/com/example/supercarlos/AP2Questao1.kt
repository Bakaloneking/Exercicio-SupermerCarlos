package com.example.supercarlos

fun main(){
    println("Bem vindo ao Supermercado Carlos!");
    val spw = SuperWeb();

    val itensNoEstoque = spw.estoque.getItens();

    println("ESTOQUE");
    println(String.format("%-10s %-20s %-15s %-15s %-10s %-12s %-7s",
        "CÓDIGO", "NOME", "MARCA", "GÊNERO", "PREÇO", "VALIDADE", "VÁLIDO?"))
    println("-----------------------------------------------------------");

    for (item in itensNoEstoque){
        val produto = item.getProduto();
        val marca = produto.getMarca();
        val genero = produto.getGenero();
        val validade = item.getValidade();
        val textoValido = if (item.valido()) "sim" else "não";
        val codigoItem = item.getCodigo();

        println(String.format("%-10s %-20s %-15s %-15s R$%-8.2f %-12s %-7s",
            codigoItem,
            produto.nome,
            marca.nome,
            genero.nome,
            produto.preco,
            validade.toString(),
            textoValido
        ));
    }
    println("Total: ${spw.estoque.qtdItens()} itens.");
}