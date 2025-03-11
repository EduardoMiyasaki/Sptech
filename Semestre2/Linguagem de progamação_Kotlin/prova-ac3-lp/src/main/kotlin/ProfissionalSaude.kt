abstract class ProfissionalSaude {

    var nome: String = ""
        private set

    var nivelExperiencia: Int = 0
        private set

    abstract fun realizarAtendimento(): String

    abstract fun detalhar(): String

    fun verificarStatus(): String {
        return "Profissional $nome tem nível de experiência $nivelExperiencia."
    }

    fun setNome(nome: String) {
        if (nome.length >= 3) {
            this.nome = nome
        }
    }

    fun setNivelExperiencia(nivelExperiencia: Int) {
        if (nivelExperiencia > 0) {
            this.nivelExperiencia = nivelExperiencia

        }
    }
}