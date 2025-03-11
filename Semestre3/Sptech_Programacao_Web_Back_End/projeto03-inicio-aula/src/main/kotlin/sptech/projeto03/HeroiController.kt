package sptech.projeto03

import org.springframework.http.HttpRequest
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/herois")
class HeroiController {

    val herois = mutableListOf<Heroi>(
        Heroi("Puri Puri", "A", 10_000),
        Heroi("Saitama", "C", 500_000),
        Heroi("King", "A", 300),
        Heroi("Cavaleiro sem licença", "C", 10),
    )

    var maisForte = Heroi("Superhomem", "S", 7_000_000)


    /*
    Quando retornamos objetos complexos, o Spring, por padrão
    converte ele em JSON
     */
    @GetMapping("/mais-forte")
    fun maisForte(): Heroi {
        return maisForte
    }

    // Aqui vai retornar uma lista de JSONs
    @GetMapping("/listar")  //   /herois
    fun todos(): List<Heroi> {
        return herois
    }

    /*
    Aqui usamos um recurso chamado Request param ou query param
    normalmente usamos ele para filtrar resultados
    O primeiro request param é sempre precedido de ?
    caso existem mais de 1, colocamos o &

    importante: Se há pelo menos 1 request param, dizemos que a URL tem uma query string

    o nome do paramêtro na Query String, por padrão, é o mesmo nome do paramêtro
    */
    @GetMapping
    fun listarPorClasseOuForca(
        @RequestParam(required = false) classe: String?, @RequestParam(required = false) forcaMinima: Int?
    ): List<Heroi> {

        if (classe == null && forcaMinima == null) {
            return herois
        } else {
            val filtraClasse = classe != null;
            val filtraforca = forcaMinima != null;

            if (filtraClasse && filtraforca) {
                return herois.filter {
                    it.classe == classe && it.forca!! >= forcaMinima!!
                }
            }
            if (filtraClasse) {
                return herois.filter { it.classe == classe }
            }
            return herois.filter { it.forca!! >= forcaMinima!! }
        }
    }

    @PostMapping("/{apelido}/{classe}/{forca}")
    fun criarHeroi(@PathVariable apelido: String, @PathVariable classe: String, @PathVariable forca: Int): String {
        val novoHeroi = Heroi(apelido, classe, forca);
        herois.add(novoHeroi);
        return "Heroi cadastrado com sucesso"
    }

    @PostMapping
    fun adicionarHeroi(@RequestBody novoHeroi: Heroi): String {
        herois.add(novoHeroi);
        return "Herói cadastrado com sucesso";
    }

    @DeleteMapping("/{id}")
    fun excluir(@PathVariable id: Int): String {
        herois.removeAt(id);
        return "Herói excluído com sucesso";
    }

    @GetMapping("/{id}")
    fun recuperar(@PathVariable id: Int): Heroi {
        return herois[id]

    }

    @PutMapping("/{id}")
    fun atualizar(@PathVariable id: Int, @RequestBody heroiAtualizado:Heroi ): ResponseEntity<String> {
        herois[id] = heroiAtualizado;
        return ResponseEntity.ok().body("200");
    }

    @PatchMapping("/{id}/{novaClasse}")
    fun mudarClasse(@PathVariable id: Int, @RequestBody novaClasse: String ): String {
        herois[id].classe = novaClasse;
        return "Herói atualizado com sucesso";
    }
}