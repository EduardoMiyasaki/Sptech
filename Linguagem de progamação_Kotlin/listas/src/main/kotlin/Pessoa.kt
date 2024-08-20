class Pessoa(var nome : String , var idade : Int) {

    fun respirar(){
        println("Respirando...");
    }

    fun ola(){
        println("Olá!Meu nome é ${this.nome} e tenho ${this.idade} anos")
    }
}