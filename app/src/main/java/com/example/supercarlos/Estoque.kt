package com.example.supercarlos

class Estoque{
    private val itens = mutableListOf<ItemProduto>();
    fun entraItem(item: ItemProduto){
        itens.add(item);
    };
    fun saiItem(item: ItemProduto): ItemProduto?{
        return if (itens.remove(item)){
            item;
        } else {
            null;
        };
    };
    fun getItens(): List<ItemProduto>{
        return itens.toList();
    };
    fun getItens(marca: Marca): List<ItemProduto>{
        return itens.filter { it.getProduto().getMarca() == marca };
    };
    fun getItens(produto: Produto): List<ItemProduto>{
        return itens.filter { it.getProduto() == produto };
    };
    fun getItens(genero: Genero): List<ItemProduto>{
        return itens.filter { it.getProduto().getGenero().javaClass == genero.javaClass };
    };

    fun qtdItens(): Int {
        return itens.size;
    };

};