import com.github.javafaker.Faker
import java.util.*

fun main() {

    val snNumero = Scanner(System.`in`)
    val faker = Faker(Locale("pt-br"))

    print("Digite um número:")
    val numero = snNumero.nextInt();

    // Debug = adicionar um ponto de parada para verificar se está funcionando
    if (numero >= 10) {
        print(faker.address().city())
    }

    while (true){

        println("""
            1 - > Adicionar nova pessoa
            2 -> sair
        """.trimIndent())

        val opcaoEscolhida = snNumero.nextInt();

        when(opcaoEscolhida){
            1 -> println(faker.name().name())
            else -> break
        }
    }
}