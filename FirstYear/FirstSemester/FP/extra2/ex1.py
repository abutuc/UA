def menu():
    opcoes = ["Registar chamada", "Ler ficheiro", "Listar clientes", "Fatura", "Terminar"]
    for i in range(5):
        print("{}) {}".format(i+1, opcoes[i]))
    escolha = input("Opção? ")
    return escolha

def validar(numero):
    digitos = "0123456789"
    valido = True

    if len(numero) < 3:
        valido = False
    else:
        if numero[0] == '+':
            if len(numero[1:]) <= 2:
                valido = False
            else:
                for char in numero[1:]:
                    if char in digitos:
                        valido = True
                    else:
                        valido = False
                        break
        else:
            for char in numero:
                if char in digitos:
                    valido = True
                else:
                    valido = False
                    break
    return valido
                    
def opcao1(fname):
    f_handle = open(fname, "a")
    while True:
        origem = input("Telefone origem? ")
        if validar(origem):
            break
    while True:
        destino = input("Telefone destino? ")
        if validar(destino):
            break
    duracao = input("Duração (s)? ")

    f_handle.write("{}  {}  {}\n".format(origem, destino, duracao))
    f_handle.close()

def opcao2(fname, chamadas):
    f_handle = open(fname, "r")
    for line in f_handle:
        chamadas.append(tuple(line.strip().split()))

def opcao3(fname):
    chamadas = list()
    opcao2(fname, chamadas)
    clientes = set()
    for chamada in chamadas:
        clientes.add(chamada[0])
        clientes.add(chamada[1])
    output = list()
    for cliente in clientes:
        output.append(cliente)
    output.sort()
    return output

def opcao4(fname):
    cliente = input("Cliente? ")
    chamadas = list()
    total = 0
    opcao2(fname, chamadas)
    print("Fatura do cliente {}".format(cliente))
    print("{:22s}{:15s}{:2s}".format("Destino", "Duração", "Custo"))
    for chamada in chamadas:
        if chamada[0] == cliente:
            if chamada[1][0] == "2":
                custo = 0.02 * float(chamada[2])
            elif chamada[1][0] == "+":
                custo = 0.80 * float(chamada[2])
            
            elif chamada[0][:3] == chamada[1][:3]:
                custo = 0.04 * float(chamada[2])
            else:
                custo = 0.10 * float(chamada[2])
            
            total += custo
            print("{:22s}{:15s}{:2.2f}".format(chamada[1], chamada[2], custo))
    
    print("{:>28s}{:>15.2f}".format("Total:", total))
                
def main():
    registo = "chamadas1.txt"
    chamadas = list()
    while True:
        escolha = menu()
        if escolha == "1":
            opcao1(registo)
        elif escolha == "2":
            opcao2(registo, chamadas)
        elif escolha == "3":
            clientes = opcao3(registo)
            print("Clientes: {}".format(" ".join(clientes)))
        elif escolha == "4":
            opcao4(registo)
        elif escolha == "5":
            break
        
        else:
            break

main()