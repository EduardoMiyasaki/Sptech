open abstract class Pessoa {

    var nome: String = "";
    private var idade: Int = 0;
    private var sexo: String = "";

    open fun status(){
        println("Meu nome é $nome, tenho $idade anos e sou do sexo $sexo")
    }
}