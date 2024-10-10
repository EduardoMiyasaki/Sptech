p <- 200000
n <- 15000

pop.escolaridade = rep(c(0,1,2,3,4,5,6),p)
set.seed(15)

escolaridade.temp = sample(pop.escolaridade, n)

escolaridade = factor(escolaridade.temp,
levels = c(0,1,2,3,4,5,6),
labels = c("Analfabeto", "1° Grau", "2° Grau", "3° Grau", "Mestrado", "Doutorado",
           "posdoc"),
ordered = TRUE)

rm(pop.escolaridade , escolidaridade.temp)
str(escolaridade)

