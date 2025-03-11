package sptech.projeto04

import java.time.LocalDate

data class HeroiDTO(
    var apelido: String,
    var classe: String,
    var forca: Int?,
    var dataAposentadoria: LocalDate?
)
