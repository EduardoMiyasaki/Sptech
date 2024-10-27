import statsmodels.api as sm
import numpy as np
from scipy import stats


# Variaveis independentes(distanciaPoluicao) Variavel Dependente(concentracao)

distanciaPoluicao = np.array([2,4,6,8,10])
concentracao = np.array([11.5, 10.2, 10.3, 9.68, 9.32])

# concetracao = a * distanciaPoluicao  + b

solucao = stats.linregress(distanciaPoluicao,concentracao)
a,b = solucao.slope , solucao.intercept

print(f"A Inclinação angular é de {a}")
print(f"A Inclinação linear é de {b}")

                                                                        s
