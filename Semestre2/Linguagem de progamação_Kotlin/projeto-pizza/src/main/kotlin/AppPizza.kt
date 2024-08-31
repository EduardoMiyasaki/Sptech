import java.util.Scanner

fun main() {

    val snTexto = Scanner(System.`in`);
    val snNumero = Scanner(System.`in`);

    val pedido1 = PedidoPizza();

    print("Informe o sabor da pizza:");
    pedido1.sabor = snTexto.nextLine();

    print("Informe o preço da pizza:");
    pedido1.preco = snNumero.nextDouble();

    print("Informe a quantidade de amigos que voçê irá dividir:")
    pedido1.qtdAmigos = snNumero.nextInt();

    print("Você possui algum Cupom? Se não possui, digite não: ")
    val cupom = snTexto.nextLine();
    // poderia chamar snTexto.nextLine() dentro do validarCupom, mas vou deixar fora pra ficar mais intuitivo
    pedido1.validarCupom(cupom);

    println(pedido1.descrever());

    println("Cada amigo vai pagar R$ ${String.format("%.2f" , pedido1.obterValorPorAmigo())}")

    println(pedido1.obterCuponsUsados())


}