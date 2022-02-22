def leibnizPi4(n):
    soma = 0
    for i in range(n):
        soma += ((-1) ** (i)) / ((2 * (i)) + 1)
    return soma

def main():
    print("Este programa calcula a soma dos n primeiros termos da série de Leibniz.\n")
    print("O programa vai iterar infinitamente até o utilizador introduzir o valor (-1).\n \n")
    while True:
        n = int(input("Valor de n: "))
        if n == -1:
            break
        else:
            print(" A soma dos {0} primeiros termos da série de Leibniz é igual a {1} \n".format(n, leibnizPi4(n)))
main()
print("Fim do programa.")