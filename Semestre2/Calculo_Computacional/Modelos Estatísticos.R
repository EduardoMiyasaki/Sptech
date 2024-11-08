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

plot(fitted(modeloNotas2),residuals(modeloNotas2))
abline(h = 0, lty = 2)

sigma(modeloNotas)/mean(notas$nota.algo)


novaBase = base.r.wege

plot(novaBase$Close)

novaBase$id = seq(1:48)
modelo2 = lm(novaBase$Close ~ novaBase$id)
summary(modelo2)

par(mfrow=c(2,2))
plot(modelo2, which = 1:4)

plot(novaBase$Close)  

modelo_poli = lm(novaBase$Close~poly(novaBase$id,3))

summary(modelo_poli)

plot(novaBase$Close)
lines(sort(novaBase$id),fitted(modelo_poli)[order(novaBase$id)],col = 'blue', type = "b")
# o type h mostra os residuos
modelo_poli$coefficients

library(ggplot2)
x = novaBase$id
y = novaBase$Close
ggplot(novaBase, aes(id, Close))+
geom_point()+
geom_smooth(method='lm',formula = y~poly(x,3))


            # Regressão logaritima

modelo_log = lm(novaBase$Close~log(novaBase$id))
summary(modelo_log)

lines(sort(novaBase$id),fitted(modelo_log)[order(novaBase$id)],col = 'blue', type = "l")
library(ggplot2)
x = novaBase$id
y = novaBase$Close
ggplot(novaBase, aes(id, Close))+
  geom_point()+
  geom_smooth(method='lm',formula = y~log(x))

# se = FALSE tira a linha cinza de margem de erro
