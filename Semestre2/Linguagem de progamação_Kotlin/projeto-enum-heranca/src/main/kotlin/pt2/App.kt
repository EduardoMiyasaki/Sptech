package pt2

fun main(){


    println("------------------------------Pessoa---------------------------")

    val pessoa1 = Pessoa();
    pessoa1.nome = "Jhenny doe"
    println(pessoa1.nome)
    println(pessoa1.andar())

    println("------------------------------Aluno---------------------------")

    val aluno1 = Aluno();
    aluno1.nome = "Cleber";
    aluno1.RA = "123456"
    println(aluno1.nome)
    println(aluno1.RA)
    println(aluno1.andar())

    println("------------------------------Professor---------------------------")

    val professor1 = Professor();
    professor1.nome = "John doe"
    professor1.lattes = "123456"
    println(professor1.nome)
    println(professor1.prepararProva())
}