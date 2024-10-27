
desempenho = read.delim("C:/Users/duduk/Downloads/desempenho.txt")

View(desempenho)

mediaMatematica = mean(desempenho$matematica)
mediaMatematica

summary(desempenho)

table(desempenho$genero)

# Qual é a faixa que representa 65% da frequência da maior faixa dos dados de literatura?
# Escolha a alternativa e justifique.

literatura = summary(desempenho$literatura)
literatura

boxplot(desempenho$literatura ~ desempenho$genero,
        ylab = "Literatura",
        xlab = "Gênero")

?boxplot


                              # Exercício 6

a = c(157, 158, 159, 160, 161, 162, 163, 164)
range = max(a) - min(a)
print(range)

                              # Exercício 7
x<-c(10:20)*20
x

                                # Exercício 8

hospital = data.frame(TempoEmprego = c(2,4,5),
                      clinica = c(55,20,35),
                      hospital = c(25,6,15),
                      laboratorio = c(10,4,10))

View(hospital)
probabilidade = (hospital$TempoEmprego <= 4)/180
probabilidade
120 / 180 *100

