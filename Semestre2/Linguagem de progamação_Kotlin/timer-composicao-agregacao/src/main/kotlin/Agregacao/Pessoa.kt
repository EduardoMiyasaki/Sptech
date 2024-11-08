package Agregacao

open class Pessoa {

    var nome: String = ""
        private set

    var cpf: String = ""
        private set

    open fun apresentar(): String{
        return "Olá, Meu nome é ${nome}"
    }

    fun setNome(nome: String){
        if(nome.length > 2){
            this.nome = nome
        }
    }

    fun setCpf(cpf: String){
        if(cpf.length == 11){
            this.cpf = cpf
        }
    }
}