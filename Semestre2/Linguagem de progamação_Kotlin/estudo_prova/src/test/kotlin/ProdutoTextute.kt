class ProdutoFixture {
    companion object {
        fun umProduto(): Produto {

            val clazz = Produto::class.java
            val produto = clazz.getDeclaredConstructor().newInstance()

            clazz.getDeclaredField("id").let {
                it.isAccessible = true
                it.set(produto, 1)
            }

            clazz.getDeclaredField("nome").let {
                it.isAccessible = true
                it.set(produto, "Smartphone")
            }

            clazz.getDeclaredField("categoria").let {
                it.isAccessible = true
                it.set(produto, "Eletrônicos")
            }

            clazz.getDeclaredField("preco").let {
                it.isAccessible = true
                it.set(produto, 999.99)
            }

            clazz.getDeclaredField("estoque").let {
                it.isAccessible = true
                it.set(produto, 50)
            }

            clazz.getDeclaredField("disponivel").let {
                it.isAccessible = true
                it.set(produto, true)
            }

            return produto
        }
    }
}
