package repository


import dominio.Carro
import org.apache.commons.dbcp2.BasicDataSource
import org.springframework.jdbc.core.BeanPropertyRowMapper
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.queryForObject

class CarroRepository{

    lateinit var jdbcTemplate : JdbcTemplate;

    fun configurar(){

        val datasource =  BasicDataSource()
        datasource.driverClassName = "org.h2.Driver"
        datasource.url = "jdbc:h2:mem:concessionaria"
        datasource.username = "root"
        datasource.password = "1234"

        jdbcTemplate = JdbcTemplate(datasource)
    }

    fun criarTabela(){
        jdbcTemplate.execute("""
            CREATE TABLE IF NOT EXISTS Carro(
            id INT PRIMARY KEY AUTO_INCREMENT,
            nome VARCHAR(45) NOT NULL,
            vendido BOOLEAN
            )
        """.trimIndent())
    }

    fun adicionarCarro(carro : Carro): Boolean{

      val qtdLinhasAfetadas =  jdbcTemplate.update("""
            INSERT INTO Carro (nome,vendido) VALUES (?, false)
        """,
        carro.nome
      )
        return qtdLinhasAfetadas > 0
    }

    fun listarCarroPorId(id : Int): Carro{

        return jdbcTemplate.queryForObject("SELECT * FROM Carro WHERE id = ?",
            BeanPropertyRowMapper(Carro::class.java),
            id)
    }

    fun listarCarros(): List<Carro>{
        val listaCarros = jdbcTemplate.query("SELECT * FROM Carro",
            BeanPropertyRowMapper(Carro::class.java))
        return listaCarros
    }

    fun venderCarro(id: Int) : Boolean{
        val qtdLinhasAfetadas = jdbcTemplate.update("UPDATE Carro set vendido = true WHERE id = ?"
            ,id)

        return qtdLinhasAfetadas > 0
    }

    fun existePorId(id: Int): Boolean{
        val qtdExistentes = jdbcTemplate.queryForObject(
            "SELECT COUNT(*) FROM Carro where id = ?",
            Int::class.java
            ,id
        )
        return qtdExistentes > 0
    }

}