package com.example.supercarlos

fun main(){
    println("Função de Dois Carrinhos");
    val spw = SuperWeb();
    val estoque = spw.estoque;
    val carrinhoA = spw.carrinhoA;
    val carrinhoB = spw.carrinhoB;

    println("--- ESTADO INICIAL ---");
    println("Itens no Estoque: ${estoque.qtdItens()}");
    println("Itens no Carrinho A (Válidos): ${carrinhoA.getItens().size}");
    println("Itens no Carrinho B (Inválidos): ${carrinhoB.getItens().size}\n");

    val itensOriginaisCopia = estoque.getItens().toList();

    for (item in itensOriginaisCopia) {
        if (item.valido()) {
            carrinhoA.adicionarItem(item, estoque);
        } else {
            carrinhoB.adicionarItem(item, estoque);
        }
    };

    println(">> Itens do estoque distribuídos para os carrinhos A (Válidos) e B (Inválidos).\n");

    println("--- ESTADO FINAL ---");
    println("Itens restantes no Estoque: ${estoque.qtdItens()}");

    println("\n Carrinho A (Itens Válidos)");

    val itensValidos = carrinhoA.getItens();
    if (itensValidos.isNotEmpty()){
        for (item in itensValidos){
            println(String.format("Cód: %-5s | %-20s | Validade: %s",
                item.getCodigo(), item.getProduto().nome, item.getValidade().toString()));
        }
    } else {
        println("Carrinho A vazio.");
    };
    println("Total de itens no Carrinho A: ${itensValidos.size}");

    println("\n Carrinho B (Itens Inválidos/Vencidos)");

    val itensInvalidos = carrinhoB.getItens();
    if (itensInvalidos.isNotEmpty()){
        for (item in itensInvalidos) {
            println(String.format("Cód: %-5s | %-20s | Validade: %s",
                item.getCodigo(), item.getProduto().nome, item.getValidade().toString()));
        }
    } else {
        println("Carrinho B vazio.");
    }
    println("Total de itens no Carrinho B: ${itensInvalidos.size}");
}