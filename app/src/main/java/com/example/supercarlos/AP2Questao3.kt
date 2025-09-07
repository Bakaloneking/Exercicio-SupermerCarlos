package com.example.supercarlos

fun main(){
    println("Estoque por Gênero e Marca que não estão vencidos");
    val spw = SuperWeb();
    val generos = spw.getGeneros();
    val estoque = spw.estoque;
    var totalItensMostrados = 0;

    println(String.format("%-10s %-20s %-15s %-15s %-10s %-12s",
        "CÓDIGO", "NOME", "MARCA", "GÊNERO", "PREÇO", "VALIDADE"))
    println("---------------------------------------------------------------------------------------");

    for (genero in generos) {
        val itensDoGenero = estoque.getItens(genero);
        val itensValidosdoGenero = itensDoGenero.filter { it.valido() };
        val itensAgrupadosPorMarca = itensValidosdoGenero.groupBy { it.getProduto().getMarca() };

        for ((marca, itensDaMarca) in itensAgrupadosPorMarca) {
            for (item in itensDaMarca) {
                val produto = item.getProduto();
                val validade = item.getValidade();

                println(String.format("%-10s %-20s %-15s %-15s R$%-8.2f %-12s",
                    item.getCodigo(),
                    produto.nome,
                    marca.nome,
                    genero.nome,
                    produto.preco,
                    validade.toString()
                ));
                totalItensMostrados++
            };
        };
    };
    println("Total itens em validade: $totalItensMostrados itens.")
}