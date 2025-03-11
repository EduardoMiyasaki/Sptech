package school.sptech.estudoprova.controller

import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*
import school.sptech.estudoprova.dto.HeroiDTO
import school.sptech.estudoprova.model.Heroi

@RestController
@RequestMapping("/herois")
class HeroiController {

    var listaHerois = mutableListOf<Heroi>();

    @PostMapping
    fun criarHeroi(@RequestBody dto: HeroiDTO): ResponseEntity<Heroi> {
        val heroi: Heroi = Heroi(dto)
        listaHerois.add(heroi)
        return ResponseEntity.status(201).body(heroi)
    }

    @GetMapping
    fun listarHerois(
        @RequestParam nome: String?,
        @RequestParam poderMinimo: Double?
    ): ResponseEntity<List<Heroi>> {

        if (nome == null && poderMinimo == null) {
            if (listaHerois.isEmpty()) {
                return ResponseEntity.status(204).build()
            }
            return ResponseEntity.status(200).body(listaHerois);
        }

        val filtraNome = nome != null
        val filtraPoder = poderMinimo != null

        val listaFiltrada = mutableListOf<Heroi>();

        if (filtraNome && filtraPoder) {
            listaFiltrada.addAll(listaHerois.filter {
                it.nome == nome && it.poder!! >= poderMinimo!!
            })
        } else if (filtraNome) {
            listaFiltrada.addAll(
                listaHerois.filter { it.nome == nome })
        } else {
            listaFiltrada.addAll(
                listaHerois.filter { it.poder!! >= poderMinimo!! })
        }

        if (listaFiltrada.isEmpty()) {
            return ResponseEntity.status(204).build()
        }
        return ResponseEntity.status(200).body(listaFiltrada);
    }

    @GetMapping("/{id}")
    fun listarHeroiPeloId(@PathVariable id: Int): ResponseEntity<Heroi> {
        if (id in 0..< listaHerois.size) {
            return ResponseEntity.status(200).body(listaHerois[id])
        }
        return ResponseEntity.status(404).build()
    }

    @PutMapping("/{id}")
    fun atualizarHeroi(@PathVariable id: Int, @RequestBody dto: HeroiDTO): ResponseEntity<Heroi> {
        if (id in 0..< listaHerois.size) {
            listaHerois[id] = Heroi(dto);
            return ResponseEntity.status(200).body(listaHerois[id])
        }
        return ResponseEntity.status(404).build()
    }

    @DeleteMapping("/{id}")
    fun deletarHeroi(@PathVariable id: Int): ResponseEntity<String> {
        if (id in 0..< listaHerois.size) {
            listaHerois.removeAt(id)
            return ResponseEntity.status(204).build()
        }
        return ResponseEntity.status(404).build()
    }
}