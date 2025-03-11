package classe_abstrata// Classe abstrata é 'open' por default

abstract class Animal {

    var nome: String = ""

    open fun respirar(){
        println("Anima está respirando")
    }

    abstract fun Comer()

    abstract fun nascer()
}