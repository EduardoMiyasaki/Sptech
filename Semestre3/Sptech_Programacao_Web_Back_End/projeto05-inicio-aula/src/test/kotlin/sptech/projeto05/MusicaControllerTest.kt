package sptech.projeto05

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import sptech.projeto05.controller.MusicaController
import sptech.projeto05.entity.Musica
import java.time.LocalDate
import kotlin.reflect.full.findAnnotation
import kotlin.reflect.full.valueParameters

class MusicaControllerTest {

    private lateinit var musicaController: MusicaController

    @BeforeEach
    fun setUp() {
        musicaController = MusicaController()
        musicaController.musicas.clear()
        musicaController.musicas.addAll(
            listOf(
                Musica(1, "Aquarela", "Toquinho", LocalDate.parse("2023-01-01")),
                Musica(2, "O Bêbado e o Equilibrista", "Elis Regina", LocalDate.parse("2023-02-01")),
                Musica(3, "O Mundo é um Moinho", "Cartola", LocalDate.parse("2023-03-01")),
                Musica(4, "Cálice", "Chico Buarque", LocalDate.parse("2023-04-01")),
                Musica(5, "Apesar de Você", "Chico Buarque", LocalDate.parse("2023-05-01"))
            )
        )
    }

    @Test
    @DisplayName("a classe é uma Rest Controller")
    fun classe_eh_rest_controller() {
        val anotacaoReqMapping = MusicaController::class.findAnnotation<RestController>()
        assertNotNull(anotacaoReqMapping)
    }

    @Test
    @DisplayName("a URI base é a correta")
    fun uri_base_correta() {
        val anotacaoReqMapping = MusicaController::class.findAnnotation<RequestMapping>()
        assertNotNull(anotacaoReqMapping)
        val uri = anotacaoReqMapping!!.value[0]
        assertTrue(uri == "/musicas" || uri == "musicas")
    }

    @Test
    @DisplayName("getLista() é um endpoint")
    fun get_lista_eh_endpoint() {
        val anotacao = MusicaController::getLista.findAnnotation<GetMapping>()
        assertNotNull(anotacao)
        assertTrue(anotacao?.value!!.isEmpty())
    }

    @Test
    @DisplayName("getLista() está com os parâmetros corretos")
    fun get_lista_parametros_corretos() {
        val parametros = MusicaController::getLista.valueParameters
        assertEquals(1, parametros.size)

        val anotacao = parametros[0].findAnnotation<RequestParam>()
        assertNotNull(anotacao)
    }

    @Test
    @DisplayName("post() é um endpoint")
    fun post_eh_endpoint() {
        val anotacao = MusicaController::post.findAnnotation<PostMapping>()
        assertNotNull(anotacao)
        assertTrue(anotacao?.value!!.isEmpty())
    }

    @Test
    @DisplayName("post() está com os parâmetros corretos")
    fun post_parametros_corretos() {
        val parametros = MusicaController::post.valueParameters
        assertEquals(1, parametros.size)

        val anotacao = parametros[0].findAnnotation<RequestBody>()
        assertNotNull(anotacao)
    }

    @Test
    @DisplayName("delete() é um endpoint")
    fun delete_eh_endpoint() {
        val anotacao = MusicaController::delete.findAnnotation<DeleteMapping>()
        assertNotNull(anotacao)
        assertEquals("/{id}", anotacao!!.value[0])
    }

    @Test
    @DisplayName("delete() está com os parâmetros corretos")
    fun delete_parametros_corretos() {
        val parametros = MusicaController::delete.valueParameters
        assertEquals(1, parametros.size)

        val anotacao = parametros[0].findAnnotation<PathVariable>()
        assertNotNull(anotacao)
    }

    @Test
    @DisplayName("getUm() é um endpoint")
    fun get_um_eh_endpoint() {
        val anotacao = MusicaController::getUm.findAnnotation<GetMapping>()
        assertNotNull(anotacao)
        assertEquals("/{id}", anotacao!!.value[0])
    }

    @Test
    @DisplayName("getUm() está com os parâmetros corretos")
    fun get_um_parametros_corretos() {
        val parametros = MusicaController::getUm.valueParameters
        assertEquals(1, parametros.size)

        val anotacao = parametros[0].findAnnotation<PathVariable>()
        assertNotNull(anotacao)
    }

    @Test
    @DisplayName("put() é um endpoint")
    fun put_eh_endpoint() {
        val anotacao = MusicaController::put.findAnnotation<PutMapping>()
        assertNotNull(anotacao)
        assertEquals("/{id}", anotacao!!.value[0])
    }

