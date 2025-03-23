package sptech.projeto05

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import sptech.projeto05.controller.MusicaController
import kotlin.test.assertNotNull

@SpringBootTest
class Projeto05ApplicationTests {

	@Autowired
	lateinit var musicaController: MusicaController

	@Test
	fun `O projeto não possui erro de configuração da controller`() {
		assertNotNull(musicaController)
	}

}
