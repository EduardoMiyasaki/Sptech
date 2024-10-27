# Carregar as bibliotecas
library(readxl)
library(ggplot2)
library(dplyr)

# Carregar o arquivo de Excel e transformar as prioridades em valores numéricos
prioridades <- read_excel("C:/Users/duduk/Downloads/prioridades-projetos-mestrado.xlsx")
# Definir os valores numéricos para cada prioridade
respostas_prioridades <- c(
  "Baixa prioridade" = 5,
  "Média-baixa prioridade" = 4,
  "Média prioridade" = 3,
  "Alta-média prioridade" = 2,
  "Alta prioridade" = 1
)

# Transformar as respostas em valores numéricos
prioridades[] <- lapply(prioridades, function(x) as.numeric(respostas_prioridades[x]))

View(prioridades)

contagem_prioridades <- apply(prioridades, 2, function(coluna)
   table(factor(coluna, levels= 1:5)))

View(contagem_prioridades)
# Contagem de Alta Prioridade (1) e Alta-média Prioridade (2)
alta_prioridade_contagem <- colSums(prioridades == 1 | prioridades == 2)

# Gráfico de barras usando barplot
barplot(alta_prioridade_contagem, col = c("black", "white"), las = 2, cex.names = 0.7,
        main = "Contagem de Alta Prioridade e Alta-média Prioridade",
        xlab = "Sub-área", ylab = "Contagem")


dados_doc <- prioridades[, grepl("Doc", colnames(prioridades))]
dados_inf <- prioridades[, grepl("Inf", colnames(prioridades))]
dados_com <- prioridades[, grepl("Com", colnames(prioridades))]
dados_eng <- prioridades[, grepl("Eng", colnames(prioridades))]
dados_pro <- prioridades[, grepl("Pro", colnames(prioridades))]
dados_mon <- prioridades[, grepl("Mon", colnames(prioridades))]
dados_sof <- prioridades[, grepl("Sof", colnames(prioridades))]

contagem_prioridades <- apply(prioridades, 2, 
                              function(coluna) table(factor(coluna, levels = 1:5)))


alta_prioridade_doc <- colSums(dados_doc == 1 | dados_doc == 2) 
alta_prioridade_inf <- colSums(dados_inf == 1 | dados_inf == 2) 
alta_prioridade_com <- colSums(dados_com == 1 | dados_com == 2) 
alta_prioridade_eng <- colSums(dados_eng == 1 | dados_eng == 2)
alta_prioridade_pro <- colSums(dados_pro == 1 | dados_pro == 2) 
alta_prioridade_mon <- colSums(dados_mon == 1 | dados_mon == 2) 
alta_prioridade_sof <- colSums(dados_sof == 1 | dados_sof == 2) 

barplot(
  alta_prioridade_doc,
  names.arg = colnames(alta_prioridade_doc),
  main = "Contagem de Prioridade por Subárea",
  xlab = "Subáreas",
  ylab = "Contagem Prioridade",
  col = "lightblue"
)

barplot(
  alta_prioridade_inf,
  names.arg = colnames(alta_prioridade_inf),
  main = "Contagem de Prioridade por Subárea",
  xlab = "Subáreas",
  ylab = "Contagem Prioridade",
  col = "lightgreen"
)

barplot(
  alta_prioridade_com,
  names.arg = colnames(alta_prioridade_com),
  main = "Contagem de Prioridade por Subárea",
  xlab = "Subáreas",
  ylab = "Contagem Prioridade",
  col = "lightyellow"
)
barplot(
  alta_prioridade_eng,
  names.arg = colnames(alta_prioridade_eng),
  main = "Contagem de Prioridade por Subárea",
  xlab = "Subáreas",
  ylab = "Contagem Prioridade",
  col = "pink"
)
barplot(
  alta_prioridade_pro,
  names.arg = colnames(alta_prioridade_pro),
  main = "Contagem de Prioridade por Subárea",
  xlab = "Subáreas",
  ylab = "Contagem Prioridade",
  col = "lightgray"
)
barplot(
  alta_prioridade_mon,
  names.arg = colnames(alta_prioridade_mon),
  main = "Contagem de Prioridade por Subárea",
  xlab = "Subáreas",
  ylab = "Contagem Prioridade",
  col = "black"
)
barplot(
  alta_prioridade_sof,
  names.arg = colnames(alta_prioridade_sof),
  main = "Contagem de Prioridade por Subárea",
  xlab = "Subáreas",
  ylab = "Contagem Prioridade",
  col = "violet"
)


