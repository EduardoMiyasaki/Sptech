from scipy import stats
import numpy as np
import matplotlib.pyplot as plt
import statistics as st

tempoVencimento = np.array([18,5,11,9,14,6,13,8,22,15,7,20,19,16,21,10,17,12])
rendimento = np.array([2.9,4.2,3.2,3.8,4.0,4.5,3.4,3.7,2.1,4.7,4.3,2.7,2.5,4.1,2.3,3.5,3.2,3.6])

# Calcule a média, mediana e desvio padrão dos rendimentos do título

media = st.mean(rendimento)
print(f"O rendimento médio foi de {media:.2f}")
mediana = st.median(rendimento)
print(f"A mediana de rendimento é {mediana:.2f}")
desvioPadrao = st.pstdev(rendimento)
print(f"O desvio padrão do rendimento é {desvioPadrao:.2f}")

# Formule um sistema linear de equações para representar a relação entre os rendimentos do título e os períodos de vencimento.

solucao = stats.linregress(tempoVencimento,rendimento)
a,b = solucao.slope, solucao.intercept
print(f"A regressão linear é de {solucao}")

def formula(a,b,x):
    return a*x + b
def graph(a,b):
    x = tempoVencimento
    y = formula(a,b,x)
    plt.scatter(tempoVencimento,rendimento)
    plt.plot(x,y)
    plt.xticks(np.arange(5, 40, step = 5))
    plt.xlabel('tempo Vencimento')
    plt.ylabel('Rendimento [%]')
    plt.title('Rendimento de acordo com o ano')
    plt.grid()
    plt.show()
graph(a, b)

# Analise os coeficientes obtidos na resolução dos sistemas lineares. Que insights você pode obter sobre a sensibilidade
# dos rendimentos aos períodos de vencimento para esse tipo de título

# Quanto mais longe do tempo de vencimento,o rendimento é menor, porém a ação com 15 anos de vencimento é um outlier

#Com base na sua análise, forneça recomendações aos investidores interessados em títulos do
# tesouro com diferentes prazos de vencimento.

# Quanto menor o tempo de vencimento,Maior o rendimento


                                                                    # Exercício 2
                                                                    
                                                                    
velocidadeObturador = np.array([1/2,1/4,1/8,1/15,1/30,1/60,1/125,1/250,1/500,1/1000,])
brilho = np.array([200.0,190,175,171,168,150,148,140,131,127])

# ) Calcule a moda, mediana, os decils, a variância e desvio padrão dos valores de brilho

moda = st.mode(brilho)
mediana = st.median(brilho)
variancia = st.variance(brilho)
desvio = st.pstdev(brilho)

print(f"a Moda de brilho é {moda}")
print(f"a Mediana de brilho é {mediana}")
print(f"a variancia de brilho é {variancia:.2f}")
print(f"o desvio de brilho é {desvio:.2f}")

# Sistema de regressão

solucao = stats.linregress(brilho,velocidadeObturador)
a,b = solucao.slope, solucao.intercept
print(f"A regressão linear é de {solucao}")

# Crie um gráfico de dispersão para visualizar a relação entre as configurações de abertura e o brilho da imagem.

def formula(a,b,x):
    return a*x + b
def graph(a,b):
    x = brilho
    y = formula(a,b,x)
    plt.scatter(brilho,velocidadeObturador)
    plt.plot(x,y)
    plt.xticks(np.arange(5, 40, step = 5))
    plt.xlabel('Brilho')
    plt.ylabel('Relação entre Velocidade do Obturador e Brilho[%]')
    plt.title('Velocidade do obturador')
    plt.grid()
    plt.show()
graph(a, b)

# Formule um sistema linear de equações para representar a relação entre as configurações de velocidade do obturador e brilho da imagem.

# Brilho = A * VelocidadeObturador + b





