# Projeto Supermercado SPW (SuperCarlos)

Este projeto é uma simulação em Kotlin de um sistema de gerenciamento de supermercado, desenvolvido como parte da avaliação da disciplina de Programação para Dispositivos Móveis.

O sistema implementa classes para gerenciar produtos, marcas, gêneros, estoque e carrinhos de compra, seguindo os princípios de Programação Orientada a Objetos.

## Estrutura do Projeto

O código-fonte está localizado em `app/src/main/java/com/example/supercarlos/`. As principais classes do modelo de negócio são:

* `SuperWeb.kt`: Classe principal que inicializa e orquestra os dados do supermercado.
* `Produto.kt`, `Marca.kt`, `Genero.kt`: Classes que definem a estrutura dos produtos.
* `ItemProduto.kt`: Representa um item físico no estoque, com código de barras e data de validade.
* `Estoque.kt`: Gerencia a entrada e saída de itens.
* `Carrinho.kt`: Simula o carrinho de compras do cliente.
* `Data.kt`: Classe utilitária para manipulação de datas.

## Como Executar as Questões

Cada questão do exercício foi resolvida em um arquivo separado com sua própria função `main`. Para executar uma questão específica, localize o arquivo correspondente e execute a função `main` contida nele através do seu IDE (IntelliJ ou Android Studio).

### Parte I

* **1ª Questão**: `AP2Questao1.kt` - Lista todos os itens em estoque.
* **2ª Questão**: `AP2Questao2.kt` - Lista os itens do estoque agrupados por gênero.
* **3ª Questão**: `AP2Questao3.kt` - Lista os itens válidos agrupados por gênero e marca.
* **4ª Questão**: `AP2Questao4.kt` - Conta e verifica o total de itens válidos e vencidos.
* **5ª Questão**: `AP2Questao5.kt` - Move itens de código ímpar para o carrinho.
* **6ª Questão**: `AP2Questao6.kt` - Move uma quantidade aleatória de itens válidos para o carrinho.
* **7ª Questão**: `AP2Questao7.kt` - Permite ao usuário buscar itens válidos por marca.

### Parte II

* **1ª Questão**: `AFQuestao1.kt` - Permite ao usuário buscar itens por gênero.
* **2ª Questão**: `AFQuestao2.kt` - Busca itens vencidos com base em uma data fornecida pelo usuário.
* **3ª Questão**: `AFQuestao3.kt` - Encontra o produto mais barato de cada gênero.
* **4ª Questão**: `AFQuestao4.kt` - Calcula o lucro potencial, prejuízo com itens vencidos e lucro real.
* **5ª Questão**: `AFQuestao5.kt` - Simula a transferência de 10 itens para o carrinho e seu retorno ao estoque.
* **6ª Questão**: `AFQuestao6.kt` - Distribui itens válidos e inválidos para dois carrinhos diferentes (Carrinho A e B).

## Tecnologias Utilizadas

* **Linguagem**: Kotlin
* **Ambiente de Execução**: JVM
* **Gerenciador de Build**: Gradle

---
*Este projeto foi desenvolvido para fins acadêmicos.*
