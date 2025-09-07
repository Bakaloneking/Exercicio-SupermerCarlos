package com.example.supercarlos

class Carrinho {
    private val itens = mutableListOf<ItemProduto>();
    fun adicionarItem(item: ItemProduto, estoque: Estoque){
        val itemRetirado = estoque.saiItem(item);
        if (itemRetirado != null){
            itens.add(itemRetirado);
        };
    };
    fun removeItem(item: ItemProduto, estoque: Estoque){
        if (itens.remove(item)){
            estoque.entraItem(item);
        };
    };

    fun totalAPagar(): Double {
        var total = 0.0;
        for (item in itens) {
            total += item.getProduto().preco
        };
        return total;
    };

    fun getItens(): List<ItemProduto>{
        return itens.toList();
    };
};