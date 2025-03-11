library(readxl)
library(dplyr)
library(ggplot2)
library(corrplot)

base <- read_excel("C:/Users/duduk/Downloads/base.xlsx")
View(base)

dados_limpos <- base %>% filter(is.na(illusion.percFaltas))

print(dados_limpos)

base_limpa <- na.omit(base)
View(base_limpa)

nota1Illusion = base_limpa$illusion.nota1 * 25 /100

nota2Illusion = base_limpa$illusion.nota2 * 35 /100

nota3Illusion = base_limpa$illusion.nota3 * 40/100


nota1Conjuration = base_limpa$conjuration.nota1 * 25 /100

nota2Conjuration = base_limpa$conjuration.nota2 * 35 /100

nota3Conjuration = base_limpa$conjuration.nota3 * 40/100


nota1Restoration = base_limpa$restoration.nota1 * 25 /100

nota2Restoration = base_limpa$restoration.nota2 * 35 /100

nota3Restoration = base_limpa$restoration.nota3 * 40/100



nota1Alteration = base_limpa$alteration.nota1 * 25 /100

nota2Alteration = base_limpa$alteration.nota2 * 35 /100

nota3Alteration = base_limpa$alteration.nota3 * 40/100


nota1Destruction = base_limpa$destruction.nota1 * 25 /100

nota2Destruction = base_limpa$destruction.nota2 * 35 /100

nota3Destruction = base_limpa$destruction.nota3 * 40/100

base_limpa$notaFinalIllusion = nota1Illusion + nota2Illusion + nota3Illusion
base_limpa$notaFinalConjuration = nota1Conjuration + nota2Conjuration + nota3Conjuration
base_limpa$notaFinalRestorarion = nota1Restoration + nota2Restoration + nota3Restoration
base_limpa$notaFinalAlteration = nota1Alteration + nota2Alteration + nota3Alteration
base_limpa$notaFinalDestruction = nota1Destruction + nota2Destruction + nota3Destruction

base_limpa$NotaFinalGeral = (base_limpa$notaFinalIllusion * 15 /100) + (base_limpa$notaFinalConjuration * 15 /100) +(base_limpa$notaFinalRestorarion * 25 / 100) + (base_limpa$notaFinalAlteration * 25 /100) + (base_limpa$notaFinalDestruction * 20 /100)

# Tendo a nota final calculada em cima das matérias crie uma coluna categórica seguindo a
# regra de >= 6,0 aprovado e qualquer outra coisa reprovado;

base_limpa$aprovado = ifelse(base_limpa$NotaFinalGeral >= 6, "aprovado", "reprovado")
View(base_limpa)

# 5) a )

aprovadosPorTurma = table(base_limpa$turma , base_limpa$aprovado)
print(aprovadosPorTurma)


percentuaisPorTurma <- prop.table(aprovadosPorTurma, 1) * 100
View(percentuaisPorTurma)
df_percentuais <- as.data.frame(percentuaisPorTurma)
colnames(df_percentuais) <- c("Turma", "Status", "Percentual")

# Plotar um gráfico de barras com ggplot
ggplot(df_percentuais, aes(x = Turma, y = Percentual, fill = Status)) +
  geom_bar(stat = "identity", position = "dodge") +
  labs(title = "Percentual de Aprovados e Reprovados por Turma",
       x = "Turma",
       y = "Percentual (%)") +
  theme_minimal() +
  scale_fill_manual(values = c("blue", "red"))

# 5) b)

# Calcular aprovação na matéria de Conjuration
base_limpa$aprovadoConjuration = ifelse(base_limpa$notaFinalConjuration >= 6, "aprovado", "reprovado")

# Total de alunos
totalAlunosConjuration = nrow(base_limpa)
print(totalAlunosConjuration)

# Número de aprovados
aprovadosConjuration = sum(base_limpa$aprovadoConjuration == "aprovado")
print(aprovadosConjuration)

# Percentual de aprovação em Conjuration
probAprovacaoConjuration = (aprovadosConjuration / totalAlunosConjuration) * 100
print(paste("Percentual de alunos aprovados em Conjuration: ", round(probAprovacaoConjuration, 2), "%"))

