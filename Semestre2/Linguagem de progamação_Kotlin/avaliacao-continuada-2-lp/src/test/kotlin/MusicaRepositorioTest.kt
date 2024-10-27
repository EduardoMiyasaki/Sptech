import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.springframework.jdbc.core.BeanPropertyRowMapper
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlin.test.fail

@DisplayName("2 - Testes para o repositório de músicas")
class MusicaRepositorioTest {

    private lateinit var musicaRepositorio: MusicaRepositorio

    @BeforeEach
    fun setUp() {
        musicaRepositorio = MusicaRepositorio()

        val clazz = MusicaRepositorio::class.java

        try {
            val metodo = clazz.getDeclaredMethod("configurar")
            metodo.invoke(musicaRepositorio)
        } catch (e: NoSuchMethodException) {
            fail("O método configurar não foi encontrado na classe MusicaRepositorio... Verifique se ele foi implementado corretamente.")
        }

        assertNotNull(
            musicaRepositorio.jdbcTemplate,
            "jdbcTemplate nulo... Verifique se ele foi inicializada no método configurar."
        )

        musicaRepositorio.jdbcTemplate.execute("DROP TABLE IF EXISTS musica")

        try {
            val metodo = clazz.getDeclaredMethod("criarTabela")
            assertNotNull(
                metodo,
                "O método criarTabela não foi encontrado na classe MusicaRepositorio... Verifique se ele foi implementado corretamente."
            )
            metodo.invoke(musicaRepositorio)
        } catch (e: NoSuchMethodException) {
            fail("O método criarTabela não foi encontrado na classe MusicaRepositorio... Verifique se ele foi implementado corretamente.")
        }
    }

    @Nested
    @DisplayName("1. Testes para o método inserir")
    inner class Inserir {

        @Test
        fun `inserir - Deve inserir uma música com sucesso`() {
            try {
                val clazzRepositorio = MusicaRepositorio::class.java
                val metodo = clazzRepositorio.getDeclaredMethod("inserir", Musica::class.java)

                val inserido = metodo.invoke(musicaRepositorio, MusicaFixture.umaMusica()) as Boolean

                val musicas = musicaRepositorio.jdbcTemplate.query(
                    "SELECT * FROM musica",
                    BeanPropertyRowMapper(Musica::class.java)
                )

                val musica = musicas.first()
                val clazzMusica = Musica::class.java

                val fieldId = clazzMusica.getDeclaredField("id").apply {
                    isAccessible = true
                }

                val fieldTitulo = clazzMusica.getDeclaredField("titulo").apply {
                    isAccessible = true
                }

                val fieldArtista = clazzMusica.getDeclaredField("artista").apply {
                    isAccessible = true
                }

                val fieldAlbum = clazzMusica.getDeclaredField("album").apply {
                    isAccessible = true
                }

                val fieldDuracao = clazzMusica.getDeclaredField("duracao").apply {
                    isAccessible = true
                }

                val fieldDisponivel = clazzMusica.getDeclaredField("disponivel").apply {
                    isAccessible = true
                }

                assertEquals(
                    true,
                    inserido,
                    "O método inserir deve retornar true para uma música inserida com sucesso."
                )
                assertEquals(1, musicas.size, "Deve ter uma música inserida no banco de dados.")
                assertEquals(
                    1,
                    fieldId.get(musica),
                    "O id da música inserida deve ser 1 ao retornar (gerado automáticamente)."
                )
                assertEquals(
                    "Bohemian Rhapsody",
                    fieldTitulo.get(musica),
                    "O título da música inserida deve ser preenchido."
                )
                assertEquals("Queen", fieldArtista.get(musica), "O artista da música inserida deve ser preenchido.")
                assertEquals(
                    "A Night at the Opera",
                    fieldAlbum.get(musica),
                    "O álbum da música inserida deve ser preenchido."
                )
                assertEquals(354, fieldDuracao.get(musica), "A duração da música inserida deve ser preenchida.")
                assertEquals(true, fieldDisponivel.get(musica), "A disponibilidade da música deve ser preenchida.")

            } catch (e: NoSuchMethodException) {
                fail("O método inserir não foi encontrado na classe MusicaRepositorio... Verifique se ele foi implementado corretamente.")
            }
        }
    }

