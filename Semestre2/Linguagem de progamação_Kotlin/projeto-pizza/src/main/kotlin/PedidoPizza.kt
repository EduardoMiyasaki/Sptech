class PedidoPizza {

    var sabor: String = "";
    var preco: Double = 0.0
    var qtdAmigos: Int = 0

    val listaCupons = mutableListOf<String>();

    public fun descrever(): String {

        return """
             "Pedido de pizza de ${this.sabor}
              que custa ${String.format("%.2f", preco)}R$"
        """.trimIndent()

    }

    public fun validarCupom(cupom: String) {

        if (cupom == "#amopizza") {

            this.preco = preco * 0.9;
        }
        listaCupons.add(cupom);
    }

    public fun obterValorPorAmigo(): Double{

        var valorDividido: Double = this.preco / this.qtdAmigos;

        return valorDividido;
    }

    public fun obterCuponsUsados() : String {

        var cupons: String = ""

        for (cupomDaVez in listaCupons){
            cupons = "\n ${cupomDaVez}"
        }

        return cupons;
    }

    public fun mostrarPreco(){
        println("O preço atual do pedido é ${this.preco}")
    }
}