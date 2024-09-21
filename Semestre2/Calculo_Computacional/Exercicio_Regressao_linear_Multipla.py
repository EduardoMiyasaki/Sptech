import statsmodels.api as sm
import numpy as np
from scipy import stats
import matplotlib.pyplot as plt
import statistics as st

qtdComida = np.array([36,82,45,49,21,24,58,73,85,52])
hiperativo = np.array([6,14,5,13,5,8,14,11,18,6])

# Plote um gráfico de dispersão para decidir se uma reta pode descrever de modo razoável o comportamento geral dos dados

solucao = stats.linregress(qtdComida,hiperativo)
a,b = solucao.slope, solucao.intercept
print(f"A regressão linear é de {solucao}")

def formula(a,b,x):
    return a*x + b
def graph(a,b):
    x = qtdComida
    y = formula(a,b,x)
    plt.scatter(qtdComida,hiperativo)
    plt.plot(x,y)
    # Se comentar o plot aparece apenas os dados e não a linha de regressão linear
    plt.xlabel('Quantidade de comida')
    plt.ylabel('Hiperatividade [%]')
    plt.title('Nivel de hiperatividade por comida')
    plt.grid()
    plt.show()
graph(a, b)

# Fórmula

# Hiperatividade = a * 65 + b

print(f'eq. da reta: y = {a:.2f}x + {b:.2f}')
# Trocando o x por 65 da o resultado de 11,93

hiperativade65 = 0.16 * 65 + 1.53
print(f'Ingerindo 65g de comida o total de hiperatividade é {hiperativade65:.2f}')

# Discuta os valores encontrados e a precisão da reta construída

# Os valores encontrados estão de acordo com a reta