    @Nested
    @DisplayName("2. Testes para o método listar")
    inner class Listar {

        @Test
        fun `listar - Deve listar as músicas cadastradas no banco`() {
            try {

                musicaRepositorio.jdbcTemplate.update(
                    """
                        INSERT INTO musica (titulo, artista, album, duracao, disponivel)
                        VALUES('Bohemian Rhapsody', 'Queen', 'A Night at the Opera', 354, true)
                    """
                )

                val clazzRepositorio = MusicaRepositorio::class.java
                val metodoListar = clazzRepositorio.getDeclaredMethod("listar")

                val musicas = metodoListar.invoke(musicaRepositorio) as List<Musica>
                val musica = musicas.first()

                val clazzMusica = Musica::class.java

                val fieldId = clazzMusica.getDeclaredField("id").apply {
                    isAccessible = true
                }

                val fieldTitulo = clazzMusica.getDeclaredField("titulo").apply {
                    isAccessible = true
                }

                val fieldArtista = clazzMusica.getDeclaredField("artista").apply {
                    isAccessible = true
                }

                val fieldAlbum = clazzMusica.getDeclaredField("album").apply {
                    isAccessible = true
                }

                val fieldDuracao = clazzMusica.getDeclaredField("duracao").apply {
                    isAccessible = true
                }

                val fieldDisponivel = clazzMusica.getDeclaredField("disponivel").apply {
                    isAccessible = true
                }

                assertEquals(1, musicas.size, "Deve ter uma música listada no banco de dados.")
                assertEquals(1, fieldId.get(musica), "O Id da música listada não é o correto.")
                assertEquals(
                    "Bohemian Rhapsody",
                    fieldTitulo.get(musica),
                    "O título da música listada não é o correto."
                )
                assertEquals("Queen", fieldArtista.get(musica), "O artista da música listada não é o correto.")
                assertEquals(
                    "A Night at the Opera",
                    fieldAlbum.get(musica),
                    "O álbum da música listada não é o correto."
                )
                assertEquals(354, fieldDuracao.get(musica), "A duração da música listada não é a correta.")
                assertEquals(true, fieldDisponivel.get(musica), "A disponibilidade da música listada não é a correta.")

            } catch (e: NoSuchMethodException) {
                fail("O método listar não foi encontrado na classe MusicaRepositorio... Verifique se ele foi implementado corretamente.")
            }
        }

        @Test
        fun `listar - Deve retornar uma lista vazia caso não tenha músicas no banco`() {
            try {

                val clazzRepositorio = MusicaRepositorio::class.java
                val metodoListar = clazzRepositorio.getDeclaredMethod("listar")

                val musicas = metodoListar.invoke(musicaRepositorio) as List<Musica>

                assertEquals(
                    0,
                    musicas.size,
                    "Ao não ter cadastrado nada, não deve ter músicas listadas no banco de dados."
                )

            } catch (e: NoSuchMethodException) {
                fail("O método listar não foi encontrado na classe MusicaRepositorio... Verifique se ele foi implementado corretamente.")
            }
        }
    }

    @Nested
    @DisplayName("3. Testes para o método existePorId")
    inner class ExistePorId {

        @Test
        fun `existePorId - Deve verificar se existe uma música por id e retornar true`() {
            try {

                musicaRepositorio.jdbcTemplate.update(
                    """
                        INSERT INTO musica (titulo, artista, album, duracao, disponivel)
                        VALUES('Bohemian Rhapsody', 'Queen', 'A Night at the Opera', 354, true)
                    """
                )

                val clazzRepositorio = MusicaRepositorio::class.java
                val metodoExistePorId = clazzRepositorio.getDeclaredMethod("existePorId", Int::class.java)

                val existe = metodoExistePorId.invoke(musicaRepositorio, 1) as Boolean

                assertEquals(true, existe, "Deve existir uma música com o Id informado no banco de dados.")

            } catch (e: NoSuchMethodException) {
                fail("O método existePorId não foi encontrado na classe MusicaRepositorio... Verifique se ele foi implementado corretamente.")
            }
        }

        @Test
        fun `existePorId - Deve verificar se existe uma música por id e retornar false`() {
            try {

                val clazzRepositorio = MusicaRepositorio::class.java
                val metodoExistePorId = clazzRepositorio.getDeclaredMethod("existePorId", Int::class.java)

                val existe = metodoExistePorId.invoke(musicaRepositorio, 1) as Boolean

                assertEquals(false, existe, "Não deve existir uma música com o Id informado no banco de dados.")

            } catch (e: NoSuchMethodException) {
                fail("O método existePorId não foi encontrado na classe MusicaRepositorio... Verifique se ele foi implementado corretamente.")
            }
        }
    }

