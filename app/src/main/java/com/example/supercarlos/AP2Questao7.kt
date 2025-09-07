package com.example.supercarlos

fun main(){
    println("Busca de itens por marca");

    val spw = SuperWeb();
    val estoque = spw.estoque;

    print(">> Digite o nome da marca: ");
    val nomeMarcaBuscada = readLine()!!;

    println("\n>> RESULTADO DA BUSCA:");

    val todosOsItens = estoque.getItens();
    val itensEncontrados = todosOsItens.filter { item ->
        val itemEValido = item.valido();
        val marcaCorrespondente = item.getProduto().getMarca().nome.equals(nomeMarcaBuscada, ignoreCase = true);
        itemEValido && marcaCorrespondente
    };



    if (itensEncontrados.isNotEmpty()){
        println(String.format("%-10s %-20s %-15s %-15s %-10s %-12s",
            "CÓDIGO", "NOME", "MARCA", "GÊNERO", "PREÇO", "VALIDADE"));
        for (item in itensEncontrados){
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
    } else {
        println("Nenhum item encontrado para a marca '$nomeMarcaBuscada'.");
    };
    println("Total de itens encontrados: ${itensEncontrados.size}");
}