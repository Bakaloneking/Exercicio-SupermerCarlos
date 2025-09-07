package com.example.supercarlos

fun main(){
    println("Estoque por Gênero");

    val spw = SuperWeb();
    val generos = spw.getGeneros();
    val estoque =spw.estoque;

    println(String.format("%-10s %-20s %-15s %-15s %-10s %-12s %-7s",
        "CÓDIGO", "NOME", "MARCA", "GÊNERO", "PREÇO", "VALIDADE", "VÁLIDO?"))
    println("------------------------------------------------------------------------------------------");

    for (genero in generos) {
        val itensPorGenero = estoque.getItens(genero);

        for (item in itensPorGenero) {
            val produto = item.getProduto();
            val marca = produto.getMarca();
            val validade = item.getValidade();
            val textoValido = if (item.valido()) "sim" else "não";
            val codigoItem = item.getCodigo();

            println(String.format("%-10s %-20s %-15s %-15s R$%-8.2f %-12s %-7s",
                codigoItem,       // Argumento 1: Código do item (Long)
                produto.nome,           // Argumento 2: Nome do produto (String)
                marca.nome,             // Argumento 3: Nome da marca (String)
                genero.nome,            // Argumento 4: Nome do gênero (String)
                produto.preco,          // Argumento 5: Preço do produto (Float)
                validade.toString(),    // Argumento 6: Data de validade (String)
                textoValido             // Argumento 7: Status de validade (String)
            ));
        };
        println("Total gênero ${genero.nome.uppercase()}: ${itensPorGenero.size} itens.\n");
    }
    println("Total geral: ${estoque.qtdItens()} itens.");
}