import statistics as st
import numpy as np

horas = [9,10,11,12,13,14,15,16,17,18]

numeroUsuarios = [10,12,15,25,22,18,15,20,28,30]

usoCpu = [20.0,25.2,30.0,45.1,42.7,33.6,31.5,45.0,53.1,60.2]

print(f"A média de usuários ativos é {st.mean(numeroUsuarios)}")
print(f"A mediana de usuários ativos é {st.median(numeroUsuarios):.2f}")
print(f"O desvio padrão de usuários ativos é {st.pstdev(numeroUsuarios):.2f}")
print(f"A média de uso da CPU é {st.mean(usoCpu):.2f}")
print(f"A mediana de uso da Cpu é {st.median(usoCpu):.2f}")
print(f"O desvio padrão de uso da Cpu é {st.pstdev(usoCpu):.2f}")

# Pontos que representam o número de usuários
pontosUsuario = np.array([[10, 1],[25, 1]])

# Pontos de uso da CPU

pontosUsoCpu = np.array([20, 45.1])

modelo1 = np.linalg.solve(pontosUsuario, pontosUsoCpu)

print(modelo1)

# Formula = usoCpu = M * U + b

primeiro_dado = pontosUsoCpu[0] = 1.67333333 * 10 + 3.26666667
print(primeiro_dado)

pontosUsuario2 = np.array([[20, 1], [28, 1]])
pontosUsoCpu2 = np.array([45.0, 53.1])
modelo2 = np.linalg.solve(pontosUsuario2, pontosUsoCpu2)
print(modelo2)

segundo_dado = pontosUsoCpu2[0] = 1.0125 * 20 + 24.75

print(segundo_dado)

# Se você acredita que existe uma relação linear, calcule a inclinação e a interceptação da linha de
# melhor ajuste que descreve a relação entre o uso da CPU e os usuários ativos.
interceptacao = np.intersect1d(primeiro_dado, segundo_dado)
print(f"A interceptação é {interceptacao}")

slope, intercept = np.polyfit(numeroUsuarios,usoCpu,1)
print(f"A inclinação desse sistema linear é {slope:.2f}")
