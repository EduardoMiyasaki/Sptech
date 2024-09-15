import math

s1 = {1,2,3}
#print(2 * s1)

altura = 1.75
peso = 85
imc = (peso / (pow(altura , 2)))
print(math.ceil(imc))

a1 = 114.6
a2 = 114,8

print(round(a1))

s1 = [1,2,3]
s2 = [4,5,6]
print(s1 + s2)

a = 4/6
a1 = 3/2
a = (a * a1) + 1
b = pow(a,3)
a1 = pow(3, b)
print(a1)

a = 4
b = 2
c = a + b
print(type(c))

salario = 5.468
horas = 174

print(math.floor(horas/ salario))

a = 4
b = 2
c = a + b
print('type(c)')

cor1 = {'TAEE11', 'TRPL4', 'EGIE3', 'CPFE6', 'ELET3'}
cor2 = {'ELET3', 'PETR4', 'VALE3', 'BBAS3', 'BEES3'}
cor3 = {'VALE3', 'PETR4', 'CSNA3', 'CMIN3', 'PRIO3'}
cor4 = {'BBAS3', 'BEES3', 'ITUB4','IUTB3', 'BBDC4'}
cor5 = {'BBDC4', 'ITUB4'}
cor6 = {'VALE3', 'PETR4', 'CSNA3', 'CMIN3', 'PRIO3','RRRP3'}

# Tudo true
#print(cor3.issubset(cor6))
#print(cor3 not in cor6)

# True
print(cor5.intersection(cor4))

print(cor2.symmetric_difference(cor3))

expressao = ((45/8)**(2+1.5))/(1-(5/7 + 6)/4) + 600

print(f'{expressao:.4f}')

print(2 * 2 **3)

a = 4
b = 2
c = a/b
print(type(c))

a = 4/6
b = 3/2
c = (a*b) + 1
d = pow(3, 2/3)
e = pow(d,c)
f = 1.4 + e
print(round(f,3))

print((-4)**(-5))
print(pow(-4,-5))
print("------------")
print( -4**1/2)
print(-pow(4,0.5))
print("------------")
print( ((2)**(3))**4 )
print(pow(pow(2,3),4))

try: 

   list = 5*[0]+5*[10] 
   x = list[9] 
   print('Done!') 
except IndexError: 
   print('Index out of Bond!') 
else: 
   print('Nothing is wrong!') 
finally: 
   print('Finally block!') 


maquinas = {
    "maquina_1": {"Memória RAM": "valor1", "Placa de Rede": "valor2", "CPU": "valor3"},
    "maquina_2": {"Memória RAM": "valor1", "Placa de Rede": "valor2", "CPU": "valor3"},
    "maquina_3": {"Memória RAM": "valor1", "Placa de Rede": "valor2", "CPU": "valor3"}
}

print(maquinas["maquina_3"]["CPU"])




