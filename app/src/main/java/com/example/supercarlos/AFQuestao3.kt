package com.example.supercarlos

fun main(){
    println("Produtos Mais Baratos por Gênero");

    val spw = SuperWeb();
    val todosOsProdutos = spw.getProdutos();
    val todosOsGeneros = spw.getGeneros();

    println("Analisando os produtos cadastrados...");

    for (genero in todosOsGeneros){
        val produtosDoGenero = todosOsProdutos.filter { it.getGenero().javaClass == genero.javaClass };
        val produtoMaisBarato = produtosDoGenero.minByOrNull { it.preco };

        if (produtoMaisBarato != null){
            println(
                String.format(">> Gênero: %-15s | Produto: %-20s | Preço: R$%.2f",
                    genero.nome,
                    produtoMaisBarato.nome,
                    produtoMaisBarato.preco
                )
            );
        } else {
            println(">> Gênero: ${genero.nome.padEnd(15)} | Nenhum produto encontrado.")
        };
    }
}