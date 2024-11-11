class Explorador : Aventureiro() {

    var nivelExperiencia: Int = 0
        private set

    // Agregação da Classe Missoes

    private val missoes = mutableListOf<Missao>()

    fun inscreverEmMissao(missao: Missao) {
        missoes.add(missao)
    }

    fun listarMissoes(): List<Missao> {
        return missoes
    }

    fun abandonarMissao(nomeMissao: String) {
        missoes.removeIf { it.nome == nomeMissao }
    }

    fun ganharExperiencia(pontos: Int) {
        this.nivelExperiencia += pontos;
    }

    fun dificuldadeMediaMissoes(): Int {

        // Jeito do reis

        if (missoes.isEmpty()) return 0

//        var soma = 0
//        missoes.forEach {
//            soma += it.nivelDificuldade
//        }

        val soma = missoes.sumOf { it.nivelDificuldade }

        return soma / missoes.size

        // Meu jeito

        //var somaDificuldade = 0

//        if (missoes.isEmpty()) return 0

//        for (i in 0..missoes.size) {
//            somaDificuldade += missoes[i].nivelDificuldade
//        }

//        val media = somaDificuldade / missoes.size
//        return media

    }
}