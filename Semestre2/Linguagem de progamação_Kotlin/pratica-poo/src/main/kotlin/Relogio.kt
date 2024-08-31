class Relogio {

    var modelo: String = "";
    var preco: Double = 0.0;
    var horas: Int = 0
    var minutos: Int = 0
    var segundos: Int = 0


    public fun zerar() {
        this.horas = 0
        this.minutos = 0
        this.segundos = 0
    }

    public fun validar(): String {

        var valido = false;
        // if ((this.horas < 0 || this.horas > 24) || (this.minutos < 0 || this.minutos > 60) || (this.segundos < 0 || this.segundos > 60)) {

        if (horas !in 0..23) {// !In = não está dentro de 0 até 23
            horas = 0
            valido = true
        }

        if (minutos !in 0..60) {// !In = não está dentro de 0 até 23
            minutos = 0
            valido = true
        }

        if (segundos !in 0..60) {// !In = não está dentro de 0 até 23
            segundos = 0
            valido = true
        }

        if (valido){
            return "Valores inválidos identificados!!! Ajustado!"
    }
    return "Valores corretos"
}

public fun verHora(): String {

    return """
            Horas: ${"%02d".format(this.horas)}
            Minutos: ${"%02d".format(this.minutos)}
            Segundos: ${"%02d".format(this.segundos)}
        """.trimIndent()

}

}