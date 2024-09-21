import statsmodels.api as sm
import numpy as np

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
