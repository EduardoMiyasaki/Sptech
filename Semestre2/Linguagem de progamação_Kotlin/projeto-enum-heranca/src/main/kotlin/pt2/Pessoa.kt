package pt2

// Quando você colocar open você está declarando que ela pode ser herdada
// tem que colocar em tudo atributos e metódos

open class Pessoa {
    var nome: String = ""

    open fun andar(): String {
        return "Andando"
    }
}