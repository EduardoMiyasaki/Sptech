p <- 200000
n <- 15000

pop.escolaridade = rep(c(0,1,2,3,4,5,6),p)
set.seed(15)

escolaridade.temp = sample(pop.escolaridade, n)

escolaridade = factor(escolaridade.temp,
levels = c(0,1,2,3,4,5,6),
labels = c("Analfabeto", 
           "1° Grau",
           "2° Grau", "3° Grau", "Mestrado", "Doutorado",
           "posdoc"),
ordered = TRUE)

rm(pop.escolaridade , escolidaridade.temp)
str(escolaridade)


summary(escolaridade)

# Mesma coisa que o summary :) table(escolaridade)

prop.table(table(escolaridade))

# Retorna o percentual de cada dado nessa tabela

# Rbinom cria uma dristribuiçao binária aleatório 0 ou 1
# A probabilidade de dar 1 é de 40%

fumante.n = rbinom(n,1, .40)
fumante.f = factor(fumante.n,
                   levels = c(0,1),
                   labels = c("Não", "Sim"),
                   ordered = TRUE)

str(fumante.f)

summary(fumante.f)

str(fumante.n)

mean(fumante.n)

# Mostra a probabilidade de ser fumante ou não
prop.table(table(fumante.f))

par(mfrow=c(1,2))
# 1 linha e duas colunas

barplot(table(escolaridade), ylab = "Número de participantes", xlab = "Nivel de estudo")
barplot(table(fumante.f), ylab = "Número de participantes")

round(prop.table(table(escolaridade)),3)

# Tranforma os dados de fumante e transforma 
# em uma tabela e após isso retorna a probabilidade de ser não ou sim
# e no final retorna esse valor arrendondado em 3 casas
round(prop.table(table(fumante.f)),3)

par(mfrow=c(1,2))

barplot(round(prop.table(table(escolaridade)),3),
ylab = "Proporção dos participantes",
ylim = c(0, 0.7))


barplot(round(prop.table(table(fumante.f)),3),
        ylab = "Proporção dos participantes",
        ylim = c(0, 0.7))

table(escolaridade,fumante.f)

tabela1 = round(prop.table(table(escolaridade,fumante.f)),4)
tabela1

tabela2 = prop.table(table(escolaridade, fumante.f))

addmargins(tabela1)

# Sum = probabilidade de um perante ao todo

tabela3 = round(prop.table(table(fumante.f , escolaridade),1),4)
tabela3

tabela4 = round(prop.table(table(fumante.f , escolaridade),2),4)

library(scales)

x = barplot(round(prop.table(table(fumante.f,escolaridade)),2),
            col = rep(c("#F2A6B8","#B5D3E3")),
            legend = FALSE,
            ylim = c(0, 0.2),
            yaxt = "n",
            ylab = "Percentual de participantes")
yticks = seq(0, 0.02, by = 0.05)
axis(2 , at = yticks , lab = percent(yticks))

y = round(prop.table(table(escolaridade,fumante.f)),2)

?barplot

mfrow=(c(1,2))
# Mostra a probabilidade de cada um dos tipos de estudantes de ser 
# ou não fumante
mosaicplot(prop.table(table(escolaridade,fumante.f)),
           col = c("#F2A6B8","#BD3E35"),
           main = "")
