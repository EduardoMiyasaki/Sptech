import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("Testes de unidade para a classe Produto")
class ProdutoFidelidadeTest {

    @Test
    @DisplayName("Verificar se atributos existem, estão com o tipo certo e estão privados")
    fun `verificar se atributos existem, estão com tipo certo e estão privados`() {
        assertAll("Atributos",
            // Verifica se os atributos existem
            {
                assertDoesNotThrow(
                    { Produto::class.java.getDeclaredField("id") },
                    "Não existe o atributo id."
                )
            },
            {
                assertDoesNotThrow(
                    { Produto::class.java.getDeclaredField("nome") },
                    "Não existe o atributo nome."
                )
            },
            {
                assertDoesNotThrow(
                    { Produto::class.java.getDeclaredField("preco") },
                    "Não existe o atributo preco."
                )
            },
            {
                assertDoesNotThrow(
                    { Produto::class.java.getDeclaredField("quantidade") },
                    "Não existe o atributo quantidade."
                )
            },

            // Verificação do tipo dos atributos
            {
                assertEquals(
                    Int::class.java,
                    Produto::class.java.getDeclaredField("id").type,
                    "O atributo id não é do tipo Int."
                )
            },
            {
                assertEquals(
                    String::class.java,
                    Produto::class.java.getDeclaredField("nome").type,
                    "O atributo nome não é do tipo String."
                )
            },
            {
                assertEquals(
                    Double::class.java,
                    Produto::class.java.getDeclaredField("preco").type,
                    "O atributo preco não é do tipo Double."
                )
            },
            {
                assertEquals(
                    Int::class.java,
                    Produto::class.java.getDeclaredField("quantidade").type,
                    "O atributo quantidade não é do tipo Int."
                )
            },

            // Verificar se os atributos são privados
            {
                assertTrue(
                    Produto::class.java.getDeclaredField("nome").modifiers and 2 != 0,
                    "O atributo nome não é privado."
                )
            },
            {
                assertTrue(
                    Produto::class.java.getDeclaredField("preco").modifiers and 2 != 0,
                    "O atributo preco não é privado."
                )
            },
            {
                assertTrue(
                    Produto::class.java.getDeclaredField("quantidade").modifiers and 2 != 0,
                    "O atributo quantidade não é privado."
                )
            }
        )
    }

    @Nested
    @DisplayName("Testes para o método setNome")
    inner class SetNomeTests {

        @Test
        @DisplayName("Método setNome deve alterar o nome do produto caso o novo nome tenha mínimo de 2 caracteres")
        fun `setNome deve alterar o nome do produto caso o novo nome tenha mínimo de 2 caracteres`() {
            try {
                val clazz = Produto::class.java
                val produto = clazz.getDeclaredConstructor().newInstance() as Produto

                val metodoSetNome = clazz.getDeclaredMethod("setNome", String::class.java)

                metodoSetNome.invoke(produto, "Celular")

                val nome = clazz.getDeclaredField("nome").apply { isAccessible = true }.get(produto) as String

                assertEquals("Celular", nome, "O nome do produto não foi alterado corretamente.")
            } catch (e: NoSuchMethodException) {
                fail("O método setNome não foi encontrado na classe Produto.")
            }
        }

        @Test
        @DisplayName("Método setNome não deve alterar o nome do produto caso o novo nome tenha menos de 2 caracteres")
        fun `setNome não deve alterar o nome do produto caso o novo nome tenha menos de 2 caracteres`() {
            try {
                val clazz = Produto::class.java
                val produto = clazz.getDeclaredConstructor().newInstance() as Produto

                val metodoSetNome = clazz.getDeclaredMethod("setNome", String::class.java)

                metodoSetNome.invoke(produto, "C")

                val nome = clazz.getDeclaredField("nome").apply { isAccessible = true }.get(produto) as String

                assertEquals("", nome, "O nome do produto não deveria ter sido alterado.")
            } catch (e: NoSuchMethodException) {
                fail("O método setNome não foi encontrado na classe Produto.")
            }
        }
    }

    @Nested
    @DisplayName("Testes para o método setPreco")
    inner class SetPrecoTests {

        @Test
        @DisplayName("Método setPreco deve alterar o preço do produto caso o novo preço seja maior que 0")
        fun `setPreco deve alterar o preço do produto caso o novo preço seja maior que 0`() {
            try {
                val clazz = Produto::class.java
                val produto = clazz.getDeclaredConstructor().newInstance() as Produto

                val metodoSetPreco = clazz.getDeclaredMethod("setPreco", Double::class.java)

                metodoSetPreco.invoke(produto, 99.99)

                val preco = clazz.getDeclaredField("preco").apply { isAccessible = true }.get(produto) as Double

                assertEquals(99.99, preco, "O preço do produto não foi alterado corretamente.")
            } catch (e: NoSuchMethodException) {
                fail("O método setPreco não foi encontrado na classe Produto.")
            }
        }

        @Test
        @DisplayName("Método setPreco não deve alterar o preço do produto caso o novo preço seja menor ou igual a 0")
        fun `setPreco não deve alterar o preço do produto caso o novo preço seja menor ou igual a 0`() {
            try {
                val clazz = Produto::class.java
                val produto = clazz.getDeclaredConstructor().newInstance() as Produto

                val metodoSetPreco = clazz.getDeclaredMethod("setPreco", Double::class.java)

                metodoSetPreco.invoke(produto, -10.0)

                val preco = clazz.getDeclaredField("preco").apply { isAccessible = true }.get(produto) as Double

                assertEquals(0.0, preco, "O preço do produto não deveria ter sido alterado.")
            } catch (e: NoSuchMethodException) {
                fail("O método setPreco não foi encontrado na classe Produto.")
            }
        }
    }

    @Nested
    @DisplayName("Testes para o método setQuantidade")
    inner class SetQuantidadeTests {

        @Test
        @DisplayName("Método setQuantidade deve alterar a quantidade do produto caso a nova quantidade seja maior que 0")
        fun `setQuantidade deve alterar a quantidade do produto caso a nova quantidade seja maior que 0`() {
            try {
                val clazz = Produto::class.java
                val produto = clazz.getDeclaredConstructor().newInstance() as Produto

                val metodoSetQuantidade = clazz.getDeclaredMethod("setQuantidade", Int::class.java)

                metodoSetQuantidade.invoke(produto, 10)

                val quantidade = clazz.getDeclaredField("quantidade").apply { isAccessible = true }.get(produto) as Int

                assertEquals(10, quantidade, "A quantidade do produto não foi alterada corretamente.")
            } catch (e: NoSuchMethodException) {
                fail("O método setQuantidade não foi encontrado na classe Produto.")
            }
        }

        @Test
        @DisplayName("Método setQuantidade não deve alterar a quantidade do produto caso a nova quantidade seja menor ou igual a 0")
        fun `setQuantidade não deve alterar a quantidade do produto caso a nova quantidade seja menor ou igual a 0`() {
            try {
                val clazz = Produto::class.java
                val produto = clazz.getDeclaredConstructor().newInstance() as Produto

                val metodoSetQuantidade = clazz.getDeclaredMethod("setQuantidade", Int::class.java)

                metodoSetQuantidade.invoke(produto, 0)

                val quantidade = clazz.getDeclaredField("quantidade").apply { isAccessible = true }.get(produto) as Int

                assertEquals(0, quantidade, "A quantidade do produto não deveria ter sido alterada.")
            } catch (e: NoSuchMethodException) {
                fail("O método setQuantidade não foi encontrado na classe Produto.")
            }
        }
    }
}
