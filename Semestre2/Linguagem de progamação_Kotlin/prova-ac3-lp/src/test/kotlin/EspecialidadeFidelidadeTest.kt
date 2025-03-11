import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("Testes de fidelidade para a interface Especialista")
class EspecialidadeFidelidadeTest {

    @Test
    fun `Verificar se a interface Especialista foi implementada corretamente`() {
        val clazz = Especialista::class.java
        val condition = clazz.isInterface
        assertTrue(condition, "A classe Especialista deveria ser mas não é uma interface.")
    }

    @Test
    fun `Verificar se métodos são abstratos e retornam certo`() {
        val clazz = Especialista::class.java

        assertFalse(clazz.declaredMethods.isEmpty())

        clazz.declaredMethods.forEach {
            val modifier = it.modifiers
            val condition = modifier and java.lang.reflect.Modifier.ABSTRACT != 0
            assertTrue(condition, "O método ${it.name} não é abstrato.")
        }
    }
}