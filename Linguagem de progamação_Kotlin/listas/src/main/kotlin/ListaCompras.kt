import java.util.Scanner

fun main() {

    // Declarando uma lista sem valores
    val listaCompras: MutableList<String> = mutableListOf("Arroz");

    val snTexto = Scanner(System.`in`);
    val snNumero = Scanner(System.`in`);

    while (true) {

        println("Bem vindo!!! Escolha as seguintes opções");
        println("1 - Adicionar novo produto");
        println("2 - Remover produto");
        println("3 - Atualizar produto");
        println("4 - Todos os produtos");
        println("5 - Sair");
        print("Escolha uma opção:");

        // Existe esse jeito de chamar um 'Scanner'
        // val opcaoEscolhida = readln().toInt();
        val opcaoEscolhida = snNumero.nextInt();

        when (opcaoEscolhida) {
            1 -> {
                // adicionando um produto
                print("Digite o nome do produto:")
                val novoProduto = snTexto.nextLine();
                listaCompras.add(novoProduto)
            }

            2 -> {
                // removendo um produto
                println("Lista de produtos $listaCompras");
                println("Digite a posição do produto a ser removido")
                val posicao = snNumero.nextInt()
                if(listaCompras.indices.contains(posicao)){

                listaCompras.removeAt(posicao - 1);
                }
                else{
                    println("Produto não existe")
                }
            }

            3 -> {
                // atualizando um produtos
                println("Lista dos produtos $listaCompras")
                println("Informe a posição que você deseja atualizar")
                val posicaoAtt = snNumero.nextInt();
                println("Informe o novo produto:")
                val produtoAtt = snTexto.nextLine();
                listaCompras.set(posicaoAtt - 1, produtoAtt);
                println("Produto atualizado")
            }

            4 -> {
                // mostrando a lista
                println("Lista de compras: $listaCompras")

            }

            5 -> break
            // parando o while
            else -> println("Opção inválida")
        }
                Thread.sleep(50004)
    }
}
