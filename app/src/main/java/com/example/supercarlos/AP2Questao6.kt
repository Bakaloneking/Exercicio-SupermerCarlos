package com.example.supercarlos
import kotlin.random.Random

fun main(){
    println("Função de adicionar itens aleatórios ao carrinho");

    val spw = SuperWeb();
    val estoque = spw.estoque;
    val carrinho = spw.carrinhoA;
    val itensValidosNoEstoque = estoque.getItens().filter { it.valido() };

    if (itensValidosNoEstoque.isNotEmpty()){
        val quantidadeAMover = Random.nextInt(1, itensValidosNoEstoque.size + 1);
        println(">> Decidido aleatoriamente mover $quantidadeAMover itens válidos para o carrinho.\n")
        val itensASeremMovidos = itensValidosNoEstoque.shuffled().take(quantidadeAMover)
        for (item in itensASeremMovidos) {
            carrinho.adicionarItem(item, estoque)
        }
    } else {
        println(">> Não há itens válidos no estoque para mover para o carrinho.")
    };
    println("CARRINHO DE COMPRAS");
    println(String.format("%-10s %-20s %-15s %-10s", "CÓDIGO", "NOME", "MARCA", "PREÇO"))

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
            println(String.format("%-10s %-20s %-15s %-15s R$%-8.2f %-12s",
                item.getCodigo(),
                produto.nome,
                produto.getMarca().nome,
                produto.getGenero().nome,
                produto.preco,
                item.getValidade().toString()
            ));
        }
    };
    println("Quantidade no estoque: ${estoque.qtdItens()} itens.");
}