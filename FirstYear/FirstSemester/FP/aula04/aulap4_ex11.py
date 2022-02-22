def divisor_natural(n):
    divisor_list = list()
    n_classification = ""
    i = 1
    while i < n:
        if n % i == 0:
            divisor_list.append(i)
        i += 1
    soma_divisores = sum(divisor_list)
    if soma_divisores < n:
        n_classification = "deficiente"
    elif soma_divisores > n:
        n_classification = "abundante"
    else:
        n_classification = "perfeito"
    return divisor_list, n_classification


def main():
    print("Este programa imprime no ecrâ a lista de todos os divisores próprios de um número n.")
    print("Para além disso, também classifica o número em deficiente, perfeito ou abundante.")
    print("Para terminar o loop, introduza a string 'stop.")
    while True:
        n = input("Enter value of n: ")
        if n == "stop":
            break  
        else:
            lista_divisores, classificacao_n = divisor_natural(int(n))
            for i in lista_divisores:
                print(i)
            print("O número {0} é um número {1}".format(n, classificacao_n))
    print("Fim do programa")
main()