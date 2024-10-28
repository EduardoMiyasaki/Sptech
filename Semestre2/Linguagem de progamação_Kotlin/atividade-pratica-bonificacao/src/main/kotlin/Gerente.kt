class Gerente: Funcionario() {

    override fun calcularBonificacao(): Double {
        return salario * 0.2;
    }
}