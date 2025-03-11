package interfaces

class Gato : InterfaceGato {

    override fun andar() {
        println("Andando silenciosamente")
    }

    override fun miar() {
        println("Miau")
    }
}