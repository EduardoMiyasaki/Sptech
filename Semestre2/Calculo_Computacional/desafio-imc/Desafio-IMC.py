peso = float(input("Informe quantos kg você pesa: "))
altura = float(input("Informe quantos metros você tem: "))

imc = peso / (pow(altura, 2))

# Alterando para 2f após a 'vírgula' vai ter duas casas decimais
print('O seu IMC é de {:.2f}'.format(imc))

if (imc < 18.5):
    print("Diagnóstico: abaixo do peso normal")

elif (imc >= 18.5 and imc < 25):
    print("Diagnóstico: peso normal")

elif (imc >= 25 and imc < 30):
    print("Diagnóstico: sobrepeso")

elif (imc >= 30 and imc < 40):
    print("Diagnóstico: Obesidade")

else:
    print("Diagnóstico: Obesidade mórbida")
