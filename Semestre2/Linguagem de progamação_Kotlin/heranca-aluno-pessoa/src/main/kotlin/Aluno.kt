class Aluno() : Pessoa() {

    private var matricula: Int = 0;

    fun setMatricula( matricula : Int){
        this.matricula = matricula;
    }

    fun getMatricula() : Int{
        return this.matricula;
    }
}