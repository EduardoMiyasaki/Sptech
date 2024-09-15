import math

a = 4
b = 5
soma = a + b
mult = a * b
div = a / b
sub = a - b
print(f"a soma entre {a} e {b} é {soma}")
print(f"a multiplicação entre {a} e {b} é {mult}")
print(f"a divisão entre {a} e {b} é {div}")
print(f"a subtração entre {a} e {b} é {sub}")

c = 5
d = 4

c_ao_quad = pow(5,2)
print(c_ao_quad)

raiz_quadrada = math.sqrt(25)
print(raiz_quadrada)

z = 2.5
print(math.floor(z))
print(math.ceil(z))
print(round(z))

a = 2 / 5
print(math.pow(a, 3))
print(math.pow(2/5 ,3))
print(math.pow(1/2 , -3))

print(math.pow(pow(-1 , 3), 4))

print(1/4 + pow(5,2) - pow(-2 , -4))

print(pow((4/5 - 1/2 + 1) , -2) + 1 /( 1 + pow(3, 2) - pow(4-5 , -2)))

peso = float(input("Informe seu peso em kg: "))
altura = float(input("Informe sua altura: "))

imc = peso / pow(altura , 2)

print(f'seu imc é de {imc:.2f}')



conjAgora = {"Itaúsa", "Ecorodovias", "Taesa" , "B3", "Vale"}

conjAtiva = {"B3", "Bradesco" , "BB Seguridade" , "BB Distribuidora", "Taesa", "CTEEP", "Vale", "Telefônica Brasil"}

conjGenial = {"CPFL", "Minerva", "Cyrela", "Randon" , "CTEEP"}

conjEasyInvest = {"B3" , "Brasil agro" , "Coca-Cola", "Taesa"," Vale" ,"Copel" , "Itaúsa" , "Ambev"}

conjElite = {"Bradesco","BB Seguridade","Banrisul","Engie","Itaúsa","Sanepar","Taesa","CTEEP","Telefônica Brasil","Vale"}

conjGuide = {'Alupar', 'Banco do Brasil', 'Cyrela', 'CPFL', 'Klabin', 'Porto Seguro', 'Tim', 'Vale',}

conjNovaFutura = {'B3', 'Cyrela', 'Gerdau', 'Vivo', 'CTEEP'}

conjOrama = {'Banco ABC', 'Bradesco', 'Minerva', 'CESP', 'Engie'}

# Ache se há alguma ação em comum a todas a corretoras 
acoesConjuntas = conjAgora.intersection(conjAtiva, conjGenial , conjEasyInvest , conjElite , conjGuide , conjNovaFutura , conjOrama)

print(acoesConjuntas)

# Selecione 4 corretoras
# Ache se há alguma ação em comum a essas 4 corretoras
acoesConjuntaFiltro = conjAtiva.intersection(conjGenial , conjElite , conjNovaFutura)

print(acoesConjuntaFiltro)

# Indique se há ações únicas para cada corretora
difConAtiva = conjAtiva.difference(conjGenial , conjElite, conjNovaFutura)
print(difConAtiva)

difConGenial = conjGenial.difference(conjAtiva , conjElite , conjNovaFutura)
print(difConGenial)

difConElite = conjElite.difference(conjAtiva , conjGenial , conjNovaFutura)
print(difConElite)

difConNovaFutura = conjNovaFutura.difference(conjAtiva , conjGenial , conjElite)
print(difConNovaFutura)

# Determine as relações entre os portfólios das corretoras (subset ou superset)

novaSuperOrama= conjNovaFutura.issuperset(conjOrama)
print(novaSuperOrama)

oramaSuperNova = conjOrama.issuperset(conjNovaFutura)
print(oramaSuperNova)

novaSubOrama = conjNovaFutura.issubset(conjOrama)
print(novaSubOrama)

oramaSubNova = conjOrama.issubset(conjNovaFutura)
print(oramaSubNova)

#Crie um conjunto de ações únicos de cada corretora
# Ou
# conjuntoUnico = conjAtiva.union(conjGenial , conjElite, conjNovaFutura)
conjuntoUnico = difConAtiva |  difConElite | difConGenial | difConNovaFutura

print(conjuntoUnico)


