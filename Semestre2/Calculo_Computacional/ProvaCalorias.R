library(ggplot2)

                                  # Colocando os dados

caloriasEstimadas = c(196, 394, 350, 117, 136, 364, 74, 107, 160, 419)
caloriasEncontradas = c(159, 163, 269, 61, 76, 260, 12, 80, 88, 160)

                                  # Transformando em data.frame
dataCalorias = data.frame(caloriasEncontradas, caloriasEstimadas)

                       # Plotando o gráfico de dispersão com regressão linear
graficoCalorias = ggplot(dataCalorias, aes(x = caloriasEstimadas, y = caloriasEncontradas)) +
  geom_point(size = 3, color = "black") +
  geom_smooth(method = "lm", se = FALSE, color = "red", linetype = "dashed") +
  labs(
    title = "Diagrama de Dispersão: Caloria estimada vs. Caloria encontrada",
    x = "Caloria Estimada",
    y = "Caloria Encontrada",
  ) +
  theme_minimal()

graficoCalorias

                                      # Calculando a regressão linear

regressao = lm(dataCalorias$caloriasEncontradas ~ dataCalorias$caloriasEstimadas)
print(regressao)


correlacao = cor.test(caloriasEstimadas, caloriasEncontradas)
correlacao1 = cor(caloriasEstimadas, caloriasEncontradas)

print(correlacao)
print(correlacao1)

dataCalorias$mais100Calorias = caloriasEstimadas + 100
View(dataCalorias)

correlacaoMais100Calorias = cor.test(dataCalorias$mais100Calorias , dataCalorias$caloriasEncontradas,)
print(correlacaoMais100Calorias)

dataCalorias$semBoloEspaguete = ifelse(dataCalorias$caloriasEstimadas > 350 , 0 , dataCalorias$caloriasEstimadas)


View(dataCalorias)

dataCalorias$alimentosRestante = ifelse(dataCalorias$semBoloEspaguete > 0, dataCalorias$semBoloEspaguete , NA)
View(dataCalorias)
base_limpa <- na.omit(dataCalorias)

View(base_limpa)

correlacaoAlimentosRestante = cor.test(base_limpa$caloriasEncontradas , base_limpa$caloriasEstimadas)
print(correlacaoAlimentosRestante)


