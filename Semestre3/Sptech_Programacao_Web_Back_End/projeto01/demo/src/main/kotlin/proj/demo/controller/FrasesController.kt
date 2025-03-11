package proj.demo.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

/* Usamos a anotação RestController
Ela diz pro Spring que essa classe é um controlador da API rest
ou seja, essa classe é responsável por receber as requisições HTTP
Ou seja, essa classe pode ter endpoints ou chamadas

    Por padrão,as Rest Controller são SINGLETON
    ou seja só existe 1 para toda aplicação*/

@RestController
class FrasesController {

    public var listaFrutas = listOf<String>("A uva é roxa e doce", "Laranja é cítrica");

    /* Aqui nos definimos uma chamada ou endpoint da nossa API
     Isso ocorreu pelo uso de anotação(Annotation)
     O que fica dentro dessa anotação é a uri
     as URIs seguem a conveção de nome kabeb-case(css-case)*/

    @GetMapping("/comprimentar")
    fun comprimentar(): String {
        return "Bem vindo!!!"
    }

    @GetMapping("/boa-noite")
    fun dormir(): String {
        return "Boa noite,Que hoje é dia";
    }

    @GetMapping("/resultado/{nome}")
    fun resultado(@PathVariable nome: String): String {
        return "Olá ${nome} em breve terá seu resultado";
    }

    @GetMapping("/somar/{n1}/{n2}")
    fun somar(@PathVariable n1: Double, @PathVariable n2: Double): String {
        return "A soma entre ${n1} e ${n2} é ${n1 + n2}";
    }

    @GetMapping("/frutas/{i}")
    fun contarFruta(@PathVariable i: Int): String {
        return listaFrutas.get(i);
    }

}