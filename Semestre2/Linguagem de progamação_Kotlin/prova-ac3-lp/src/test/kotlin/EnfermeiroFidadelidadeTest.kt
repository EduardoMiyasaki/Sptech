import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("Testes de fidelidade para classe Enfermeiro e suas implementações")
class EnfermeiroFidadelidadeTest {

    @Test
    fun `Verificar se a classe Enfermeiro herda de ProfissionalSaude`() {
        val clazz = Enfermeiro::class.java
        val superclass = clazz.genericSuperclass
        val condition = superclass.typeName == "ProfissionalSaude"
        assertTrue(condition, "A classe Enfermeiro não está herdando de ProfissionalSaude.")
    }

    @Test
    fun `Verificar se a classe Enfermeiro implementa a interface Especialista`() {
        val clazz = Enfermeiro::class.java
        val interfaces = clazz.interfaces
        val condition = interfaces.any { it.typeName == "Especialista" }
        assertTrue(condition, "A classe Enfermeiro não está implementando a interface Especialista.")
    }

    @Test
    fun `Verificar se atributos existem e estão com o tipo certo`() {

        assertAll("Atributos",
            {
                assertDoesNotThrow(
                    { Enfermeiro::class.java.getDeclaredField("registroEstagio") },
                    "Atributo 'registroEstagio' não existe."
                )
            },
            {
                assertTrue(
                    { Enfermeiro::class.java.getDeclaredField("registroEstagio").type == String::class.java },
                    "Atributo 'registroEstagio' não é do tipo String"
                )
            }
        )
    }

    @Nested
    @DisplayName("Testes para a implementação do método setRegistroEstagio")
    inner class SetRegistroEstagio {

        @Test
        fun `setRegistroEstagio deve alterar o valor do registro de estágio se o novo valor tiver 8 caracteres`() {
            try {
                val clazz = Enfermeiro::class.java
                val enfermeiro = clazz.getDeclaredConstructor().newInstance() as Enfermeiro

                clazz.getDeclaredField("registroEstagio").also {
                    it.isAccessible = true
                    it.set(enfermeiro, "12345678")
                }

                val novoRegistro = "87654321"

                clazz.getDeclaredMethod("setRegistroEstagio", String::class.java).also {
                    it.invoke(enfermeiro, novoRegistro)
                }

                val registroEstagio = clazz.getDeclaredField("registroEstagio").also {
                    it.isAccessible = true
                }.get(enfermeiro) as String

                assertEquals(novoRegistro, registroEstagio, "O valor do registro de estágio não foi alterado.")
            } catch (e: NoSuchMethodException) {
                fail("Método setRegistroEstagio não existe.")
            }
        }

        @Test
        fun `setRegistroEstagio não deve alterar o valor do registro de estágio se o novo valor não tiver 8 caracteres`() {
            try {
                val clazz = Enfermeiro::class.java
                val enfermeiro = clazz.getDeclaredConstructor().newInstance() as Enfermeiro

                clazz.getDeclaredField("registroEstagio").also {
                    it.isAccessible = true
                    it.set(enfermeiro, "12345678")
                }

                val novoRegistro = "1234567"

                clazz.getDeclaredMethod("setRegistroEstagio", String::class.java).also {
                    it.invoke(enfermeiro, novoRegistro)
                }

                val registroEstagio = clazz.getDeclaredField("registroEstagio").also {
                    it.isAccessible = true
                }.get(enfermeiro) as String

                assertEquals("12345678", registroEstagio, "O valor do registro de estágio foi alterado.")
            } catch (e: NoSuchMethodException) {
                fail("Método setRegistroEstagio não existe.")
            }
        }
    }

