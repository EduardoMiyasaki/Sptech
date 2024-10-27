class Musica {

    var id: Int = 0

    var titulo: String = ""
        private set

    var artista: String = ""
        private set

    var album : String = ""
        private set

    var duracao : Int = 0
        private set

    var disponivel : Boolean = false
    private set

    fun setTitulo(titulo: String){
        if(titulo.length > 2){
            this.titulo = titulo;
        }
    }

    fun setArtista(artista: String){
        if(artista.length > 2){
            this.artista = artista;
        }
    }

    fun setAlbum(album: String){
        if(album.length > 2){
            this.album = album;
        }
    }

    fun setDuracao(duracao : Int){
        if(duracao >= 30){
            this.duracao = duracao;
        }
    }

    fun setDisponivel(disponivel: Boolean){
        this.disponivel = disponivel
    }

    fun converterDuracaoEmMinutos(): String{

        var minutos = duracao / 60;
        var segundos = duracao % 60;

        return "${"%02d".format(minutos)}:${"%02d".format(segundos)}"
    }
}