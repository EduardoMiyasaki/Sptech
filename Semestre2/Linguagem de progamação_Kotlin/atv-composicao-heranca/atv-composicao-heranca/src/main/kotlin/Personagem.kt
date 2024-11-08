class Personagem : Pessoa() {

    private val habilidades = mutableListOf<Habilidade>()

    fun adicionarHabilidade(habilidade: Habilidade) {
        habilidades.add(habilidade)
    }

    fun listarHabilidades(): List<Habilidade> {
        return habilidades
    }

    fun removerHabilidade(nomeHabilidade: String) {
        val listaHabilidades = listarHabilidades()

        // habilidades.removeIf{it.nome == nomeHabilidade}

        for (i in 0 ..habilidades.size - 1) {
            if (listaHabilidades[i].nome == nomeHabilidade) {
                habilidades.removeAt(i)
            }
        }
    }
}