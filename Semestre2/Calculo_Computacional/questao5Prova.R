library(dplyr)
library(corrplot)
# Probabilidade binomial de 15 aprovados em um grupo de 60 alunos com 92,8% de aprovação
probQuinzeAlunos = pbinom(15, size = 60, prob = probAprovacaoConjuration / 100 , lower.tail = FALSE)  # Convertendo para decimal
print(paste("Probabilidade de 15 alunos Reprovados: ", probQuinzeAlunos))

probSubir = 65
probDescer = 35

probSubir1 = pbinom(4 , size = 5 , prob = 0.65, lower.tail = FALSE)
print(probSubir1)

probSubir2 = pbinom(2, size = 5 , prob = 0.65 , lower.tail = FALSE)
print(probSubir2)

dataAcao = data.frame(probSubir1, probSubir2)

tabelaAcao = table(dataAcao$probSubir1 , dataAcao$probSubir2)
View(tabelaAcao)

percentuaisAcao = prop.table(tabelaAcao, 1 )* 100
percentuaisAcao
View(percentuaisAcao)