    @Nested
    @DisplayName("4. Testes para o método buscarPorId")
    inner class BuscarPorId {

        @Test
        fun `buscarPorId - Deve buscar uma música por id e retornar corretamente`() {
            try {

                musicaRepositorio.jdbcTemplate.update(
                    """
                        INSERT INTO musica (titulo, artista, album, duracao, disponivel)
                        VALUES('Bohemian Rhapsody', 'Queen', 'A Night at the Opera', 354, true)
                    """
                )

                val clazzRepositorio = MusicaRepositorio::class.java
                val metodoBuscarPorId = clazzRepositorio.getDeclaredMethod("buscarPorId", Int::class.java)

                val musica = metodoBuscarPorId.invoke(musicaRepositorio, 1) as Musica

                val clazzMusica = Musica::class.java

                val fieldId = clazzMusica.getDeclaredField("id").apply {
                    isAccessible = true
                }

                val fieldTitulo = clazzMusica.getDeclaredField("titulo").apply {
                    isAccessible = true
                }

                val fieldArtista = clazzMusica.getDeclaredField("artista").apply {
                    isAccessible = true
                }

                val fieldAlbum = clazzMusica.getDeclaredField("album").apply {
                    isAccessible = true
                }

                val fieldDuracao = clazzMusica.getDeclaredField("duracao").apply {
                    isAccessible = true
                }

                val fieldDisponivel = clazzMusica.getDeclaredField("disponivel").apply {
                    isAccessible = true
                }

                assertEquals(1, fieldId.get(musica), "O Id da música buscada não é o correto.")
                assertEquals(
                    "Bohemian Rhapsody",
                    fieldTitulo.get(musica),
                    "O título da música buscada não é o correto."
                )
                assertEquals("Queen", fieldArtista.get(musica), "O artista da música buscada não é o correto.")
                assertEquals(
                    "A Night at the Opera",
                    fieldAlbum.get(musica),
                    "O álbum da música buscada não é o correto."
                )
                assertEquals(354, fieldDuracao.get(musica), "A duração da música buscada não é a correta.")
                assertEquals(true, fieldDisponivel.get(musica), "A disponibilidade da música buscada não é a correta.")

            } catch (e: NoSuchMethodException) {
                fail("O método buscarPorId não foi encontrado na classe MusicaRepositorio... Verifique se ele foi implementado corretamente.")
            }
        }
    }

