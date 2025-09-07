package com.example.supercarlos

fun main(){
    println("Analise de Validade do Estoque");

    val spw = SuperWeb();
    val estoque = spw.estoque;
    val todosOsItens = estoque.getItens();
    val quantidadeItensValidos = todosOsItens.count { it.valido() };
    val quantidadeItensVencidos = todosOsItens.count { !it.valido() };
    val somaDasQuantidades = quantidadeItensValidos + quantidadeItensVencidos;
    val totalItensEstoque = estoque.qtdItens();
    val verificacao = if (somaDasQuantidades == totalItensEstoque) "Correta" else "Incorreta";

    println("RELATÓRIO:")
    println("- Quantidade de itens VÁLIDOS: $quantidadeItensValidos")
    println("- Quantidade de itens VENCIDOS: $quantidadeItensVencidos")
    println("- Total de itens no estoque (método oficial): $totalItensEstoque")
    println("- Soma (Válidos + Vencidos): $somaDasQuantidades")
    println("\n- Verificação da contagem: A soma está $verificacao.")
}