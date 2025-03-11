library(ggplot2)

# Criação de tabela no R com dados fornecidos
dados <- data.frame(
  Ano = c(1982:1991, 1992:2000),
  Fundo = c(5.27, 43.08, -1.02, 56.94, 56.71, 12.48, 11.61, 27.76, -12.05, 4.74, 
            -5.79, 44.74, 0.76, 14.89, 14.65, 4.12, 16.93, 26.34, -8.60),
  EAFE = c(-0.86, 24.61, 7.86, 56.72, 69.94, 24.93, 28.59, 10.80, -23.20, 12.50, 
           -11.85, 32.94, 8.06, 11.55, 6.36, 2.06, 20.33, 27.30, -13.96)
)

# Visualização dos dados
print(dados)

correlacao <- cor(dados$Fundo, dados$EAFE)

ggplot(dados, aes(x = EAFE, y = Fundo)) +
  geom_point(size = 3, color = "black") +
  geom_smooth(method = "lm", se = FALSE, color = "red", linetype = "dashed") +
  labs(
    title = "Diagrama de Dispersão: Fundo vs. EAFE",
    x = "Rendimentos do EAFE (%)",
    y = "Rendimentos do Fundo (%)",
    caption = paste("Correlação de Pearson:", round(correlacao, 2))
  ) +
  theme_minimal()

model <- lm(Fundo ~ EAFE, data = dados)
residuos_padronizados <- rstandard(model)
outliers <- dados[abs(residuos_padronizados) > 2, ]

print(outliers)
