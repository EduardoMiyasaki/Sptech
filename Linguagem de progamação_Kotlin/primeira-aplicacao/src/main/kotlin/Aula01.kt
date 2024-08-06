fun main() {

    // var nome: String  = "lucas";
    val nome: String = "lucas"; // val não pode ser alterado (imutavel)
    // var nome = "lucas";

    // println("bom dia " + nome);
    println("bom dia $nome");
    println("bom dia ${nome.toUpperCase()}")

    val salario = 2000;

    if (salario < 1500) {
        println("Um salário mínimo");
    } else {
        println("Come bem");
    }

    val nota = 6.0;

    // if de uma linha só, replica do ternario
    val resultado = if (nota < 6.0) "reprovado" else "aprovado"

    println(resultado)

    if (nota < 3) {
        println("deu ruim")
    } else if (nota < 6) {
        println("Passou raspando")
    } else {
        println("Pode até escolher o estágio")
    }

    // parecido com switch{
    // case 1:
    // }

    when (nota) {
        1.0 -> println("Deu ruim")
        3.0 -> println("Vai levar carcada")
        in 3.1..6.0 -> println("Da pra esforçar")
        else -> println("deu ruim")
    }

    val resultadoNota = when (nota) {
        1.0 -> println("Deu ruim")
        3.0 -> println("Vai levar carcada")
        in 3.1..6.0 -> println("Da pra esforçar")
        else -> println("deu ruim")
    }

    println(resultadoNota)

    var contador: Int = 0;

    while (contador < 10) {

        println("número: ${++contador}");
    }

    var numeros = 7;

    for (n in 1..numeros) {
        println(n)
    }
    for (n in numeros downTo 1) {
        println(n)
    }
}
