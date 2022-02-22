secreto = int(input("Número a ser adivinhado: "))
for i in range(100):
    print()

jogada = 0
num_temp = 0
while True:
    jogada += 1
    adivinha = int(input("Adivinha: "))
    if adivinha == secreto:
        print("Acertou em {} tentativa(s)".format(jogada))
        break
    else:
        if jogada == 1:
            num_temp = secreto - adivinha
        else:
            if num_temp > (secreto - adivinha):
                num_temp = secreto - adivinha
                print("quente")
            else:
                print("frio")