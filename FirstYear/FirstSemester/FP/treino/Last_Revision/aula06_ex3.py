def loadFile(fname1, lst):
    f_handle = open(fname1, "r")
    for i, line in enumerate(f_handle):
        if i == 0:
            continue
        else:
            data = line.split("\t")
            lst.append(tuple([int(data[0]), data[1], float(data[5]), float(data[6]), float(data[7])]))
    f_handle.close()

def notaFinal(reg):
    nota_final = (reg[2] + reg[3] + reg[4]) / 3
    return nota_final

def printPauta(lst, file = 'default'):
    if file == 'default':
        print("{:<6s}{:^60s}{:>8s}".format("Numero", "Nome", "Nota"))
        for reg in lst:
            nota_final = notaFinal(reg)
            print("{:6}{:^60s}{:8.1f}".format(int(reg[0]), reg[1], nota_final))
    else:
        f_handle = open(file, 'w')
        f_handle.write("{:<6s}{:^60s}{:>8s}\n".format("Numero", "Nome", "Nota"))
        for reg in lst:
            nota_final = notaFinal(reg)
            f_handle.write("{:6}{:^60s}{:8.1f}\n".format(int(reg[0]), reg[1], nota_final))
        f_handle.close()
def main():
    lst = []
    loadFile("school1.csv", lst)
    loadFile("school2.csv", lst)
    loadFile("school3.csv", lst)
    lst.sort()
    printPauta(lst, "test.txt")

main()
