import java.time.LocalDate
import java.time.Year

class Produto(
    var nome: String = "",
    var preco: Double = 0.0,
    var validade: LocalDate = LocalDate.now()
) {

    fun descrever(): String {

        val hoje = LocalDate.now()

        if (validade.isBefore(hoje)) {
            return "Produto $nome está vencido"
        }
        return "Dá pra mandar dentro"
    }

}