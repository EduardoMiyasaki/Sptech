import java.util.*

fun main() {

    for (n in 1..3) {

        val nome = getNome("Digite seu $n° nome: ");
        val idade = getIdade("Digite sua $n° idade: ");
        mensagemFinal(nome, idade);
    }
}

fun getNome(texto: String): String {

    val teclado = Scanner(System.`in`)
    print(texto)
    return teclado.nextLine();
}

fun getIdade(texto: String): Int {

    val teclado = Scanner(System.`in`)
    print(texto)
    return teclado.nextInt();
}

fun mensagemFinal(nome: String, idade: Int) {
    println("Olá $nome! Sua idade é $idade anos")
}