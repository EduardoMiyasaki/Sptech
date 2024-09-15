import psutil as p

import time

from datetime import datetime

i = 1

while i < 20:
    Memoria = p.virtual_memory()

    CPU = p.cpu_stats()

    net = p.cpu_stats()
   
    data_hora = datetime.now()
    hora = data_hora.hour
    minuto = data_hora.minute
    seg = data_hora.second

    dia = data_hora.day
    mes = data_hora.month
    ano = data_hora.year
    data = [hora, minuto, seg, dia , mes, ano]

    i = i + 1

    time.sleep(1)

    dicionario = {"Memória":{"Memórial total":Memoria[0], "Percentual":Memoria[2], "Usado":Memoria[3]},"CPU":{"Trocas":CPU[0],"Interrupções":CPU[1]}, "Rede":{"Trocas":net[0],"Interrupções":net[1]}, "Hora":[hora, minuto, seg, dia , mes, ano]}
    print("------------------------------------------------------------------------------------------------------------")
    print("Memória")
    print(dicionario["Memória"])
    print("------------------------------------------------------------------------------------------------------------")
    print("CPU")
    print(dicionario["CPU"])
    print("------------------------------------------------------------------------------------------------------------")
    print("Rede")
    print(dicionario["Rede"])
    print("------------------------------------------------------------------------------------------------------------")
    print("Data e Hora")
    print(dicionario["Hora"][0],":",dicionario["Hora"][1],":",dicionario["Hora"][2],"-",dicionario["Hora"][3],"/",dicionario["Hora"][4],"/",dicionario["Hora"][5] )
    print("                                             ")
    print("                                             ")
