open class Aventureiro {

    var nome: String = ""
        private set

    var energia: Int = 0
        private set

    fun descansar(){
        energia += 10
    }

    fun status(): String{
        return "Aventureiro $nome tem $energia de energia."
    }


    fun setNome(nome: String){
        if(nome.length >=3 ){
            this.nome = nome
        }
    }

    fun setEnergia(energia: Int){
        if(energia > 0){
            this.energia = energia
        }
    }
}