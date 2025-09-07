package com.example.supercarlos

fun main(){
    println("Função de adicionar item ao carrinho");
    val spw = SuperWeb();
    val estoque = spw.estoque;
    val carrinho = spw.carrinhoA;
    val itensNoEstoqueOriginal = estoque.getItens().toList();

    for (item in itensNoEstoqueOriginal){
        if (item.getCodigo() % 2 != 0L) {
            carrinho.adicionarItem(item, estoque);
        }
    };

    println("CARRINHO DE COMPRAS")
    println(String.format("%-10s %-20s %-15s %-10s", "CÓDIGO", "NOME", "MARCA", "PREÇO"));

    val itensNoCarrinho = carrinho.getItens();
    if (itensNoCarrinho.isEmpty()){
        println("O carrinho está vazio.");
    } else {
        for (item in itensNoCarrinho){
            val produto = item.getProduto();
            println(String.format("%-10s %-20s %-15s R$%-8.2f",
                item.getCodigo(),
                produto.nome,
                produto.getMarca().nome,
                produto.preco
            ));
        }
    };
    println("Quantidade no carrinho: ${carrinho.getItens().size} itens.");
    println(String.format("Total a pagar: R$%.2f", carrinho.totalAPagar()));

    println("\n\n ESTOQUE RESTANTE");
    println(String.format("%-10s %-20s %-15s %-15s %-10s %-12s",
        "CÓDIGO", "NOME", "MARCA", "GÊNERO", "PREÇO", "VALIDADE"));

    val itensRestantesEstoque = estoque.getItens();
    if (itensRestantesEstoque.isEmpty()){
        println("O estoque está vazio.");
    } else {
        for (item in itensRestantesEstoque){
            val produto = item.getProduto();
            val genero = produto.getGenero();
            val marca = produto.getMarca();
            val validade = item.getValidade();

            println(String.format("%-10s %-20s %-15s %-15s R$%-8.2f %-12s",
                item.getCodigo(),
                produto.nome,
                marca.nome,
                genero.nome,
                produto.preco,
                validade.toString()
            ));
        }
    }
    println("Quantidade no estoque: ${estoque.qtdItens()} itens.")
}