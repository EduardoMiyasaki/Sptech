library(readxl)
library(ggplot2)

# Carregar os dados do Excel
perguntas <- read_excel("C:/Users/duduk/Downloads/perguntas-mestrado.xlsx")

# Substituir células vazias e "NA" por NA
perguntas[perguntas == ""] <- NA
perguntas[perguntas == "NA"] <- NA

# Remover colunas que contêm qualquer valor NA
new_perguntas <- perguntas[, colSums(is.na(perguntas)) == 0]

# Substituir respostas textuais por valores numéricos
respostas_numericas <- c(
  "Concordo totalmente" = 5,
  "Concordo" = 4,
  "Média-baixa prioridade" = 3,
  "Discordo" = 2,
  "Discordo totalmente" = 1
)

# Aplicar a conversão em todas as colunas
new_perguntas[] <- lapply(new_perguntas, function(x) {
  as.numeric(respostas_numericas[x])
})

# Calcular médias por setor
# Uso de na.rm = TRUE: Isso garante que as médias sejam calculadas corretamente
# mesmo que haja valores NA nas colunas.
new_perguntas$Setor1 <- rowMeans(new_perguntas[, c("Q_1.1", "Q_1.2")], na.rm = TRUE)
new_perguntas$Setor2 <- rowMeans(new_perguntas[, c("Q_2.1", "Q_2.2", "Q_2.3")], na.rm = TRUE)
new_perguntas$Setor3 <- rowMeans(new_perguntas[, c("Q_3.1", "Q_3.2", "Q_3.3")], na.rm = TRUE)
new_perguntas$Setor4 <- rowMeans(new_perguntas[, c("Q_4.1", "Q_4.2", "Q_4.3", "Q_4.5")], na.rm = TRUE)
new_perguntas$Setor5 <- rowMeans(new_perguntas[, c("Q_5.1", "Q_5.2", "Q_5.4")], na.rm = TRUE)
new_perguntas$Setor6 <- rowMeans(new_perguntas[, c("Q_6.1", "Q_6.2", "Q_6.3")], na.rm = TRUE)
new_perguntas$Setor7 <- rowMeans(new_perguntas[, c("Q_7.1", "Q_7.2", "Q_7.3")], na.rm = TRUE)
new_perguntas$Setor8 <- rowMeans(new_perguntas[, c("Q_8.1", "Q_8.2", "Q_8.3", "Q_8.4", "Q_8.5")], na.rm = TRUE)
new_perguntas$Setor9 <- rowMeans(new_perguntas[, c("Q_9.1", "Q_9.2", "Q_9.3")], na.rm = TRUE)

# Visualizar o novo dataframe
View(new_perguntas)

data_media = data.frame(Setor = c("Setor 1", "Setor 2", "Setor 3", "Setor 4", "Setor 5", 
                                     "Setor 6", "Setor 7", "Setor 8", "Setor 9"),
                        Media = c(
                          mean(new_perguntas$Setor1, na.rm = TRUE),
                          mean(new_perguntas$Setor2, na.rm = TRUE),
                          mean(new_perguntas$Setor3, na.rm = TRUE),
                          mean(new_perguntas$Setor4, na.rm = TRUE),
                          mean(new_perguntas$Setor5, na.rm = TRUE),
                          mean(new_perguntas$Setor6, na.rm = TRUE),
                          mean(new_perguntas$Setor7, na.rm = TRUE),
                          mean(new_perguntas$Setor8, na.rm = TRUE),
                          mean(new_perguntas$Setor9, na.rm = TRUE)
                        )
)

ggplot(data_media, aes(x = Setor, y = Media)) +
  geom_bar(stat = "identity", fill = "steelblue") +
  theme_minimal() +
  labs(title = "Média dos Scores por Setor",
       x = "Setor",
       y = "Média") +
  theme(axis.text.x = element_text(angle = 45, hjust = 1))
