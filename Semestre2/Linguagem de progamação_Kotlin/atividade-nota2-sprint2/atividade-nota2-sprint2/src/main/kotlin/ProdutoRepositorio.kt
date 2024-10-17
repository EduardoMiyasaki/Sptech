import org.apache.commons.dbcp2.BasicDataSource
import org.springframework.jdbc.core.BeanPropertyRowMapper
import org.springframework.jdbc.core.JdbcTemplate

class ProdutoRepositorio {

    lateinit var jdbcTemplate: JdbcTemplate

    fun configurar() {
        val datasource = BasicDataSource()
        datasource.driverClassName = "org.h2.Driver"
        datasource.url = "jdbc:h2:mem:estoque"
        datasource.username = "sa"
        datasource.password = ""

        jdbcTemplate = JdbcTemplate(datasource)
    }


    fun criarTabela() {

        jdbcTemplate.execute("""
           CREATE TABLE IF NOT EXISTS Produto(
           id INT PRIMARY KEY AUTO_INCREMENT,
           nome VARCHAR(45) NOT NULL,
           categoria VARCHAR(45) NOT NULL,
           preco Double,
           fabricante VARCHAR(45) NOT Null
           ) 
        """)

    }

    fun inserir(novoProduto : Produto) : Boolean{

        val qtdLinhasAfetadas = jdbcTemplate.update(
            """
           INSERT INTO Produto (nome,categoria,preco,fabricante) VALUES (?,?,?,?) 
        """,
            novoProduto.nome,
            novoProduto.categoria,
            novoProduto.preco,
            novoProduto.fabricante)

        return qtdLinhasAfetadas > 0
    }

    fun listar(): List<Produto>{
        return jdbcTemplate.query(
            "SELECT * FROM Produto",
        BeanPropertyRowMapper(Produto::class.java)
        )
    }

    fun existePorId(id : Int): Boolean{

        val qtdExistente = jdbcTemplate.queryForObject(
            "SELECT COUNT(*) FROM Produto WHERE id = ?",
            Int::class.java,
            id)

        return qtdExistente > 0
    }

    fun buscarPorId(id : Int) : Produto{
        val produtoEncontrado = jdbcTemplate.queryForObject(
            "SELECT * FROM Produto WHERE id = ?",
            BeanPropertyRowMapper(Produto::class.java),
            id
        )

        return produtoEncontrado;
    }

    fun atualizarPorId(id: Int , produtoParaAtualizar: Produto) : Boolean{

        val qtdLinhasAfetadas = jdbcTemplate.update(
                "UPDATE Produto SET nome = ?, categoria = ?, preco = ?, fabricante = ? WHERE id = ?",
            produtoParaAtualizar.nome , produtoParaAtualizar.categoria , produtoParaAtualizar.preco , produtoParaAtualizar.fabricante , id
        )
        return qtdLinhasAfetadas > 0
    }

    fun deletarPorId(id : Int) : Boolean{
        val qtdLinhasAfetadas = jdbcTemplate.update(
            "DELETE FROM Produto WHERE id = ?",
            id)
            return qtdLinhasAfetadas > 0
    }
}