class Estado {

    var nome: String = ""
        get() {
            if (field.isBlank()) {
                return "Valor não encontrado"
            }
            return field.uppercase()
        }
        set(value) {
            if (value.length >= 3) {
                field = value
            }
        }

    var populacao: Int = 0
        set(value) {
            if (value == 0) {
                print("Valor inválido")
            }
            field = value
        }

    var uf: String = ""
        get() {
            if (field.isBlank()) {
                return "Valor não encontrado"
            }
            return field.uppercase()
        }
        set(value) {
            if (value.length == 2) {
                field = value
            }
        }

    lateinit var cidade: Cidade
}