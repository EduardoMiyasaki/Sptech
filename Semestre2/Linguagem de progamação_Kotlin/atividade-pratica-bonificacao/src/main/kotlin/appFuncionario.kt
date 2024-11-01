import java.util.Scanner

fun main(){

    val snTexto = Scanner(System.`in`);
    val snNumero = Scanner(System.`in`);

    val gerente = Gerente();
    val desenvolvedor = Desenvolvedor();

    print("Informe o nome do gerente:");
    gerente.nome = snTexto.next();

    print("Informe o salário do gerente:");
    gerente.salario = snTexto.nextDouble();

    print("Informe o nome do desenvolvedor:");
    desenvolvedor.nome = snTexto.next();

    print("Informe o salário do desenvolvedor:");
    desenvolvedor.salario = snNumero.nextDouble()
    desenvolvedor.projeto = projetoEnum.EM_ANDAMENTO

    println("A bonifação do ${gerente.nome}(gerente) vai ser de ${gerente.calcularBonificacao()}")
    println("A bonifação do ${desenvolvedor.nome}(desenvolvedor) vai ser de ${desenvolvedor.calcularBonificacao()}")

}