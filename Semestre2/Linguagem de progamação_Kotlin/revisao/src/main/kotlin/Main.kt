import java.util.Scanner
import java.lang.Math
import kotlin.math.pow

fun main() {

    val soma: Int = 10 + 10;
    println("Valor da soma: $soma");
    println("Valor da soma: ${10 + 10}");

    val subtracao: Int = 10 - 5;
    println("Valor da subtracao : $subtracao");

    val divisao: Int = 10 / 2;
    println("Valor da divisao: $divisao");

    val multiplicacao: Int = 10 * 2;
    println("Valor da multiplicacao: $multiplicacao");

    val potencia: Double = 3.3.pow(2);
    println("O valor da potência é: ${"%.2f".format(potencia)}"); // pega a variável e coloca 2 casas decimais ao exibir

    // println(Math.round(potencia))

    val snTexto = Scanner(System.`in`);
    val snNumero = Scanner(System.`in`);

    print("Digite seu nome:")
    val nome = snTexto.nextLine();

    println("Bem vindo, $nome!");

    print("Digite um número: ");
    val numero = snNumero.nextInt();

    println("O número que você digitou foi $numero");

    // When é o switch case
    when (numero) {
        1 -> println("É 1");
        2 -> println("É 2");
        3 -> println("É 3");
        in 4..6 -> println("É do número 4 ao 6");
        7 , 8 ,9 -> println("É 7 , 8 ou 9")
        else -> println("Número inválido")
    }

    when{
        numero < 1 -> println("É menor que 1");
        numero == 1 -> println("É 1");
        numero in 4..6 -> println("É do número 4 ao 6");
        numero > 6 -> println("Maior que 6");
    }

}
