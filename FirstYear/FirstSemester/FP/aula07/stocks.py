
# Constantes para indexar os tuplos:
NAME,DATE,OPEN,MAX,MIN,CLOSE,VOLUME = 0,1,2,3,4,5,6

def main():
    lst = loadStockFile("nasdaq.csv")
    # Show just first and last tuples:
    print("first:", lst[1])
    print("last:", lst[-1])
    
    print("a) totVol=", totalVolume(lst))

    print("b) maxVal=", maxValorization(lst))
 
    stocksDic = stocksByDateByName(lst)
    print("c) CSCO@11:", stocksDic['2020-10-12']['CSCO'])
    print("c) AMZN@22:", stocksDic['2020-10-22']['AMZN'])
    port = {'NFLX': 100, 'CSCO': 80}
    print("d) portfolio@01:", portfolioValue(stocksDic, port, "2020-10-01"))
    print("d) portfolio@30:", portfolioValue(stocksDic, port, "2020-10-30"))
 
def loadStockFile(filename):
    lst = []
    with open(filename) as f:
        for line in f:
            parts = line.strip().split('\t')
            name = parts[NAME]
            date = parts[DATE]
            tup = (name, date, float(parts[OPEN]), float(parts[MAX]),
                float(parts[MIN]), float(parts[CLOSE]), int(parts[VOLUME]))
            lst.append(tup)
    return lst

def totalVolume(lst):
    totVol = {}
    for tup in lst:
        totVol[tup[NAME]] = totVol.get(tup[NAME], 0) + tup[VOLUME]
    return totVol

def maxValorization(lst):
    vMax = {}
    for tup in lst:
        vMax.setdefault(tup[DATE], ("Bax",0))

    for tup in lst:
        valorizacao = tup[CLOSE]/tup[OPEN] - 1
        if valorizacao > vMax[tup[DATE]][1]:
            vMax[tup[DATE]] = (tup[NAME], valorizacao)

    return vMax

def stocksByDateByName(lst):
    dic = {}
    for tup in lst:
        dic.setdefault(tup[DATE], {})
    for tup in lst:
        dic[tup[DATE]][tup[NAME]] = [tup[OPEN], tup[MAX], tup[MIN], tup[CLOSE], tup[VOLUME]]
    return dic

def portfolioValue(stocks, portfolio, date):
    assert date in stocks
    val = 0.0
    for key in portfolio:
        val += stocks[date][key][3] * portfolio[key]

    return val

if __name__ == "__main__":
    main()
