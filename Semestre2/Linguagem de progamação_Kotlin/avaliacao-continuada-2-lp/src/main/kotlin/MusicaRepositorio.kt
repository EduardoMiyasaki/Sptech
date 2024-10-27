import org.apache.commons.dbcp2.BasicDataSource
import org.springframework.jdbc.core.BeanPropertyRowMapper
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.queryForObject

class MusicaRepositorio {

    lateinit var jdbcTemplate: JdbcTemplate

    fun configurar() {
        val dataSource = BasicDataSource()
        dataSource.driverClassName = "org.h2.Driver"
        dataSource.url = "jdbc:h2:mem:Spot4You"
        dataSource.username = "sa"
        dataSource.password = ""

        jdbcTemplate = JdbcTemplate(dataSource)
    }

    fun criarTabela(){
        jdbcTemplate.execute("""
          CREATE TABLE IF NOT EXISTS Musica(
            id INT PRIMARY KEY AUTO_INCREMENT,
            titulo VARCHAR(45) NOT NULL,
            artista VARCHAR(45) NOT NULL,
            album VARCHAR(45) NOT NULL,
            duracao INT,
            disponivel BOOLEAN
            )
        """)
    }

    fun inserir(musica : Musica): Boolean{
        var qtdLinhasAfetadas = jdbcTemplate.update("""
            INSERT INTO Musica (titulo, artista, album, duracao, disponivel) VALUES (?, ?, ?, ?, ?)
        """,
            musica.titulo, musica.artista, musica.album, musica.duracao, musica.disponivel)

        return qtdLinhasAfetadas > 0
    }

    fun listar(): List<Musica>{
        val listaMusica = jdbcTemplate.query("""
           SELECT * FROM Musica 
        """,
            BeanPropertyRowMapper(Musica::class.java))

        return listaMusica
    }

    fun existePorId(id : Int) : Boolean{
        val qtdLinhasAfetadas = jdbcTemplate.queryForObject("""
            SELECT COUNT(*) FROM Musica WHERE id = ?
        """,
            Int::class.java,
            id)

        return qtdLinhasAfetadas > 0
    }

    fun buscarPorId(id : Int): Musica{
        return jdbcTemplate.queryForObject("""
            SELECT * FROM Musica WHERE id = ?
        """,
            BeanPropertyRowMapper(Musica::class.java),
            id)
    }

    fun atualizarPorId(id: Int, musica : Musica): Boolean{
        val qtdLinhasAfetadas = jdbcTemplate.update("""
            UPDATE Musica set titulo = ? , artista = ? , album = ? , duracao = ? , disponivel = ? WHERE id = ?
        """,
            musica.titulo, musica.artista, musica.album, musica.duracao, musica.disponivel,id)

        return qtdLinhasAfetadas > 0
    }

    fun deletarPorId(id: Int): Boolean{
        val qtdLinhasaAfetadas = jdbcTemplate.update("""
            DELETE FROM Musica WHERE id = ?
        """,id)

        return qtdLinhasaAfetadas > 0
    }

    fun disponivelPorId(id : Int): Boolean{
        val disponivel = jdbcTemplate.queryForObject("""
            SELECT disponivel from Musica WHERE id = ?
        """, Boolean::class.java,
            id)

        return disponivel
    }

    fun tornarDisponivelPorId(id: Int): Boolean{
        val disponivel = jdbcTemplate.update("""
           UPDATE Musica SET disponivel = true WHERE id = ? 
        """,id)

        return disponivel > 0
    }

}