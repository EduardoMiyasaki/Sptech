import java.time.LocalDateTime
import java.util.*
import kotlin.system.exitProcess

fun main() {

    // Não vair cair na prova

    // Thread = Aloca a aplicação em um thread até a aplicação ser fechada

    // Garbad collector sla como escreve
    // local onde guarda as variáveis na memória e após sair de um for por exemplo ela morre

    // crom = rotina

    // Assincrona = executa uma tarefa enquanto a outra tarefa está sendo preparada

    // sincrona = tem que esperar algo terminar para executar outra coisa

    println("Início da execução ${LocalDateTime.now()}")


    Timer().schedule(object : TimerTask() { // Ou Thread.sleep(2000)
        override fun run() {

            println("Agora são ${LocalDateTime.now()}")
            // exitProcess(0) // mata thread
        }

    }, 2000)

    println("Fim da execução ${LocalDateTime.now()}")

    // Recursividade recursiva
    mostrarHora()

}
    // Essa função vira um loop
    fun mostrarHora(){
       Timer().schedule(object: TimerTask(){
           override fun run(){
               println("Agora são ${LocalDateTime.now()}")
               mostrarHora()
       }
       },2000)


        // Entidades que possuem relaçãoes fracas são chamadas de composição
        // e relações fortes são chamadas de agregação
    }

