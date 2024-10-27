import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.springframework.jdbc.core.BeanPropertyRowMapper

@DisplayName("Testes para a classe do repositório de produtos")
class ProdutoRepositorioTest {

    private lateinit var produtoRepositorio: ProdutoRepositorio

    @BeforeEach
    fun setup() {

        produtoRepositorio = ProdutoRepositorio()

        val clazz = ProdutoRepositorio::class.java

        try {
            val method = clazz.getDeclaredMethod("configurar")
            method.invoke(produtoRepositorio)
        } catch (e: NoSuchMethodException) {
            fail("Método 'configurar' na 'ProdutoRepositorio' não encontrado... logo não foi atribuído ao 'jdbcTemplate'")
        }

        assertNotNull(produtoRepositorio.jdbcTemplate)

        produtoRepositorio.jdbcTemplate.execute("DROP TABLE IF EXISTS Produto")

        try {
            val method = clazz.getDeclaredMethod("criarTabela")
            assertNotNull(method, "O método 'criarTabela' não foi encontrado na classe 'ProdutoRepositorio'")
            method.invoke(produtoRepositorio)
        } catch (e: NoSuchMethodException) {
            fail("Método 'criarTabela' na 'ProdutoRepositorio' não encontrado... logo não foi criada a tabela 'Produto'")
        }
    }

    @Nested
    @DisplayName("Cenários do método inserir")
    inner class Inserir {
        @Test
        fun `inserindo com sucesso`() {
            try {
                val clazz = ProdutoRepositorio::class.java
                val method = clazz.getDeclaredMethod("inserir", Produto::class.java)

                val inserido = method.invoke(
                    produtoRepositorio,
                    ProdutoFixture.umProduto()
                )

                val produtos = produtoRepositorio.jdbcTemplate.query(
                    "SELECT * FROM Produto",
                    BeanPropertyRowMapper(Produto::class.java)
                )

                val produto = produtos[0]
                val clazzProduto = Produto::class.java

                val fieldId = clazzProduto.getDeclaredField("id").apply {
                    isAccessible = true
                }

                val fieldNome = clazzProduto.getDeclaredField("nome").apply {
                    isAccessible = true
                }

                val fieldCategoria = clazzProduto.getDeclaredField("categoria").apply {
                    isAccessible = true
                }

                val fieldPreco = clazzProduto.getDeclaredField("preco").apply {
                    isAccessible = true
                }

                val fieldDisponivel = clazzProduto.getDeclaredField("disponivel").apply {
                    isAccessible = true
                }

                assertEquals(true, inserido, "O produto deve ser inserido com sucesso")
                assertEquals(1, produtos.size, "Deve haver um produto na lista")
                assertEquals(1, fieldId.get(produto), "O id do produto deve ser 1")
                assertEquals("Notebook", fieldNome.get(produto), "O nome do produto deve ser preenchido")
                assertEquals("Eletrônicos", fieldCategoria.get(produto), "A categoria do produto deve ser preenchida")
                assertEquals(3500.0, fieldPreco.get(produto), "O preço do produto deve ser preenchido")
                assertEquals(true, fieldDisponivel.get(produto), "O produto deve estar disponível")
            } catch (e: NoSuchMethodException) {
                fail("Método 'inserir' na 'ProdutoRepositorio' não encontrado")
            }
        }
    }

    // Outros métodos de testes para listar, buscarPorId, deletarPorId e atualizar
}
