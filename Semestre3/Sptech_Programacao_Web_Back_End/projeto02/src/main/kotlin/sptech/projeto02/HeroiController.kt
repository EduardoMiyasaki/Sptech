package sptech.projeto02

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/herois")
class HeroiController {

    val herois = mutableListOf<Heroi>(
        Heroi("Puri puri", "A", 10_000),
        Heroi("Saitama", "C", 500_000),
        Heroi("King", "A", 300)
    )

    val maisForte = Heroi("SuperHomem", "S", 7_000_000);

   /*O spring retorna um JSON de Heroi Com todos os getters*/
    @GetMapping("/mais-forte")
    fun maisForte(): Heroi {
        return maisForte;
    }

    @GetMapping
    fun listarHerois(): List<Heroi> {
        return herois;
    }

    fun adicionarHeroi(heroi: Heroi) {
        herois.add(heroi);
    }

}