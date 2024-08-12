import java.util.Scanner

fun main() {

    val nome = perguntaNome("Digite o primero Nome:")
    val nome2 = perguntaNome("Digite o segundo Nome:")

    exibirMensagem(nome, nome2);
}

fun perguntaNome(pergunta: String): String {

    val teclado = Scanner(System.`in`);

    print(pergunta);
    val nome: String = teclado.nextLine();

    return nome;
}

fun exibirMensagem(nome: String, nome1: String) {

    println("Seu nome é $nome e $nome1");
}

// todos os métodos tem que ter responsabilidade única
// Exemplo: um método não pode ser getter e setter ao mesmo tempo