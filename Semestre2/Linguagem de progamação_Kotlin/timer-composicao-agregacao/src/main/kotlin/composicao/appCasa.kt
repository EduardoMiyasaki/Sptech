package composicao

fun main() {

    val quarto1 = Quarto();
    val casa1 = Casa();

    quarto1.metrosQuad = 10.0
    casa1.adicionarQuarto(quarto1)

    casa1.listarQuartos().forEach{
        println(quarto1.metrosQuad)
    }
}