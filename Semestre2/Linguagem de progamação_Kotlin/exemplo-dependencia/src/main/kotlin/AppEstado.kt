fun main(){


    val cidade1 = Cidade();
    val estado1 = Estado();

    cidade1.nome = "Itaquaquecetuba"

    estado1.nome = "Bahia"
    estado1.populacao = 7_000_000
    estado1.cidade = cidade1

    println("Nome do Estado: ${estado1.nome}")
    println("População ${estado1.populacao}")
    print("Nome da cidade: ${estado1.cidade.nome}")
}