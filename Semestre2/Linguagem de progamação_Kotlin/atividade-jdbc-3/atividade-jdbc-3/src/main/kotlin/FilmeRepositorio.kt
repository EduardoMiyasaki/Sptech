import org.apache.commons.dbcp2.BasicDataSource
import org.springframework.jdbc.core.BeanPropertyRowMapper
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.queryForObject
import java.sql.JDBCType

class FilmeRepositorio {

    lateinit var jdbcTemplate: JdbcTemplate

    fun configurar() {
        val dataSource = BasicDataSource()
        dataSource.driverClassName = "org.h2.Driver"
        dataSource.url = "jdbc:h2:mem:locadora"
        dataSource.username = "sa"
        dataSource.password = ""

        jdbcTemplate = JdbcTemplate(dataSource);
    }

    fun criarTabela(){
        jdbcTemplate.execute("""
            CREATE TABLE IF NOT EXISTS Filme(
            id INT PRIMARY KEY AUTO_INCREMENT,
            nome VARCHAR(45) NOT NULL,
            genero VARCHAR(45) NOT NULL,
            anoLancamento INT,
            duracao INT,
            alugado BOOLEAN
            )
        """)
    }

    fun inserir(filme : Filme) : Boolean{
      val qtdLinhasAfetadas = jdbcTemplate.update("""
           INSERT INTO Filme (nome,genero,anoLancamento,duracao,alugado) VALUES (?,?,?,?,?) 
        """,
          filme.nome,filme.genero,filme.anoLancamento,filme.duracao,filme.alugado
      )
        return qtdLinhasAfetadas > 0
    }

    fun listar(): List<Filme>{
        val listaFilmes = jdbcTemplate.query("SELECT * FROM Filme",
            BeanPropertyRowMapper(Filme::class.java))
        return listaFilmes
    }

    fun existePorId(id: Int): Boolean{
       val qtdLinhasAfetadas =  jdbcTemplate.queryForObject("""
            SELECT COUNT (*) FROM Filme WHERE id = ?
        """,
            Int::class.java,
            id)
        return qtdLinhasAfetadas > 0
    }

    fun buscarPorId(id: Int): Filme{
        return jdbcTemplate.queryForObject("SELECT * FROM Filme WHERE id = ?",
            BeanPropertyRowMapper(Filme::class.java),
            id)
    }

    fun atualizarPorId(id: Int , filmeParaAtualizar : Filme): Boolean{
    val qtdLinhasAfetadas = jdbcTemplate.update("""
        UPDATE Filme SET nome = ? , genero = ? , anoLancamento = ? , duracao = ? , alugado = ? WHERE id = ?
    """,filmeParaAtualizar.nome, filmeParaAtualizar.genero,filmeParaAtualizar.anoLancamento,filmeParaAtualizar.duracao,filmeParaAtualizar.alugado)
        return qtdLinhasAfetadas > 0
    }

    fun deletarPorId(id : Int) : Boolean{
        val qtdLinhasAfetadas = jdbcTemplate.update("""
            DELETE FROM Filme WHERE id = ?
        """,id)

        return qtdLinhasAfetadas > 0
    }

    fun alugadoPorId(id : Int): Boolean{
        val alugado = jdbcTemplate.queryForObject("""
            SELECT alugado FROM Filme WHERE id = ?
          
        """,Boolean::class.java,
            id)

        return alugado
    }

    fun alugarPorId(id: Int): Boolean{
        val alugado = jdbcTemplate.update("UPDATE Filme SET alugado = true WHERE id = ?",
            id)

        return alugado > 0
    }
}