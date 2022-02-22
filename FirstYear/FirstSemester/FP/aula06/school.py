def loadFile(fname, lst):
    f_handle = open(fname)
    count = 0
    for line in f_handle:
        if count == 0:
            count +=1
            continue 
        else:
            line_data = line.split('\t')
            lst.append((int(line_data[0]), line_data[1], float(line_data[5]), float(line_data[6]), float(line_data[7])))
    f_handle.close()
    return lst

def notaFinal(reg):
    media = (reg[2] + reg[3] + reg[4] ) / 3
    return media

def printPauta(lst, file): 
    file_handle = open(file, "w")
    file_handle.write("{:6s} {:^60s} {:>4s} \n".format("Número", "Nome", "Nota"))
    for registo in lst:
        nota = notaFinal(registo)
        file_handle.write("{:6d} {:^60s} {:4.1f} \n".format(registo[0], registo[1], nota))
    file_handle.close()

def main():
    lst = []
    loadFile("school1.csv", lst)
    loadFile("school2.csv", lst)
    loadFile("school3.csv", lst)
    lst.sort()
    printPauta(lst, "try.txt")

if __name__ == "__main__":
    main()