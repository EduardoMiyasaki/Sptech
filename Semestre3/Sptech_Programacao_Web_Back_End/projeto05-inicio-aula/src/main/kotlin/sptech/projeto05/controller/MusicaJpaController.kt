package sptech.projeto05.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import sptech.projeto05.entity.Musica
import sptech.projeto05.repository.MusicaRepository

@RestController
@RequestMapping("/musicas")
class MusicaJpaController(val repositorio: MusicaRepository) {

    @GetMapping
    fun get(): ResponseEntity<List<Musica>> {
        val musicas = repositorio.findAll();
        return ResponseEntity.status(200).body(musicas);
    }

    @PostMapping
    fun salvarMusica(@RequestBody musica: Musica ): ResponseEntity<Musica> {
        repositorio.save(musica);
        return ResponseEntity.status(201).body(musica)
    }
}