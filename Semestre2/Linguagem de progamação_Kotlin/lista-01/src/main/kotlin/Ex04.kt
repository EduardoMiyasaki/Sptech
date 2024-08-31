import java.util.Scanner

fun main() {

    var teclado = Scanner(System.`in`);

    print("Informe sua quantidade de gols:")
    var qtdGols = teclado.nextInt();

    when {
        qtdGols == 0 -> println("Sem pontaria");
        qtdGols in 1..2 -> println("Pontaria meia boca");
        qtdGols in 3..5 -> println("Dá pro gasto");
        qtdGols > 5 -> println("Artilheiro");
    }
}