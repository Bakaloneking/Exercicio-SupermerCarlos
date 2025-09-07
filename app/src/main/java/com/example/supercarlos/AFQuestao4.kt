package com.example.supercarlos

fun main() {
    println("Analise Financeira de Estoque");

    val spw = SuperWeb();
    val estoque = spw.estoque;

    println("--- 1. ESTADO INICIAL DO ESTOQUE ---");
    val itensIniciais = estoque.getItens();

    val lucroPotencial = itensIniciais.sumOf { it.getProduto().preco.toDouble() };

    fun imprimeEstoque(titulo: String, listaItens: List<ItemProduto>) {
        println(titulo);
        if (listaItens.isNotEmpty()) {
            println(
                String.format(
                    "%-10s %-20s %-15s %-10s %-12s",
                    "CÓDIGO",
                    "NOME",
                    "MARCA",
                    "PREÇO",
                    "VALIDADE"
                )
            );
            for (item in listaItens) {
                val p = item.getProduto()
                println(
                    String.format(
                        "%-10s %-20s %-15s R$%-8.2f %-12s",
                        item.getCodigo(),
                        p.nome,
                        p.getMarca().nome,
                        p.preco,
                        item.getValidade().toString()
                    )
                )
            }
        } else {
            println("Estoque vazio.")
        }
    };

    imprimeEstoque(">> ESTOQUE INICIAL", itensIniciais);
    println("Total de itens no estoque: ${itensIniciais.size}");
    println(String.format("Lucro potencial: R$%.2f", lucroPotencial));

    println("--- 2. REMOVENDO ITENS VENCIDOS ---");

    val itensOriginaisCopia = estoque.getItens().toList();
    val itensVencidos = itensOriginaisCopia.filter { !it.valido() };
    val prejuizo = itensVencidos.sumOf { it.getProduto().preco.toDouble() };

    if (itensVencidos.isNotEmpty()) {
        for (item in itensVencidos) {
            estoque.saiItem(item);
        }
        println(">> Foram removidos ${itensVencidos.size} itens vencidos.");
    } else {
        println(">> Não há itens vencidos no estoque.");
    }
    println(String.format("Lucro líquido: R$%.2f", lucroPotencial - prejuizo));

    println("--- 3. ESTADO FINAL DO ESTOQUE ---");

    val itensFinais = estoque.getItens();

    imprimeEstoque(">> ESTOQUE FINAL", itensFinais);
    println("Total de itens no estoque: ${itensFinais.size}");

    val lucroReal = lucroPotencial - prejuizo;

    println(String.format("Lucro real: R$%.2f", lucroReal));
}
