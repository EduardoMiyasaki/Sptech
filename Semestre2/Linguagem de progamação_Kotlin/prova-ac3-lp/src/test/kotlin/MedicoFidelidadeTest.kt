import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("Testes de fidelidade para classe Médico e suas implementações")
class MedicoFidelidadeTest {

    @Test
    fun `Verificar se a classe Medico herda de ProfissionalSaude`() {
        val clazz = Medico::class.java
        val superclass = clazz.superclass
        assertEquals(
            "ProfissionalSaude",
            superclass.simpleName,
            "A classe Medico não herda de ProfissionalSaude."
        )
    }

    @Test
    fun `Verificar se a classe Medico implementa a interface Especialista`() {
        val clazz = Medico::class.java
        val interfaces = clazz.interfaces
        val condition = interfaces.any { it.typeName == "Especialista" }
        assertTrue(condition, "A classe Medico deveria implementar a interface Especialista e não está implementando.")
    }

    @Test
    fun `Verificar se atributos existem e estão com o tipo certo`() {

        assertAll("Atributos",
            {
                assertDoesNotThrow(
                    { Medico::class.java.getDeclaredField("areaEspecialidade") },
                    "Atributo 'areaEspecialidade' não existe."
                )
            },
            {
                assertTrue(
                    { Medico::class.java.getDeclaredField("areaEspecialidade").type == String::class.java },
                    "Atributo 'areaEspecialidade' não é do tipo String"
                )
            },
            {
                assertDoesNotThrow(
                    { Medico::class.java.getDeclaredField("crm") },
                    "Atributo 'crm' não existe."
                )
            },
            {
                assertTrue(
                    { Medico::class.java.getDeclaredField("crm").type == String::class.java },
                    "Atributo 'crm' não é do tipo String"
                )
            }
        )
    }

    @Nested
    @DisplayName("Testes para a implementação do método setCRM da classe Medico")
    inner class SetCRM {

        @Test
        fun `setCRM deve alterar o CRM corretamente`() {
            try {
                val clazz = Medico::class.java
                val medico = clazz.getDeclaredConstructor().newInstance() as Medico

                clazz.getDeclaredField("crm").also {
                    it.isAccessible = true
                    it.set(medico, "A2B45")
                }

                val novoCRM = "B3C4D5"

                clazz.getDeclaredMethod("setCRM", String::class.java)
                    .invoke(medico, novoCRM)

                val crm = clazz.getDeclaredField("crm").apply { isAccessible = true }.get(medico) as String

                assertEquals(
                    novoCRM,
                    crm,
                    "O método setCRM não alterou o CRM corretamente."
                )
            } catch (e: NoSuchMethodException) {
                fail("Método setCRM não existe na classe Medico.")
            }
        }

        @Test
        fun `setCRM não deve alterar o CRM se o novo CRM não tiver 6 caracteres`() {
            try {
                val clazz = Medico::class.java
                val medico = clazz.getDeclaredConstructor().newInstance() as Medico

                clazz.getDeclaredField("crm").also {
                    it.isAccessible = true
                    it.set(medico, "A2B45")
                }

                val novoCRM = "B3C4D"

                clazz.getDeclaredMethod("setCRM", String::class.java)
                    .invoke(medico, novoCRM)

                val crm = clazz.getDeclaredField("crm").apply { isAccessible = true }.get(medico) as String

                assertEquals(
                    "A2B45",
                    crm,
                    "O método setCRM não deveria alterar o CRM se o novo CRM não tiver 6 caracteres."
                )
            } catch (e: NoSuchMethodException) {
                fail("Método setCRM não existe na classe Medico.")
            }
        }
    }

