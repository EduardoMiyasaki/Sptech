package proj.demo.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class ContadorController {

    var contagem = 0;

    @GetMapping("/contador")
    fun contar(): String{
        contagem ++;
        return "Você chamou $contagem vezes"
    }

}