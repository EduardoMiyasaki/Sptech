open class Pessoa {

    var nome: String = ""
        private set

    fun setNome(nome: String){
        if(nome.length >= 2){
            this.nome = nome
        }
    }

    fun apresentar(): String{
        return "Olá, meu nome é $nome."
    }
}