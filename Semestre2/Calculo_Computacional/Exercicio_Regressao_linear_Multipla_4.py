import statsmodels.api as sm
import numpy as np

# Variáveis independentes (X) e dependente (y)

qtdQuartoBanheiro = np.array([[3, 2], [2, 1], [4,3], [2,1], [3,2], [2,2], [5,3], [4,2]])
preco = np.array([143.800, 109.300, 158.800, 109.200, 154.700, 114.900, 188.400, 142.900])

# Adicionando a constante (termo de intercepto)à matriz x
x_const = sm.add_constant(qtdQuartoBanheiro)

# Criando e ajustando o modelo OLS (regressão múltipla)
modelo = sm.OLS(preco, x_const)
resultado = modelo.fit()

# Exibindo o resumo do modelo ajustado
print(resultado.summary())

# Como o p-value está em 3% existe grande chance de esses dados não serem aleatórios
# E como o r-value está próximo de 1 os dados estão próximos da regressão linear

# Encontre uma equação linear que permita prever o preço de venda médio de uma
# casa no bairro dado, em termos de número de quartos e do número de banheiros.

# Formula do preço da casa é precoCasa = 65.4 + 16.7x1 + 11.23x2
precoCasa = 65.4 + 16.7 * 3 + 11.23 * 1
print(f'O preço estimado de uma casa com 3 quartos e 1 banheiro nesse bairo é de {precoCasa:.3f} R$')
