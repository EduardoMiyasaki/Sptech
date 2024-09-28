fun main() {

    val musicaRepositorio = MusicaRepository();

    musicaRepositorio.configurar()

    musicaRepositorio.criarTabela();

    val novaMusica = Musica();
    novaMusica.nome = "Diggy Diggy hole"
    novaMusica.banda = "Rock de anão"
    novaMusica.produtor = "Produtora Top"

    val novaMusica3 = Musica();
    novaMusica.nome = "Toda vez que você"
    novaMusica.banda = "dsadsa"
    novaMusica.produtor = "Produtora Top"

    val sucesso = musicaRepositorio.inserir(novaMusica)
    val sucesso2 = musicaRepositorio.inserir(novaMusica3)

    if (sucesso) println("Inserido com sucesso")
    else println("Não foi inserido")

    val listaMusica = musicaRepositorio.listarMusicas()

    listaMusica.forEach { // musicaDaVez ->
        println(
            """
            Id:${it.idMusica}
            Nome:${it.nome}
            Banda:${it.banda}
            Produtora:${it.produtor}
        """.trimIndent()
        )
    }

    musicaRepositorio.listarMusicaPorId(1)
    musicaRepositorio.atualizaPorId(1, novaMusica3)

    val idParaBusca = 1

    if (musicaRepositorio.existePorId(idParaBusca)) {
        val musicaEncontrada = musicaRepositorio.listarMusicaPorId(idParaBusca)
        println("Nome ${musicaEncontrada.nome}")
    } else println("Música não existe")

    musicaRepositorio.inserir(Musica(nome = "Hotel California", banda = "Eagles", produtor = "TOP"))

    if (musicaRepositorio.existePorId(idParaBusca)) {
        val deletado = musicaRepositorio.deletaPorId(idParaBusca)
    } else println("Música não existe")

    if (musicaRepositorio.existePorId(2)) {
        val musicaAtualizada = Musica(nome = "Californication", banda = "RHCP", produtor = "California")
        val atualizado = musicaRepositorio.atualizaPorId(2, musicaAtualizada)
        println(if (atualizado) "Atualizado" else "Deu ruim")
    }
    else println("Deu ruim")
}