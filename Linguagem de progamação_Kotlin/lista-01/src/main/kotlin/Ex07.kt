import java.util.Scanner

fun main(){

    val snNumero = Scanner(System.`in`);

    print("Informe sua altura:")
    val altura = snNumero.nextDouble();

    when{
        altura < 1.8 -> println("Não pode jogar basquete")
        else -> println("Você pode jogar basquete")
    }
}