# Probabilidade binomial de 15 aprovados em um grupo de 60 alunos com 92,8% de aprovação
probQuinzeAlunos = pbinom(15, size = 60, prob = probAprovacaoConjuration / 100 , lower.tail = FALSE)  # Convertendo para decimal
print(paste("Probabilidade de 15 alunos Reprovados: ", probQuinzeAlunos))

# C)

base_limpa$MaiorQuatroDestruction = ifelse(base_limpa$notaFinalDestruction >= 4.5 , "aprovado", "reprovado")
somaAlunosaprovadosDestruction = sum(base_limpa$MaiorQuatroDestruction == "aprovado")
print(somaAlunosaprovadosDestruction)

probDestruction = somaAlunosaprovadosDestruction /210
print(probDestruction)

# D)

ggplot(base_limpa, aes(x = notaFinalRestorarion)) +
  geom_histogram(binwidth = 1, fill = "blue", color = "black", alpha = 0.7) +
  labs(title = "Distribuição das Notas Finais - Matéria Restoration",
       x = "Nota Final Restoration",
       y = "Número de Alunos") +
  theme_minimal()

alunosNegativos <- base_limpa %>% filter(notaFinalRestorarion <= 4)
print(alunosNegativos)

alunos_positivos <- base_limpa %>% filter(notaFinalRestorarion > 9)
print(alunos_positivos)
print("Alunos com desempenho negativo em Restoration:")
print(alunosNegativos[, c("ra", "notaFinalRestorarion", "turma")])

View(base_limpa)
# E) i)
cor.test(base_limpa$notaFinalIllusion , base_limpa$notaFinalAlteration)
cor.test(base_limpa$notaFinalIllusion , base_limpa$notaFinalAlteration , conf.level = 0.8)

modeloLinear = lm (base_limpa$notaFinalIllusion ~ base_limpa$notaFinalAlteration)
print(modeloLinear)
summary(modeloLinear)

plot(modeloLinear)

ggplot(base_limpa, aes(x = notaFinalAlteration, y = notaFinalIllusion)) +
  geom_point(color = "blue", alpha = 0.7) +
  geom_smooth(method = "lm", se = TRUE, color = "red", linetype = "dashed") +
  labs(title = "Relação entre Alteration e Illusion",
       x = "Nota Final Alteration",
       y = "Nota Final Illusion") +
  theme_minimal()

# Existe cerca de 80% de relação quando o aluno normalmente vai bem em uma matéria
# na outra tem 80% de chance de ir bem também
# O gráfico demonstra isso bem


# E) ii)
cor.test(base_limpa$notaFinalRestorarion , base_limpa$notaFinalDestruction)
cor.test(base_limpa$notaFinalRestorarion , base_limpa$notaFinalDestruction, con.level = 0.8)

# Existe cerca de 88% de correlação

modeloLinear2 = lm (base_limpa$notaFinalRestorarion ~ base_limpa$notaFinalDestruction)
print(modeloLinear2)
summary(modeloLinear2)

ggplot(base_limpa, aes(x = notaFinalRestorarion, y = notaFinalDestruction)) +
  geom_point(color = "blue", alpha = 0.7) +
  geom_smooth(method = "lm", se = TRUE, color = "red", linetype = "dashed") +
  labs(title = "Relação entre Restoration e Destruction",
       x = "Nota Final Restoration",
       y = "Nota Final Destruction") +
  theme_minimal()

# No geral isso é bom, pois a maioria dos alunos
# tiveram notas alta então na outra matéria ele também teve
# Porém alguns tiveram notas baixas

notasFinais <- base_limpa %>% 
  select(notaFinalIllusion, notaFinalConjuration, notaFinalRestorarion, notaFinalAlteration, notaFinalDestruction)

# Criar a matriz de correlação
matrizCorrelacao <- cor(notasFinais, use = "complete.obs")
print(matrizCorrelacao)

corrplot(matrizCorrelacao, method = "circle", type = "upper", 
         addCoef.col = "black", tl.col = "black", tl.srt = 45, 
         title = "Matriz de Correlação das Notas Finais", mar = c(0, 0, 2, 0))
