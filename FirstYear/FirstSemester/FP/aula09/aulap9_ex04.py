def mediana(lst):
    lst.sort()
    l = len(lst)

    if l % 2 == 0:
        mediana = (lst[int((l / 2) -1)] + lst[int(l/2)]) / 2
    else:
        mediana = lst[l//2]

    return mediana

def main():
    lst1 = [1,2,3,4,5,6]
    print("Mediana Lista 1: {}".format(mediana(lst1)))
    lst2 = [1,2,3,4,5,6,7]
    print("Mediana Lista 2: {}".format(mediana(lst2)))

main()
