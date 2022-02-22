import time
def menu():
    print("(I)nserir itens")
    print("(F)acturar")
    print("(S)air")
    opção = input("Opção? ")
    return opção


def inserir(dic, artigos, seccoes):
    total = 0
    total_IVA = 0
    while True:
        código = input("Código? ")
        if código == '0':
            break
        quantidade = int(input("Quantidade? "))
        if código in dic:
            preco = float(dic[código][2])*quantidade
            preco_bruto = preco
            preco += preco*(int(dic[código][3][:-1]) / 100)
            total_IVA += preco*(int(dic[código][3][:-1]) / 100)
            total += preco
            print("{}:{:.2f}€".format(dic[código][0], preco))
            artigos[código] = [dic[código], preco, preco_bruto, quantidade]
            seccoes.setdefault(dic[código][1], [])
            seccoes[dic[código][1]].append(código)
    return total, total_IVA

def sair(vendas,StockOut, total, artigos, dic):
    fhandle = open(vendas, 'a')
    fhandle.write("{}: {}\n".format(time.strftime("%d/%m/%Y  %H:%M"), total))
    fhandle.close()

    fhandle = open(StockOut, "w")
    for artigo in dic:
        if artigo in artigos:
            fhandle.write("{}; {}\n".format(artigo, artigos[artigo][3]))
        else:
            fhandle.write("{}; 0\n".format(artigo))
    fhandle.close()

def fatura(artigos, seccoes, total, total_IVA):
    total_bruto = 0
    for seccao in seccoes:
        lst = seccoes[seccao]
        lst.sort()
        print('{}:'.format(seccao))
        for código in lst:
            print("{:6s}{:15s}{:20s}{:5s}".format(str(artigos[código][3]), str(artigos[código][0][0]), "(IVA {})".format(artigos[código][0][3]), "{:.2f}€".format(artigos[código][1])))
            total_bruto += artigos[código][2]
        
    print("Total Bruto: {:.2f}€".format(total_bruto))
    print("Total IVA: {:.2f}€".format(total_IVA))
    print("Total Líquido: {:.2f}€".format(total))


def main():
    fhandle = open("hipermercado.txt", 'r')
    dic = dict()
    for line in fhandle:
        content = line.strip().split(";")
        dic[content[0]] = content[1:]
    artigos = dict()
    seccoes = dict()
    total = 0
    total_IVA = 0
    vendas = "Vendas.txt"
    StockOut = "Stockout.txt"
    while True:
        opção = menu()
        if opção == "I":
            total, total_IVA = inserir(dic, artigos, seccoes)
        elif opção == "F":
            fatura(artigos, seccoes, total, total_IVA)
        
        elif opção == "S":
            sair(vendas, StockOut, total, artigos, dic)
            break

main()