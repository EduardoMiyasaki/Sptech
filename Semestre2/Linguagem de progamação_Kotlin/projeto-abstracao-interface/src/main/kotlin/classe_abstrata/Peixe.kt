package classe_abstrata

class Peixe : Animal() {

    override fun respirar() {
        println("BUBUBUBU")
    }

    override fun Comer() {
        println("Está beliscanod um alimento.")
    }

    override fun nascer() {
        println("Nascendo de uma ova")
    }


}