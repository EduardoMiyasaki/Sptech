open abstract class Pessoa(var nome: String , var idade : Int, var sexo : String){

    fun exibirInformaçoes(){
        println("Nome: $nome");
        println("Idade: $idade");
        println("Sexo: $sexo");
    }
}