peso = float(input("Infome seu peso em kg:"))
altura = float(input("Informe sua altura em m:"))

imc = peso / (pow(altura, 2))

print("O seu IMC é de {:.1f}".format(imc))

if (imc < 18.5):
    print("Diagnóstico: Abaixo do peso normal")

elif (18.5 <= imc < 25):
    print("Diagnóstico:peso normal")

elif (25 <= imc < 30):
    print("Diagnóstico: Sobrepeso")

elif (30 <= imc < 40):
    print("Diagnóstico: Obeso")

else:
    print("Diagnóstico: Obesidade Mórbida")
