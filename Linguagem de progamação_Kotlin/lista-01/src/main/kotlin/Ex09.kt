import java.util.*

fun main(){

    val teclado = Scanner(System.`in`);

    print("Informe uma frase de pensamento positivo:")
    val frase = teclado.nextLine();

    print("Informe quantas vezes vai aparecer:");
    val vezes = teclado.nextInt();

    for (n in 1 .. vezes){
        println(frase);
    }
}