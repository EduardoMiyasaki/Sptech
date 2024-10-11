p = 200000
n = 20000
set.seed(1234)
idade = abs(round(rnorm(n,35,7),0))
altura = abs(round(rnorm(n,1.7,0.05),2))
peso = abs(round(rnorm(n, 75, 3.5),2))
imc = round(peso / altura ** 2 , 2)
par(mfrow=c(2,2))
hist(idade,main='idade',ylab='freq',xlab='idade')
hist(altura,main='altura',ylab='freq',xlab='altura')
hist(peso,main='Peso',ylab='Freq',xlab='Peso')
hist(imc,main='IMC',ylab='freq',xlab='imc')

hist_idade = hist(idade)       
str(hist_idade)

# breaks = Intervalos do histograma
# Counts = 
# Density =
# Mids = 
# Xname = 
# Equidist = 

# plot(nomeDoHistograma) retorna o histograma
par(mfrow=c(2,2))
hist(idade, breaks = 2)
hist(idade , breaks = 100)

salario = abs(round(rnorm(n, 3000,300),2))
summary(salario)

pop_carros = rep(c(0,1,2,3), p)
carros = sample(pop_carros, n)

# Replace false é como se você tivesse um baralho você pega uma carta e tira 
# ou seja você diminui em 1 carta a chance de pegar outra

# Replace true é como se pegasse uma carta de um baralho 
#e devolver ela depois ou seja a chance de você tirar ela novamente é a mesma

table(carros)
carros

pop_filhos = rep(c(0,1,2), p)
filhos = sample(pop_filhos , n)
rm(pop_filhos)
table(filhos)

par(mfrow=c(2,2))
hist(carros)
hist(filhos)

pop_escola = rep(c(0,1,2,3,4,5,6),p)
escola.temp = sample(pop_escola, n) # Variável temporária
esc = factor(escola.temp,
             levels=c(0,1,2,3,4,5,6),
             labels=c("Analfabeto","1grau",'2grau','3grau','msc','doc','posdoc'),
             ordered=TRUE)

str(esc)
table(esc)

fumante.n =rbinom(n,1,0.40)# Cria uma distribuião binomial = Binário

fumante.f = factor(fumante.n,levels=c(0,1), labels=c("Não","Sim"),
                   ordered=TRUE)
str(fumante.f)

table(fumante.f)

mean(fumante.n)

summary(fumante.f)

pop_sexo = rep(c(1,2),p)
sexo.temp = sample(pop_sexo , n)
sexo = factor(sexo.temp,
              levels=c(1,2),
              labels=c('m','f'),
              ordered=FALSE)

str(sexo)

table(sexo)

pop_prof = rep(0:2, p)
prof.temp = sample(pop_prof, n)

prof = factor(prof.temp,
              levels=c(0,1,2),
              labels=c('Humanas','Exatas','Bio'),
              ordered = FALSE)

str(prof)

table(prof)

df = data.frame(id = 1:n,altura,imc,sexo,esc,prof,fumante.f,fumante.n,
           salario,carros,filhos,idade)
df
View(df)


