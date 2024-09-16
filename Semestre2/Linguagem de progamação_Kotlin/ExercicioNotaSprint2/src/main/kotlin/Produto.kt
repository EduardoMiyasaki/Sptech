class Produto {

    var nome: String = ""
        set(value) {
            if (value.length >= 4) {
                field = value
            } else field = "N/D"
        }

    var preco: Double = 0.0
        set(value) {
            if (brinde) {
                field = 0.01
            } else {
                if (value >= 0.01) {
                    field = value
                }
            }
        }

    var brinde: Boolean = false
        set(value) {
            if (value == true) {
                preco = 0.01
                field = true
            }
        }
}