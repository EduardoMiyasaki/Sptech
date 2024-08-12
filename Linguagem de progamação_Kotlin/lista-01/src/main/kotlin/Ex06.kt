import java.util.Scanner

fun main(){

    val snTexto = Scanner(System.`in`);
    val snNumero = Scanner(System.`in`);

    print("Informe uma linha de Ônibus:")
    val nome = snTexto.nextLine();

    print("Informe o maior tempo de volta:")
    val tempoMax = snNumero.nextInt();

    print("Informe o menor tempo de volta:")
    val tempoMin = snNumero.nextInt();

    print("A linha $nome leva em média ${tempoMax /  tempoMin} minutos")
}