class Medico : ProfissionalSaude(), Especialista {

    var crm: String = ""
        private set

    var areaEspecialidade: String = ""
        private set

    fun setCRM(crm: String) {
        if (crm.length == 6) {
            this.crm = crm
        }
    }

    fun setAreaEspecialidade(area: String) {
        if (area.length >= 5) {
            this.areaEspecialidade = area
        }
    }


    override fun realizarAtendimento(): String {
        return "O médico $nome, especialista em $areaEspecialidade, CRM $crm, realizou um atendimento com sucesso."
    }

    override fun detalhar(): String {
        return "Médico $nome com CRM $crm, especialista em $areaEspecialidade, e nível de experiência $nivelExperiencia."
    }

    override fun especialidade(): String {
        return "Especialidade médica: $areaEspecialidade."
    }

    override fun tratarPaciente(): String {
        return "O médico $nome, especialista em $areaEspecialidade, tratou o paciente utilizando seus conhecimentos."
    }
}