library(readxl)

# Carregar os dados do Excel
perguntas <- read_excel("C:/Users/duduk/Downloads/perguntas-mestrado.xlsx")

# Substituir células vazias por NA
perguntas[perguntas == ""] <- NA
perguntas[perguntas == "NA"] <- NA

# Ver os dados originais
View(perguntas)

# Remover colunas que contêm qualquer valor NA
new_perguntas <- perguntas[, colSums(is.na(perguntas)) == 0]

# Visualizar o novo dataframe sem colunas com NA
View(new_perguntas)

new_perguntas[new_perguntas == "Concordo totalmente"] <- "5"
new_perguntas[new_perguntas == "Concordo"] <- "4"
new_perguntas[new_perguntas == "Não concordo e nem discordo"] <- "3"
new_perguntas[new_perguntas == "Discordo"] <- "2"
new_perguntas[new_perguntas == "Discordo totalmente"] <- "1"

new_perguntas[] <- lapply(new_perguntas, as.numeric)

new_perguntas$Setor1 = paste(new_perguntas$Q_1.1, new_perguntas$Q_1.2)
new_perguntas$Setor2 = paste(new_perguntas$Q_2.1, new_perguntas$Q_2.2, new_perguntas$Q_2.3)
new_perguntas$Setor3 = paste(new_perguntas$Q_3.1, new_perguntas$Q_3.2, new_perguntas$Q_3.3)
new_perguntas$Setor4 = paste(new_perguntas$Q_4.1, new_perguntas$Q_4.2, new_perguntas$Q_4.3, new_perguntas$Q_4.5)
new_perguntas$Setor5 = paste(new_perguntas$Q_5.1, new_perguntas$Q_5.2, new_perguntas$Q_5.4)
new_perguntas$Setor6 = paste(new_perguntas$Q_6.1, new_perguntas$Q_6.2 , new_perguntas$Q_6.3)
new_perguntas$Setor7 = paste(new_perguntas$Q_7.1, new_perguntas$Q_7.2 , new_perguntas$Q_7.3)
new_perguntas$Setor8 = paste(new_perguntas$Q_8.1, new_perguntas$Q_8.2, new_perguntas$Q_8.3, new_perguntas$Q_8.4 , new_perguntas$Q_8.5)
new_perguntas$Setor9 = paste(new_perguntas$Q_9.1, new_perguntas$Q_9.2, new_perguntas$Q_9.3)
View(new_perguntas)

new_perguntas$Setor1 = (new_perguntas$Q_1.1 + new_perguntas$Q_1.2)/2
new_perguntas$Setor2 = (new_perguntas$Q_2.1 + new_perguntas$Q_2.2 + new_perguntas$Q_2.3)/3
new_perguntas$Setor3 = (new_perguntas$Q_3.1 + new_perguntas$Q_3.2 + new_perguntas$Q_3.3)/3
new_perguntas$Setor4 = (new_perguntas$Q_4.1 + new_perguntas$Q_4.2 + new_perguntas$Q_4.3 + new_perguntas$Q_4.5)/4
new_perguntas$Setor5 = (new_perguntas$Q_5.1 + new_perguntas$Q_5.2 + new_perguntas$Q_5.4)/ 3
new_perguntas$Setor6 = (new_perguntas$Q_6.1 + new_perguntas$Q_6.2 + new_perguntas$Q_6.3)/3
new_perguntas$Setor7 = (new_perguntas$Q_7.1 + new_perguntas$Q_7.2 + new_perguntas$Q_7.3)/3
new_perguntas$Setor8 = (new_perguntas$Q_8.1 + new_perguntas$Q_8.2 + new_perguntas$Q_8.3 + new_perguntas$Q_8.4 + new_perguntas$Q_8.5)/5
new_perguntas$Setor9 = (new_perguntas$Q_9.1 + new_perguntas$Q_9.2 + new_perguntas$Q_9.3) /3
