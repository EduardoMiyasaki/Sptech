fun main(){

    val pessoa1 = Pessoa("Eduardo", 18);
    val pessoa2 = Pessoa("Fernando", 13);

    println("Pessoa 1 - ${pessoa1.nome}")

    val pessoas: MutableList<Pessoa> = mutableListOf();
    pessoas.add(pessoa1);
    pessoas.add(pessoa2);

    for (pessoaDaVez in pessoas){
        println("A pessoa se chama ${pessoaDaVez.nome} com idade ${pessoaDaVez.idade} anos ")
    }

    pessoa1.respirar();
    pessoa1.ola()
    pessoa2.ola()
}