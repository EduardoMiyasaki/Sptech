package pt1

fun main(){

    val tarefa: Tarefa = Tarefa();
    tarefa.nome = "Dar banho ao peixe"
    tarefa.pontuacao = 8
    tarefa.status = StatusEnum.PENDENTE

    println("Vou iniciar o banho...")

    tarefa.status = StatusEnum.EM_ANDAMENTO
    println(tarefa.status.nomeCompleto);

    if(tarefa.status.equals(StatusEnum.PENDENTE)){
        println("Tarefa pendente")
    }
    else if (tarefa.status.equals(StatusEnum.EM_ANDAMENTO)){
        println("Tarefa em andamento")
    }
    else{
        println("Tarfea concluída")
    }
}