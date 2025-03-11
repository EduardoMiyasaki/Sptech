import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.fail
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("Testes de fidelidade para classe médico porém testando a classe abstrata ProfissionalSaude implementada no médico")
class MedicoHerdadaProfissionalSaudeFidelidadeImplementacaoTest {

    @Nested
    @DisplayName("Testes para a implementação do método verificarStatus da classe herdada ProfissionalSaude")
    inner class VerificarStatus {

        @Test
        fun `verificarStatus deve retornar a mensagem correta`() {
            try {
                val clazz = Medico::class.java
                val medico = clazz.getDeclaredConstructor().newInstance() as Medico

                clazz.superclass.getDeclaredField("nome").also {
                    it.isAccessible = true
                    it.set(medico, "Dr. House")
                }

                clazz.superclass.getDeclaredField("nivelExperiencia").also {
                    it.isAccessible = true
                    it.set(medico, 5)
                }

                val metodoVerificarStatus = clazz.superclass.getDeclaredMethod("verificarStatus")
                    .invoke(medico) as String

                val nome = clazz.superclass.getDeclaredField("nome").apply { isAccessible = true }.get(medico) as String
                val nivelExperiencia =
                    clazz.superclass.getDeclaredField("nivelExperiencia").apply { isAccessible = true }
                        .get(medico) as Int

                assertEquals(
                    "Profissional $nome tem nível de experiência $nivelExperiencia.",
                    metodoVerificarStatus,
                    "O método verificarStatus não retornou a mensagem correta."
                )
            } catch (e: NoSuchMethodException) {
                fail("Método verificarStatus não existe na classe ProfissionalSaude.")
            }
        }
    }

    @Nested
    @DisplayName("Testes para a implementação do método setNome da classe herdada ProfissionalSaude")
    inner class SetNome {

        @Test
        fun `setNome deve alterar o nome corretamente`() {
            try {
                val clazz = Medico::class.java
                val medico = clazz.getDeclaredConstructor().newInstance() as Medico

                clazz.superclass.getDeclaredField("nome").also {
                    it.isAccessible = true
                    it.set(medico, "Dr. House")
                }

                val novoNome = "Dr. House Jr."

                clazz.superclass.getDeclaredMethod("setNome", String::class.java)
                    .invoke(medico, novoNome)

                val nome = clazz.superclass.getDeclaredField("nome").apply { isAccessible = true }.get(medico) as String

                assertEquals(
                    novoNome,
                    nome,
                    "O método setNome não alterou o nome corretamente."
                )
            } catch (e: NoSuchMethodException) {
                fail("Método setNome não existe na classe ProfissionalSaude.")
            }
        }

        @Test
        fun `setNome não deve alterar o nome se o novo nome for menor que 3 caracteres`() {
            try {
                val clazz = Medico::class.java
                val medico = clazz.getDeclaredConstructor().newInstance() as Medico

                clazz.superclass.getDeclaredField("nome").also {
                    it.isAccessible = true
                    it.set(medico, "Dr. House")
                }

                val novoNome = "Dr"

                clazz.superclass.getDeclaredMethod("setNome", String::class.java)
                    .invoke(medico, novoNome)

                val nome = clazz.superclass.getDeclaredField("nome").apply { isAccessible = true }.get(medico) as String

                assertEquals(
                    "Dr. House",
                    nome,
                    "O método setNome não deveria alterar o nome se o novo nome for menor que 3 caracteres mas ele alterou."
                )
            } catch (e: NoSuchMethodException) {
                fail("Método setNome não existe na classe ProfissionalSaude.")
            }
        }
    }

    @Nested
    @DisplayName("Testes para a implementação do método setNivelExperiencia da classe herdada ProfissionalSaude")
    inner class SetNivelExperiencia {

        @Test
        fun `setNivelExperiencia deve alterar o nível de experiência corretamente`() {
            try {
                val clazz = Medico::class.java
                val medico = clazz.getDeclaredConstructor().newInstance() as Medico

                clazz.superclass.getDeclaredField("nivelExperiencia").also {
                    it.isAccessible = true
                    it.set(medico, 5)
                }

                val novoNivelExperiencia = 10

                clazz.superclass.getDeclaredMethod("setNivelExperiencia", Int::class.java)
                    .invoke(medico, novoNivelExperiencia)

                val nivelExperiencia = clazz.superclass.getDeclaredField("nivelExperiencia")
                    .apply { isAccessible = true }
                    .get(medico) as Int

                assertEquals(
                    novoNivelExperiencia,
                    nivelExperiencia,
                    "O método setNivelExperiencia não alterou o nível de experiência corretamente."
                )
            } catch (e: NoSuchMethodException) {
                fail("Método setNivelExperiencia não existe na classe ProfissionalSaude.")
            }
        }

        @Test
        fun `setNivelExperiencia não deve alterar o nível de experiência se o novo nível for igual a 0`() {
            try {
                val clazz = Medico::class.java
                val medico = clazz.getDeclaredConstructor().newInstance() as Medico

                clazz.superclass.getDeclaredField("nivelExperiencia").also {
                    it.isAccessible = true
                    it.set(medico, 5)
                }

                val novoNivelExperiencia = 0

                clazz.superclass.getDeclaredMethod("setNivelExperiencia", Int::class.java)
                    .invoke(medico, novoNivelExperiencia)

                val nivelExperiencia = clazz.superclass.getDeclaredField("nivelExperiencia")
                    .apply { isAccessible = true }
                    .get(medico) as Int

                assertEquals(
                    5,
                    nivelExperiencia,
                    "O método setNivelExperiencia não deveria alterar o nível de experiência se o novo nível for menor ou igual a 0 mas ele alterou."
                )
            } catch (e: NoSuchMethodException) {
                fail("Método setNivelExperiencia não existe na classe ProfissionalSaude.")
            }
        }

        @Test
        fun `setNivelExperiencia não deve alterar o nível de experiência se o novo nível for menor que 0`() {
            try {
                val clazz = Medico::class.java
                val medico = clazz.getDeclaredConstructor().newInstance() as Medico

                clazz.superclass.getDeclaredField("nivelExperiencia").also {
                    it.isAccessible = true
                    it.set(medico, 5)
                }

                val novoNivelExperiencia = -1

                clazz.superclass.getDeclaredMethod("setNivelExperiencia", Int::class.java)
                    .invoke(medico, novoNivelExperiencia)

                val nivelExperiencia = clazz.superclass.getDeclaredField("nivelExperiencia")
                    .apply { isAccessible = true }
                    .get(medico) as Int


                assertEquals(
                    5,
                    nivelExperiencia,
                    "O método setNivelExperiencia não deveria alterar o nível de experiência se o novo nível for menor ou igual a 0 mas ele alterou."
                )

            } catch (e: NoSuchMethodException) {
                fail("Método setNivelExperiencia não existe na classe ProfissionalSaude.")
            }
        }
    }
}