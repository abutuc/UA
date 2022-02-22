def retriveApostas(fread):
    jornadas = [str(x) for x in range(14)]
    saldo = 0
    while True:
        tipo_aposta = input("(S)imples ou (M)últipla? ")
        if tipo_aposta == "S" or tipo_aposta == "M":
            break
        print("Enter either 'S' or 'M'!")
    apostas_multiplas = dict()
    while True:
        while True:
            jornada = input("Jornada? ")
            if jornada in jornadas:
                break
            print("Jornada inválida!")
        if jornada == '0':
            break
        f_handle = open(fread, "r")
        jogos = list()
        i = 0
        for line in f_handle:
            if jornada == line[:len(jornada)]:
                i += 1
                jogos.append(line.strip().split(','))
            if i == 9:
                break
        f_handle.close()

        jornada_file = open("jornada{}.txt".format(jornada), 'w')
        for i,jogo in enumerate(jogos):
            while True:
                aposta = input("{} {} vs {}: ".format(i+1, jogo[1], jogo[2]))
                if tipo_aposta == "S":
                    if aposta == "1" or aposta == "2" or aposta == "X":
                        break
                    print("Aposta inválida!")
                elif tipo_aposta == "M":
                    if aposta in "12X":
                        break
                    print("Aposta inválida")
            jornada_file.write("{}, {}\n".format(i+1, aposta))
        jornada_file.close()
        saldo -= 0.40
        print("Jornada {}".format(jornada))

        jornada_file = open("jornada{}.txt".format(jornada), 'r')
        jogos_file = open("Jogos.csv", 'r')
        i = 0
        certas = 0
        for aposta in jornada_file:
            for l in jogos_file:
                content = l.strip().split(',')
                if content[1] == jogos[i][1] and content[2] == jogos[i][2]:
                    if content[3] > content[4]:
                        certa = "1"
                    elif content[3] < content[4]:
                        certa = "2"
                    else:
                        certa = "X"

                    aposta_1 = aposta.strip().split(',')
                    if aposta_1[1].strip() == certa:
                        escolha = "CERTO"
                        certas += 1
                    else:
                        escolha = "ERRADO"
                    if tipo_aposta == "M":
                        apostas_multiplas.setdefault(1, 0)
                        apostas_multiplas.setdefault(2, 0)
                        apostas_multiplas.setdefault(3,0)
                        if len(aposta_1[1].strip()) == 1:   
                            apostas_multiplas[1] += 1
                        elif len(aposta_1[1].strip()) == 2:
                            apostas_multiplas[2] += 1
                        elif len(aposta_1[1].strip()) == 3:
                            apostas_multiplas[3] += 1
                    print("{:12s}{:>15s}{:^10s}{:<22s}{:7s}({:2s})".format(str(i+1),content[1], str(content[3]) + '-' + str(content[4]), content[2], ':' + aposta_1[1], escolha))
                    jogos_file.seek(0)
                    break
            i += 1
        jornada_file.close()
        jogos_file.close()
        if tipo_aposta == "S":
            if certas == 9:
                premio = "1º PRÉMIO"
                saldo += 5000
            elif certas == 8:
                premio = "2º PRÉMIO"
                saldo += 1000
            elif certas == 7:
                premio = "3º PRÉMIO"
                saldo += 100
            else:
                premio = "SEM PRÉMIO"    

            print("TEM {} CERTAS. {}.".format(certas, premio))
        elif tipo_aposta == "M":
            numero_apostas = (1 ** apostas_multiplas[1]) * (2 ** apostas_multiplas[2]) * (3 ** apostas_multiplas[3])
            custo = numero_apostas * 0.4
            saldo -= custo + 0.4
            print("Número de apostas: {}".format(numero_apostas))
        print("Saldo: {:} euro".format(saldo))



    


def main():
    retriveApostas("Jornadas.csv")


main()