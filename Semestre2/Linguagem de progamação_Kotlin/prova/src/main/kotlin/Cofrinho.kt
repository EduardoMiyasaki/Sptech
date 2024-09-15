class Cofrinho {

    var objetivo: String = "";
    var saldo: Double = 0.0;
    var meta: Double = 0.0;
    var depositos: Int = 0;

    public fun depositar(valorDeposito: Double) {
        if (valorDeposito > 0) {
            saldo = saldo + valorDeposito;
            depositos++;
        }
    }

    public fun retirar(valorRetirada: Double) {
        if (valorRetirada > 0 && valorRetirada <= saldo) {
            saldo = saldo - valorRetirada;
        }
    }

    public fun porcentagemAteMeta(): Double {

        var porcentagem = (saldo / meta) * 100
        return porcentagem;
    }

    public fun descrever(): String {

        val porcentagem = porcentagemAteMeta()

        if (porcentagem < 100) {
            return """
                O cofrinho de objetivo ${objetivo} está com saldo R$ ${saldo} 
             , estando a ${porcentagem}% da meta de R$ ${meta}
            """.trimIndent()
        }
        return """
            O cofrinho de objetivo ${objetivo} está com R$${saldo} de saldo. Já chegou na meta, estando em ${porcentagem}% dela!
        """.trimIndent()
    }
}