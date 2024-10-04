qtdLancamento = 450
moeda1 = rbinom(qtdLancamento, 1 , 0.5)

moeda1.f = factor(moeda1, levels=c(0,1) , labels=c('Cara', 'Coroa'),
                  ordered = TRUE)

table(moeda1.f)

moeda2 = rbinom(qtdLancamento, 1, 0.7)

moeda2.f = factor(moeda2,levels=c(0,1), labels=c('Coroa', 'Cara'),
                  ordered = TRUE)

table(moeda2.f)

hist(moeda1, main='Cara ou Coroa')

# O número de vezes que cara foi maior que o número de vezes que caiu coroa

hist(moeda2, main = 'Cara ou coroa')

# O número de vezes que caiu cara foi o dobro de vezes que coroa
