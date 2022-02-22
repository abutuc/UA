import json

fi = open('twitter.json')
data = json.load(fi)

todas_palavras={}
for tweet in data:
    for p in tweet['text'].split(" "):
        if p not in todas_palavras:
            todas_palavras[p] = 0
        todas_palavras[p]+=1

def selectsort(lista):
    for i in range(len(lista)):
        maior = lista[i]
        j = i+1
        for k,v in lista[(i+1):]:
            mk, mv = maior
            if v > mv:
                maior = (k, v)
                m_index = j
            j+=1
        print maior
        lista[i], lista[m_index] = lista[m_index], lista[i]

    return lista

def quicksort(lista):
    print lista
    if len(lista) <= 1:
        return lista

    pivot = lista[0]
    pivot_palavra, pivot_qtd = pivot

    prev = []
    for (palavra, qtd) in lista[1:]:
        if qtd < pivot_qtd:
            prev.append((palavra, qtd))

    nxt = []
    for (palavra, qtd) in lista[1:]:
        if qtd >= pivot_qtd:
            nxt.append((palavra, qtd))

    return quicksort(prev) + [pivot] + quicksort(nxt)


#print todas_palavras.keys()

todas_palavras_lista = []
for k, v in todas_palavras.items():
    todas_palavras_lista.append((k, v))

print selectsort(todas_palavras_lista)
