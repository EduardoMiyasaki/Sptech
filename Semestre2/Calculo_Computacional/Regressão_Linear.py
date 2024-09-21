from scipy import stats
import numpy as np
import matplotlib.pyplot as plt
import statistics as st
usuarios = np.array([10, 12, 15, 25, 22, 18, 15, 20, 28, 30])
uso_cpu = np.array([20, 25.2, 30, 45.1, 42.7, 33.6, 31.5, 45, 53.1,
60.2])
solucao = stats.linregress(usuarios,uso_cpu)
a, b = solucao.slope, solucao.intercept
print(solucao)
print("---------------------")
usuario = [10, 12, 15, 25, 22, 18, 15, 20, 28, 30]
uso_cpu = [20, 25.2, 30, 45.1, 42.7, 33.6, 31.5, 45, 53.1, 60.2]
a, b = st.linear_regression(usuario, uso_cpu)
print(f"eq. da reta: y = {a:.2f}x + {b:.2f})
