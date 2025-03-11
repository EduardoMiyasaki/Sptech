package interfaces

 // É possível herdar de uma classe e implementar uma interface
class Goleiro: JogadorFutebol, Pessoa() {

    override fun correr() {
        println("Correndo")
    }

    override fun chutar() {
        println("Chutando")
    }

    override fun cair() {
        println("Caindo")
    }

    override fun pegarComMao() {
        println("Defesa")
    }

    override fun coletiva(texto: String): String {
       return "goleiro falando na coletiva: $texto"
    }
}