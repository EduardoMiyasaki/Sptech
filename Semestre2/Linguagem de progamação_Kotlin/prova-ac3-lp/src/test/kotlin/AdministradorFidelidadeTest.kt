import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("Testes de fidelidade para classe Administrador e suas implementações")
class AdministradorFidelidadeTest {

    @Test
    fun `Verificar se a classe Administrador herda de ProfissionalSaude`() {
        val clazz = Administrador::class.java
        val superclass = clazz.superclass
        val condition = superclass == ProfissionalSaude::class.java
        assertTrue(condition, "A classe Administrador deveria herdar mas não herda de ProfissionalSaude.")
    }

    @Test
    fun `Verificar se atributos existem e estão com o tipo certo`() {
        assertAll("Atributos",
            {
                assertDoesNotThrow(
                    { Administrador::class.java.getDeclaredField("nivelSupervisao") },
                    "Atributo 'nivelSupervisao' não existe."
                )
            },
            {
                assertTrue(
                    { Administrador::class.java.getDeclaredField("nivelSupervisao").type == Int::class.java },
                    "Atributo 'nivelSupervisao' deveria ser mas não é do tipo Int"
                )
            }
        )
    }

    @Test
    fun `Verificar se métodos foram implementados corretamente`() {
        assertAll(
            "Métodos",
            {
                assertDoesNotThrow(
                    { Administrador::class.java.getDeclaredMethod("realizarAtendimento") },
                    "Método 'realizarAtendimento' não foi encontrado."
                )
            },
            {
                assertDoesNotThrow(
                    { Administrador::class.java.getDeclaredMethod("detalhar") },
                    "Método 'detalhar' não foi encontrado."
                )
            },
            {
                assertDoesNotThrow(
                    { Administrador::class.java.getDeclaredMethod("setNivelSupervisao", Int::class.java) },
                    "Método 'setNivelSupervisao' não foi encontrado."
                )
            }
        )
    }

    @Nested
    @DisplayName("Testes para a implementação do método setNivelSupervisao da classe Medico")
    inner class SetNivelSupervisao {

        @Test
        fun `setNivelSupervisao deve alterar o valor do atributo`() {
            try {
                val clazz = Administrador::class.java
                val enfermeiro = clazz.getDeclaredConstructor().newInstance() as Administrador

                clazz.getDeclaredMethod("setNivelSupervisao", Int::class.java).also {
                    it.isAccessible = true
                    it.invoke(enfermeiro, 2)
                }

                val result = clazz.getDeclaredField("nivelSupervisao").apply { isAccessible = true }.get(enfermeiro)

                assertEquals(
                    2,
                    result,
                    "O método 'setNivelSupervisao' não alterou o valor do atributo corretamente."
                )
            } catch (e: NoSuchMethodException) {
                fail("Método 'setNivelSupervisao' não foi encontrado.")
            }
        }

        @Test
        fun `setNivelSupervisao não deve alterar o valor do atributo se for menor ou igual a zero`() {
            try {
                val clazz = Administrador::class.java
                val enfermeiro = clazz.getDeclaredConstructor().newInstance() as Administrador

                clazz.getDeclaredMethod("setNivelSupervisao", Int::class.java).also {
                    it.isAccessible = true
                    it.invoke(enfermeiro, 0)
                }

                val nivelSupervisao = clazz.getDeclaredField("nivelSupervisao").apply { isAccessible = true }.get(enfermeiro)

                assertEquals(
                    0                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           ,
                    nivelSupervisao,
                    "O método 'setNivelSupervisao' não validou o valor corretamente."
                )

                clazz.getDeclaredMethod("setNivelSupervisao", Int::class.java).also {
                    it.isAccessible = true
                    it.invoke(enfermeiro, -1)
                }

                val result2 = clazz.getDeclaredField("nivelSupervisao").apply { isAccessible = true }.get(enfermeiro)

                assertEquals(
                    0,
                    result2,
                    "O método 'setNivelSupervisao' não validou o valor corretamente."
                )
            } catch (e: NoSuchMethodException) {
                fail("Método 'setNivelSupervisao' não foi encontrado.")
            }
        }
    }

    @Nested
    @DisplayName("Testes para a implementação do método realizarAtendimento da classe herdada ProfissionalSaude")
    inner class RealizarAtendimento {

        @Test
        fun `realizarAtendimento deve retornar a mensagem correta`() {
            try {
                val clazz = Administrador::class.java
                val enfermeiro = clazz.getDeclaredConstructor().newInstance() as Administrador

                clazz.superclass.getDeclaredField("nome").also {
                    it.isAccessible = true
                    it.set(enfermeiro, "José")
                }

                clazz.getDeclaredField("nivelSupervisao").also {
                    it.isAccessible = true
                    it.set(enfermeiro, 2)
                }

                val result = clazz.superclass.getDeclaredMethod("realizarAtendimento").invoke(enfermeiro) as String

                val nome = clazz.superclass.getDeclaredField("nome").apply { isAccessible = true }.get(enfermeiro)

                val nivelSupervisao = clazz.getDeclaredField("nivelSupervisao").apply { isAccessible = true }.get(enfermeiro)

                assertEquals(
                    "O administrador $nome supervisionou um atendimento no nível $nivelSupervisao.",
                    result,
                    "O método 'realizarAtendimento' não retornou a mensagem correta."
                )
            } catch (e: NoSuchMethodException) {
                fail("Método 'realizarAtendimento' não foi encontrado.")
            }
        }
    }

    @Nested
    @DisplayName("Testes para a implementação do método detalhar da classe herdada ProfissionalSaude")
    inner class Detalhar {

        @Test
        fun `detalhar deve retornar a mensagem correta`() {
            try {
                val clazz = Administrador::class.java
                val enfermeiro = clazz.getDeclaredConstructor().newInstance() as Administrador

                clazz.superclass.getDeclaredField("nome").also {
                    it.isAccessible = true
                    it.set(enfermeiro, "José")
                }

                clazz.getDeclaredField("nivelSupervisao").also {
                    it.isAccessible = true
                    it.set(enfermeiro, 2)
                }

                clazz.superclass.getDeclaredMethod("setNivelExperiencia", Int::class.java).also {
                    it.isAccessible = true
                    it.invoke(enfermeiro, 3)
                }

                val result = clazz.superclass.getDeclaredMethod("detalhar").invoke(enfermeiro) as String

                val nome = clazz.superclass.getDeclaredField("nome").apply { isAccessible = true }.get(enfermeiro)

                val nivelSupervisao = clazz.getDeclaredField("nivelSupervisao").apply { isAccessible = true }.get(enfermeiro)

                val nivelExperiencia = clazz.superclass.getDeclaredField("nivelExperiencia").apply { isAccessible = true }.get(enfermeiro)

                assertEquals(
                    "Administrador $nome com nível de supervisão $nivelSupervisao e nível de experiência $nivelExperiencia.",
                    result,
                    "O método 'detalhar' não retornou a mensagem correta."
                )

            } catch (e: NoSuchMethodException) {
                fail("Método 'detalhar' não foi encontrado.")
            }
        }
    }
}