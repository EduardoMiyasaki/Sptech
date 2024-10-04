box_Peso = boxplot(peso)

str(box_Peso)

boxplot(peso , horizontal = TRUE)

boxplot(peso,
        main = "distribuição das amostras",
        xlab = 'peso em Kg',
        col = 'blue',
        border = 'brown',
        horizontal = TRUE,
        notch = TRUE)


peso2= abs(round(rnorm(n, 82 , 3.7),2))

boxplot(peso,peso2,
        main = "distribuição das amostras",
        names = c('peso1','peso2'),
        las = 2,
        col = c('orange','blue'),
        horizontal = TRUE,
        notch = TRUE)

# %in% permite ver se uma coisa está dentro de outra

data1 = c(3,5,7,7,14,19,22,25)
data2 = c(1,2,3,4,5)
