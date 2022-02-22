# Irá atualizar a lista das equipas e inicializar os resultados de cada equipa.
def equipas_registo(equipas, tabela):
    print("Enter '-1' to exit.")
    while True:
        equipa = input("Equipa: ")
        if equipa == '-1':
            break
        else:
            equipas.append(equipa)
            tabela[equipa] = [0, 0, 0, 0, 0, 0]
# Irá emparelhar as equipas nos possíveis jogos e devolver a lista com os diferentes tuplos.
def matches(equipas):
    lista_jogos = list()
    for i in equipas:
        for f in range(len(equipas)):
            if equipas[f] == i:
                continue
            else:
                lista_jogos.append( (i, equipas[f]))
    return lista_jogos

# Regista os resultados de cada jogo
def scores(jogos):
    scores = {}
    for jogo in jogos:
        print("Jogo: {} vs {}".format(jogo[0], jogo[1]))
        goals_team1 = int(input("{} goals: ".format(jogo[0])))
        goals_team2 = int(input("{} goals: ".format(jogo[1])))
        scores[jogo] = (goals_team1, goals_team2)
    return scores

def registos(tabela, resultados):
    for jogo in resultados:
        if resultados[jogo][0] > resultados[jogo][1]:
            tabela[jogo[0]][0] += 1
            tabela[jogo[0]][5] += 3
            tabela[jogo[1]][2] += 1
        elif resultados[jogo][0] < resultados[jogo][1]:
            tabela[jogo[1]][0] += 1
            tabela[jogo[1]][5] += 3
            tabela[jogo[0]][2] += 1
        else:
            tabela[jogo[1]][1] += 1
            tabela[jogo[1]][5] += 1
            tabela[jogo[0]][1] += 1
            tabela[jogo[0]][5] += 1

        tabela[jogo[0]][3] += resultados[jogo][0]
        tabela[jogo[0]][4] += resultados[jogo][1]

        tabela[jogo[1]][3] += resultados[jogo][1]
        tabela[jogo[1]][4] += resultados[jogo][0]

def printTabela(tabela):
    print("{:12s}{:^14s}{:^13s}{:^14s}{:^8s}{:^8s}{:^8s}{:^10s}".format("Equipa", "Vitórias", "Empates", "Derrotas", "GM", "GS", "DG", "Pontos"))
    lst = [team for team ]
    for team in dict(sorted(tabela.items(), key= lambda item: (item[1][5]), reverse=True)):
        tabela[team].append(tabela[team][3] - tabela[team][4])
        print("{:12s}{:^14s}{:^13s}{:^14s}{:^8s}{:^8s}{:^8s}{:^10s}".format(team, str(tabela[team][0]), str(tabela[team][1]), str(tabela[team][2]), str(tabela[team][3]),str(tabela[team][4]), str(tabela[team][6]) , str(tabela[team][5])))

    table = dict(sorted(tabela.items(), key= lambda item: (item[1][5],item[1][6]) , reverse=True))
    for key in table:
        champions = key
        break
    return champions



def main():
    # Lista das Equipas
    equipas = []
    # Tabela do Campeonato
    tabela = {}
    equipas_registo(equipas, tabela)
    # Contém os diferentes jogos
    jogos = matches(equipas)
    # Contém os diferentes resultados
    resultados = scores(jogos)
    registos(tabela, resultados)
    campeao = printTabela(tabela)
    print("O campeão é {}!".format(campeao))

main()