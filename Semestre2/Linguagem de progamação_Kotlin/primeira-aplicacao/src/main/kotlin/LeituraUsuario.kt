import java.util.Scanner
import javax.swing.JOptionPane

fun main() {

    val snString = Scanner(System.`in`);
    val snNumero = Scanner(System.`in`);

    print("Digite seu nome:");
    var nome = snString.nextLine();

    print("digite sua idade:");
    var idade = snNumero.nextInt();

    print("Digite seu email:");
    val email = snString.nextLine();

  /*  println("Digite sua renda mensal");
    var renda = snNumero.nextDouble();

   */

    println("Seu nome é $nome");
    println("Seu email é $email");
    println("você tem $idade anos");
   // println("Sua renda é $renda");

}