    @Test
    @DisplayName("put() está com os parâmetros corretos")
    fun put_parametros_corretos() {
        val parametros = MusicaController::put.valueParameters
        assertEquals(2, parametros.size)

        val anotacao = parametros[0].findAnnotation<PathVariable>()
        assertNotNull(anotacao)

        val anotacao2 = parametros[1].findAnnotation<RequestBody>()
        assertNotNull(anotacao2)
    }

    @Test
    @DisplayName("patchImproprioMenores() é um endpoint")
    fun patch_improprio_menores_eh_endpoint() {
        val anotacao = MusicaController::patchImproprioMenores.findAnnotation<PatchMapping>()
        assertNotNull(anotacao)
        assertEquals("/improprio-menores/{id}", anotacao!!.value[0])
    }

    @Test
    @DisplayName("patchImproprioMenores() está com os parâmetros corretos")
    fun patch_improprio_menores_parametros_corretos() {
        val parametros = MusicaController::patchImproprioMenores.valueParameters
        assertEquals(1, parametros.size)

        val anotacao = parametros[0].findAnnotation<PathVariable>()
        assertNotNull(anotacao)
    }

    @Test
    @DisplayName("patchProprioMenores() é um endpoint")
    fun patch_proprio_menores_eh_endpoint() {
        val anotacao = MusicaController::patchProprioMenores.findAnnotation<PatchMapping>()
        assertNotNull(anotacao)
        assertEquals("/proprio-menores/{id}", anotacao!!.value[0])
    }

    @Test
    @DisplayName("patchProprioMenores() está com os parâmetros corretos")
    fun patch_proprio_menores_parametros_corretos() {
        val parametros = MusicaController::patchProprioMenores.valueParameters
        assertEquals(1, parametros.size)

        val anotacao = parametros[0].findAnnotation<PathVariable>()
        assertNotNull(anotacao)
    }

    @Test
    @DisplayName("patchMusicaOuvida() é um endpoint")
    fun patch_musica_ouvida_eh_endpoint() {
        val anotacao = MusicaController::patchMusicaOuvida.findAnnotation<PatchMapping>()
        assertNotNull(anotacao)
        assertEquals("/musica-ouvida/{id}", anotacao!!.value[0])
    }

    @Test
    @DisplayName("patchMusicaOuvida() está com os parâmetros corretos")
    fun patch_musica_ouvida_parametros_corretos() {
        val parametros = MusicaController::patchMusicaOuvida.valueParameters
        assertEquals(1, parametros.size)

        val anotacao = parametros[0].findAnnotation<PathVariable>()
        assertNotNull(anotacao)
    }


    @Test
    @DisplayName("get sem pesquisa retorna todas as musicas")
    fun get_sem_pesquisa_retorna_todas_musicas() {
        val response = musicaController.getLista(null)
        assertEquals(HttpStatus.OK, response.statusCode)
        assertEquals(5, response.body?.size)
    }

    @Test
    @DisplayName("get com pesquisa filtra musicas por nome ou interprete")
    fun get_com_pesquisa_filtra_musicas() {
        val response = musicaController.getLista("Chico")
        assertEquals(HttpStatus.OK, response.statusCode)
        assertEquals(2, response.body?.size)
        assertTrue(response.body?.all { it.interprete.contains("Chico") }!!)
    }

    @Test
    @DisplayName("get sem pesquisa e retorna sem corpo e o status correto")
    fun get_sem_pesquisa_sem_corpo_status_correto() {
        musicaController.musicas.clear()
        val response = musicaController.getLista(null)
        assertEquals(HttpStatus.NO_CONTENT, response.statusCode)
        assertNull(response.body)
    }

    @Test
    @DisplayName("get com pesquisa e sem correspondencias retorna sem corpo e o status correto")
    fun get_com_pesquisa_sem_correspondencias_sem_corpo_status_correto() {
        val response = musicaController.getLista("Inexistente")
        assertEquals(HttpStatus.NO_CONTENT, response.statusCode)
        assertNull(response.body)
    }

    @Test
    @DisplayName("post adiciona uma nova musica")
    fun post_adiciona_nova_musica() {
        val novaMusica = Musica(0, "Nova Música", "Novo Artista")
        val response = musicaController.post(novaMusica)
        assertEquals(HttpStatus.CREATED, response.statusCode)
        assertEquals(6, musicaController.musicas.size)
        assertEquals(6, response.body?.id)
        assertEquals("Nova Música", response.body?.nome)
        assertEquals(LocalDate.now(), response.body?.dataCadastro)
    }

    @Test
    @DisplayName("delete remove uma musica por id")
    fun delete_remove_musica_por_id() {
        val response = musicaController.delete(1)
        assertEquals(HttpStatus.NO_CONTENT, response.statusCode)
        assertEquals(4, musicaController.musicas.size)
        assertNull(musicaController.musicas.find { it.id == 1 })
    }

