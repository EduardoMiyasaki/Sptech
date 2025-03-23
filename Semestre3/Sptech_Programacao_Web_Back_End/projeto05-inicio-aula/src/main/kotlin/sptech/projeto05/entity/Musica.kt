package sptech.projeto05.entity

import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import java.time.LocalDate

@Entity
data class Musica(

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Int? = 0,
    var nome: String?,
    var interprete: String?,

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    var dataCadastro: LocalDate = LocalDate.now(),
    var propriaParaCriancas: Boolean = false,
    var quantidadeReproducoes: Int = 0
){

    constructor() : this(null, null, null)
}

