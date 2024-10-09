alunos = 50

notaGrupo1 = abs(round(rnorm(alunos,60,15),2))
notaGrupo2 = abs(round(rnorm(alunos,75,10),2))
notaGrupo3 = abs(round(rnorm(alunos,55,17),2))

hist(notaGrupo1, main = 'Notas do grupo1', xlab = 'notas')

# O primeiro grupo teve uma média de notas entre 50 e 70 
# e a maioria das outras pessoas tiveram nota acima disso

hist(notaGrupo2, main = 'Notas do grupo2', xlab = 'notas')
# A média de pessoas que obtiveram a nota 75 foi muita alta
# de 60 a 70 mais de 10 pessoas e abaixo de 50 menos de 5 pessoas tiraram

hist(notaGrupo3, main = 'Notas do grupo3',  xlab = 'notas')

# O grupo 3 tem notas mais distribuidas ou seja

boxplot(notaGrupo1)
boxplot(notaGrupo2)
boxplot(notaGrupo3)
