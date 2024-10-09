producao = 100
maquina1 = rbinom(50, producao, 0.6)
set.seed(1)
maquina1.f = factor(maquina1, levels=c(0,1) , labels=c('Sucesso', 'Falha'),
                  ordered = TRUE)

table(maquina1.f)

maquina2 = rbinom(50,producao, 0.8)

maquina2.f = factor(maquina2,levels=c(0,1), labels=c('Sucesso', 'Falha'),
                  ordered = TRUE)

table(maquina2.f)

hist(maquina1, main='Sucesso ou falha')

# O número de vezes que cara foi maior que o número de vezes que caiu coroa

hist(maquina2, main = 'Sucesso ou falha')

# O número de vezes que caiu cara foi o dobro de vezes que coroa
