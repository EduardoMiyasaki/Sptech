populacao = 100

pesoPopulacao1 = abs(round(rnorm(populacao, 70, 12),2))
pesoPopulacao2 = abs(round(rnorm(populacao, 75 , 12) ,2))

par(mfrow=c(2,2))
hist(pesoPopulacao1, main='Peso população 1', ylab = 'Frequência', xlab = 'peso')
hist(pesoPopulacao2, main='Peso população 2', ylab = 'Frequência', xlab = 'peso')

# A população 1 normalmente tem um peso mais distribuído entre 50 e 80

# Enquanto a população 2 tem uma maior frequência entre 60 e 90 e os dados estão mais centralizados

boxplot(pesoPopulacao1)

# A mediana da população 1 está em 70 kg e
# o peso mínimo dessa população foi de aproximadamente 45 kg
# O peso maxímo foi de aproximadamente 100 kg e existe um outlier acima desse peso


boxplot(pesoPopulacao2)

# A mediana da população 2 está em 75 kg e
# O peso minímo dessa população foi de aproximadamente 50 kg e o 
# O peso máximo foi de aproximadamente 110 kg e não tem outlier