import math
def calculate(string):
    numbers = string.split(',')
    results = list()
    c = 50
    h = 30
    for number in numbers:
        results.append(str(int(round(math.sqrt(((2*c*float(number))/h))))))
    print(','.join(results))

calculate("100,150,180")