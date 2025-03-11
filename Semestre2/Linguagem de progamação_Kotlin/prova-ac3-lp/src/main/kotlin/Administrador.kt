class Administrador : ProfissionalSaude() {

    var nivelSupervisao: Int = 0
        private set

    fun setNivelSupervisao(nivel: Int) {
        if (nivel > 0) {
            this.nivelSupervisao = nivel
        }
    }

    override fun realizarAtendimento(): String {
        return "O administrador $nome supervisionou um atendimento no nível $nivelSupervisao."
    }

    override fun detalhar(): String {
        return "Administrador $nome com nível de supervisão $nivelSupervisao e nível de experiência $nivelExperiencia."
    }
}