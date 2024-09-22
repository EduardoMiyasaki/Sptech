import psutil
from datetime import datetime
import time
import numpy as np
import statsmodels.api as sm
import numpy as np
from scipy import stats
import matplotlib.pyplot as plt
import statistics as st

dadoCPU = np.array([])
dadoRAM = np.array([])
dadoDisco = np.array([])
dadoRede = np.array([])

a = 1
resposta = 'sim'
while resposta != 'n':
            data_hora = datetime.now()
            hora = data_hora.hour
            minuto = data_hora.minute
            segundo = data_hora.second
            
            dia = data_hora.day
            mes = data_hora.month
            ano = data_hora.year
            data = [hora ,minuto, segundo, dia, mes, ano]

            print(f'O Horário da captura foi as {hora}:{minuto}:{segundo} {dia}/{mes}/{ano}')

            porc_cpu = psutil.cpu_percent(interval=1)
            dadoCPU = np.append(dadoCPU, porc_cpu)

            mem = psutil.virtual_memory()
            porc_ram = mem.percent
            
            dadoRAM = np.append(dadoRAM, porc_ram)

            usoDisco = psutil.disk_usage('/')
            dadoDisco = np.append(dadoDisco, usoDisco.percent)
            
            net_io_counters = psutil.net_io_counters()
            dadoRede = np.append(dadoRede, net_io_counters.bytes_recv)
                       
            print(f'A lista de uso da CPU é{dadoCPU}')
            print(f'A lista de uso de RAM é {dadoRAM}')
            
            a = a + 1
            resto5 = a % 5
            if(resto5 == 0):
                resposta = input('deseja continuar capturando?')
                
print('finalizado')
print(dadoDisco)
print(f'A quantidade KB/s Recebidos pela rede foi de {dadoRede}')
solucao = stats.linregress(dadoRAM,dadoCPU)
a,b = solucao.slope , solucao.intercept
print(f'A regressão linear é de {solucao}')

def formula(a,b,x):
    return a*x + b
def graph(a,b):
    x = dadoRAM
    y = formula(a,b,x)
    plt.scatter(dadoRAM,dadoCPU)
    plt.plot(x,y)
    # Se comentar o plot aparece apenas os dados e não a linha de regressão linear
    plt.xlabel('Quantidade de uso da RAM')
    plt.ylabel('Quantidade de uso de CPU%')
    plt.title('Uso de RAM e CPU')
    plt.grid()
    plt.show()
graph(a, b)

# Formula PorcUsoCPU = a * usoRAM + b

# A = Slope = coeficiente angular, b = Intercept = Coeficiente linear


# Regressão linear Múltipla

# Fórmula Regressão Múltipla

# porcCPU = b0 + b1 * porcRam + b2 * qtdKb/s Rede
dadoMaquina = np.array([])

for i in range(len(dadoCPU)):

        dados = np.array([[dadoCPU[i], dadoRAM[i], dadoRede[i]]])
   # dados = {'CPU':dadoCPU[i],'RAM':dadoRAM[i],'Rede':dadoRede[i]}
   # Podia ser em um dicionário, porém , não ia funcionar pois preciso só dos números
        dadoMaquina = np.vstack([dadoMaquina,dados])

print(f'{dadoMaquina}')



x_const = sm.add_constant(dadoMaquina)
print(dadoCPU.shape)
print(x_const.shape)
modelo = sm.OLS(dadoCPU,x_const)
resultado = modelo.fit()
print(resultado.summary())
    
