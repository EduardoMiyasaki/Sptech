package pt2

class Aluno : Pessoa() {

    var RA: String = "";

    fun estudar(): String{
        return "Estudando..."
    }

    override fun andar(): String {
        return "Correndo para a reunião"
    }
}