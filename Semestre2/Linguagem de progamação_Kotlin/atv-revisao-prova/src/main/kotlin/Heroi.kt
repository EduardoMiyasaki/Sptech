abstract class Heroi {

    var nome: String = ""
        private set
    var poderPrincipal: String = ""
        private set
    var nivelEnergia: Int = 0
        private set

    abstract fun usarPoder(): String;

    abstract fun descrever(): String;

    fun recuperarEnergia(): String {

        nivelEnergia += 20;
        return "O heroi $nome está recuperando energia e agora tem $nivelEnergia pontos."
    }

    fun setNome(nome: String) {
        if (nome.length >= 3) {
            this.nome = nome
        }
    }

    fun setPoderPrincipal(poder: String) {
        if (poder.length >= 10) {
            this.poderPrincipal = poder
        }
    }

    fun setNivelEnergia(energia: Int) {
        if (energia > 0) {
            this.nivelEnergia = energia
        }
    }
}