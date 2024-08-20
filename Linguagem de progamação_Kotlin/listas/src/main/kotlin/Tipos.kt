fun main() {

    // tipo inferido, pois , o tipo de variável é definido de acordo com o valor recebido
    val texto = "Texto inicial"; // como é Val o valor não pode ser alterado constantes

    // tipo declarativo: você declara o valor que essa variável vai receber
    var textoDefinido: String;

    val numero: Int = 10;
    val real: Double = 10.0;
    val float: Float = 10.0F;

    var aposentando: Boolean;

    aposentando = true;
    aposentando = false;

    val aposentadoTexto: String = aposentando.toString();
    println(aposentadoTexto);

    

}