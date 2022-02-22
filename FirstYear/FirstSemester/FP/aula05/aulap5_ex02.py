def inputFloatList():
    num_list = list()
    while True:
        num = input("Enter value:")
        if num == "":
            return num_list              
        else:
            num_list.append(float(num))

def countLower(lst, v):
    lower = 0
    for i in lst:
        if i < v:
            lower += 1 
    return lower

def minmax(lst):
    maximo = lst[0]
    minimo = lst[0]
    for i in lst:
        if i > maximo:
            maximo = i     
        if i < minimo:
            minimo = i 
    return maximo, minimo

def main():
    num_list = inputFloatList()
    mx, mn = minmax(num_list)
    valor_medio = (mx + mn) / 2
    count_lower = countLower(num_list, valor_medio)
    print("A lista introduzida foi : {0}".format(num_list))
    print("Máximo : {:<10.2f}Mínimo: {:<10.2f}Média: {:<10.2f}".format(mx, mn, valor_medio))
    print("Existem {} elementos inferiores a {:.2f} na lista introduzida.".format(int(count_lower), valor_medio))
main()