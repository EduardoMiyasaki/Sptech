import java.util.Scanner
import kotlin.math.pow

fun main() {

    var snTexto = Scanner(System.`in`);
    var snNumero = Scanner(System.`in`);


    print("Digite seu nome:");
    val nome = snTexto.nextLine();

    print("Digite seu peso:");
    val peso = snNumero.nextFloat();

    print("Digite sua altura:");
    val altura = snNumero.nextFloat();

    val imc = peso / (altura.pow(2));

    println("Olá,$nome! Seu IMC é %.2f".format(imc));
}
