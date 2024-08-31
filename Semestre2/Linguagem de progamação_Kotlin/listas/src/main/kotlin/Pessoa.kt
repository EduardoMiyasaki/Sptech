class Pessoa {

    private var nome: String = "";
    private var idade: Int = 0;
    private var sexo : String = "Null";

    // Metódos especiais
    public fun getNome(): String{
        return this.nome;
    }

    public fun setNome(nome: String){
        this.nome = nome;
    }

    public fun getIdade(): Int{
        return this.idade;
    }

    public fun setIdade(idade : Int){
        this.idade = idade;
    }

    public fun getSexo(): String{
        return this.sexo;
    }

    public fun setSexo(sexo: String){
        this.sexo = sexo;
    }

    fun respirar() {
        println("Respirando...");
    }

    fun ola() {
        println("Olá!Meu nome é ${this.nome} e tenho ${this.idade} anos")
    }

    public fun status(){
        println("O nome desta pessoa é ${getNome()}, sua idade é ${getIdade()} anos e é do sexo ${getSexo()}");
    }
}