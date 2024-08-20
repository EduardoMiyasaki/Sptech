fun main() {

    // Val Pois você vai mudar o valor de dentro e não a estrutura da lista
    // Problema de do listOf que ela é imutável ou seja não consigo retirar ou adicionar valor
    val listaPaises = listOf("Brasil", "Alemanha", "Estados Unidos")

    println("Países: $listaPaises");
    println("Primeiro País: ${listaPaises.get(0)}");
    println("Primeiro País: ${listaPaises[0]}");

    val listaProdutos = mutableListOf<String>("Bolacha", "Macarrão");

    listaProdutos.add("Pão");
    listaProdutos.remove("Bolacha");
    listaProdutos.removeAt(0);

    println(listaProdutos)

    val listaInteirosDeclarativo: MutableList<Int>;
    // ou
    val listaInteirosDeclarativo2: MutableList<Int> = mutableListOf();

    val listaPessoas: MutableList<String> = mutableListOf("João", "Maria", "José")

    println("A primeira pessoa é ${listaPessoas.get(0)}");
    // Outro jeito
    println("A primeira pessoa é ${listaPessoas[0]}");
    // Outro jeito
    println("A primeira pessoa é ${listaPessoas.first()}");

    println("A última pessoa é ${listaPessoas.last()}");
    // ou
    println("A última pessoa é ${listaPessoas[listaPessoas.size - 1]}");

    // Comentários coloridos
    // FIXME:(Funciona mas tem que fazer alterações)


    if (listaPessoas.indices.contains(4)) {
        println("A quinta pessoa é ${listaPessoas[4]}")
    } else {
        println("Pessoa não existe")
    }

    println("Pessoas: $listaPessoas")
    println("A partir da segunda pessoa: ${listaPessoas.drop(1)}");
    println("A partir da penúltima pessoa: ${listaPessoas.dropLast(1)}");
    println("Sem o primero e a última pessoa é: ${listaPessoas.drop(1).dropLast(1)}");

    listaPessoas.add("Eduardo")
    listaPessoas.add("Fernando")
    listaPessoas.removeAt(0)
    println("Pessoas: $listaPessoas")

    listaPessoas[0] = "Mariahzinha";
    listaPessoas.set(0, "Mariahzinha");

    // atualizar pelo valor do elemento

    val posicaoMaria = listaPessoas.indexOf("Maria");

    if(posicaoMaria != -1){
        listaPessoas[posicaoMaria] = "Mariazinha";
    }
}