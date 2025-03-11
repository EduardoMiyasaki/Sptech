import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("Testes de fidelidade para classe abstrata ProfissionalSaude")
class ProfissionalSaudeFidelidadeTest {

    @Test
    fun `Verificar se a classe abstrata ProfissionalSaude foi implementada corretamente`() {
        val clazz = ProfissionalSaude::class.java
        val modifier = clazz.modifiers
        val condition = modifier and java.lang.reflect.Modifier.ABSTRACT != 0
        assertTrue(condition, "A classe ProfissionalSaude não é abstrata.")
    }

    @Test
    fun `Verificar se atributos existem e estão com o tipo certo`() {

        assertAll("Atributos",
            {
                assertDoesNotThrow(
                    { ProfissionalSaude::class.java.getDeclaredField("nome") },
                    "Atributo 'nome' não existe."
                )
            },
            {
                assertTrue(
                    { ProfissionalSaude::class.java.getDeclaredField("nome").type == String::class.java },
                    "Atributo 'nome' não é do tipo String"
                )
            },
            {
                assertDoesNotThrow(
                    { ProfissionalSaude::class.java.getDeclaredField("nivelExperiencia") },
                    "Atributo 'nivelExperiencia' não existe."
                )
            },
            {
                assertTrue(
                    { ProfissionalSaude::class.java.getDeclaredField("nivelExperiencia").type == Int::class.java },
                    "Atributo 'nivelExperiencia' não é do tipo String"
                )
            }
        )
    }

    @Test
    fun `Verificar se métodos são abstratos e retornam certo`() {
        assertAll("Métodos",
            {
                assertDoesNotThrow(
                    { ProfissionalSaude::class.java.getDeclaredMethod("realizarAtendimento") },
                    "Método 'realizarAtendimento' não existe."
                )
            },
            {
                assertTrue(
                    { ProfissionalSaude::class.java.getDeclaredMethod("realizarAtendimento").returnType == String::class.java },
                    "Método 'realizarAtendimento' deveria retornar String"
                )
            },
            {
                val clazz = ProfissionalSaude::class.java
                val method = clazz.getDeclaredMethod("realizarAtendimento")
                val condition = method.modifiers and java.lang.reflect.Modifier.ABSTRACT != 0
                assertTrue(condition, "Método 'realizarAtendimento' deveria ser abstrato e não é atualmente.")
            },
            {
                assertDoesNotThrow(
                    { ProfissionalSaude::class.java.getDeclaredMethod("detalhar") },
                    "Método 'detalhar' não existe."
                )
            },
            {
                assertTrue(
                    { ProfissionalSaude::class.java.getDeclaredMethod("detalhar").returnType == String::class.java },
                    "Método 'detalhar' deveria retornar String"
                )
            },
            {
                val clazz = ProfissionalSaude::class.java
                val method = clazz.getDeclaredMethod("detalhar")
                val condition = method.modifiers and java.lang.reflect.Modifier.ABSTRACT != 0
                assertTrue(condition, "Método 'detalhar' deveria ser abstrato e não é atualmente.")
            }
        )
    }

    @Test
    fun `verificar se métodos concretos existem`() {
        assertAll("Métodos",

            {
                assertDoesNotThrow(
                    { ProfissionalSaude::class.java.getDeclaredMethod("verificarStatus") },
                    "Método 'verificarStatus' não existe."
                )
            },
            {
                assertTrue(
                    { ProfissionalSaude::class.java.getDeclaredMethod("verificarStatus").returnType == String::class.java },
                    "Método 'verificarStatus' deveria retornar String"
                )
            },
            {
                val clazz = ProfissionalSaude::class.java
                val method = clazz.getDeclaredMethod("verificarStatus")
                val condition = method.modifiers and java.lang.reflect.Modifier.ABSTRACT == 0
                assertTrue(condition, "Método 'verificarStatus' deveria ser concreto e não é atualmente.")
            },
            {
                assertDoesNotThrow(
                    { ProfissionalSaude::class.java.getDeclaredMethod("setNome", String::class.java) },
                    "Método 'setNome' não existe."
                )
            },
            {
                assertTrue(
                    {
                        ProfissionalSaude::class.java.getDeclaredMethod(
                            "setNome",
                            String::class.java
                        ).returnType == Void.TYPE
                    },
                    "Método 'setNome' não deveria estar com retorno"
                )
            },
            {
                val clazz = ProfissionalSaude::class.java
                val method = clazz.getDeclaredMethod("setNome", String::class.java)
                val condition = method.modifiers and java.lang.reflect.Modifier.ABSTRACT == 0
                assertTrue(condition, "Método 'setNome' deveria ser concreto e não é atualmente.")
            },
            {
                assertDoesNotThrow(
                    { ProfissionalSaude::class.java.getDeclaredMethod("setNivelExperiencia", Int::class.java) },
                    "Método 'setNivelExperiencia' não existe."
                )
            },
            {
                assertTrue(
                    {
                        ProfissionalSaude::class.java.getDeclaredMethod(
                            "setNivelExperiencia",
                            Int::class.java
                        ).returnType == Void.TYPE
                    },
                    "Método 'setNivelExperiencia' não deveria estar com retorno."
                )
            },
            {
                val clazz = ProfissionalSaude::class.java
                val method = clazz.getDeclaredMethod("setNivelExperiencia", Int::class.java)
                val condition = method.modifiers and java.lang.reflect.Modifier.ABSTRACT == 0
                assertTrue(condition, "Método 'setNivelExperiencia' deveria ser concreto e não é atualmente.")
            }
        )
    }
}