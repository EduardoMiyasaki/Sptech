package school.sptech.estudoprova.model

import school.sptech.estudoprova.dto.HeroiDTO

class Heroi {

    var nome: String = ""
    var poder: Double = 0.0
    var idade: Int = 0

    constructor(dto: HeroiDTO){
        this.nome = dto.nome
        this.poder = dto.poder
    }

    override fun toString(): String {
        return "Heroi(nome='$nome', poder='$poder', idade=$idade)"
    }

}