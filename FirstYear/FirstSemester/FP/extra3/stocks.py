# NMEC: 103530
# NOME: André Gabriel Butuc

def printStocks(stocks):
    for stock in stocks:
        vlz = round(((stock[3] - stock[2]) * 100) / stock[2], 1)
        print("{:10s}{:10s}{:8.2f}{:8.2f}{:12d}{:>8s}".format(stock[0], stock[1], stock[2], stock[3], stock[4], str(vlz)+'%'))

def load(fname):
    fhandle = open(fname, "r")
    lst = []
    for line in fhandle:
        content = line.strip().split("\t")
        lst.append((content[0], content[1], float(content[2]), float(content[3]), int(content[4])))
    fhandle.close()
    return lst

def main():
    # Cada tuplo = (empresa, cidade, abertura, fecho, volume)
    stocks = [
        ('INTC', 'London', 34.249, 34.451, 1792860),
        ('TSLA', 'London', 221.33, 229.63, 398520),
        ('EA', 'Paris', 72.63, 68.98, 1189510),
        ('INTC', 'Tokyo', 33.22001, 34.28999, 4509110),
        ('TSLA', 'Paris', 217.35, 217.75, 252500),
        ('ATML', 'Frankfurt', 8.23, 8.36, 810440),
        ]

    print("\na)")
    printStocks(stocks)

    
    print("\nb)")
    stocks2 = sorted(stocks, key= lambda stock: (stock[0], -stock[4]))
    printStocks(stocks2)

    
    print("\nc)")
    stocks3 = [stock for stock in stocks if stock[1] == "Paris"]
    printStocks(stocks3)

    
    print("\nd)")
    stocks4 = load("stocks.txt")
    printStocks(stocks4)
    # As condições seguintes devem ser verdadeiras
    assert type(stocks4)==list
    assert type(stocks4[0])==tuple
    assert len(stocks4[0])==5
    assert type(stocks4[0][2])==float
    assert type(stocks4[0][4])==int
    print("FIM")

if __name__ == "__main__":
    main()

