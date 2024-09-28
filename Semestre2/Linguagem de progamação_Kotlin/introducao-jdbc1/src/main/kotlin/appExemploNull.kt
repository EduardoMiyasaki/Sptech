import java.util.Scanner

fun main(){

    val snTexto = Scanner(System.`in`);
    val snNumero = Scanner(System.`in`);

    // esse interrogação apos o tipo do dado significa que pode vir nulo
    var nome: String? = null;

    // retorna se tiver valor e se for nulo retorna nome não definido
    val resposta: String = nome?: "Nome não definido";

    var resposta2: String = "";
    if(nome != null){
        resposta2 = nome;
    }
    else resposta2 = "Nome não definido"

    println(resposta2)

    /*
    Se nome for nulo irá printar uma excessão

    if(nome.isNullOrBlank()){
        print(nome!!)
    }

     */

    var email : String? = null
    print("Digite seu email:")
    email = snTexto.nextLine()
    println(email)

    print("Digite um número:")
    var numero : Int? = readln().toInt()
    println(numero)

    print("Digite outro número:")
    var numero2 = readln().toIntOrNull() ?: 0
    println(numero2)

    // Música é do tipo musica mas no momento está sem valor
    val musica1 : Musica? = null;
    val musica2 = Musica();
    // println(musica1!!.nome)

    if(musica1 != null){
        println("Nome : ${musica1.nome}")
        println("Produtor: ${musica1.produtor ?: "Produtor nulo"}")
    }
    else println("Música não existe")

    if(musica2 != null){
        if(musica2.produtor.isNullOrBlank()){
            println("Produtor nulo")
        }
    }

}