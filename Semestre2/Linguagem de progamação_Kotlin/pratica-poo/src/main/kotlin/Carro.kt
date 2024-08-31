class Carro(var marca: String, var modelo: String, var velocidade: Int = 0, var ligado: Boolean = false) {

    // quando for instanciar um carro é necessário passar a marca e modelo pois no construtor não passei nenhum valor para esses dois, porém não preciso passar velocidade nem se  está ligado

    val historicoDeAcao = mutableListOf<String>()

    private var rodas: Int = 0;
    private var portas: Int = 0;
    private var cor: String = "";

    public fun ligar() {

        this.ligado = true;
        println("Ligando carro")
        historicoDeAcao.add("Ligou o carro")
    }

    public fun desligar() {

        this.ligado = false
        println("Desligando carro")
        historicoDeAcao.add("Desligou o carro")
    }

    public fun andar() {
        println("Seu carro está andando a ${this.velocidade} m/s");
    }

    public fun acelerar() {
        if (ligado) {

            if (velocidade >= 120) {
                println("Velocidade igual ou acima 120")
            } else {
                println("Acelerando")
                this.velocidade += 10;
            }
            historicoDeAcao.add("Acelerou o carro")
        } else {
            println("Carro está desligado")
        }
    }

    public fun frear() {
        if (ligado) {
            if (this.velocidade <= 0) {
                println("Velocidade já é 0")
            } else {
                this.velocidade -= 10;
            }
            historicoDeAcao.add("Freou1 o carro")
        } else {
            println("Carro desligado")
        }
    }

    fun descricao(): String {

        val textoLigado = if (ligado) {
            "ligado"
        } else {
            "desligado"
        }

        return """
           Marca : ${this.marca}
           Modelo : ${this.modelo}
           Ligado : $textoLigado
           Velocidade : ${this.velocidade}
       """.trimIndent()

        // .trimIndent = identação sem espaço na esquerda ou direta
    }

    public fun caixaPreta(): String {

        var acoes = "";

        // puxa o valor do vetor para dentro da variavel acaoDaVez
        for (acaoDaVez in historicoDeAcao) {
            acoes += "\n - $acaoDaVez"
        }

        /*for(index in 1..historicoDeAcao){
             acoes += "\n - ${historicoDeAcao[index - 1]}"
         }

         */


        return acoes
    }

    fun exibirVelocidadeComTexto(texto: String) {
        println()
        println("Texto da velocidade dinâmico  $texto");
    }
}