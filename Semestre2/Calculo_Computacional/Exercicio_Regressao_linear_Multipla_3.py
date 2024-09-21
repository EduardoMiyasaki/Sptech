import statsmodels.api as sm
import numpy as np
from scipy import stats
import matplotlib.pyplot as plt
import statistics as st

# Formule uma equação de regressão linear avaliando sua qualidade e buscando responder
# quantos sacos de trigo por hectare teríamos ao notar um índice pluviométrico de 9,5, 17,1
# e 6,8


precipitacao = np.array([12.9,7.2,11.3,18.6,8.8,10.3,15.9,13.1])
safraTrigo = np.array([62.5,28.7,52.2,80.6,41.6,44.5,71.3,54.4])

solucao = stats.linregress(precipitacao,safraTrigo)
a,b,c,d = solucao.slope, solucao.intercept , solucao.rvalue, solucao.pvalue
print(f'A regressão linear é de {solucao}')
print(f'a Equacão da reta é {a:.2f}x + {b:.2f}')
print(f'O valor de R é de {c:.2f}')
print(f'O valor de P é de {d}')

print(f'Como o valor de R é próximo de 1 significa que esses dados estão bem próximos da linha de regressão linear')
print(f'Porém como p tem um valor alto existe grande chance de essa reta ser dados aleatórios')
print('Uma boa solução seria procurar mais dados')

def formula(a,b,x):
    return a*x + b
def graph(a,b):
    x = precipitacao
    y = formula(a,b,x)
    plt.scatter(precipitacao,safraTrigo)
    plt.plot(x,y)
    # Se comentar o plot aparece apenas os dados e não a linha de regressão linear
    plt.xlabel('Precipitação')
    plt.ylabel('Safras de trigo')
    plt.grid()
    plt.show()
graph(a, b)

precipitacao9_5 = 4.42 * 9.5 + 0.23
print(f'Com a precipitação 9,5 a quantidade de safras de trigo é {precipitacao9_5:.0f}')

precipitacao17_1 = 4.42 * 17.1 + 0.23
print(f'Com a precipitação 17,1 a quantidade de safras de trigo é {precipitacao17_1:.0f}')

precipitacao6_8 = 4.42 * 6.8 + 0.23
print(f'Com a precipitação 6,8 a quantidade de safras de trigo é {precipitacao6_8:.0f}')



