package classe_abstrata

fun main() {

    val cachorro = Cachorro();
    cachorro.nascer()

    cachorro.nome = "Reinato augusto"
    cachorro.respirar()

    val peixe = Peixe()

    peixe.nome = "Nemo"
    peixe.nascer()
    peixe.Comer()
    peixe.respirar()

}