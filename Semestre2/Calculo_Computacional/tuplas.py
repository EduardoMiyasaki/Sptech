tup = (4,5,6,)
print(type(tup))
lista = {1,2,3,4}
print(type(lista))

tuple(lista)

tup2 = 4,5,6
print(tuple({'olá'}))

nested_tup = ((4, 5, 6), (7, 8))
print(nested_tup[0])

# print("Pegando a posição 1 da tupla dentro de outra" + nested_tup[0]{1})

tuup = ('foo', [1,2,3] , True)

senha = 'a@sptech'
print(senha)

print(type(senha))

tuple(senha)

senha2 = tuple(senha)
print(senha2)

values = (1,2,3,4,5,6)

a, b , *rest = values
print(a)
print(b)
print(rest)

values1 = ('ola', 'mundo', 'python', 'java', 'mysql', 'oracle')
c,d, *_ = values1
print(c)
print(d)
print(_)
