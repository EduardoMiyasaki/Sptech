from scipy import stats
import numpy as np
import matplotlib.pyplot as plt
import statistics as st

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


