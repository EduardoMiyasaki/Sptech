calcute_fatorial = function(n){
  if(n == 0){
    return(1)
  }
  else{
    return (n * calcute_fatorial(n - 1))
  }  
} 


calcute_fatorial(5)

factorial(5)

n = 5
r = 3


combinacoes = choose(n,r)

cat("O número de combinações de", n, "elementos tomados", r, "a cada vez é",
    combinacoes, "\n")

calculate_arranjo <- function(n, r){
   if (n < r){
     return(0) # retorna 0 se n form menor que r
     } else {
       return(factorial(n) / factorial(n - r))
       }
}

arranjos <- calculate_arranjo(n, r)

cat("O número de arranjos de", n, "elementos tomados", r, "a cada vez é", arranjos, "\n")