    @Test
    @DisplayName("delete retorna o status correto para id inexistente")
    fun delete_retorna_status_correto_id_inexistente() {
        val response = musicaController.delete(100)
        assertEquals(HttpStatus.NOT_FOUND, response.statusCode)
    }

    @Test
    @DisplayName("get por id retorna a musica")
    fun get_por_id_retorna_musica() {
        val response = musicaController.getUm(2)
        assertEquals(HttpStatus.OK, response.statusCode)
        assertEquals("O Bêbado e o Equilibrista", response.body?.nome)
    }

    @Test
    @DisplayName("get por id retorna o status correto e sem corpo para id inexistente")
    fun get_por_id_retorna_status_correto_sem_corpo_id_inexistente() {
        val response = musicaController.getUm(100)
        assertEquals(HttpStatus.NOT_FOUND, response.statusCode)
        assertNull(response.body)
    }

    @Test
    @DisplayName("put atualiza uma musica")
    fun put_atualiza_musica() {
        val musicaAtualizada = Musica(0, "Música Atualizada", "Artista Atualizado", LocalDate.now())
        val response = musicaController.put(3, musicaAtualizada)
        assertEquals(HttpStatus.OK, response.statusCode)
        assertEquals("Música Atualizada", response.body?.nome)
        assertEquals(3, response.body?.id)
        assertEquals("Música Atualizada", musicaController.musicas.find { it.id == 3 }?.nome)
    }

    @Test
    @DisplayName("put retorna o status correto e sem corpo para id inexistente")
    fun put_retorna_status_correto_sem_corpo_id_inexistente() {
        val musicaAtualizada = Musica(0, "Música Atualizada", "Artista Atualizado", LocalDate.now())
        val response = musicaController.put(100, musicaAtualizada)
        assertEquals(HttpStatus.NOT_FOUND, response.statusCode)
        assertNull(response.body)
    }

    @Test
    @DisplayName("patchImproprioMenores define propriaParaCriancas como falso")
    fun patch_improprio_menores_define_propria_para_criancas_falso() {
        val response = musicaController.patchImproprioMenores(1)
        assertEquals(HttpStatus.OK, response.statusCode)
        assertFalse(response.body?.propriaParaCriancas ?: true)
        assertFalse(musicaController.musicas.find { it.id == 1 }?.propriaParaCriancas ?: true)
    }

    @Test
    @DisplayName("patchImproprioMenores retorna o status correto e sem corpo para id inexistente")
    fun patch_improprio_menores_retorna_status_correto_sem_corpo_id_inexistente() {
        val response = musicaController.patchImproprioMenores(100)
        assertEquals(HttpStatus.NOT_FOUND, response.statusCode)
        assertNull(response.body)
    }

    @Test
    @DisplayName("patchProprioMenores define propriaParaCriancas como verdadeiro")
    fun patch_proprio_menores_define_propria_para_criancas_verdadeiro() {
        val response = musicaController.patchProprioMenores(4)
        assertEquals(HttpStatus.OK, response.statusCode)
        assertTrue(response.body?.propriaParaCriancas ?: false)
        assertTrue(musicaController.musicas.find { it.id == 4 }?.propriaParaCriancas ?: false)
    }

    @Test
    @DisplayName("patchProprioMenores retorna o status correto e sem corpo para id inexistente")
    fun patch_proprio_menores_retorna_status_correto_sem_corpo_id_inexistente() {
        val response = musicaController.patchProprioMenores(100)
        assertEquals(HttpStatus.NOT_FOUND, response.statusCode)
        assertNull(response.body)
    }

    @Test
    @DisplayName("patchMusicaOuvida incrementa quantidadeReproducoes")
    fun patch_musica_ouvida_incrementa_quantidade_reproducoes() {
        val response = musicaController.patchMusicaOuvida(1)
        assertEquals(HttpStatus.OK, response.statusCode)
        assertEquals(1, response.body?.quantidadeReproducoes)
        assertEquals(1, musicaController.musicas.find { it.id == 1 }?.quantidadeReproducoes)

        val response2 = musicaController.patchMusicaOuvida(1)
        assertEquals(2, response2.body?.quantidadeReproducoes)
        assertEquals(2, musicaController.musicas.find { it.id == 1 }?.quantidadeReproducoes)
    }

    @Test
    @DisplayName("patchMusicaOuvida retorna o status correto e sem corpo para id inexistente")
    fun patchMusicaOuvida_retorna_o_status_correto_e_sem_corpo_para_id_inexistente() {
        val response = musicaController.patchMusicaOuvida(100)
        assertEquals(HttpStatus.NOT_FOUND, response.statusCode)
        assertNull(response.body)
    }
}
