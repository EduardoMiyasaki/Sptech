**BAIXE O ZIP NO FINAL DO ENUNCIADO PARA A REALIZAÇÃO DA ATIVIDADE.**

# 🎧 Bem-vindo ao Spot4You – Sua Plataforma de Streaming Favorita! 🎶

Você foi contratado para trabalhar no time de desenvolvimento do **Spot4You**, a plataforma de streaming que é a nova sensação entre os amantes da música. Aqui, **a música é poder** e **a programação é o ritmo que mantém tudo funcionando**. Seu desafio? 💻 Criar um sistema de cadastro de músicas para o banco de dados, garantindo que todas as faixas estejam perfeitamente organizadas 🎵 e prontas para tocar nas playlists dos usuários! 🎧

## 🎯 Missão Principal

Implementar e gerenciar a classe `Musica`, uma estrela oculta que vai brilhar nos bastidores do Spot4You. 🌟

# 🎼 1. Criação da Classe Musica 🎶

Agora é hora de você colocar a mão na massa e ajudar a criar a estrutura básica da nossa estrela, a classe `Musica`! 🌟

Utilize a classe `Musica` já criada e, dentro dela, implemente os seguintes atributos (⚠️ **NÃO CRIE CONSTRUTOR, CRIE COMO ATRIBUTOS DE CLASSE/INSTÂNCIA**):

🚨 **OBS:** TODOS OS ATRIBUTOS DEVEM TER O "SET" PRIVADO (MENOS `id`).

### 🎵 Atributos da Musica:

- `id` (tipo: INTEIRO, valor padrão: 0): Representa o **identificador único** da música (PÚBLICO). 🆔
- `titulo` (tipo: TEXTO, valor padrão ""): O **título** da música. 🎶
- `artista` (tipo: TEXTO, valor padrão ""): O nome do **artista**. 🎤
- `album` (tipo: TEXTO, valor padrão ""): O nome do **álbum** da música. 💿
- `duracao` (tipo: INTEIRO, valor padrão: 0): A **duração** da música em segundos. ⏱️
- `disponivel` (tipo: BOOLEANO, valor padrão: false): Indica se a música está **disponível** para reprodução. ✅🚫

---

## ⚠️ Regras Importantes! 🎶

Não é qualquer música que entra na nossa base de dados. 📂 Você precisa seguir algumas regras (porque até no mundo da música, as boas práticas são importantes!):

1. **🎤 Títulos impactantes**: Não aceitamos músicas com títulos vazios ou muito curtos. O mínimo são **2 caracteres** para evitar que uma música se chame só "A" ou "M". 📝
- **Método**: `setTitulo(novoValor: String)`
---
2. **🎸 Artistas de verdade**: Não dá pra aceitar um artista sem nome, certo? Mínimo de **2 caracteres** também! 🎙️
- **Método**: `setArtista(novoValor: String)`
---
3. **💿 Álbuns inesquecíveis**: O mesmo vale para os álbuns. Precisamos de nomes decentes (ao menos **2 caracteres**) para dar aquela credibilidade. 📀
- **Método**: `setAlbum(novoValor: String)`
---
4. **⏱️ Duração apropriada**: Músicas com menos de **30 segundos**? ⛔ Nem pensar! A música precisa ter pelo menos esse tempo para entrar no Spot4You. Não queremos apenas toques de celular. 📱
- **Método**: `setDuracao(novoValor: Int)`
---
5. **🚦 Disponibilidade**: Cada música tem que ser marcada como disponível ✅ ou não 🚫, porque no Spot4You, não basta só criar – **você decide** se a música entra no ar 📡 ou fica guardada para um grande lançamento. 🚀 (não faça nenhuma validação, apenas atribua o valor)
- **Método**: `setDisponivel(novoValor: Boolean)`
---
6. 🕒 Método para converter a duração da música em minutos e segundos

- **Método**: `converterDuracaoEmMinutos(): String`
- **Objetivo**: Converter a duração da música para o formato "mm:ss". 🎧⏲️
- **Retorno**: Retorna a duração da música no formato "mm:ss". 🕑🎶

### 🔍 Explicação:

Esse método vai calcular a duração da música em **minutos** e **segundos**, a partir da quantidade total de segundos, e formatar o resultado para aparecer no formato "mm:ss", com zeros à esquerda, para ficar tudo bonitinho! 🤓🎼

### ✍️ Como fazer:

1. Divida a quantidade total de segundos por **60** para obter os minutos:
  - `minutos = duracao / 60` ⏳🎶

2. O **resto** da divisão por 60 será os **segundos**:
  - `segundos = duracao % 60` ⏱️🎵

3. Formate o resultado para ter exatamente **2 dígitos** em cada parte (minutos e segundos). Assim, vai aparecer como "mm:ss". ✨

### 🎼 Exemplos:

