import org.apache.commons.dbcp2.BasicDataSource
import org.springframework.jdbc.core.BeanPropertyRowMapper
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.queryForObject

class MusicaRepository {

    // Vou inicializar essa variavel mais tarde
    lateinit var jdbcTemplate: JdbcTemplate;

    fun configurar() {

        val dataSource: BasicDataSource = BasicDataSource();

        dataSource.driverClassName = "org.h2.Driver"
        dataSource.url = "jdbc:h2:mem:festival"
        dataSource.username = "root"
        dataSource.password = ""

        jdbcTemplate = JdbcTemplate(dataSource);
    }

    fun criarTabela() {
        jdbcTemplate.execute(
            """
        CREATE TABLE IF NOT EXISTS Musica(
        idMusica INT PRIMARY KEY AUTO_INCREMENT,
        nome VARCHAR(45) NOT NULL,
        banda VARCHAR(45) NOT NULL,
        produtor VARCHAR(45)
        )
    """.trimIndent()
        )
    }

    // Metódo post
    fun inserir(novaMusica: Musica): Boolean {
        val qtdLinhasAfetadas = jdbcTemplate.update(
            """
    INSERT INTO Musica (nome,banda,produtor) VALUES(?,?,?)
    """,
            novaMusica.nome,
            novaMusica.banda,
            novaMusica.produtor
        )
        return qtdLinhasAfetadas > 0
    }

    // Metódo get
    fun listarMusicas(): List<Musica> {
        return jdbcTemplate.query(
            " SELECT * FROM Musica ",
            BeanPropertyRowMapper(Musica::class.java)
            // BeanPropertyRowMapper = mapeia o resultado do comando sql
            // ou seja se no banco tiver uma coluna chamado nome e tiver um atributo na
            // classe chamada nome ele ira automaticamente atribuir o valor do sql para
            // a classe
        )
    }

    fun listarMusicaPorId(id: Int): Musica {

        // if (existePorId(id)) {
        val musicaEncontrada = jdbcTemplate.queryForObject(
            "SELECT * FROM Musica WHERE idMusica = ?",
            BeanPropertyRowMapper(Musica::class.java),
            id
        )
        return musicaEncontrada
        //  }
        //  return Musica();
    }


    fun existePorId(id: Int): Boolean {
        val qtdExistente = jdbcTemplate.queryForObject(
            "SELECT COUNT(*) FROM Musica WHERE IdMusica = ?",
            Int::class.java,
            id
        )
        return qtdExistente > 0
    }

    fun deletaPorId(id: Int): Boolean {
        val qtdLinhasAfetadas = jdbcTemplate.update(
            "DELETE FROM Musica WHERE idMusica = ?",
            id
        )
        return qtdLinhasAfetadas > 0
    }

    fun atualizaPorId(id: Int, novaMusica: Musica): Boolean {
        val qtdLinhasAfetadas = jdbcTemplate.update(
            "UPDATE Musica SET nome = ?, banda = ? , produtor = ? WHERE IdMusica = ?",
            novaMusica.nome, novaMusica.banda, novaMusica.produtor, id
        )
        return qtdLinhasAfetadas > 0
    }
}

