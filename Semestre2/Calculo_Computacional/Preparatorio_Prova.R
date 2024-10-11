# Exercício 2
set.seed(20)
notas <-data.frame(Matricula = sample(x = 011475:012990, size = 30, replace = FALSE),
                    ac1 = sample(x = 1:10, size = 30, replace = TRUE),
                    ac2 = sample(x = 1:10, size = 30, replace = TRUE),
                    prova_final= sample(x = 1:10, size = 30, replace = TRUE))

# size significa que são 30 matriculas
# replace os dados não são repetidos

# Substituindo as notas para elas só que com o peso correto
pesoAC1 = notas$ac1 * 0.4
pesoAC1

pesoAC2 = notas$ac2 * 0.4
pesoAC2

provaFinal = notas$prova_final * 0.2
provaFinal

# Fazendo a média ponderada
media = pesoAC1 + pesoAC2 + provaFinal

# Adicionando a média dos alunos ao dataFrame
notas$media = media

# Adicionando uma nova coluna que se a nota do aluno for maior que 7
# ele está aprovado
notas$aprovado = ifelse(notas$media > 7, "Sim", "Não")

notas
aprovados = table(notas$aprovado)
aprovados
summary(notas$ac1)
summary(notas$ac2)

                        # Exercício 3
Produto_Vendedor = data.frame(Vendedor = c("Ana","Flavia","Pedro","Mariana","Ana","Flavia","Pedro","Mariana"),
                              Dia =c(1,1,1,1,2,2,2,2),
                              Produto = c("Saia","Casaco","Vestido","Meia","CalçaFlaire",
                              "CalçaSkinny","CalçaSkinny","Manta"),
                              Quantidade = c(1,2,1,5,3,0,3,4))

Precos = data.frame(Produto = c("Calça","Vestido","Blusa",
                    "Manta","Saia","Casaco","Meia"),
                    Preco_Unitario = c(240,320,98,69,145,289,39),
                    Custo_Unitario = c(210,160,60,39,89,144,15))

Produto_Vendedor$Lucro = ifelse(Produto_Vendedor$Produto %in% Precos$Produto,
                            Produto_Vendedor$Quantidade * (Precos$Preco_Unitario - Precos$Custo_Unitario), 0)

View(Produto_Vendedor)

Lucro_Vendedor = data.frame(Produto_Vendedor$Vendedor, Produto_Vendedor$Lucro)
Lucro_Vendedor

# Resumindo o lucro por vendedor
Lucro_Vendedor = aggregate(Lucro ~ Vendedor, data = Produto_Vendedor, sum)

# Gráfico de barras com a função base do R
barplot(Lucro_Vendedor$Lucro, 
        names.arg = Lucro_Vendedor$Vendedor, 
        xlab = "Vendedores", 
        ylab = "Lucro", 
        main = "Lucro do Vendedor Por dia")

