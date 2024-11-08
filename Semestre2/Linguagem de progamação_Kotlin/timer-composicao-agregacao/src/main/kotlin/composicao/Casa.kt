package composicao

class Casa {

    // é uma boa prática deixar private
    private val quartos = mutableListOf<Quarto>();

    fun adicionarQuarto(quarto: Quarto){
        quartos.add(quarto)
    }

    fun listarQuartos(): List<Quarto>{
        return quartos
    }
}