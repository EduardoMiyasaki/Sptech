fun main() {

    val carro1 = Carro("Volvo", "Xc5", ligado = true);
    // é possível reatribui valores sem se preocupar com a ordem

    println("Estado do carro: ${carro1.ligado}");
    carro1.ligar();
    println("Estado do carro: Ligado ${carro1.ligado}");

    print("Desligando carro...")
    carro1.desligar()
    println("Carro desligado? ${carro1.ligado}");

    carro1.ligar();
    carro1.acelerar();
    carro1.acelerar();
    carro1.acelerar();
    carro1.frear();

   println(carro1.descricao())

    carro1.frear();
    carro1.frear();
    carro1.frear();

   println("\n Velocidade: ${carro1.velocidade}")

    carro1.desligar();
    println(carro1.descricao());
    carro1.frear()
    carro1.frear()
    carro1.frear()
    println()
    println(carro1.descricao())

    print(carro1.caixaPreta())

    carro1.exibirVelocidadeComTexto("Esse carro está com ${carro1.velocidade} km/h")
}
