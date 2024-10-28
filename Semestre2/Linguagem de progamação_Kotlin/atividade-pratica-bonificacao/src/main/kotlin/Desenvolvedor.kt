class Desenvolvedor: Funcionario() {

    override fun calcularBonificacao(): Double {
        return salario * 0.15
    }
}