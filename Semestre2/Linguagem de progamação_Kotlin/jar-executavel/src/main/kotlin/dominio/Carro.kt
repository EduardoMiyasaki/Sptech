package dominio

class Carro {

        // o id nunca pode ser private, se não, não da para acessar
        var id: Int = 0;
        var nome: String = ""
         private set

    var vendido: Boolean = false
    private set

    fun setNome(nome: String){
        if(nome.length > 3 ){
            this.nome = nome;
        }
    }

    fun setVendido(novoValor: Boolean){
        this.vendido = novoValor;
    }



}