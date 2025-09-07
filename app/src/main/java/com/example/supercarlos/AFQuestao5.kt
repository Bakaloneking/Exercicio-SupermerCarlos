package com.example.supercarlos
import kotlin.random.Random

fun main(){
    println("Transferencia Estoque-Carrinho");

    val spw = SuperWeb();
    val estoque = spw.estoque;
    val carrinho = spw.carrinhoA;

    fun mostrarStatus(etapa: String) {
        println("\n--- $etapa ---\n");
        if (estoque.getItens().isEmpty()){
            println("Estoque vazio.");
        } else {
            println("--------------------------ESTOQUE----------------------------")
            println(String.format("%-10s %-20s %-15s %-15s %-10s %-12s",
                "CÓDIGO", "NOME", "MARCA", "GÊNERO", "PREÇO", "VALIDADE"));
            for (item in estoque.getItens()) {
                val produto = item.getProduto()
                val genero = produto.getGenero()
                val marca = produto.getMarca()
                val validade = item.getValidade()

                println(
                    String.format(
                        "%-10s %-20s %-15s %-15s R$%-8.2f %-12s",
                        item.getCodigo(),
                        produto.nome,
                        marca.nome,
                        genero.nome,
                        produto.preco,
                        validade.toString()
                    )
                )
            }
            println(" Itens no Estoque: ${estoque.qtdItens()}");
            if (carrinho.getItens().isEmpty()){
                println("Carrinho vazio.");
            } else {
                println("------------------------------------CARRINHO------------------------------")
                println(String.format("%-10s %-20s %-15s %-15s %-10s %-12s",
                    "CÓDIGO", "NOME", "MARCA", "GÊNERO", "PREÇO", "VALIDADE"));
                for (item in carrinho.getItens()) {
                    val produto = item.getProduto()
                    val genero = produto.getGenero()
                    val marca = produto.getMarca()
                    val validade = item.getValidade()

                    println(
                        String.format(
                            "%-10s %-20s %-15s %-15s R$%-8.2f %-12s",
                            item.getCodigo(),
                            produto.nome,
                            marca.nome,
                            genero.nome,
                            produto.preco,
                            validade.toString()
                        )
                    )
                }
            }
            println(" Itens no Carrinho: ${carrinho.getItens().size}");
        }
    };

    mostrarStatus("INICIAL");
    println("\n>> Movendo 10 itens aleatórios para o carrinho...\n");

    val itensDisponiveis = estoque.getItens();
    val quantidadeAMover = minOf(10, itensDisponiveis.size);

    if (quantidadeAMover > 0){
        val itensParaCarrinho = itensDisponiveis.shuffled().take(quantidadeAMover);
        for (item in itensParaCarrinho){
            carrinho.adicionarItem(item, estoque);
        }
    } else {
        println("\n>> Não há itens no estoque para mover para o carrinho.\n");
    };

    mostrarStatus("MOVIMENTAÇÃO");
    println("\n>> Devolvendo todos os itens do carrinho para o estoque...\n");

    val itensNoCarrinhoCopia = carrinho.getItens().toList();

    for (item in itensNoCarrinhoCopia){
        carrinho.removeItem(item,estoque);
    }

    mostrarStatus("DEVOLUÇÃO")
}
