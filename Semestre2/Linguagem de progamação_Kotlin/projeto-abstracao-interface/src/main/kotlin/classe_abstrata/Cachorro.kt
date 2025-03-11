package classe_abstrata

class Cachorro: Animal() {


    override fun Comer() {
        println("Comendo ração com suas patas")
    }

    override fun nascer() {
        println("Nasce do ventre de sua mãe")
    }
}