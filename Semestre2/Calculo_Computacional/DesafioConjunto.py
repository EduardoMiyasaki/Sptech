import math

conjAgora = {"Itaúsa", "Ecorodovias", "Taesa" , "B3", "Vale"}

conjAtiva = {"B3", "Bradesco" , "BB Seguridade" , "BB Distribuidora", "Taesa", "CTEEP", "Vale", "Telefônica Brasil"}

conjGenial = {"CPFL", "Minerva", "Cyrela", "Randon" , "CTEEP"}

conjEasyInvest = {"B3" , "Brasil agro" , "Coca-Cola", "Taesa"," Vale" ,"Copel" , "Itaúsa" , "Ambev"}

conjElite = {"Bradesco","BB Seguridade","Banrisul","Engie","Itaúsa","Sanepar","Taesa","CTEEP","Telefônica Brasil","Vale"}

conjGuide = {'Alupar', 'Banco do Brasil', 'Cyrela', 'CPFL', 'Klabin', 'Porto Seguro', 'Tim', 'Vale',}

conjNovaFutura = {'B3', 'Cyrela', 'Gerdau', 'Vivo', 'CTEEP'}

conjOrama = {'Banco ABC', 'Bradesco', 'Minerva', 'CESP', 'Engie'}

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

