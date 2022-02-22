#encoding: utf8

import time

def menu():
    op = ""
    while op not in ["I", "F", "S"]:
        print "(I)nserir itens"
        print "(F)acturar"
        print "(S)air"
        op = raw_input(">").upper()
    return op

def ler_bd():
    fi = open('hipermercado.txt')
    bd = {}
    for linha in fi:
       artigo = linha.strip().split(";")
       bd[int(artigo[0])] = {'nome':artigo[1], 'seccao': artigo[2], 'valor': artigo[3], 'iva': artigo[4]}
    return bd

def calcular_preco(bd, code, qtd):
    iva = 1+int(bd[code]['iva'][:-1])/100.0
    preco_unidade = float(bd[code]['valor'])*iva
    return preco_unidade*qtd

def calcular_iva(bd, code, qtd):
    iva = int(bd[code]['iva'][:-1])/100.0
    iva_unidade = float(bd[code]['valor'])*iva
    return iva_unidade*qtd

def inserir_itens(bd):
    code = -1
    total = 0
    stock = {}
    while code != 0:
        code = int(raw_input("?"))
        if code == 0:
            break
        preco = calcular_preco(bd, code, 1)
        print "{}: {}".format(bd[code]['nome'], preco)
        total+=preco
        if code not in stock:
            stock[code] = 0
        stock[code]+=1
    return (total, stock)

def faturar(bd, stocks):
    fact = {}
    total_bruto = 0
    total_iva = 0
    total_liquido = 0
    for c,q in stocks.items():
        if q > 0:
            if bd[c]['seccao'] not in fact:
                fact[bd[c]['seccao']] = ""
            fact[bd[c]['seccao']]+="\t{} {} (IVA {})\t\t{}€\n".format(
                q,
                bd[c]['nome'],
                bd[c]['iva'],
                calcular_preco(bd, c, q)
            )
            total_liquido+=calcular_preco(bd, c, q)
            total_iva+=calcular_iva(bd, c, q)
    total_bruto=total_liquido-total_iva

    for s in fact.keys():
        print s
        print fact[s]
    print "Total Bruto:\t\t{}".format(total_bruto)
    print "Total IVA:\t\t{}".format(total_iva)
    print "Total Liquido:\t\t{}".format(total_liquido)

def main():
    bd = ler_bd()
    vendas = []
    stocks = {}

    for cod in bd.keys():
        stocks[cod] = 0

    while True:
        op = menu()

        if op == 'I':
            (total, stock) = inserir_itens(bd)

            #actualizar as vendas
            vendas.append((time.strftime("%d/%m/%Y %H:%M"), total))

            #actualizar os stocks
            for cod,qtd in stock.items():
                stocks[cod]+=qtd

        elif op == 'F':
            faturar(bd, stocks)
        else:
            #Guardar as vendas
            fo = open('vendas.txt','w')
            for t,v in vendas:
                fo.write("{}: {}\n".format(t, v))

            #Guardas os stocks
            foo = open('stocks.txt', 'w')
            for c,q in stocks.items():
                foo.write("{}: {}\n".format(c,q))

            return

main()
