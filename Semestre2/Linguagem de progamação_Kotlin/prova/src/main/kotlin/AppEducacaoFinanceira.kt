import java.util.Scanner

fun main() {

    val snTexto = Scanner(System.`in`);
    val snNumero = Scanner(System.`in`);

    val cofrinho1 = Cofrinho();

    print("Informe qual é o seu objetivo com esse cofrinho?")
    cofrinho1.objetivo = snTexto.nextLine();

    print("Qual é a sua meta com esse cofrinho:")
    cofrinho1.meta = snNumero.nextDouble();

    while (true) {
        println("------- Cofrinho --------")
        println("1 - Depositar no cofre");
        println("2 - Retirar do cofre")
        println("3 - Detalhes");
        println("4 - sair")

        val opcaoEscolhida = snNumero.nextInt();
        when (opcaoEscolhida) {
            1 -> {
                print("Informe o valor do depósito:");
                val deposito = snNumero.nextDouble();
                cofrinho1.depositar(deposito);
            }

            2 -> {
                print("Quanto você quer retirar:");
                val retirada = snNumero.nextDouble();
                cofrinho1.retirar(retirada);
            }

            3 -> {
                println(cofrinho1.descrever())
            }

            4 -> break;
            else -> println("Opção inválida")
        }
    }

}