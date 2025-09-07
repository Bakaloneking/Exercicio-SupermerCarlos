package com.example.supercarlos

fun main(){
    println("Busca de itens por gênero");

    val spw = SuperWeb()
    val estoque = spw.estoque;

    print(">> Digite o nome do gênero (Leite, Presunto, Achocolatado): ");
    val nomeGeneroBuscado = readLine();

    val generoEscolhido: Genero? = when (nomeGeneroBuscado?.lowercase()) {
        "leite" -> Leite()
        "presunto" -> Presunto()
        "achocolatado" -> Achocolatado()
        else -> null
    };

    val itensEncontrados: List<ItemProduto>

    if (generoEscolhido != null) {
        println("Buscando itens do gênero: ${generoEscolhido.nome}");
        itensEncontrados = estoque.getItens(generoEscolhido);
    } else {
        println("$nomeGeneroBuscado não é um gênero válido.");
        itensEncontrados = emptyList();
    };

    println("RESULTADO DA BUSCA:");
    println(String.format("%-10s %-20s %-15s %-15s %-10s %-12s %-7s",
        "CÓDIGO", "NOME", "MARCA", "GÊNERO", "PREÇO", "VALIDADE", "VÁLIDO?"));

    if (itensEncontrados.isNotEmpty()){
        for (item in itensEncontrados) {
            val produto = item.getProduto();
            val textoValido = if (item.valido()) "sim" else "não";
            println(String.format("%-10s %-20s %-15s %-15s R$%-8.2f %-12s %-7s",
                item.getCodigo(),
                produto.nome,
                produto.getMarca().nome,
                produto.getGenero().nome,
                produto.preco,
                item.getValidade().toString(),
                textoValido
            ));
        }
    } else {
        println("Nenhum item encontrado para o gênero '$nomeGeneroBuscado'.");
    }
    println("Total de itens encontrados: ${itensEncontrados.size}");
}