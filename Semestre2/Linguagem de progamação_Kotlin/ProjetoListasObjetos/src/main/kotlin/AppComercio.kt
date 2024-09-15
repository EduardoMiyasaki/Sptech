import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Scanner

fun main() {

    val snNumero = Scanner(System.`in`);
    val snTexto = Scanner(System.`in`);

    val bancoDeDados = mutableListOf<Produto>();

    println("Bem vindo ao gerenciamento de produtos")

    while (true) {
        println(
            """
            ----- Produtos -----
            1 - Adicionar produto
            2 - Buscar produto por indice (Começa do 0)
            3 - Remover produto por indice (Começa do 0)
            4 - Verificar validade por indice
            5 - Sair 
        """.trimIndent()
        )

        println("Informe a sua opção:")
        val opcaoEscolhida = snNumero.nextInt();

        when (opcaoEscolhida) {
            1 -> {
                val novoProduto = Produto();

                println("Informe qual é o nome do produto:")
                novoProduto.nome = snTexto.nextLine();

                println("Informe o preço deste produto:")
                novoProduto.preco = snNumero.nextDouble();

                println("Informe a data de validade dd/mm/yyyy:")
                val dataTexto = snTexto.nextLine()

                val formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy")

                val dataFormatada = LocalDate.parse(dataTexto, formatador);
                novoProduto.validade = dataFormatada;

                bancoDeDados.add(novoProduto)
            }

            2 -> {
                print("Informe em qual indice está o produto:")
                val index = snNumero.nextInt();

                if (index >= 0 && index <= bancoDeDados.size) {

                    val formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy")
                    val produtoEncontrado = bancoDeDados[index]
                    println("O produto com nome ${produtoEncontrado.nome} com preço de ${produtoEncontrado.preco} tem validade ${produtoEncontrado.validade.format(formatador)}")

                }
                else print("Produto não encontrado")
            }

            3 -> {

                print("Informe o indice do produto que você deseja remover")

                val index = snNumero.nextInt();

                if (index >= 0 && index <= bancoDeDados.size) {
                    bancoDeDados.removeAt(index)
                    println("O produto foi removido")
                }
                else {
                    print("Produto não encontrado")
                }
            }

            4 -> {
                print("Informe o indice do produto que você deseja ver a validade:")
                val index = snNumero.nextInt()

                val produtoEscolhido = bancoDeDados[index]
                println("o ${produtoEscolhido.nome} tem a data de validade até ${produtoEscolhido.validade}")
                println(produtoEscolhido.descrever())
            }

            5 -> break
            else -> println("Opção inválida");
        }
        Thread.sleep(1000);
    }
}