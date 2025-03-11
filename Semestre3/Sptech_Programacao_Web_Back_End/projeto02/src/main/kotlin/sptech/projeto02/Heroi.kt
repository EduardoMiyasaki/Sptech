package sptech.projeto02

import com.fasterxml.jackson.annotation.JsonIgnore

/*
Para que um atributo não seja exposto no json gerado colocamos uma anotação no atributo
@JsonIgnore ou deixamos um atributo private o que não é boa prática
*/

data class Heroi(
    var apelido: String? = null,
    var classe: String? = null,
    var forca: Int? = null,
    @JsonIgnore var senha: String = "1234",
    @JsonIgnore var patrimonio: Double = 0.0
) {

    // aqui criamos um metódo que retorna uma informação é chamado de
    // Campo virtual ou campo calculado ou atributo virtual ou atributo calculado

    // Este campo aparece no JSON por conta que segue as regras de nomenclatura dos getters
    fun getSalario(): Double {
        // Salário é igual força * 1.5 se for null o salário é 0
        return forca?.times(1.5) ?: 0.0;
    }

}