    @Nested
    @DisplayName("Testes para a implementação do método realizarAtendimento")
    inner class RealizarAtendimento {

        @Test
        fun `realizarAtendimento deve retornar a mensagem correta`() {
            try {
                val clazz = Enfermeiro::class.java
                val enfermeiro = clazz.getDeclaredConstructor().newInstance() as Enfermeiro

                clazz.superclass.getDeclaredField("nome").also {
                    it.isAccessible = true
                    it.set(enfermeiro, "José")
                }

                clazz.getDeclaredField("registroEstagio").also {
                    it.isAccessible = true
                    it.set(enfermeiro, "12345678")
                }

                val result = clazz.getDeclaredMethod("realizarAtendimento").invoke(enfermeiro)

                val nome = clazz.superclass.getDeclaredField("nome").also {
                    it.isAccessible = true
                }.get(enfermeiro) as String

                val registroEstagio = clazz.getDeclaredField("registroEstagio").also {
                    it.isAccessible = true
                }.get(enfermeiro) as String

                assertEquals(
                    "O enfermeiro $nome, registro de estágio $registroEstagio, realizou um atendimento básico com cuidado.",
                    result,
                    "A mensagem retornada não está correta."
                )

            } catch (e: NoSuchMethodException) {
                fail("O método 'realizarAtendimento' não foi encontrado.")
            }
        }
    }

    @Nested
    @DisplayName("Testes para a implementação do método detalhar")
    inner class Detalhar {

        @Test
        fun `detalhar deve retornar a mensagem correta`() {
            try {
                val clazz = Enfermeiro::class.java
                val enfermeiro = clazz.getDeclaredConstructor().newInstance() as Enfermeiro

                clazz.superclass.getDeclaredField("nome").also {
                    it.isAccessible = true
                    it.set(enfermeiro, "José")
                }

                clazz.getDeclaredField("registroEstagio").also {
                    it.isAccessible = true
                    it.set(enfermeiro, "12345678")
                }

                clazz.superclass.getDeclaredField("nivelExperiencia").also {
                    it.isAccessible = true
                    it.set(enfermeiro, 5)
                }

                val result = clazz.getDeclaredMethod("detalhar").invoke(enfermeiro)

                val nome = clazz.superclass.getDeclaredField("nome").also {
                    it.isAccessible = true
                }.get(enfermeiro) as String

                val registroEstagio = clazz.getDeclaredField("registroEstagio").also {
                    it.isAccessible = true
                }.get(enfermeiro) as String

                val nivelExperiencia = clazz.superclass.getDeclaredField("nivelExperiencia").also {
                    it.isAccessible = true
                }.get(enfermeiro) as Int

                assertEquals(
                    "Enfermeiro $nome com registro de estágio $registroEstagio e nível de experiência $nivelExperiencia.",
                    result,
                    "A mensagem retornada não está correta."
                )

            } catch (e: NoSuchMethodException) {
                fail("O método 'detalhar' não foi encontrado.")
            }

        }
    }

    @Nested
    @DisplayName("Testes para a implementação do método especialidade")
    inner class Especialidade {

        @Test
        fun `especialidade deve retornar a mensagem correta`() {
            try {
                val clazz = Enfermeiro::class.java
                val enfermeiro = clazz.getDeclaredConstructor().newInstance() as Enfermeiro

                val result = clazz.getDeclaredMethod("especialidade").invoke(enfermeiro)

                assertEquals(
                    "Especialidade de enfermagem: Auxiliar.",
                    result,
                    "A mensagem retornada não está correta."
                )

            } catch (e: NoSuchMethodException) {
                fail("O método 'especialidade' não foi encontrado.")
            }
        }
    }

    @Nested
    @DisplayName("Testes para a implementação do método tratarPaciente")
    inner class TratarPaciente {

        @Test
        fun `tratarPaciente deve retornar a mensagem correta`() {
            try {
                val clazz = Enfermeiro::class.java
                val enfermeiro = clazz.getDeclaredConstructor().newInstance() as Enfermeiro

                clazz.superclass.getDeclaredField("nome").also {
                    it.isAccessible = true
                    it.set(enfermeiro, "José")
                }

                val result = clazz.getDeclaredMethod("tratarPaciente").invoke(enfermeiro)

                val nome = clazz.superclass.getDeclaredField("nome").also {
                    it.isAccessible = true
                }.get(enfermeiro) as String

                assertEquals(
                    "O enfermeiro $nome realizou o tratamento do paciente com técnicas de enfermagem especializadas.",
                    result,
                    "A mensagem retornada não está correta."
                )

            } catch (e: NoSuchMethodException) {
                fail("O método 'tratarPaciente' não foi encontrado.")
            }
        }
    }
}