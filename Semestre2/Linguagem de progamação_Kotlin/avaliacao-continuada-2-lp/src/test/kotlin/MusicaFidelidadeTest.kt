import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

@DisplayName("1 - Testes de unidade para a classe Musica")
class MusicaFidelidadeTest {

    @Nested
    @DisplayName("1 - Testes dos atributos da classe")
    inner class AtributosTestes {

        @Test
        fun `1 - verificar se atributos existem`() {
            assertAll("Atributos",
                {
                    assertDoesNotThrow(
                        { Musica::class.java.getDeclaredField("id") },
                        "Atributo id não existe"
                    )
                },
                {
                    assertDoesNotThrow(
                        { Musica::class.java.getDeclaredField("titulo") },
                        "Atributo titulo não existe"
                    )
                },
                {
                    assertDoesNotThrow(
                        { Musica::class.java.getDeclaredField("artista") },
                        "Atributo artista não existe"
                    )
                },
                {
                    assertDoesNotThrow(
                        { Musica::class.java.getDeclaredField("album") },
                        "Atributo album não existe"
                    )
                },
                {
                    assertDoesNotThrow(
                        { Musica::class.java.getDeclaredField("duracao") },
                        "Atributo duracao não existe"
                    )
                },
                {
                    assertDoesNotThrow(
                        { Musica::class.java.getDeclaredField("disponivel") },
                        "Atributo disponivel não existe"
                    )
                }
            )
        }

        @Test
        fun `2 - verificar se os atributos estão com tipo certo`() {
            assertAll("Atributos",
                {
                    val field = Musica::class.java.getDeclaredField("id")
                    assertTrue(field.type == Int::class.java, "Atributo id não é do tipo Int")
                },
                {
                    val field = Musica::class.java.getDeclaredField("titulo")
                    assertTrue(field.type == String::class.java, "Atributo titulo não é do tipo String")
                },
                {
                    val field = Musica::class.java.getDeclaredField("artista")
                    assertTrue(field.type == String::class.java, "Atributo artista não é do tipo String")
                },
                {
                    val field = Musica::class.java.getDeclaredField("album")
                    assertTrue(field.type == String::class.java, "Atributo album não é do tipo String")
                },
                {
                    val field = Musica::class.java.getDeclaredField("duracao")
                    assertTrue(field.type == Int::class.java, "Atributo duracao não é do tipo Int")
                },
                {
                    val field = Musica::class.java.getDeclaredField("disponivel")
                    assertTrue(field.type == Boolean::class.java, "Atributo disponivel não é do tipo Boolean")
                }
            )
        }
    }

