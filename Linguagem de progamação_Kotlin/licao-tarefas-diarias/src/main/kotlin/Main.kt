import java.util.Scanner

fun main() {


    val listaTarefas: MutableList<String> = mutableListOf();

    val snTexto = Scanner(System.`in`);
    val snNumero = Scanner(System.`in`);

    while (true) {
        println("1 - Adicionar tarefa");
        println("2 - Remover tarefa");
        println("3 - Exibir todas as tarefas");
        println("4 - Atualizar tarefa");
        println("5 - Exibir número total de tarefas");
        println("6 - Sair");
        print("Escolha uma opção:");

        val opcaoEscolhida = snNumero.nextInt();
        when (opcaoEscolhida) {
            1 -> {
                print("Adicione uma tarefa:")
                val tarefa = snTexto.nextLine();
                if (listaTarefas.indexOf(tarefa) == -1) {

                    listaTarefas.add(tarefa);
                } else {
                    println("Tarefa já existe");
                }
            }

            2 -> {
                println("Lista de tarefas $listaTarefas");
                print("Informe a posição que você deseja remover:")
                val posicao = snNumero.nextInt();
                if (listaTarefas.indices.contains(posicao)) {
                    listaTarefas.removeAt(posicao);
                } else {
                    println("Posição não existe");
                }
            }

            3 -> {
                println("Exibindo todas as tarefas $listaTarefas");
            }

            4 -> {

                //for(item in listaTarefas){
                // println("Produto atual $item")
                //}
                print("Informe a posição da tarefa que você quer atualizar:")
                val posicaoAtt = snNumero.nextInt();
                if (listaTarefas.indices.contains(posicaoAtt)) {

                    print("Informe a nova tarefa");
                    val tarefaAtt = snTexto.nextLine();
                    listaTarefas.set(posicaoAtt, tarefaAtt);
                    println("Tarefa atualizada");

                } else {
                    println("Posi1ção inválida");
                }
            }

            5 -> {
                println("O número total de tarefas cadastradas é ${listaTarefas.size}");
            }

            6 -> break
            else -> println("Opção inválida");
        }
        Thread.sleep(1000);
    }
}