    @Nested
    @DisplayName("Testes para a implementação do método setAreaEspecialidade da classe Medico")
    inner class SetAreaEspecialidade {

        @Test
        fun `setAreaEspecialidade deve alterar a área de especialidade corretamente`() {
            try {
                val clazz = Medico::class.java
                val medico = clazz.getDeclaredConstructor().newInstance() as Medico

                clazz.getDeclaredField("areaEspecialidade").also {
                    it.isAccessible = true
                    it.set(medico, "Cardiologia")
                }

                val novaAreaEspecialidade = "Ortopedia"

                clazz.getDeclaredMethod("setAreaEspecialidade", String::class.java)
                    .invoke(medico, novaAreaEspecialidade)

                val areaEspecialidade =
                    clazz.getDeclaredField("areaEspecialidade").apply { isAccessible = true }.get(medico) as String

                assertEquals(
                    novaAreaEspecialidade,
                    areaEspecialidade,
                    "O método setAreaEspecialidade não alterou a área de especialidade corretamente."
                )
            } catch (e: NoSuchMethodException) {
                fail("Método setAreaEspecialidade não existe na classe Medico.")
            }
        }

        @Test
        fun `setAreaEspecialidade não deve alterar a área de especialidade se a nova área de especialidade tiver menos de 5 caracteres`() {
            try {
                val clazz = Medico::class.java
                val medico = clazz.getDeclaredConstructor().newInstance() as Medico

                clazz.getDeclaredField("areaEspecialidade").also {
                    it.isAccessible = true
                    it.set(medico, "Cardiologia")
                }

                val novaAreaEspecialidade = "Orto"

                clazz.getDeclaredMethod("setAreaEspecialidade", String::class.java)
                    .invoke(medico, novaAreaEspecialidade)

                val areaEspecialidade =
                    clazz.getDeclaredField("areaEspecialidade").apply { isAccessible = true }.get(medico) as String

                assertEquals(
                    "Cardiologia",
                    areaEspecialidade,
                    "O método setAreaEspecialidade não deveria alterar a área de especialidade se a nova área de especialidade tiver menos de 5 caracteres."
                )
            } catch (e: NoSuchMethodException) {
                fail("Método setAreaEspecialidade não existe na classe Medico.")
            }
        }
    }

    @Nested
    @DisplayName("Testes para a implementação do método realizarAtendimento da classe herdada ProfissionalSaude")
    inner class RealizarAtendimento {

        @Test
        fun `realizarAtendimento deve retornar a mensagem correta`() {
            try {
                val clazz = Medico::class.java
                val medico = clazz.getDeclaredConstructor().newInstance() as Medico

                clazz.superclass.getDeclaredField("nome").also {
                    it.isAccessible = true
                    it.set(medico, "Dr. House")
                }

                clazz.getDeclaredField("areaEspecialidade").also {
                    it.isAccessible = true
                    it.set(medico, "Cardiologia")
                }

                clazz.getDeclaredField("crm").also {
                    it.isAccessible = true
                    it.set(medico, "A2B456")
                }

                val metodoRealizarAtendimento = clazz.superclass.getDeclaredMethod("realizarAtendimento")
                    .invoke(medico) as String

                val nome = clazz.superclass.getDeclaredField("nome").apply { isAccessible = true }.get(medico) as String
                val areaEspecialidade =
                    clazz.getDeclaredField("areaEspecialidade").apply { isAccessible = true }.get(medico) as String
                val crm = clazz.getDeclaredField("crm").apply { isAccessible = true }.get(medico) as String

                assertEquals(
                    "O médico $nome, especialista em $areaEspecialidade, CRM $crm, realizou um atendimento com sucesso.",
                    metodoRealizarAtendimento,
                    "O método realizarAtendimento não retornou a mensagem correta."
                )


            } catch (e: NoSuchMethodException) {
                fail("Método realizarAtendimento não existe na classe ProfissionalSaude.")
            }
        }
    }

