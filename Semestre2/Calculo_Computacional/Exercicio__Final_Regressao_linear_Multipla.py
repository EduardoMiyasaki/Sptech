import statsmodels.api as sm
import numpy as np
from scipy import stats
import matplotlib.pyplot as plt
import statistics as st

                                                            # Exercício 1
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
print('----------------------------------------------------------------------------------------------------------------------')


                                                            # Exercício 2
                                                            
semanasTrabalhadas = np.array([2,7,9,1,5,12])
carros = np.array([13,21,23,14,15,21])

# Calcule o coeficiente angular da reta e seu coeficiente linear
solucao = stats.linregress(semanasTrabalhadas,carros)
a,b = solucao.slope, solucao.intercept
print(f'O coefiente angular é de {a:.2f}')
print(f'O coeficiente linear é de {b:.2f}')

# Use esse resultado para poder estimar quantos automóveis pode-se esperar que uma pessoa
# inspecione durante o mesmo período de duas horas se ela está
# trabalhando no posto de inspeção há oito semanas


# CarrosInspecionados = 0.90*8 + 12.45
# A quantidade de carros inspecionados é de 20
calculo = 0.90 * 8 + 12.45
print(f"A quantidade de carros inspecionados em 8 semanas é de {calculo:.0f}")

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

print('----------------------------------------------------------------------------------------------------------------------')

                                                            # Exercício 3

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

print('----------------------------------------------------------------------------------------------------------------------')

                                                        # Exercício 4

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
# 65.4 é o preço base da casa(constante)
# 16.7 é o preço por quarto e 11.23 é o preco por banheiro
precoCasa = 65.4 + 16.7 * 3 + 11.23 * 1
print(f'O preço estimado de uma casa com 3 quartos e 1 banheiro nesse bairo é de {precoCasa:.3f} R$')

print('----------------------------------------------------------------------------------------------------------------------')

                                                        # Exercício 5
                                                        
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

print('----------------------------------------------------------------------------------------------------------------------')

                                                        # Exercício 6

# Varivéis independetes(medicamentoA,medicamentoB,medicamentoC) Variavél dependente (eficacia)

medicamento = np.array([[15,20,10],[15,20,20],[15,30,10],[15,30,20],[30,20,10], [30,20,20],[30,30,10],[30,30,20],[45,20,10],[45,20,20],[45,30,10],[45,30,20]])
eficacia = np.array([47, 54, 58, 66, 59, 67, 71, 83, 72, 82, 85, 94])

# Adicionando a contstante(termo de intercepto(Coeficinete linear)) à matriz x 
x_const = sm.add_constant(medicamento)

# Criando e ajustando o modelo OLS (Regressão múltipla)

modelo = sm.OLS(eficacia,x_const)
resultado = modelo.fit()

# Exibindo o modelo ajustado
print(resultado.summary())

# Como o r-value está 99% os dados estão de acordo com a regressão múltipla
# porém o p value está alto ou seja há grandes chances dos dados serem aleatórios

# Fórmula eficácia = b0 + b1x1 + b2x2 + b3x3

eficacia = -2.333 + 0.9 * 12.5 + 1.2667 * 25 + 0.9 * 15
print(f'A Eficácia do remédio com 12.5 mg do medicamento a, 25 do b e 15 do c é de {eficacia:.0f}%')






