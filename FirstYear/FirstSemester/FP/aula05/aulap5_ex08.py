def evenThenOdd(s):
    return s[::2] + s[1::2]

def remove_duplicate(s):
    string_letters = list(s)
    letter = ""
    for f, i in enumerate(string_letters):
        if i == letter:
            string_letters.pop(f)
        else:
            letter = i
    new_string = "".join(string_letters)
    
    return new_string

def reapeatNumTimes(n):
    lista = list()
    for i in range(n):
        for f in range(i+1):
            lista.append(i+1)  
    return lista

def ReturnMax(lista):
    maximo = lista[0]
    maximo_index = 0
    for i, f in enumerate(lista):
        if f > maximo:
            maximo = f
            maximo_index = i
    
    return maximo_index

