import java.util.Scanner

fun main(){

    val teclado = Scanner(System.`in`);

    print("Digite seu nome:")
    val nome = teclado.nextLine();

    print("Digite seu bairro:")
    val bairro = teclado.nextLine();

    println("Seu nome é $nome e mora no bairro $bairro")
}