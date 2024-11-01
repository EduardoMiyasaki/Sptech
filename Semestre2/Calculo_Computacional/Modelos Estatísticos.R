base.r.notas
notas = base.r.notas

View(notas)

hist(notas$nota.arqcomp)
plot(notas$nota.algo , notas$nota.arqcomp,
     xlab = "Notas de algoritmo",
     ylab = "Notas de arq_Comp")
View(notas)


modeloNotas = lm(notas$nota.arqcomp ~ notas$nota.algo)
# esse ~ significa 
summary(modeloNotas)
modeloNotas


par(mfrow=c(2,2))
plot(modeloNotas, which = 1:4)

plot(notas$nota.algo, notas$nota.arqcomp)
abline(modeloNotas)

notas_score = (notas$nota.arqcomp + notas$nota.banco)/2
modeloNotas2 = lm(notas$nota.algo ~ notas_score)

plot(notas_score, notas$nota.algo)
abline(modeloNotas2)
summary(modeloNotas2)

plot(modeloNotas2, which = 1:4)

pairs(notas)

library(GGally)
ggpairs(notas)


