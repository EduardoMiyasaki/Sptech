import org.apache.commons.dbcp2.BasicDataSource
import org.springframework.beans.BeanUtils
import org.springframework.jdbc.core.BeanPropertyRowMapper
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.queryForObject


fun main() {

    val dataSource: BasicDataSource = BasicDataSource();

    dataSource.driverClassName = "org.h2.Driver"

    // passando o database festival
    // mem mata o banco toda vez que finalizar

    dataSource.url = "jdbc:h2:mem:festival"

    // caso queira salvar um arquivo do projeto como se fosse um banco
    // dataSource.url = "jdbc:h2:file:./festival"

    // fazendo conexão com o mysql
    // dataSource.url = "jdbc:mysql://localhost:3306/meubanco"

    dataSource.username = "root"
    dataSource.password = ""

    val jdbcTemplate = JdbcTemplate(dataSource);

    jdbcTemplate.execute(
        """
        CREATE TABLE Musica(
        idMusica INT PRIMARY KEY AUTO_INCREMENT,
        nome VARCHAR(45) NOT NULL,
        banda VARCHAR(45) NOT NULL,
        produtor VARCHAR(45)
        )
    """.trimIndent()
    )

    val qtdInseridos = jdbcTemplate.update(
        "INSERT INTO Musica(nome, banda, produtor)" +
                "VALUES('Still loving you','scorpions','Records')"
    )

    println("Linhas afetadas ${qtdInseridos}");

    val listaMusica: List<Musica> = jdbcTemplate.query(
        "SELECT * FROM Musica",
        BeanPropertyRowMapper(Musica::class.java)
        // Pega todas as linha e mapeia para Musica
    )

    println(listaMusica[0].nome)



    val listaFiltrada = listaMusica.filter { musica -> musica.nome.length >= 3 }
    /*
    for(musicaDaVez in listaMusica)
     println("""
            Id:${it.idMusica}
            Nome:${it.nome}
            Banda:${it.banda}
            Produtora:${it.produtor}
        """.trimIndent())
     */

    // Esse código está ruim pois está com SQL Injection
    fun atualizarMusica(id: Int, nome: String, banda: String, produtora: String) {
        jdbcTemplate.update("UPDATE Musica set (nome, banda, produtor) = ('${nome}','${banda}','${produtora}') WHERE idMusica = ${id}")

    }

    atualizarMusica(1,"Marilia mendonça","Bin","a");

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

    val musicaId = 1;

    val existeMusica : Boolean = jdbcTemplate.queryForObject("SELECT count(*) FROM Musica WHERE IdMusica = ?",
    Int::class.java,
    musicaId) > 0

    if (existeMusica) {
        val musicaEncontrada = jdbcTemplate.queryForObject(
            "SELECT * FROM Musica WHERE idMusica = ?",
            BeanPropertyRowMapper(Musica::class.java),
            musicaId
        )
        println(
            """
            Id: ${musicaEncontrada.idMusica}
            Nome: ${musicaEncontrada.nome}
            Banda: ${musicaEncontrada.banda}
        """.trimIndent()
        )
    } else println("Musica não encontrada")

}