    @Nested
    @DisplayName("Testes para a implementação do método detalhar da classe herdada ProfissionalSaude")
    inner class Detalhar {

        @Test
        fun `detalhar deve retornar a mensagem correta`() {
            try {
                val clazz = Medico::class.java
                val medico = clazz.getDeclaredConstructor().newInstance() as Medico

                clazz.superclass.getDeclaredField("nome").also {
                    it.isAccessible = true
                    it.set(medico, "Dr. House")
                }

                clazz.getDeclaredField("areaEspecialidade").also {
                    it.isAccessible = true
                    it.set(medico, "Cardiologia")
                }

                clazz.getDeclaredField("crm").also {
                    it.isAccessible = true
                    it.set(medico, "A2B456")
                }

                clazz.superclass.getDeclaredField("nivelExperiencia").also {
                    it.isAccessible = true
                    it.set(medico, 5)
                }

                val metodoDetalhar = clazz.superclass.getDeclaredMethod("detalhar")
                    .invoke(medico) as String

                val nome = clazz.superclass.getDeclaredField("nome").apply { isAccessible = true }.get(medico) as String
                val areaEspecialidade =
                    clazz.getDeclaredField("areaEspecialidade").apply { isAccessible = true }.get(medico) as String
                val crm = clazz.getDeclaredField("crm").apply { isAccessible = true }.get(medico) as String
                val nivelExperiencia =
                    clazz.superclass.getDeclaredField("nivelExperiencia").apply { isAccessible = true }
                        .get(medico) as Int

                assertEquals(
                    "Médico $nome com CRM $crm, especialista em $areaEspecialidade, e nível de experiência $nivelExperiencia.",
                    metodoDetalhar,
                    "O método detalhar não retornou a mensagem correta."
                )

            } catch (e: NoSuchMethodException) {
                fail("Método detalhar não existe na classe ProfissionalSaude.")
            }
        }
    }

    @Nested
    @DisplayName("Testes para a implementação do método especialidade da interface Especialista")
    inner class Especialidade {

        @Test
        fun `especialidade deve retornar a mensagem correta`() {
            try {
                val clazz = Medico::class.java
                val medico = clazz.getDeclaredConstructor().newInstance() as Medico

                clazz.getDeclaredField("areaEspecialidade").also {
                    it.isAccessible = true
                    it.set(medico, "Cardiologia")
                }

                val metodoEspecialidade = clazz.getDeclaredMethod("especialidade")
                    .invoke(medico) as String

                val areaEspecialidade =
                    clazz.getDeclaredField("areaEspecialidade").apply { isAccessible = true }.get(medico) as String

                assertEquals(
                    "Especialidade médica: $areaEspecialidade.",
                    metodoEspecialidade,
                    "O método especialidade não retornou a mensagem correta."
                )

            } catch (e: NoSuchMethodException) {
                fail("Método especialidade não existe na interface Especialista.")
            }
        }
    }

    @Nested
    @DisplayName("Testes para a implementação do método tratarPaciente da interface Especialista")
    inner class TratarPaciente {

        @Test
        fun `tratarPaciente deve retornar a mensagem correta`() {
            try {
                val clazz = Medico::class.java
                val medico = clazz.getDeclaredConstructor().newInstance() as Medico

                clazz.superclass.getDeclaredField("nome").also {
                    it.isAccessible = true
                    it.set(medico, "Dr. House")
                }

                clazz.getDeclaredField("areaEspecialidade").also {
                    it.isAccessible = true
                    it.set(medico, "Cardiologia")
                }

                val metodoTratarPaciente = clazz.getDeclaredMethod("tratarPaciente")
                    .invoke(medico) as String

                val nome = clazz.superclass.getDeclaredField("nome").apply { isAccessible = true }.get(medico) as String
                val areaEspecialidade =
                    clazz.getDeclaredField("areaEspecialidade").apply { isAccessible = true }.get(medico) as String

                assertEquals(
                    "O médico $nome, especialista em $areaEspecialidade, tratou o paciente utilizando seus conhecimentos.",
                    metodoTratarPaciente,
                    "O método tratarPaciente não retornou a mensagem correta."
                )

            } catch (e: NoSuchMethodException) {
                fail("Método tratarPaciente não existe na interface Especialista.")
            }
        }
    }
}