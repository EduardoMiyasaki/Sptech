
# Exporta o wege.full.csv

View(wege)

# Relaçao de abertura e fechamento do preço de uma ação
plot(wege$Open, wege$Close)

modeloAbertura = lm(wege$Open ~ wege$Close)
summary(modeloAbertura)

par(mfrow=c(2,2))
plot(modeloAbertura , which = 1:4)

plot(wege$Open , wege$Close)
abline(modeloAbertura)

# Open é quanto a acão iniciou o dia, High = o valor mais alto da ação 
# low = mais baixo e no final do dia quanto que terminou


            #  Fazendo um relação pra ver quando se valeu a pena comprar
            #determinada ação de acordo com o ponto mais baixo até o mais alto
plot(wege$Low , wege$High)

modeloLucro = lm(wege$Low ~ wege$High)
summary(modeloLucro)

par(mfrow=c(2,2))
plot(modeloLucro, which = 1:4)

plot(wege$Low , wege$High)
abline(modeloLucro)

# Fazendo uma relação de o quanto a média do valor da ação no dia
# influencia ela no fechamento do dia
mediaAcao = (wege$High + wege$Low)/2
modeloAcaoMedia = lm(wege$Close ~ mediaAcao)
plot(mediaAcao , wege$Close)
abline(modeloAcaoMedia)

summary(modeloAcaoMedia)

par(mfrow=c(2,2))
plot(modeloAcaoMedia , which = 1:4)

# testando se o fechamento é uma resultante da média da ação.

dados_fechamento = wege[,c("Close", "High", "Low")]

pairs(dados_fechamento)

library(GGally)
ggpairs(dados_fechamento)

modelo1 = lm(dados_fechamento$Close ~ dados_fechamento$High + dados_fechamento$Low)
hist(residuals(modelo1))

plot(fitted(modelo1), residuals(modelo1))
abline(h = 0, lty = 2)

summary(modelo1)

sigma(modelo1)/mean(dados_fechamento$Close)

# Apresentou uma taxa de 7% de erro

                             # Regressão Polinomial

plot(wege$Close)
wege$id = seq(1:177)
modelo2 = lm(wege$Close ~ wege$id)
summary(modelo2)

par(mfrow=c(2,2))
plot(modelo2 , which = 1:4)

plot(wege$Close)
abline(modelo2)

modelo_poli <- lm(wege$Close~poly(wege$id,3))
summary(modelo_poli)

# Fazendo com log
modelo_log <- lm(wege$Close~log(wege$id,3))
summary(modelo_log)

# Como deu um valor de R muito baixo não irei continuar

plot(wege$Close)
lines(sort(wege$id),fitted(modelo_poli)[order(wege$id)], col="red",type="l")

modelo_poli$coefficients

library(ggplot2)
x <- wege$id
y <- wege$Close
ggplot(wege, aes(id, Close))+
geom_point()+
geom_smooth(method = "lm",formula = y~poly(x,3))      
