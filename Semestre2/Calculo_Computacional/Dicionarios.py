empty_dict = {}

d1 = {"a": "algum valor", "b": [1, 2, 3, 4]}
print(d1)
# Retornando o valor de dentro do 'json'
print(d1['a'])
# Retorna o segundo valor de dentro da 'Lista' B
print(d1['b'][2])
#Mostra a quantidade de "Listas"
print(list(d1.keys()))

#Mostra os valores das 'Listas"
print(list(d1.values()))
# Mostra totalmente A sintaxe desse dicionário
print(list(d1.items()))

# Atualizando a lista B e adicionando a lista C
d1.update({"b": "foo", "c": 12})
# Mostra totalmente A sintaxe desse dicionário
print(list(d1.items()))

# 'Json de notas'
planilha_notas = {
    'Julia': [9.2, 8.5, 10.0],
    'Eduardo': [8.3, 9.5, 7.9],
    'Marcio': [9.1, 8.9, 8.2],
    'Reis': [9.7, 9.1, 9.2]
}
print(planilha_notas.items())
print(planilha_notas.values())

total_notas = 0
count_notas = 0

# Está passando pelo 'Json' está passando os valores para nome e nota
for nome, nota in planilha_notas.items():
    #Somando totas as notas de cada aluno
    total = sum(nota)
    print(f'A média de {nome} é: {total / len(nota):.2f}')
    # Somando a notas de todos alunos
    total_notas += total
    
    count_notas += len(nota)

print(f'A média da classe é de: {total_notas / count_notas:.2f}')

texto = ('Uma das maiores operadoras de linhas de transmissão do país (Taesa) '
         'a empresa tem um nível de endividamento alto '
         'decorrente de grandes investimentos em projetos que começaram do zero '
         'Porém o BBA destaca que a companhia tem perfil de dívida alongado e ' 
         'junto às receitas previsíveis das suas transmissoras ' 
         'tem uma flexibilidade financeira adequada')

contagem_palavras = {}

# conta as ocorrências de cada palavra única
for palavra in texto.split():
    if palavra in contagem_palavras:
        contagem_palavras[palavra] += 1 # atualiza o par chave-valor existente
    else:
        contagem_palavras[palavra] = 1 # insere um novo par de chave-valor

print(f'{"PALAVRA":<15}CONTAGEM')

for palavra, count in sorted(contagem_palavras.items()):
    print(f'{palavra:<15}{count}')

print('\nNúmero de palavras únicas:', len(contagem_palavras))

import psutil



