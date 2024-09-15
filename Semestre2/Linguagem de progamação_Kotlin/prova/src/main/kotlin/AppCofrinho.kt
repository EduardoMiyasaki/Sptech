fun main(){

    val cofrinho = Cofrinho();

    cofrinho.depositar(100.0)
    println(cofrinho.saldo)
    cofrinho.retirar(75.0)
    println(cofrinho.saldo)
}