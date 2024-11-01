class Desenvolvedor: Funcionario() {

    override fun calcularBonificacao(): Double {
        return salario * 0.15
    }

    var projeto = projetoEnum.SEM_PROJETO

}