    @Nested
    @DisplayName("5. Testes para o método atualizarPorId")
    inner class AtualizarPorId {

        @Test
        fun `atualizarPorId - Deve atualizar uma música por id e retornar true`() {
            try {

                musicaRepositorio.jdbcTemplate.update(
                    """
                        INSERT INTO musica (titulo, artista, album, duracao, disponivel)
                        VALUES('Bohemian Rhapsody', 'Queen', 'A Night at the Opera', 354, true)
                    """
                )

                val clazzRepositorio = MusicaRepositorio::class.java
                val metodoAtualizarPorId = clazzRepositorio.getDeclaredMethod(
                    "atualizarPorId",
                    Int::class.java,
                    Musica::class.java
                )

                val musica = MusicaFixture.musicaAtualizacao()

                val atualizado = metodoAtualizarPorId.invoke(musicaRepositorio, 1, musica) as Boolean

                val musicas = musicaRepositorio.jdbcTemplate.query(
                    "SELECT * FROM musica",
                    BeanPropertyRowMapper(Musica::class.java)
                )

                val musicaAtualizada = musicas.first()

                val clazzMusica = Musica::class.java

                val fieldId = clazzMusica.getDeclaredField("id").apply {
                    isAccessible = true
                }

                val fieldTitulo = clazzMusica.getDeclaredField("titulo").apply {
                    isAccessible = true
                }

                val fieldArtista = clazzMusica.getDeclaredField("artista").apply {
                    isAccessible = true
                }

                val fieldAlbum = clazzMusica.getDeclaredField("album").apply {
                    isAccessible = true
                }

                val fieldDuracao = clazzMusica.getDeclaredField("duracao").apply {
                    isAccessible = true
                }

                val fieldDisponivel = clazzMusica.getDeclaredField("disponivel").apply {
                    isAccessible = true
                }

                assertEquals(
                    true,
                    atualizado,
                    "O método atualizarPorId deve retornar true para uma música atualizada com sucesso."
                )

                assertEquals(1, musicas.size, "Deve ter uma música atualizada no banco de dados.")
                assertEquals(
                    1,
                    fieldId.get(musicaAtualizada),
                    "O id da música atualizada deve ser correto ao retornar (não alterou)."
                )

                assertEquals(
                    "Another One Bites the Dust",
                    fieldTitulo.get(musicaAtualizada),
                    "O título da música atualizada deve ser o correto."
                )

                assertEquals(
                    "Queen",
                    fieldArtista.get(musicaAtualizada),
                    "O artista da música atualizada deve ser o correto."
                )

                assertEquals(
                    "The Game",
                    fieldAlbum.get(musicaAtualizada),
                    "O álbum da música atualizada deve ser o correto."
                )

                assertEquals(
                    216,
                    fieldDuracao.get(musicaAtualizada),
                    "A duração da música atualizada deve ser a correta."
                )

                assertEquals(
                    false,
                    fieldDisponivel.get(musicaAtualizada),
                    "A disponibilidade da música atualizada deve ser a correta."
                )

            } catch (e: NoSuchMethodException) {
                fail("O método atualizarPorId não foi encontrado na classe MusicaRepositorio... Verifique se ele foi implementado corretamente.")
            }
        }

        @Test
        fun `atualizarPorId - Deve retornar false caso não encontre a música para atualizar`() {
            try {

                val clazzRepositorio = MusicaRepositorio::class.java
                val metodoAtualizarPorId = clazzRepositorio.getDeclaredMethod(
                    "atualizarPorId",
                    Int::class.java,
                    Musica::class.java
                )

                val musica = MusicaFixture.musicaAtualizacao()

                val atualizado = metodoAtualizarPorId.invoke(musicaRepositorio, 1, musica) as Boolean

                assertEquals(
                    false,
                    atualizado,
                    "O método atualizarPorId deve retornar false caso não encontre a música para atualizar (quantidade de linhas afetadas = 0)."
                )

            } catch (e: NoSuchMethodException) {
                fail("O método atualizarPorId não foi encontrado na classe MusicaRepositorio... Verifique se ele foi implementado corretamente.")
            }
        }
    }

    @Nested
    @DisplayName("6. Testes para o método deletarPorId")
    inner class DeletarPorId {

        @Test
        fun `deletarPorId - Deve deletar uma música por id e retornar true`() {
            try {

                musicaRepositorio.jdbcTemplate.update(
                    """
                        INSERT INTO musica (titulo, artista, album, duracao, disponivel)
                        VALUES('Bohemian Rhapsody', 'Queen', 'A Night at the Opera', 354, true)
                    """
                )

                val clazzRepositorio = MusicaRepositorio::class.java
                val metodoDeletarPorId = clazzRepositorio.getDeclaredMethod("deletarPorId", Int::class.java)

                val deletado = metodoDeletarPorId.invoke(musicaRepositorio, 1) as Boolean

                val musicas = musicaRepositorio.jdbcTemplate.query(
                    "SELECT * FROM musica",
                    BeanPropertyRowMapper(Musica::class.java)
                )

                assertEquals(
                    true,
                    deletado,
                    "O método deletarPorId deve retornar true para uma música deletada com sucesso."
                )

                assertEquals(0, musicas.size, "Não deve ter músicas no banco de dados após deletar.")

            } catch (e: NoSuchMethodException) {
                fail("O método deletarPorId não foi encontrado na classe MusicaRepositorio... Verifique se ele foi implementado corretamente.")
            }
        }

        @Test
        fun `deletarPorId - Deve retornar false caso não encontre a música para deletar`() {
            try {

                val clazzRepositorio = MusicaRepositorio::class.java
                val metodoDeletarPorId = clazzRepositorio.getDeclaredMethod("deletarPorId", Int::class.java)

                val deletado = metodoDeletarPorId.invoke(musicaRepositorio, 1) as Boolean

                assertEquals(
                    false,
                    deletado,
                    "O método deletarPorId deve retornar false caso não encontre a música para deletar (quantidade de linhas afetadas = 0)."
                )

            } catch (e: NoSuchMethodException) {
                fail("O método deletarPorId não foi encontrado na classe MusicaRepositorio... Verifique se ele foi implementado corretamente.")
            }
        }
    }

