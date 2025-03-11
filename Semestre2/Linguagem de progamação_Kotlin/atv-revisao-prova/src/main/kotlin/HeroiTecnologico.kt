class HeroiTecnologico : Heroi(), UsuarioGadgets {

    var gadgetAtual: String = ""
        private set

    override fun usarPoder(): String {
        return "O herói tecnológico $nome usa seu poder: $poderPrincipal, auxiliado por tecnologia avançada!"
    }

    override fun equiparGadget(gadget: String): String {
        this.gadgetAtual = gadget
        return "Gadget $gadget equipado pelo herói $nome."
    }

    override fun usarGadget(): String {
        if (gadgetAtual == "") {
            return "Nenhum gadget equipado"
        }
        else  return "O gadget $gadgetAtual foi ativado!"
    }

    override fun descrever(): String {
        return "Herói $nome: Poder Principal - $poderPrincipal, Energia - $nivelEnergia."
    }
}