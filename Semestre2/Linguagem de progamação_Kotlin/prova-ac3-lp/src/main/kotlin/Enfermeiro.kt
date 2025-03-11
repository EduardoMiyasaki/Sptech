class Enfermeiro : ProfissionalSaude(), Especialista {

    var registroEstagio: String = ""
        private set

    fun setRegistroEstagio(estagio: String) {
        if (estagio.length == 8) {
            this.registroEstagio = estagio

        }
    }

    override fun realizarAtendimento(): String {
        return "O enfermeiro $nome, registro de estágio $registroEstagio, realizou um atendimento básico com cuidado."
    }

    override fun detalhar(): String {
        return "Enfermeiro $nome com registro de estágio $registroEstagio e nível de experiência $nivelExperiencia."
    }

    override fun especialidade(): String {
        return "Especialidade de enfermagem: Auxiliar."
    }

    override fun tratarPaciente(): String {
        return "O enfermeiro $nome realizou o tratamento do paciente com técnicas de enfermagem especializadas."
    }
}