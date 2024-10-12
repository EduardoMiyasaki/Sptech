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
# Lucro ~ Vendedor = Lucro é a Variável que será resumida
# Data eu passo de qual dataframe os dados estão sendo retirados
# Sum soma os lucro dos vendedores
Lucro_Vendedor = aggregate(Lucro ~ Vendedor, data = Produto_Vendedor, sum)

# Gráfico de barras com a função base do R
barplot(Lucro_Vendedor$Lucro, 
        names.arg = Lucro_Vendedor$Vendedor, 
        xlab = "Vendedores", 
        ylab = "Lucro", 
        main = "Lucro do Vendedor Por dia")

                              # Exercício 4

numero1 = as.numeric(readline(prompt="Digite um Número:"))
numero2 = as.numeric(readline(prompt="Digite um Número:"))

maior = ifelse(numero1 > numero2, "numero1 Numero 1 maior que 2", "${numero2} maior que 1")
maior

                          # Exercício 5
# Utilizando seed =10, 
# crie um vetor de valores numéricos com o seguinte código:

set.seed(10)

vetorNumerico <- sample(x = 1:25, size = 800, replace = TRUE)
# Calcule a frequência em que cada número apare

table(vetorNumerico)


                        # Exercício 6

set.seed(50)

vendas <- data.frame(Qtd = sample(x = 28:52, size = 30, replace = TRUE),
                     DiaMes = seq(from=as.Date("2021-09-01"), to=as.Date("2021-09-30"), by="day"),
                     DiaSemana = weekdays(seq(from=as.Date("2021-09-01"), to=as.Date("2021-09-30"),
                                              by="day")))

plot(vendas$DiaMes, vendas$Qtd, main = "Frequência da Qtd de vendas",xlab = "Dia", ylab =
       "Qtd vendas")

varmes <- max(vendas$Qtd) - min(vendas$Qtd)
varmes

medven <- round(mean(vendas$Qtd))
medven
hist(vendas$Qtd, main = "Frequência da Qtd de vendas",xlab = "Qtd vendas", ylab =
       "Frequência", col = "red")

                              # Exercício 7
x1 = c(1, 2, 3, 4)
x2 = c(2, 5, 8, 11)
x3 = c('A','B','C','D')
x4 = c('a', 'b',' c', 'd')
x5 = c('A', 'C',' E',' G')
x6 = c(10, 9, 8, 7)
x7 = c(10, 8, 6, 4)
x8 = c(2, 2, 2, 2, 5, 5, 5, 5, 8, 8, 8, 8)
x9 = c(x1, x2, x3, x4, x5, x6, x7, x8)


                       
                               # Exercício 8

# Pegando a data atual

data_atual = Sys.Date()
data_atual
# Informando o ano de nascimento
data_nascimento = as.Date('2006-06-10')
# Colocando minha idade em anos atráves de semanas e
# depois divido por 52 pois um ano tem 52 semanas

idade_anos = as.numeric(difftime(data_atual, data_nascimento, units = "weeks")) %/% 52
idade_anos
idade_semanas = as.numeric(difftime(data_atual, data_nascimento, units = "weeks"))
idade_semanas

                                #Exercício 9

#a) Quantas calças (flaire + skinny) foram vendidas? Qual o Faturamento total em calças? 
# Não funcionou
#qtdCalcaVendidas = ifelse(vendas_calcas$Produto %in% c("CalçaFlaire", "CalçaSkinny"),qtdCalcaVendidas = qtdCalcaVendida + 1,0 ]
# Filtrando a quantidade total de calças vendidas

quantidadeCalcasVendidas = sum(Produto_Vendedor$Quantidade[grepl("Calça", Produto_Vendedor$Produto)])

# Exibindo a quantidade de calças vendidas
quantidadeCalcasVendidas

# Agrupamento e soma do lucro das calças por vendedor
FaturamentoCalcas <- ifelse(grep('Calça',Produto_Vendedor$Produto),
                            Produto_Vendedor$Quantidade * (Precos$Preco_Unitario[Precos$Produto == "Calça"] - Precos$Custo_Unitario[Precos$Produto == "Calça"]),0)


# Visualização do faturamento das calças por vendedor
FaturamentoCalcas

View(Lucro_Vendedor)
                              
                                                #Exercício 10


set.seed(20)

vendedores <- c("Ana", "Flavia", "Pedro", "Mariana")

# Criando um vetor para os dias (30 dias de vendas para 4 vendedores)
dias <- rep(1:30, each = length(vendedores))

# Vendedores repetidos para cada dia
vendedores_repetidos <- rep(vendedores, times = 30)

produtos <- c("calçaFlaire", "calçaSkinny", "vestido", "blusa", "manta", "saia", "casaco", "meia")

# Simulando vendas entre 0 e 5 unidades diárias
vendas <- sample(0:5, size = length(dias), replace = TRUE)

dados_vendas <- data.frame(
  Dia = dias,
  Vendedor = vendedores_repetidos,
  Vendas = vendas
)

# Visualizando os dados
View(dados_vendas)
                                            # Exercício 11

# Função para calcular somas acumuladas
soma_acumulada <- function(vetor) {
  return(cumsum(vetor))
}

# Exemplo de uso
x <- c(1, 3, 8, 2, 1, 3)
resultado <- soma_acumulada(x)
print(resultado)
                                    
                                              # Exercicio 12
caminho_temperatura ="C:/Users/rodri/Downloads/temperaturas_cidades.csv"
caminho = file.choose()

temperatura = read.csv(caminho)

head(temperatura)

# Remover linhas com valores ausentes
temperatura <- na.omit(temperatura)

# Garantir que a coluna Data esteja no formato correto
temperaturas$Data <- as.Date(temperatura$Data)
# Filtrar os dados para o último ano
ultimo_ano <- max(temperatura$Data)
dados_ultimo_ano <- temperatura
  filter(format(Data, "%Y") == format(ultimo_ano, "%Y"))

# Calcular a média das temperaturas por cidade
media_temperaturas <- dados_ultimo_ano %>%
  group_by(Cidade) %>%
  summarise(Media_Temperatura = mean(Temperatura, na.rm = TRUE))

# Obter as 5 cidades com as maiores médias de temperatura
top_5_cidades <- media_temperaturas %>%
  arrange(desc(Media_Temperatura)) %>%
  head(5)

# Criar um gráfico
ggplot(top_5_cidades, aes(x = reorder(Cidade, -Media_Temperatura), y = Media_Temperatura)) +
  geom_bar(stat = "identity", fill = "blue") +
  labs(title = "Top 5 Cidades com Maiores Temperaturas Médias",
       x = "Cidade",
       y = "Temperatura Média") +
  theme_minimal()