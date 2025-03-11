package proj.demo.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/paises")
class PaisesController {

    var paises = mutableListOf("Brasil", "México", "Chile", "Peru")

    @GetMapping
    fun listarPaises(): String {
        return """
             ${paises.size} paises encontrados"
            Paises: $paises,
        """.trimIndent()
    }

    @GetMapping("/{id}")
    fun listarPaisesPeloID(@PathVariable id: Int): String {
        validarId(id)
        return "Pais: ${paises[id]}";
    }

    @GetMapping("novo/{nomePais}")
    fun adicionarPais(@PathVariable nomePais: String): String {
        paises.add(nomePais);
        return "País ${nomePais} adicionado com sucesso";
    }

    @GetMapping("/excluir/{id}")
    fun excluirPais(@PathVariable id: Int): String {
        validarId(id);
        paises.removeAt(id)
        return "País removido com sucesso"
    }

    fun validarId(id: Int): String {
        if (id >= paises.size || id < 0) {
            return "País com id $id não existe"
        }
        return "";
    }

    @GetMapping("/editar/{id}/{novoNome}")
    fun atualizarPais(@PathVariable id: Int, @PathVariable novoNome: String): String {
        validarId(id);
        val paisAntigo = paises[id];
        paises.set(id, novoNome);
        return "País $paisAntigo agora se chama ${paises[id]}";
    }
}