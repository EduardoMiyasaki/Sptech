fun main(){
    /*Atividade de Gerenciamento de Produtos em Kotlin
    BAIXE O ZIP NO FINAL DO ENUNCIADO PARA A REALIZAÇÃO DA ATIVIDADE.

    Objetivo
    Desenvolver um sistema de gerenciamento de produtos com validação de dados e controle de disponibilidade em estoque.

    1. Criação da Classe Produto
            Utilize a classe Produto já criada e implemente os seguintes atributos (NÃO CRIE CONSTRUTOR, CRIE COMO ATRIBUTOS DE CLASSE/INSTÂNCIA):

    OBS: TODOS OS ATRIBUTOS DEVEM TER O "SET" PRIVADO (EXCETO id).

    id (tipo: INTEIRO, valor padrão: 0): Representa o identificador único do produto (PÚBLICO).
    nome (tipo: TEXTO, valor padrão: ""): O nome do produto.
    categoria (tipo: TEXTO, valor padrão: ""): A categoria do produto.
    preco (tipo: DECIMAL, valor padrão: 0.0): O preço do produto.
    quantidade (tipo: INTEIRO, valor padrão: 0): A quantidade disponível em estoque.
    disponivel (tipo: BOOLEANO, valor padrão: false): Indica se o produto está disponível para venda.
    2. Métodos da Classe Produto
            Implemente métodos com validações para garantir a consistência dos dados do produto.

    a) Método para definir o nome do produto

    Método: setNome(novoValor: String)
    Objetivo: Definir o nome do produto.
    Validação: O nome deve ter 2 ou mais caracteres, caso contrário, não faça nada.
    b) Método para definir a categoria do produto

    Método: setCategoria(novoValor: String)
    Objetivo: Definir a categoria do produto.
    Validação: A categoria deve ter 2 ou mais caracteres, caso contrário, não faça nada.
    c) Método para definir o preço do produto

    Método: setPreco(novoValor: Double)
    Objetivo: Definir o preço do produto.
    Validação: O preço deve ser maior que 0.0, caso contrário, não faça nada.
    d) Método para definir a quantidade do produto

    Método: setQuantidade(novoValor: Int)
    Objetivo: Definir a quantidade do produto.
    Validação: A quantidade deve ser maior ou igual a 0, caso contrário, não faça nada.
    e) Método para verificar se o produto está disponível

    Método: verificarDisponibilidade(): Boolean
    Objetivo: Retornar se o produto está disponível para venda.
    Retorno: Retorna true se a quantidade for maior que 0 e o produto estiver marcado como disponível; caso contrário, retorna false.
    f) Método para descrever o produto

    Método: descrever(): String
    Objetivo: Descrever o produto com todas as informações.
    Retorno: Retorna uma string com os detalhes do produto.
    Exemplo:

    kotlin
    Copiar código
            return """
    Id: ${id}
    Nome: ${nome}
    Categoria: ${categoria}
    Preço: ${preco}
    Quantidade: ${quantidade}
    Disponível: ${if (disponivel) "Sim" else "Não"}
""".trimIndent()
    3. Métodos da Classe ProdutoRepositorio
            Utilize a classe ProdutoRepositorio já criada e implemente os seguintes métodos:

    a) Criar a tabela de produtos

    Método: criarTabela()
    Retorno: Não retorna nada.
    Observação: O método deve criar a tabela de produtos no banco de dados conforme os atributos definidos.
    b) Inserir novo produto

    Método: inserir(novoProduto: Produto): Boolean
    Retorno: Retorna true se o produto for inserido com sucesso; caso contrário, retorna false.
    c) Listar todos os produtos

    Método: listar(): List<Produto>
    Retorno: Retorna uma lista de todos os produtos cadastrados.
    d) Verificar se um produto existe por id

    Método: existePorId(id: Int): Boolean
    Retorno: Retorna true se o produto existir; caso contrário, retorna false.
    e) Buscar um produto por id

    Método: buscarPorId(id: Int): Produto
    Retorno: Retorna o produto correspondente ao id.
    f) Atualizar um produto por id

    Método: atualizarPorId(id: Int, produtoParaAtualizar: Produto): Boolean
    Retorno: Retorna true se o produto for atualizado com sucesso; caso contrário, retorna false.
    g) Deletar um produto por id

    Método: deletarPorId(id: Int): Boolean
    Retorno: Retorna true se o produto for deletado com sucesso; caso contrário, retorna false.
    h) Verificar se um produto está disponível para venda por id

    Método: disponivelPorId(id: Int): Boolean
    Retorno: Retorna true se o produto estiver disponível para venda; caso contrário, retorna false.
    i) Atualizar disponibilidade de um produto por id

    Método: atualizarDisponibilidadePorId(id: Int, disponivel: Boolean): Boolean
    Retorno: Atualiza o campo disponível do produto por id e retorna true se a atualização for bem-sucedida; caso contrário, retorna false.
    Considerações Finais

            Não será necessário desenvolver nada na main, apenas as classes.
    Utilize os testes unitários fornecidos para verificar o desenvolvimento.
    */

}