    @Nested
    @DisplayName("7. Testes para o método disponivelPorId")
    inner class DisponivelPorId {

        @Test
        fun `disponivelPorId - Deve retornar disponibilidade de acordo com o id (cenário true)`() {
            try {

                musicaRepositorio.jdbcTemplate.update(
                    """
                        INSERT INTO musica (titulo, artista, album, duracao, disponivel)
                        VALUES('Bohemian Rhapsody', 'Queen', 'A Night at the Opera', 354, true)
                    """
                )

                val clazzRepositorio = MusicaRepositorio::class.java
                val metodoDisponivelPorId = clazzRepositorio.getDeclaredMethod("disponivelPorId", Int::class.java)

                val disponivel = metodoDisponivelPorId.invoke(musicaRepositorio, 1) as Boolean

                assertEquals(true, disponivel, "A música deve estar disponível no banco de dados.")

            } catch (e: NoSuchMethodException) {
                fail("O método disponivelPorId não foi encontrado na classe MusicaRepositorio... Verifique se ele foi implementado corretamente.")
            }
        }

        @Test
        fun `disponivelPorId - Deve retornar disponibilidade de acordo com o id (cenário false)`() {
            try {

                musicaRepositorio.jdbcTemplate.update(
                    """
                        INSERT INTO musica (titulo, artista, album, duracao, disponivel)
                        VALUES('Bohemian Rhapsody', 'Queen', 'A Night at the Opera', 354, false)
                    """
                )

                val clazzRepositorio = MusicaRepositorio::class.java
                val metodoDisponivelPorId = clazzRepositorio.getDeclaredMethod("disponivelPorId", Int::class.java)

                val disponivel = metodoDisponivelPorId.invoke(musicaRepositorio, 1) as Boolean

                assertEquals(false, disponivel, "A música não deve estar disponível no banco de dados.")

            } catch (e: NoSuchMethodException) {
                fail("O método disponivelPorId não foi encontrado na classe MusicaRepositorio... Verifique se ele foi implementado corretamente.")
            }
        }
    }

    @Nested
    @DisplayName("8. Testes para o método tornarDisponivelPorId")
    inner class TornarDisponivelPorId {

        @Test
        fun `tornarDisponivelPorId - Deve tornar disponível uma música por id e retornar true`() {
            try {

                musicaRepositorio.jdbcTemplate.update(
                    """
                        INSERT INTO musica (titulo, artista, album, duracao, disponivel)
                        VALUES('Bohemian Rhapsody', 'Queen', 'A Night at the Opera', 354, false)
                    """
                )

                val clazzRepositorio = MusicaRepositorio::class.java
                val metodoTornarDisponivelPorId =
                    clazzRepositorio.getDeclaredMethod("tornarDisponivelPorId", Int::class.java)

                val alterou = metodoTornarDisponivelPorId.invoke(musicaRepositorio, 1) as Boolean

                val musica = musicaRepositorio.jdbcTemplate.queryForObject(
                    "SELECT * FROM musica WHERE id = 1",
                    BeanPropertyRowMapper(Musica::class.java)
                )

                val clazzMusica = Musica::class.java

                val fieldDisponivel = clazzMusica.getDeclaredField("disponivel").apply {
                    isAccessible = true
                }

                assertEquals(
                    true,
                    alterou,
                    "O método tornarDisponivelPorId deve retornar true para uma música tornada disponível com sucesso."
                )

                assertEquals(
                    true,
                    fieldDisponivel.get(musica),
                    "A música deve estar disponível após a execução do método."
                )

            } catch (e: NoSuchMethodException) {
                fail("O método tornarDisponivelPorId não foi encontrado na classe MusicaRepositorio... Verifique se ele foi implementado corretamente.")
            }
        }

        @Test
        fun `tornarDisponivelPorId - Deve retornar false caso não encontre a música para tornar disponível`() {
            try {

                val clazzRepositorio = MusicaRepositorio::class.java
                val metodoTornarDisponivelPorId =
                    clazzRepositorio.getDeclaredMethod("tornarDisponivelPorId", Int::class.java)

                val alterou = metodoTornarDisponivelPorId.invoke(musicaRepositorio, 1) as Boolean

                assertEquals(
                    false,
                    alterou,
                    "O método tornarDisponivelPorId deve retornar false caso não encontre a música para tornar disponível (quantidade de linhas afetadas = 0)."
                )

            } catch (e: NoSuchMethodException) {
                fail("O método tornarDisponivelPorId não foi encontrado na classe MusicaRepositorio... Verifique se ele foi implementado corretamente.")
            }
        }
    }
}