- Para uma música com **3 minutos e 45 segundos** de duração (225 segundos), o método deve retornar `"03:45"`. 🎶🔄
- Para uma música com **1 minuto e 5 segundos** de duração (65 segundos), o retorno deve ser `"01:05"`. 🎵⏲️

- Para garantir que o formato tenha sempre dois dígitos, use o método `padStart` da classe `String`. O `padStart(2, '0')` preenche o número com zeros à esquerda até que tenha exatamente 2 dígitos.


## 🛠️ Vamos Gerenciar Nossas Músicas com Estilo! 🎶

Parabéns, você foi escolhido para cuidar do **MusicaRepositorio**, o lugar onde as faixas mais épicas do Spot4You são armazenadas e organizadas! 📀🎸 Aqui está a missão: construir os métodos que vão controlar tudo – da criação à remoção das músicas. Bora codar ao som das suas playlists favoritas! 🎧💻

### 📀 a) Criar a Tabela de Músicas

- **Método:** `criarTabela()`
- **Retorno:** Não retorna nada (tipo aquele silêncio antes do drop 🎶).
- **Observação:** Este método é responsável por **criar a tabela de músicas no banco de dados**. Se algo der errado e a tabela sair toda errada, o teste vai falhar e seu chefe vai te mandar uma música triste. 😢 Então, capriche!

### ➕ b) Inserir Nova Música

- **Método:** `inserir(novaMusica: Musica): Boolean`
- **Retorno:** O método vai conferir se a música foi adicionada com sucesso ao banco. Se mais de 0 linhas forem afetadas, retorna `true` (vamos festejar 🎉); caso contrário, retorna `false` (o clima fica tenso 😬).
- **Observação:** Ao inserir, lembre-se de adicionar **todos os atributos, exceto o `id`**. O `id` é autogerado, tipo aquele sucesso que surge do nada! 🎤

### 📜 c) Listar Todas as Músicas

- **Método:** `listar(): List<Musica>`
- **Retorno:** Vai retornar uma lista com **todas as músicas cadastradas**, prontas para arrasar nas playlists dos usuários. Imagina o Spot4You cheio de hits! 💥

### 🔍 d) Verificar se uma Música Existe por ID

- **Método:** `existePorId(id: Int): Boolean`
- **Retorno:** Retorna `true` se a música existe, ou `false` se o ID que você passou não leva a nenhuma faixa (tipo aquela busca no catálogo e você não acha sua música favorita 😔).

### 🎯 e) Buscar uma Música por ID

- **Método:** `buscarPorId(id: Int): Musica`
- **Retorno:** Retorna a música correspondente ao ID buscado. Aqui é onde você encontra aquela música que todos estão procurando! 🎧

### 🔄 f) Atualizar uma Música por ID

- **Método:** `atualizarPorId(id: Int, musicaParaAtualizar: Musica): Boolean`
- **Retorno:** Verifica se a atualização foi um sucesso. Se mais de 0 linhas foram afetadas, retorna `true` (mudança aprovada! 🎉); caso contrário, `false` (erro na remixagem 😬).
- **Observação:** Você pode atualizar todos os atributos, **exceto o `id`** (ele é sagrado!).

### ❌ g) Deletar uma Música por ID

- **Método:** `deletarPorId(id: Int): Boolean`
- **Retorno:** Verifica se a música foi removida do banco. Se mais de 0 linhas forem afetadas, retorna `true` (adeus, música! 👋); se não, `false` (parece que a música se apegou ao banco 😅).

### ✅ h) Verificar Disponibilidade de uma Música por ID

- **Método:** `disponivelPorId(id: Int): Boolean`
- **Retorno:** Retorna `true` se a música estiver disponível para streaming ou `false` se estiver guardada no cofre esperando o momento certo de brilhar. 💫
- **Dica:** No `SELECT`, pegue apenas o campo `disponivel` (nada de trazer todos os dados de uma vez, porque eficiência é a chave aqui 🔑).

### 🚀 i) Tornar uma Música Disponível por ID

- **Método:** `tornarDisponivelPorId(id: Int): Boolean`
- **Retorno:** Atualiza o campo `disponivel` para `true` (a música foi liberada e está pronta para tocar 🎉) e verifica se a alteração foi bem-sucedida.

## 🎤 Considerações Finais

- **Não precisa se preocupar com a `main`** – a estrela do show aqui são as classes que você vai criar! 🌟
- Temos **testes unitários** prontos para dar aquele suporte e facilitar a correção do que for desenvolvido. É como ter um técnico de som afinando tudo enquanto você codifica! 🎛️🎶
- Se os **testes unitários** parecerem um obstáculo, sem problemas! Dá pra usar a `main` e testar manualmente o que você acabou de implementar. Afinal, testar novas melodias nunca é demais! 🎧
- **Por favor, não altere** o nome dos métodos e atributos propostos nos requisitos. Manter a harmonia no código é essencial para não desafinar o projeto! 🎵🚫
