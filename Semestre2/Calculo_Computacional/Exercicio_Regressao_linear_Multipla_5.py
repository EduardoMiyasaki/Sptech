import statsmodels.api as sm
import numpy as np

# Variaveis independentes(temperaturaECobre) Variavel Dependente(dureza)

temperaturaECobre = np.array([[1000, 0.02], [1200,0.02],[1000,0.10],[1200,0.10],[1000,0.18],[1200,0.18]])
dureza = np.array([78.9, 55.2, 80.9, 57.4 ,85.3 , 60.7])

# Adicionando a constante (termo de intercepto)à matriz x
x_const = sm.add_constant(temperaturaECobre)

# Criando e ajustando o modelo OLS (regressão múltipla)
modelo = sm.OLS(dureza, x_const)
resultado = modelo.fit()

# Exibindo o resumo do modelo ajustado
print(resultado.summary())

# Como o p-value está em 5.94 existe grande chance de esses dados serem aleatórios
# E como o r-value está quase 1(99%) os dados estão próximos da regressão linear

# Formula Dureza: Dureza = b0 + b1x1 + b2x2 ou 197.6479 + -0.1197 * temperatura + 37.1875 * QtdCobre

dureza = 197.6479 + -0.1197 * 1100 + 37.1875 * 0.14
print(f'A dureza do aço quando o conteúdo de cobre for 0.14 e a temperatura for 1100 é {dureza:.1f}')
