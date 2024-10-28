package pt3

fun main() {

    val animal = Animal()
    animal.nome = "Desconhecido"
    println(animal.reproduzirSom())

    println("--------------------------Cachorro---------------------")

    val cachorro = Cachorro()
    cachorro.nome = "Marley"
    println(cachorro.reproduzirSom())

    println("--------------------------Gato---------------------")

    val gato = Gato()
    gato.nome = "Bob"
    println(gato.reproduzirSom())


}