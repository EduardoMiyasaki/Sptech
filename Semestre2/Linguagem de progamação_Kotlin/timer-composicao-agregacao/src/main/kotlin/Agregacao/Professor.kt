package Agregacao

class Professor: Pessoa() {

    var lattes: String = "";

    override fun apresentar(): String {
        return "Olá, eu sou o professor $nome"
    }
}