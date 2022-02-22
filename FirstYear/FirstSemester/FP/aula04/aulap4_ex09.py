def Fibonacci (n):
    termo1 = 0
    termo2 = 1
    termo_novo = 0
    for i in range(n-2):
        termo_novo = termo1 + termo2
        termo1 = termo2
        termo2 = termo_novo
    return termo2

def main():
    while True:
        termo = int(input("n : "))
        if termo == -1:
            break
        elif termo == 1:
            print("Termo 1 da sequência de Fibonacci é 0")
        else:
            print("Termo {} da sequência de Fibonacci é {}".format(termo, Fibonacci(termo)))

main()
print("Fim do programa.")