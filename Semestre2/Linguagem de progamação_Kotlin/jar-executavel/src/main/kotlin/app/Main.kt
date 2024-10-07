package app

import dominio.Carro
import repository.CarroRepository
import java.text.BreakIterator
import java.util.Scanner

fun main(){

    val snNumero = Scanner(System.`in`);
    val snTexto = Scanner(System.`in`)

    val repository = CarroRepository();
    repository.configurar(); //  inicilizando o jdbc Template
    repository.criarTabela(); // usando o jdbc para criar uma tabela

    while(true){

     println("""
        1 - Inserir carro
        2 - Buscar por id
        3 - Vender
        4 - Sair
        
        Informe a sua opção:
     """)
        val opcaoEscolhida = snNumero.nextInt();

        when(opcaoEscolhida) {

            1 -> {
                val carro2 = Carro();
                print("Digite o nome do carro:")
                carro2.setNome(snTexto.nextLine());

                repository.adicionarCarro(carro2)
            }

            2 -> {
                print("Informe o ID do carro que você procura:")
               val carroEncontrado = repository.listarCarroPorId(snNumero.nextInt())
                println("""
                    Nome: ${carroEncontrado.nome}
                    Vendido ${if (carroEncontrado.vendido) "Sim " else "Não"} 
                """.trimIndent())
            }

            3 -> {
                println("Informe o ID do carro que você quer vender:")
                repository.venderCarro(snNumero.nextInt())

            }

            4 -> break
            else -> break
        }
    }
}