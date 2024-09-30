class Carro {

    // private antes do var engloba get e set

    // criar vários set é uma boa prática,
    // pois podemos mudar a regra de acordo com a necessidade

    private var id: Int = 0;

    var cor: String = ""
        private set
    // var cor : String = "";
    // private set
    // esse jeito é melhor pois não precisa escrever o get no kotlin :)

    var nome: String = ""
        private set

    var fabricante: String = ""
        private set

    var potencia: Int = 0
        private set

    fun setNome(nome: String) {
        if (nome.length > 2) {
            this.nome = nome
        } else println("Valor incorreto! Digite mais de 3 caracteres")
    }

    fun setarNome(nome: String) {
        if (nome.isBlank()) {
        }
        this.nome = nome
    }


    fun setCor(cor: String) {
        if (cor.length > 3) {
            this.cor = cor;
        }
    }

    fun setFabricante(fabricante: String) {
        if (fabricante.length > 3) {
            this.fabricante = fabricante;
        } else println("Valor incorreto! Digite mais de 3 caracteres")
    }

    fun setPotencia(potencia: Int) {
        if (potencia > 0) {
            this.potencia = potencia;
        } else println("Valor incorreto! Potência tem que ser maior que 0");
    }

    fun mostrarCarro(): String {
        return """
            Nome: ${this.nome}
            Fabricante: ${this.fabricante}
            Potência: ${this.potencia}
        """.trimIndent();
    }
}