    @Nested
    @DisplayName("2 - Testes dos métodos da classe")
    inner class MetodosTestes {

        @Nested
        @DisplayName("2.1 - Testes do método setTitulo")
        inner class SetTituloTestes {

            @Test
            fun `setTitulo deve alterar o nome da musica caso o novo nome tenha mínimo de 2 caracteres`() {
                try {
                    val clazz = Musica::class.java
                    val musica = clazz.getDeclaredConstructor().newInstance()

                    val setTitulo = clazz.getDeclaredMethod("setTitulo", String::class.java)

                    setTitulo.invoke(musica, "Nome da Música")

                    val titulo = clazz.getDeclaredField("titulo").apply { isAccessible = true }.get(musica) as String

                    assertEquals("Nome da Música", titulo, "Nome da música não foi alterado corretamente.")

                } catch (e: NoSuchMethodException) {
                    fail("Método setTitulo não existe")
                }
            }

            @Test
            fun `setTitulo não deve alterar o nome da musica caso o novo nome tenha menos de 2 caracteres`() {
                try {
                    val clazz = Musica::class.java
                    val musica = clazz.getDeclaredConstructor().newInstance()

                    val setTitulo = clazz.getDeclaredMethod("setTitulo", String::class.java)

                    setTitulo.invoke(musica, "N")

                    val titulo = clazz.getDeclaredField("titulo").apply { isAccessible = true }.get(musica) as String

                    assertEquals("", titulo, "Nome da música não deveria ter sido alterado.")

                } catch (e: NoSuchMethodException) {
                    fail("Método setTitulo não existe")
                }
            }
        }

        @Nested
        @DisplayName("2.2 - Testes do método setArtista")
        inner class SetArtistaTestes {

            @Test
            fun `setArtista deve alterar o nome do artista caso o novo nome tenha mínimo de 2 caracteres`() {
                try {
                    val clazz = Musica::class.java
                    val musica = clazz.getDeclaredConstructor().newInstance()

                    val setArtista = clazz.getDeclaredMethod("setArtista", String::class.java)

                    setArtista.invoke(musica, "Nome do Artista")

                    val artista = clazz.getDeclaredField("artista").apply { isAccessible = true }.get(musica) as String

                    assertEquals("Nome do Artista", artista, "Nome do artista não foi alterado corretamente.")

                } catch (e: NoSuchMethodException) {
                    fail("Método setArtista não existe")
                }
            }

            @Test
            fun `setArtista não deve alterar o nome do artista caso o novo nome tenha menos de 2 caracteres`() {
                try {
                    val clazz = Musica::class.java
                    val musica = clazz.getDeclaredConstructor().newInstance()

                    val setArtista = clazz.getDeclaredMethod("setArtista", String::class.java)

                    setArtista.invoke(musica, "N")

                    val artista = clazz.getDeclaredField("artista").apply { isAccessible = true }.get(musica) as String

                    assertEquals("", artista, "Nome do artista não deveria ter sido alterado.")

                } catch (e: NoSuchMethodException) {
                    fail("Método setArtista não existe")
                }
            }
        }

        @Nested
        @DisplayName("2.3 - Testes do método setAlbum")
        inner class SetAlbumTestes {

            @Test
            fun `setAlbum deve alterar o nome do album caso o novo nome tenha mínimo de 2 caracteres`() {
                try {
                    val clazz = Musica::class.java
                    val musica = clazz.getDeclaredConstructor().newInstance()

                    val setAlbum = clazz.getDeclaredMethod("setAlbum", String::class.java)

                    setAlbum.invoke(musica, "Nome do Album")

                    val album = clazz.getDeclaredField("album").apply { isAccessible = true }.get(musica) as String

                    assertEquals("Nome do Album", album, "Nome do album não foi alterado corretamente.")

                } catch (e: NoSuchMethodException) {
                    fail("Método setAlbum não existe")
                }
            }

            @Test
            fun `setAlbum não deve alterar o nome do album caso o novo nome tenha menos de 2 caracteres`() {
                try {
                    val clazz = Musica::class.java
                    val musica = clazz.getDeclaredConstructor().newInstance()

                    val setAlbum = clazz.getDeclaredMethod("setAlbum", String::class.java)

                    setAlbum.invoke(musica, "N")

                    val album = clazz.getDeclaredField("album").apply { isAccessible = true }.get(musica) as String

                    assertEquals("", album, "Nome do album não deveria ter sido alterado.")

                } catch (e: NoSuchMethodException) {
                    fail("Método setAlbum não existe")
                }
            }
        }

        @Nested
        @DisplayName("2.4 - Testes do método setDuracao")
        inner class SetDuracaoTestes {

            @Test
            fun `setDuracao deve alterar a duração da música caso o novo valor seja maior ou igual a 30`() {
                try {
                    val clazz = Musica::class.java
                    val musica = clazz.getDeclaredConstructor().newInstance()

                    val setDuracao = clazz.getDeclaredMethod("setDuracao", Int::class.java)

                    setDuracao.invoke(musica, 30)

                    val duracao = clazz.getDeclaredField("duracao").apply { isAccessible = true }.get(musica) as Int

                    assertEquals(30, duracao, "Duração da música não foi alterada corretamente.")

                } catch (e: NoSuchMethodException) {
                    fail("Método setDuracao não existe")
                }
            }

            @Test
            fun `setDuracao não deve alterar a duração da música caso o novo valor seja menor que 30`() {
                try {
                    val clazz = Musica::class.java
                    val musica = clazz.getDeclaredConstructor().newInstance()

                    val setDuracao = clazz.getDeclaredMethod("setDuracao", Int::class.java)

                    setDuracao.invoke(musica, 29)

                    val duracao = clazz.getDeclaredField("duracao").apply { isAccessible = true }.get(musica) as Int

                    assertEquals(0, duracao, "Duração da música não deveria ter sido alterada.")

                } catch (e: NoSuchMethodException) {
                    fail("Método setDuracao não existe")
                }
            }
        }

        @Nested
        @DisplayName("2.5 - Testes do método setDisponivel")
        inner class SetDisponivelTestes {

            @Test
            fun `setDisponivel deve alterar a disponibilidade da música para true`() {
                try {
                    val clazz = Musica::class.java
                    val musica = clazz.getDeclaredConstructor().newInstance()

                    val setDisponivel = clazz.getDeclaredMethod("setDisponivel", Boolean::class.java)

                    setDisponivel.invoke(musica, true)

                    val disponivel =
                        clazz.getDeclaredField("disponivel").apply { isAccessible = true }.get(musica) as Boolean

                    assertTrue(disponivel, "Disponibilidade da música não foi alterada corretamente.")

                } catch (e: NoSuchMethodException) {
                    fail("Método setDisponivel não existe")
                }
            }

            @Test
            fun `setDisponivel deve alterar a disponibilidade da música para false`() {
                try {
                    val clazz = Musica::class.java
                    val musica = clazz.getDeclaredConstructor().newInstance()

                    val setDisponivel = clazz.getDeclaredMethod("setDisponivel", Boolean::class.java)

                    setDisponivel.invoke(musica, false)

                    val disponivel =
                        clazz.getDeclaredField("disponivel").apply { isAccessible = true }.get(musica) as Boolean

                    assertFalse(disponivel, "Disponibilidade da música não foi alterada corretamente.")

                } catch (e: NoSuchMethodException) {
                    fail("Método setDisponivel não existe")
                }
            }
        }

        @Nested
        @DisplayName("2.6 - Testes do método converterDuracaoEmMinutos")
        inner class ConverterDuracaoEmMinutosTestes {

            @Test
            fun `converterDuracaoEmMinutos deve retornar a duração da música em minutos e segundos`() {
                try {
                    val clazz = Musica::class.java
                    val musica = clazz.getDeclaredConstructor().newInstance()

                    val setDuracao = clazz.getDeclaredMethod("setDuracao", Int::class.java)

                    setDuracao.invoke(musica, 150)

                    val converterDuracaoEmMinutos = clazz.getDeclaredMethod("converterDuracaoEmMinutos")

                    val duracaoFormatada = converterDuracaoEmMinutos.invoke(musica) as String

                    assertEquals("02:30", duracaoFormatada, "Duração da música não foi formatada corretamente.")

                } catch (e: NoSuchMethodException) {
                    fail("Método converterDuracaoEmMinutos não existe")
                }
            }
        }
    }
}