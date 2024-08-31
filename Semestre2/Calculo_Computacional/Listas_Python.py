a_list = [2,3,6,None]

print(a_list)

tup = ('foo','bar','baz')
b_list = list(tup)

print(type(b_list))
print(b_list)
b_list[2] = "bass"
print(b_list)

c_list = ['foo', 'bar', 'baz']

#Adicionando um item na lista
c_list.append('dwarf')
print(c_list)


#   Removendo item da lista
c_list.remove('baz')
print(c_list)

#Permite adicionar onde eu quiser o valor
# exxemplo red vai estar na posição 1
c_list.insert(1,'red')
print(c_list)

#Remove o valor do index
c_list.pop(2)
print(c_list)

# Concatenação
x_list = [4, None , 'foo']
print(x_list)
x_list.extend([7, 8, (2, 3)])

print(x_list)

a = [7,2,5,1,3]
# Ele deixa as coisas em ordem númerico
a.sort()

b = ['saw', 'small','He', 'foxes', 'six']
# Ele deixa as coisas em ordem de quantidade de letras
b.sort(key=len)


seq = [7,2,3,7,5,6,0,1]

# Mostrando a lista do index 1 até o index 5 
print(seq[1:5])

# Dou um update na lista 
seq[3:5] = [6, 3]

print(seq)
print(seq[:5])
print(seq[3:])

