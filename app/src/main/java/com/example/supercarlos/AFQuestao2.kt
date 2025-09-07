package com.example.supercarlos

fun main(){
    println("Busca por itens antes de certa data");
    val spw = SuperWeb();
    val estoque = spw.estoque;

    try {
        print(">> Digite o Dia (DD): ");
        val dia = readLine()!!.toInt();
        print(">> Digite o Mês (MM): ");
        val mes = readLine()!!.toInt();
        print(">> Digite o Ano (AAAA): ");
        val ano = readLine()!!.toInt();

        val dataFornecida = Data(dia, mes, ano);
        val todosOsItens = estoque.getItens();
        val itensVencidos = todosOsItens.filter { it.getValidade().antes(dataFornecida) }

        println("\n>> RESULTADO DA BUSCA:");
        println(String.format("%-10s %-20s %-15s %-15s %-10s %-12s %-7s",
            "CÓDIGO", "NOME", "MARCA", "GÊNERO", "PREÇO", "VALIDADE", "VÁLIDO?"));

        if (itensVencidos.isNotEmpty()){
            for (item in itensVencidos){
                val produto = item.getProduto()
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
            println("Nenhum item encontrado anterior a data '$dataFornecida'.");
        }
        println("Total de itens encontrados: ${itensVencidos.size}");
    } catch (e: NumberFormatException) {
     println("Formato de data inválido. Certifique-se de que está no formato DD/MM/AAAA.");
    }
}