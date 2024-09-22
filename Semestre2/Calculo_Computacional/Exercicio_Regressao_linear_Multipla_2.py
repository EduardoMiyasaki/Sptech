import statsmodels.api as sm
import numpy as np
from scipy import stats
import matplotlib.pyplot as plt
import statistics as st

semanasTrabalhadas = np.array([2,7,9,1,5,12])
carros = np.array([13,21,23,14,15,21])

# Calcule o coeficiente angular da reta e seu coeficiente linear
solucao = stats.linregress(semanasTrabalhadas,carros)
a,b = solucao.slope, solucao.intercept
print(f'{a:.2f}')
print(f'{b:.2f}')

# Use esse resultado para poder estimar quantos automóveis pode-se esperar que uma pessoa
# inspecione durante o mesmo período de duas horas se ela está
# trabalhando no posto de inspeção há oito semanas


# CarrosInspecionados = 0.90*8 + 12.45
# A quantidade de carros inspecionados é de 20
calculo = 0.90 * 8 + 12.45
print(f"{calculo:.0f}")

# Exiba um gráfico com os dados e a reta de regressão formada

def formula(a,b,x):
    return a*x + b
def graph(a,b):
    x = semanasTrabalhadas
    y = formula(a,b,x)
    plt.scatter(semanasTrabalhadas,carros)
    plt.plot(x,y)
   # plt.xticks(np.arange(5, 40, step = 5))
    plt.xlabel('Semanas trabalhadas')
    plt.ylabel('Carros inspecionados')
   # plt.title('')
    plt.grid()
    plt.show()
graph(a, b)



