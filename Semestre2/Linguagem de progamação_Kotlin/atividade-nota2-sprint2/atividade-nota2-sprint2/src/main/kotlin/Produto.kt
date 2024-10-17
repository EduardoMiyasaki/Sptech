class Produto {

    var id: Int = 0

    var nome: String = ""
        private set

    var categoria: String = ""
        private set

    var preco: Double = 0.0
        private set

    var fabricante: String = ""
        private set


    fun setNome(nome: String) {

        if (nome.length > 3) {
            this.nome = nome;
        } else println("Nome inválido! Deve ter mais de 3 caracteres");
    }

    fun setCategoria(categoria: String) {

        if (categoria.length > 5) {
            this.categoria = categoria;
        } else println("Categoria inválida! Deve ter mais de 5 caracteres")
    }

    fun setPreco(preco: Double) {
        if (preco > 0) {
            this.preco = preco;
        } else println("Preço inválido! Deve ser maior que 0")
    }

    fun setFabricante(fabricante: String) {

        if (fabricante.length >= 2) {
            this.fabricante = fabricante;
        }
        else println("Fabricante inválido! Deve ter mais de 2 caracteres");
    }
}