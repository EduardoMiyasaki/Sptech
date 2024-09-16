class Cidade() {

    var nome: String = ""
        // get() = field.uppercase() // exemplo deixando em maiusculo
        get() {
            if (field.isBlank()) {
                return "Não informado"
            }
            return field.uppercase();
        }

        set(value) {
            if (value.length >= 3) {
                field = value
            }
        }

}