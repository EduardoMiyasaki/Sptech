                                        # Exercício 1

# Você é um administrador de um data center e deseja implantar 5 servidores em diferentes locais geográficos
# para garantir alta disponibilidade.
# Quantas maneiras diferentes existem de escolher a ordem de implantação
# dos servidores?

servidores = 5
factorial(servidores)
                                        # Exercício 2


# Suponha que você esteja gerenciando um fundo de investimento e tem 10 ações em que pode investir.
# Você deseja criar uma carteira de investimentos com 3 ações escolhidas a partir dessas 10.
# Quantas combinações de carteiras diferentes você pode criar?

acoes = 10
escolhidas = 3

# totalAcoes = factorial(acoes)
# coesEscolhidas = factorial(escolhidas)

# combinacoesAcao = totalAcoes / (acoesEscolhidas) * (factorial(acoes - escolhidas))        

# combinacoesAcao

combinacoes <- choose(acoes, escolhidas)
cat("O número de combinações de", n, "elementos tomados", r, "a cada vez é",
    combinacoes, "\n")


                                    # Exercício 3

# Você está configurando uma rede de entrega de conteúdo (CDN) 
# para seu aplicativo web e tem 5 servidores disponíveis em diferentes regiões.
# Você deseja escolher 2 servidores para configurar o CDN. Quantas
# combinações diferentes de servidores você pode escolher para o CDN?

servidores = 5
servidoresEsc = 2

combinacoesServ = choose(servidores, servidoresEsc)

cat("O número de combinações de", servidores, "elementos tomados", servidoresEsc, "a cada vez é",
    combinacoesServ, "\n")
    
                                    # Exercício 4

# Você está planejando alocar tarefas em um cluster de servidores.
# Você tem 4 servidores disponíveis e 6 tarefas a serem alocadas.
# Quantas permutações diferentes de alocação de tarefas são possíveis?

calculate_arranjo <- function(n, r){
  if (n < r){
    return(0) # retorna 0 se n form menor que r
  } else {
    return(factorial(n) / factorial(n - r))
  }
}

servidores = 4
tarefas = 6
arranjos <- calculate_arranjo(tarefas, servidores)
cat("O número de arranjos de", servidores, "elementos tomados", tarefas, "a cada vez é", arranjos
    , "\n")

                                      # Exercício 5

# Você está gerenciando um projeto de desenvolvimento de software
# e precisa alocar 3 desenvolvedores de uma equipe de 6 para uma tarefa específica.
# Quantas combinações diferentes de equipes de desenvolvedores você pode formar?

devs = 3
equipe = 6  

combinacoesDev = choose(equipe , devs)
cat("O número de combinações de", devs, "elementos tomados",equipe, "a cada vez é",
    combinacoesDev, "\n")
