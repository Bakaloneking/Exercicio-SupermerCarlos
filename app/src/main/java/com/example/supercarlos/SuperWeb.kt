package com.example.supercarlos

import kotlin.random.Random

class SuperWeb{
    private val marcas = mutableListOf<Marca>();
    private val produtos = mutableListOf<Produto>();
    private val generos = mutableListOf<Genero>();

    val estoque = Estoque();
    val carrinhoA = Carrinho();
    val carrinhoB = Carrinho();

    init{
        iniciarSupermercado();
    };

    private fun iniciarSupermercado(){
        val generoLeite = Leite();
        val generoAchocolatado = Achocolatado();
        val generoPresunto = Presunto();
        generos.addAll(listOf(generoLeite, generoAchocolatado, generoPresunto));

        val marcaNestle = Marca("Nestle");
        val marcaItambe = Marca("Itambé");
        val marcaParmalat = Marca("Parmalat");
        val marcaPepsico = Marca("Pepsico");
        val marcaPerdigao = Marca("Perdigao");
        val marcaSadia = Marca("Sadia");
        marcas.addAll(listOf(marcaNestle, marcaItambe, marcaParmalat, marcaPepsico, marcaPerdigao, marcaSadia));

        // 3. Criar Produtos
        // Leites
        produtos.add(Produto( 101, "Leite Ninho", 5.50f, marcaNestle, generoLeite))
        produtos.add(Produto(102, "Leite em Pó", 4.80f, marcaItambe, generoLeite))
        produtos.add(Produto(103, "Leite Integral", 4.20f, marcaParmalat, generoLeite))
        // Achocolatados
        produtos.add(Produto(201, "Nescau", 7.00f, marcaNestle, generoAchocolatado))
        produtos.add(Produto(202, "Toddy", 6.50f, marcaPepsico, generoAchocolatado))
        produtos.add(Produto(203, "Achocolatado Itambé", 5.90f, marcaItambe, generoAchocolatado))
        // Presuntos
        produtos.add(Produto(301, "Presunto Cozido", 8.00f, marcaSadia, generoPresunto))
        produtos.add(Produto(302, "Presunto de Peru", 9.50f, marcaPerdigao, generoPresunto))
        produtos.add(Produto(303, "Presunto Royale", 10.20f, marcaSadia, generoPresunto))

        var codigoBarras = 1000L;

        for (i in 1..10){
            val produto = produtos.filter { it.getGenero() is Leite }.random();
            val validade = Data(Random.nextInt(1,29), Random.nextInt(1,13), Random.nextInt(2024,2027));
            estoque.entraItem(ItemProduto(codigoBarras++, validade, produto))
        };

        for (i in 1..10) {
            val produto = produtos.filter { it.getGenero() is Achocolatado }.random()
            val validade = Data(Random.nextInt(1, 29), Random.nextInt(1, 13), Random.nextInt(2024, 2027))
            estoque.entraItem(ItemProduto(codigoBarras++, validade, produto))
        }

        for (i in 1..10) {
            val produto = produtos.filter { it.getGenero() is Presunto }.random()
            val validade = Data(Random.nextInt(1, 29), Random.nextInt(1, 13), Random.nextInt(2024, 2027))
            estoque.entraItem(ItemProduto(codigoBarras++, validade, produto))
        };
    };

    fun getMarcas(): List<Marca> = marcas.toList();
    fun getProdutos(): List<Produto> = produtos.toList();
    fun getGeneros(): List<Genero> = generos.toList();

};