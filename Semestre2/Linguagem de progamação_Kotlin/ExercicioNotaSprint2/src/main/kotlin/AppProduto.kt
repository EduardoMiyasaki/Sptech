import java.util.Scanner

fun main() {

    val snTexto = Scanner(System.`in`);
    val snNumero = Scanner(System.`in`);

    val produto1 = Produto();

    print("Informe o nome do produto:")
    produto1.nome = snTexto.nextLine();

    var contador = 1
    while (contador == 1) {
        println(
            """
            Informe se é brinde
            1 - É Brinde
            2 - Não é brinde
        """.trimIndent()
        )
        val opcaoEscolhida = snNumero.nextInt();

        when (opcaoEscolhida) {
            1 -> produto1.brinde = true
            else -> produto1.brinde = false
        }
        contador++;
    }
    if (!produto1.brinde) {
        print("Informe o preço do produto:")
        produto1.preco = snNumero.nextDouble();
    }

    println("O produto ${produto1.nome} custa R$ ${String.format("%.2f", produto1.preco)}")
}
