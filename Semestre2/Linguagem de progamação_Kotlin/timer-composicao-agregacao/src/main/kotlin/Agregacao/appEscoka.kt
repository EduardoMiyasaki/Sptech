package Agregacao

fun main(){

    val professor = Professor();
    professor.lattes = "123456"

    val escola = Escola();
    escola.setNome("Sptech");

    escola.adicionarProfessor(professor)
}