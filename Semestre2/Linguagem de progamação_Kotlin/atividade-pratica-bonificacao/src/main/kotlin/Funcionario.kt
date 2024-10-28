open class Funcionario {

    var nome: String = "";
    var salario: Double = 0.0;

    open fun calcularBonificacao(): Double {
        val bonificacao = salario * 0.1;
        return bonificacao;
    }

}