import java.util.Scanner

fun main() {

    val teclado = Scanner(System.`in`);

    print("Informe seu salário:")
    val salario = teclado.nextFloat();

    when (salario) {
        in 0.0..1000.0 -> println("Classe C");
        in 1000.01..2000.0 -> println("Classe B");
        in 2000.01 .. 5000.0 -> println("Classe A");
        else -> println("Classe AA")

    }
}