import math as m

altura = 1.75
peso = 85

IMC = (peso / (pow(altura, 2)))

teto = m.floor(IMC)
print(teto)

# Exercício 2

a = 4/6
b = 3/2
c = (a * b) + 1
d = pow(3, 2/3)
e =  pow(d , c)
f = 1.4 + e
print("Exercício 2: ", round(f , 3))

# Exercício 3

a = 4
b = 2
c = a + b
print(type(c))

# Exercício 4

a =  ((45/8)**(2+1.5))/(1-(5/7 + 6)/4) + 600

print("Exercício 4: ", round(a , 4))

# Exercício 4

print("Exercício 4: ", round(a , 4))

# Exercício 5

print(- 4 ** -5)
print(m.pow(-4, -5))


# Exercício 6

segAQuar = (8.5 * 3)* 4
quiASex = (9 * 2) * 4

totalHoras = segAQuar + quiASex
salario = 5468

media = salario / totalHoras

print("A hora trabalhada do joão equivale a" , media )

# Exercício 7

A1 = 114.6
A2 = 114.8

# Exercício 8

a = 4
b = 2
c = a + b
print(type(c))

# Exercício 9

a = 4
b = 2
c = a / b
print(type(c))

# Exercício 10

a = 4/6
a1 = 3/2
a = (a * a1) + 1
b = pow(a , 3)
a1 = pow(3 , b)
print("oi", a1)

