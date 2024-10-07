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
        4 - Listar todos os carros 
        5 - Sair
        
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
                var id = snNumero.nextInt()
                if(repository.existePorId(id)) {
                    val carroEncontrado = repository.listarCarroPorId(id)
                    println(
                        """
                    Nome: ${carroEncontrado.nome}
                    Vendido: ${if (carroEncontrado.vendido) "Sim " else "Não"} 
                """.trimIndent()
                    )
                }
                else println("ID não existe")
            }

            3 -> {
                println("Informe o ID do carro que você quer vender:")
                var id = snNumero.nextInt()
                if(repository.existePorId(id)) {
                    repository.venderCarro(id)
                } else println("ID não existe")
            }

            4 -> {

               val listaCarros = repository.listarCarros()
                for(carroDaVez in listaCarros){

                    println("ID do carro: ${carroDaVez.id}")
                    println("Nome do carro: ${carroDaVez.nome}")
                    println("Vendido: ${if(carroDaVez.vendido) "Sim" else "Não"}")
                    println("----------------------------------------------------")
                }
            }
            5 -> break
            else -> break

        }
    }
}