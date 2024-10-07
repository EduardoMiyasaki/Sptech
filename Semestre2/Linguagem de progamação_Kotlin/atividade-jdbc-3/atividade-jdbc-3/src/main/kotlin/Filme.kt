class Filme {

    var id:Int = 0

    var nome: String = ""
        private set

    var genero: String = ""
        private set

    var anoLancamento: Int = 0
    private set

    var duracao: Int = 0
    private set

    var alugado : Boolean = false
    private set

    fun setNome(nome: String) {
        if (nome.length >= 2) {
            this.nome = nome
        }
    }

        fun setGenero(genero: String){
            if(genero.length >= 2 ){
                this.genero = genero
            }
        }

    fun setAlugado(alugado: Boolean){
        this.alugado = alugado
    }

        fun setAnoLancamento(ano: Int){
            if(ano >= 1895){
                this.anoLancamento = ano
            }
        }

        fun setDuracao(duracao: Int){
            if (duracao >= 15){
                this.duracao = duracao
            }
        }

    fun converterDuracaoEmHoras(): String{
        var horas = duracao / 60
        var minutos = duracao % 60
        return "${"%02d".format(horas)}:${"%02d".format(minutos)}"
    }

    fun descrever(): String{
        return """
         Id: ${id}
        Nome do Filme: ${nome}
        Gênero do Filme: ${genero}
        Ano de Lançamento: ${anoLancamento}
        Duração: ${converterDuracaoEmHoras()}
        Alugado: ${if (alugado) "Sim" else "Não"}
        """.trimIndent()
    }



}