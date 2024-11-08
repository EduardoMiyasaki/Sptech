package Agregacao

class Escola {

    var nome: String = ""
        private set

    private val professores = mutableListOf<Professor>()

    fun adicionarProfessor(professor: Professor) {
        professores.add(professor)
    }

    fun listarProfessores(): List<Professor> {
        return professores
    }

    fun setNome(nome: String) {
        if (nome.length > 2) {
            this.nome = nome

        }
    }
}