class Missao {

    var nome: String = ""
        private set

    var descricao: String = ""
        private set

    var nivelDificuldade: Int = 0
        private set

    fun setNome(nome: String) {
        if (nome.length >= 3) {
            this.nome = nome
        }
    }

    fun setDescricao(desc: String) {
        if (desc.length >= 10) {
            this.descricao = desc
        }
    }

    fun setNivelDificuldade(dificuldade: Int) {
        if (dificuldade > 0) {
            this.nivelDificuldade = dificuldade
        }
    }
}