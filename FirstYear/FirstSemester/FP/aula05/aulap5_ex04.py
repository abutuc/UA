def jogos(equipas):
    lista_jogos = list()
    for i in equipas:
        for f in range(len(equipas)):
            if equipas[f] == i:
                continue
            else:
                lista_jogos.append( (i, equipas[f]))
    return lista_jogos
def main():
    equipas_futebol = ["FCP", "SCP", "SLB"]
    print(jogos(equipas_futebol))
main()