import java.util.Scanner

fun main() {

    var teclado = Scanner(System.`in`);

    print("Informe seu nome:")
    var nome = teclado.nextLine();

    print("Informe sua idade:")
    var idade = teclado.nextInt();

    if (idade < 16) {
        println("Você não pode votar ainda")
    } else {
        println("Você já pode votar");
    }


}