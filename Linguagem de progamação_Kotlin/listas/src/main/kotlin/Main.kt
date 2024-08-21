fun main() {

    val pessoa1 = Pessoa();
    val pessoa2 = Pessoa();

    pessoa1.setNome("Eduardo");
    pessoa2.setNome("Fernando");

    pessoa1.setIdade(18);
    pessoa2.setIdade(13);

    pessoa1.setSexo("Masculino");
    pessoa2.setSexo("Masculino");

    println("Pessoa 1 - ${pessoa1.getNome()}");

    val pessoas: MutableList<Pessoa> = mutableListOf();
    pessoas.add(pessoa1);
    pessoas.add(pessoa2);

    for (pessoaDaVez in pessoas) {
        println("A pessoa se chama ${pessoaDaVez.getNome()} com idade ${pessoaDaVez.getIdade()} anos ")
    }

    pessoa1.status()
}