import java.util.Scanner

fun main() {

    val snTexto = Scanner(System.`in`);
    val snNumero = Scanner(System.`in`);

    val relogio1 = Relogio();

    relogio1.modelo = "Tommy"
    relogio1.preco = 570.0;
    relogio1.horas = 24
    relogio1.minutos = 28
    relogio1.segundos = 30

    println(relogio1.verHora())
    println(relogio1.validar())
    println(relogio1.verHora())

    val relogio2 = Relogio();

    print("Infome o modelo do Relógio:")
    val modelo = snTexto.nextLine();
    relogio2.modelo = modelo;

    print("Infome o preço do Relógio:")
    val preco = snNumero.nextDouble();
    relogio2.preco = preco;

    print("Infome as horas do Relógio:")
    relogio2.horas = snNumero.nextInt();

    print("Infome os minutos do Relógio:")
    relogio2.minutos = snNumero.nextInt();

    print("Infome os segundos do Relógio:")
    val segundos = snNumero.nextInt();
    relogio2.segundos = segundos;

    println(relogio2.validar())
    println(relogio2.verHora())
    println("Hora no 2° Relógio ${relogio2.horas}")


}