# Aula 01
""" 01
temp_cel = float(input("Temperature in Celsius: "))
temp_fa = 1.8 * temp_cel + 32
print("{} in Fahrenheit is {}".format(temp_cel, temp_fa))
"""

""" 03
nome = input("Como te chamas? ")
ano = int(input("Em que ano nasceste? "))
print("{} , em 2020 farás {} anos.".format(nome, 2020-ano))
"""

""" 04
segundos = int(input("Tempo: "))
horas = segundos // 3600
minutos = segundos % 3600 // 60
segundos = segundos % 3600 % 60
print("{:2d}:{:02d}:{:02d}".format(horas, minutos, segundos))
"""

""" 05
dist = 0
func = 0
piso = 3 
for i in range(1, 4):
    for f in range(i):
        dist += piso*4
print("Por ano o elevador percorre {}km.".format((dist*365) / 1000))
print("O elevador esteve em funcionamento por {} horas.".format((dist*365) / 3600))
"""

""" 06
import math
sides = []
for i in ['A', 'B']:
    sides.append(float(input("Cateto {}: ".format(i))))
hip = math.hypot(sides[0], sides[1])
arc = math.degrees(math.acos(sides[0]/hip))
print("Hipotenuse: {} u.m   Arco: {} graus".format(hip, arc))
"""

""" 07
import math
print("Input the coords with the following structure: 'Coords A: x y', with a space between the coords")
coordsA = tuple(map(float,input("Coords A: ").split(" ")))
coordsB = tuple(map(float,input("Coords B: ").split(" ")))
dist = math.dist(coordsA, coordsB)
print("Distance between the two given points: {:.2f}".format(dist))
"""

""" 08
pf, pc, imp, spa, tirag = 20, 24.95, 0.23, 0.20, 500
lucro = (((pc - spa)/(1+imp)) - pf)*tirag
coletados = pc*tirag*imp
taxas = tirag * spa
print("Lucro: {:.2f}    Impostos: {:.2f}    Taxas Reunidas: {:.2f}".format(lucro, coletados, taxas))
"""

""" 09
print("Input time in a hh:mm format.")
time = input("Time: ").split(':')
minutes = int(time[0])*60 + int(time[1])
minutes += 10 + 18 + 40
time = "{:02d}:{:02d}".format(minutes//60, minutes%60)
print(time)
"""


# Aula 02

""" 01
def max2(num1, num2):
    mx = num1
    if num2 > mx:
        mx = num2
    return mx
"""

""" 02
def max3(num1, num2, num3):
    mx = num1
    if num2 > mx:
        mx = num2
    elif num3 > mx:
        mx = num3
    return mx
"""

""" 03
def even_odd(num):
    if num % 2 == 0:
        return 'Even'
    return 'Odd'
"""

""" 04
def gas(l):
    price = 1.4
    pay = 1.4 * l
    if l > 40:
        pay *= 0.9
    return pay
"""

""" 05
age = int(input("Age? "))
if age > 0:
	print("Age:", age)
else:
	print("Invalid input")
	exit(1)
if age < 13 :
    cat = "child"
elif age < 20:
	cat = "teenager"
else:
	cat = "adult"
print("Category:", cat)
"""

""" 06
import math
print("IMC Calculator")
massa = float(input("Massa corporal em kg: "))
altura = float(input("Altura em metros: "))
imc = massa / (math.pow(altura, 2))
if imc < 18.5:
    cat = "Magro"
elif imc < 25:
    cat = 'Saudável'
elif imc < 30:
    cat = "Forte"
else:
    cat = "Obeso"

print("Está na categoria: {}".format(cat))
"""

""" 07
print("Kryptonite Phases")
temp = float(input("Temperature: "))
pressure = float(input("Pressure: "))

if temp > 400:
    if pressure > 50:
        phase = "'Liquid'"
    else:
        phase = "'Gas'"
else:
    if pressure > 1/8 * temp:
        phase = "'Solid'"
    else:
        phase = "'Gas'"

print("The Kryptonite is in the {} phase".format(phase))
"""

""" 08
print("Calculadora Nota Final")
ctp = float(input("CTP: "))
cp = float(input("CP: "))
nota = 0.3*ctp + 0.7*cp
if ctp < 6.5 or cp < 6.5:
    nota = 66

elif nota < 9.5:
    atrp = float(input("ATPR: "))
    apr = float(input("APR: "))
    nota = 0.3*atrp + 0.7*apr

print("Nota: {}".format(nota))
"""

# Aula 03

""" 01

def bodyMassIndex(weight, height):
    return weight / pow(height, 2)

def bmiCategory(imc):
    if imc < 18.5:
        cat = "Underweight"
    elif imc < 25:
        cat = 'Normal Weight'
    elif imc < 30:
        cat = "Overweight"
    else:
        cat = "Obesity"
    return cat

def main():
    weight = float(input("Weight: "))
    height = float(input("Height: "))
    imc = bodyMassIndex(weight, height)
    cat = bmiCategory(imc)
    print("With {:.2f} kg/m^2 you have {}".format(imc, cat))

main()
"""

""" 02
def polinomial(x):
    return pow(x, 2) + 2*x + 3

def main():
    print(polinomial(0))
    print(polinomial(1))
    print(polinomial(2))
    print(polinomial(polinomial(1)))

main()
"""

""" 03 & 04
def max2(num1, num2):
    mx = num1
    if num2 > mx:
        mx = num2
    return mx

def max3(num1, num2, num3):
    return max2(max2(num1,num2), num3)

def main():
    print(max2(4,3))
    print(max2(-3, -2))
    print(max3(4, 3, -3))
    print(max3(3, -3, -2))

main()
"""

""" 05
def tax(r):
    if r <= 1000:
        tax = 0.1*r
    elif r <= 2000:
        tax = 0.2*r - 100
    else:
        tax = 0.3*r - 300
    return tax
"""

"""06
def intersects(a1, b1, a2, b2):
    assert a1<=b1
    assert a2<=b2
    intersect = True
    if a1 >= b2 or b1 <= a2:
        intersect = False
    return intersect
"""

""" 07
def isLeapYear(year):
    isLeap = False
    if year % 4 == 0:
        isLeap = True
        if year % 100 == 0:
            isLeap = False
            if year % 400 == 0:
                isLeap = True
    return isLeap

def monthDays(year, month):
    MONTHDAYS = (0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31)
    if isLeapYear(year) and month==2:
        return 29
    return MONTHDAYS[month]

def nextDay(year, month, day):
    monthdays = monthDays(year, month)
    if day + 1 <= monthdays:
        day += 1
    else:
        day = 1
        if month == 12:
            month = 1
            year += 1
        
        else:
            month += 1
    return year, month, day
"""

""" 08
def hms2sec(h,m,s):
    return h * 3600 + m * 60 + s
"""

""" 09
def sec2hms(sec):
    h = sec // 3600
    m = sec % 3600 // 60
    s = sec % 3600 % 60
    return h, m, s
"""

""" 10
def countdown(N):
    print(N)
    if N > 0:
        countdown(N-1)
"""

""" 11
def mdc(a,b):
    r = a % b
    if r == 0:
        return b
    if r > 0:
        return mdc(b, r)
"""

# Aula 04

""" 02
def table(n):
    print("{:>2s}{:>6s}{:>10s}".format('n', 'n^2', '2^n'))
    for i in range(n):
        m = i+1
        print("{:2d}{:6d}{:10d}".format(m, pow(m,2), pow(2,m)))
"""

""" 03
def sequence(n='positive'):
    un = 100
    count = 1
    if n == 'positive':
        while un > 0:
            print(un)
            un = 1.01*un - 1.01
            count +=1
        print(count)
    else:
        for i in range(n):
            print(un)
            un = 1.01*un - 1.01
"""

""" 04
def factorial(n):
    assert isinstance(n, int)
    assert n >= 0
    fact = 1
    for i in range(n):
        fact *= i+1
    return fact
"""

""" 05
import random
def HiLo():
    num = random.randint(1, 100)
    guess = ''
    attemps = 0
    while guess != num:
        guess = int(input("Guess: "))
        if guess > num:
            print("Go lower!")
        elif guess < num:
            print("Go higher!")
        attemps += 1
    print("Good job. You guessed the number with only {} attemps.".format(attemps))
"""

""" 06
def leibniz(n):
    pi = 0
    for i in range(n):
        pi += pow(-1, i) / (2*i+1)
    return pi
"""

""" 07
def average():
    trigger = 0
    soma = 0
    count = 0
    while trigger == 0:
        num = input()
        if num == '':
            trigger = 1
        else:
            soma += float(num)
            count += 1
    return soma/count
"""

""" 08
import turtle
def draw(turtle, start, end, step):
    while start != end:
        turtle.forward(start)
        turtle.left(90)
        start += step   
def main():
    wn = turtle.Screen()
    steve = turtle.Turtle()
    draw(steve, 200, 0, -5)
    wn.exitonclick()
"""

""" 09
def Fibonacci(n):
    num1 = 0
    num2 = 1
    for i in range(2, n):
        temp = num1 + num2
        num1 = num2
        num2 = temp
    return num2
"""

""" 10
def isPrime(n):
    div = 2
    while div < n:
        if n % div == 0:
            return False
        div += 1
    return True
"""

""" 11
def naturalDivisors():
    num = int(input("Positive integer: "))
    div = num - 1
    divisors = list()
    while div > 0:
        if num % div == 0:
            divisors.append(div)
        div -= 1
    divisors.sort()
    return divisors
"""

# Aula 05

""" 02
def inputFloatList():
    lst = []
    while True:
        num = input("Num: ")
        if num == '':
            break
        else:
            lst.append(float(num))
    return lst

def countLower(lst, v):
    count = 0
    for num in lst:
        if num < v:
            count += 1
    return count

def minmax(lst):
    mx = lst[0]
    mn = lst[0]
    for num in lst:
        if num > mx:
            mx = num
        if num < mn:
            mn = num
    return mn, mx

def main():
    lst = inputFloatList()
    mn, mx = minmax(lst)
    vm = (mx + mn) / 2
    count = countLower(lst, vm)
    print(count)
"""

""" 03
def telToName(tel, telList, nameList):
    if tel in telList:
        ind = telList.index(tel)
        return nameList[ind]
    else:
        return tel

def nameToTels(name, telList, nameList):
    matches = []
    for person in nameList:
        if name.lower() in person.lower():
            matches.append(telList[nameList.index(person)])
    return matches

def main():
    telList = ['975318642', '234000111', '777888333', '911911911']
    nameList = ['Angelina', 'Brad', 'Claudia', 'Bruna']

    tel = input("Tel number? ")
    print( telToName(tel, telList, nameList) )
    print( telToName('234000111', telList, nameList) == "Brad" )
    print( telToName('222333444', telList, nameList) == "222333444" )

    name = input("Name? ")
    print( nameToTels(name, telList, nameList) )
    print( nameToTels('Clau', telList, nameList) == ['777888333'] )
    print( nameToTels('Br', telList, nameList) == ['234000111', '911911911'] )
"""

""" 04
def allMatches(team):
    assert len(teams) >= 2
    matches = []
    for team in teams:
        for tm in teams:
            if tm == team:
                continue
            else:
                matches.append((team, tm))
    return matches
"""

""" 05
def countDigits(str):
    count = 0
    for char in str:
        if char.isdigit():
            count += 1
    return count
"""

""" 06
def shorten(str):
    uppers = []
    for char in str:
        if char.isupper():
            uppers.append(char)
    return ''.join(uppers)
"""

""" 07
def ispalindrome(s):
    return s == s[::-1]
"""

""" 08
def evenThenOdd(s):
    return s[::2] + s[1::2]

def removeAdjacentDuplicates(s):
    word = s[0]
    for i in range(1, len(s)):
        if s[i] == s[i-1]:
            continue
        else:
            word += s[i]
    return word

def reapeatNumTimes(n):
    lst = []
    for i in range(n+1):
        for f in range(i):
            lst.append(i)
    return lst

def positionOfFirstLargest(arr):
    ind = 0
    mx = arr[0]
    index_max = 0
    for num in arr:
        if num > mx:
            mx = num
            index_max = ind
        ind += 1
    return index_max
"""

# Aula 06

""" 01
def fileSum(f_name):
    f_handle = open(f_name, 'r')
    soma = 0
    for line in f_handle:
        soma += float(line)
    f_handle.close()
    return soma

def main():
    f_name = 'nums.txt'
    soma = fileSum(f_name)
    print(soma)

main()
"""

""" 02
import turtle

def turtledraw(turtle, f_name):
    f_handle = open(f_name, 'r')
    for line in f_handle:
        if line.strip() == 'UP':
            turtle.penup()
        elif line.strip() == 'DOWN':
            turtle.pendown()
        else:
            x, y = line.strip().split()
            turtle.goto(int(x), int(y))
    f_handle.close()

def main():
    wn = turtle.Screen()
    steve = turtle.Turtle()
    f_name = 'drawing.txt'
    turtledraw(steve, f_name)
    wn.exitonclick()

main()
"""

""" 03 & 04
def loadFile(fname, lst):
    f_handle = open(fname, 'r')
    count = 0
    for line in f_handle:
        if count == 0:
            count = 1
            continue
        content = line.split('\t')
        lst.append((int(content[0]), content[1], float(content[5]), float(content[6]), float(content[7])))
    f_handle.close()

def notaFinal(reg):
    return (reg[2] + reg[3] + reg[4]) / 3

def printPauta(lst, fname=''):
    if fname == '':
        print("{:}{:^70s}{:>10s}".format("Numero", "Nome", "Nota"))
        for reg in lst:
            print("{:5d}{:^70s}{:10.1f}".format(reg[0], reg[1], notaFinal(reg)))
    else:
        f_handle = open(fname, 'w')
        f_handle.write("{:}{:^70s}{:>10s}\n".format("Numero", "Nome", "Nota"))
        for reg in lst:
            f_handle.write("{:5d}{:^70s}{:10.1f}\n".format(reg[0], reg[1], notaFinal(reg)))
        f_handle.close()

def main():
    lst = []
    loadFile("school1.csv", lst)
    loadFile("school2.csv", lst)
    loadFile("school3.csv", lst)
    lst.sort()
    printPauta(lst, 'test.txt')

main()
"""

""" 05
import math
def floatInput(prompt, min=-math.inf, max=math.inf):
    trigger = False
    while not trigger:
        num = input(prompt)
        try:
            conversion = float(num)
        except ValueError:
            print("Not a float!")
            continue    
        else:
            if min <= conversion <= max:    
                return conversion
            else:
                print("Value should be in [{}, {}]!".format(min, max))
"""

# Extra 1

""" 01
def genFibonacci(n):
    assert n >= 2
    lst = []
    for i in range(2, n):
        lst.append(lst[i-2] + lst[i-1])
    return lst
"""

""" 02 & 03 
def containsDoubles(str):
    containsDouble = False
    for i in range(1, len(str)):
        if str[i-1].lower() == str[i].lower():
            containsDouble = True
            break
    return containsDouble

def findLinesWithDoubles(fname):
    f_handle = open(fname, 'r')
    lines_doubles = []
    for line in f_handle:
        if containsDoubles(line):
            lines_doubles.append(line.strip())
    return lines_doubles

print(findLinesWithDoubles('wordlist.txt'))
"""

""" 04
def load(fname):
    with open(fname) as f:
        lst = []
        for line in f:
            word = line.strip()
            lst.append(word)
    return lst


def filterPattern(lst, pattern):
    filters = []
    for word in lst:
        if matchesPattern(word, pattern):
            filters.append(word)
    return filters

def matchesPattern(s, pattern):
    s = s.lower()
    pattern = pattern.lower()
    if not len(s) == len(pattern):
        return False
    matches = False
    for i in range(len(s)):
        if pattern[i] == '?':
            continue
        if s[i] == pattern[i]:
            matches = True
        else:
            matches = False
            break
    return matches
"""

""" 05
def printTable(lst):
    print("{:^4s}{:>20s}{:>8s}{:>8s}".format("Nome", "Peso", "Altura", "IMC"))
    for reg in lst:
        print("{:^4s}{:20d}{:8.2f}{:8.1f}".format(reg[0], round(reg[1]), reg[2], reg[1]/(reg[2])**2))
    print()

def inputBetween(prompt, mn, mx):
    while True:
        num = float(input(prompt))
        if mn <= num <= mx:
            return num
        else:
            print("Value must be in [{}, {}]!".format(mn, mx))

def selectTaller(lst, num):
    tall_people = []
    for reg in lst:
        if reg[2] > num:
            tall_people.append(reg)
    return tall_people
"""


# Aula 07 

""" 02

import sys 

def countLetters(fname):
    fhandle = open(fname, "r")
    dic = {}

    for line in fhandle:
        content = list(line.lower())
        for char in content:
            if char.isalpha():      
                dic.setdefault(char, 0)
                dic[char] += 1
    fhandle.close()
    return dic

def main():
    fname = sys.argv[1]
    dic = countLetters(fname)
    lst = sorted(dic , key= lambda t: t)
    for letter in lst:
        print(letter, dic[letter])

main()

"""

""" 03 & 04 

def listContacts(dic):
    print("{:>12s} : {:^22s} : {:>}".format("Numero", "Nome", "Morada"))
    for num in dic:
        print("{:>12s} : {:^22s} : {:>}".format(num, dic[num][0], dic[num][1]))


def addContact(dic):
    numero = input("Número: ")
    nome = input("Nome: ")
    morada = input("Morada: ")
    dic[numero] = (nome, morada)

def removeContact(dic):
    numero = input("Número: ")
    confirmation = input("Tem a certeza que quer efetuar esta operação? [(S)im ou (N)ão] ")
    if confirmation.lower() == "s":
        dic.pop(numero)

def findNumber(dic):
    numero = input("Número: ")
    if numero in dic:
        return dic[numero][0]

    else:
        return numero

def filterPartName(dic, partName):
    n_dic = {}
    for number in dic:
        if partName.lower() in dic[number][0].lower():
            n_dic[number] = dic[number][0]
    return n_dic

def menu():
    print()
    print("(L)istar contactos")
    print("(A)dicionar contacto")
    print("(R)emover contacto")
    print("Procurar (N)úmero")
    print("Procurar (P)arte do nome")
    print("(T)erminar")
    op = input("opção? ").upper()   # converts to uppercase...
    return op

def main():
    # The list of contacts:
    contactos = {"234370200": ("Universidade de Aveiro", 'Santiago, Aveiro'),
        "727392822": ("Cristiano Aveiro", 'Madeira') ,
        "387719992": ("Maria Matos", "Braga"),
        "887555987": ("Marta Maia", 'Coimbra'),
        "876111333": ("Carlos Martins", 'Porto'),
        "433162999": ("Ana Bacalhau", 'Viseu')
        }

    op = ""
    while op != "T":
        op = menu()
        if op == "T":
            print("Fim")
        elif op == "L":
            print("Contactos:")
            listContacts(contactos)
        elif op == 'A':
            addContact(contactos)
        elif op == 'R':
            removeContact(contactos)
        elif op == 'N':
            print(findNumber(contactos))
        elif op == 'P':
            partName = input("Parte do nome: ")
            print(filterPartName(contactos,partName))
        else:
            print("Não implementado!")
main()

"""

""" 05

def registerTeams(lst, table):
    print("Team Registration Iniciated. Enter the frase 'END' to end the registration process.")
    while True:
        team = input("Team: ")
        if team.lower() == "end":
            break
        lst.append(team)
        table[team] = [0, 0, 0, 0, 0, 0]

def matchGenerator(teams):
    matches = []
    for team in teams:
        for team_2 in teams:
            if team == team_2:
                continue
            else:
                matches.append((team, team_2))
    return matches

def registerScore(scores, game, table):
    print("{} vs {}".format(game[0], game[1]))
    home_team = int(input("{}: ".format(game[0])))
    table[game[0]][3] += home_team
    table[game[1]][4] += home_team
    away_team = int(input("{}: ".format(game[1])))
    table[game[1]][3] += away_team
    table[game[0]][4] += away_team

    if home_team > away_team:
        table[game[0]][0] += 1
        table[game[0]][5] += 3
        table[game[1]][2] += 1   
    elif home_team < away_team:
        table[game[0]][2] += 1
        table[game[1]][0] += 1
        table[game[1]][5] += 3  
    else:
        table[game[0]][1] += 1
        table[game[0]][5] += 1
        table[game[1]][1] += 1
        table[game[1]][5] += 1

    scores[game] = (home_team, away_team)

def print_table(table):
    ordered = sorted(table.items(), key= lambda team: (team[1][5], team[1][3] - team[1][4]), reverse=True)
    print("{:12s}{:>12s}{:>12s}{:>12s}{:>18s}{:>18s}{:>16s}".format("Equipa", "Vitórias", "Empates", "Derrotas", "Golos Marcados", "Golos Sofridos", "Pontos"))
    for team in ordered:
        print("{:12s}{:12d}{:12d}{:12d}{:18d}{:18d}{:16d}".format(team[0], team[1][0], team[1][1], team[1][2], team[1][3], team[1][4], team[1][5]))
    print()
    return ordered[0][0]

def main():
    teams = []
    table = {}
    registerTeams(teams, table)
    scores = {}
    matches = matchGenerator(teams)
    for match in matches:
        registerScore(scores, match, table)   
    vencedor = print_table(table)
    print("O grande vencedor é {}!! Parabéns campeão!".format(vencedor))

main()

"""

""" 06

# A set of functions to deal with bags of money.
#
# JMR 2017

# Face values of coins (in cents):
COINS = [200, 100, 50, 20, 10, 5, 2, 1]

def value(bag):
    # Return total amount in a bag.
    total_amount = 0
    for coin in bag:
        total_amount += bag[coin] * coin
    return total_amount


def transfer1coin(bag1, c, bag2):
    # Try to transfer one coin of value c from bag1 to bag2.
    # If possible, transfer coin and return True, otherwise return False.
    if bag1.get(c, 0) == 0:
        return False
    else:
        bag1[c] -= 1
        bag2.setdefault(c, 0)
        bag2[c] += 1
        return True

def transfer(bag1, amount, bag2):
    #Try to transfer an amount from bag1 to bag2.
    #If possible, transfer coins and return True,
    #otherwise, return False and leave bags with same values.
    if amount == 0:
        return True
    if value(bag1) < amount:
        return False
    
    coins_to_transfer = {}
    print("bag1: ", bag1)
    for coin in sorted(bag1, reverse=True):
        if amount // coin != 0 and bag1[coin] != 0:
            coins_to_transfer[coin] = amount // coin
            if coins_to_transfer[coin] > bag1[coin]:
                coins_to_transfer.pop(coin)
                continue
            amount = amount % coin
    print(amount)

    if amount > 0:
        lst = sorted(bag1, reverse=True)
        for coin in coins_to_transfer:
            amount += coin * coins_to_transfer[coin]
            lst.remove(coin)
        coins_to_transfer.clear()
        for i in lst:
            if amount // i != 0 and bag1[i] != 0:
                coins_to_transfer[i] = amount // i
            amount = amount % i

    print(coins_to_transfer)
    for coin in coins_to_transfer:
        bag1[coin] -= coins_to_transfer[coin]
        bag2.setdefault(coin, 0)
        bag2[coin] += coins_to_transfer[coin]
        
    return True

def strbag(bag):
    #Return a string representing the contents of a bag.
    # You may want to change this to produce a more user-friendly
    # representation such as "4x200+3x50+1x5+3x1=958".
    string = ""
    for coin in sorted(bag, reverse=True):
        if bag[coin] != 0:
            string += str(bag[coin]) + "x" + str(coin) + "+"
    string = string[:-1]
    string += "=" + str(value(bag))
    return string
    

def main():
    # A bag of coins is represented by a dict of {coin: number} items
    bag1 = {1: 4, 2: 0, 5:1, 10: 0, 20: 5, 50: 4, 100: 2, 200: 1}
    bag2 = {}

    # Test the value function.
    assert value({}) == 0
    assert value({1:7, 5:2, 20:4, 100:1}) == 197
    
    # Test the strbag function.
    print( strbag({1:7, 5:2, 20:4, 100:1}) )        # 1x100+4x20+2x5+7x1=197
    print( strbag({1:7, 5:2, 10:0, 20:4, 100:1}) )  # 1x100+4x20+2x5+7x1=197

    print("bag1:", strbag(bag1))    # bag1: 1x200+2x100+4x50+5x20+1x5+4x1=709
    print("bag2:", strbag(bag2))    # bag2: =0
    
    print(transfer1coin(bag1, 10, bag2))    # False!
    print("bag1:", strbag(bag1))    # bag1: 1x200+2x100+4x50+5x20+1x5+4x1=709
    print("bag2:", strbag(bag2))    # bag2: =0

    print(transfer1coin(bag1, 20, bag2))    # True
    print("bag1:", strbag(bag1))    # bag1: 1x200+2x100+4x50+4x20+1x5+4x1=689
    print("bag2:", strbag(bag2))    # bag2: 1x20=20

    print(transfer1coin(bag1, 20, bag2))    # True
    print("bag1:", strbag(bag1))    # bag1: 1x200+2x100+4x50+3x20+1x5+4x1=669
    print("bag2:", strbag(bag2))    # bag2: 2x20=40
    
    print(transfer(bag1, 157, bag2))        # True (should be easy)
    print("bag1:", strbag(bag1))    # bag1: 1x200+1x100+3x50+3x20+2x1=512
    print("bag2:", strbag(bag2))    # bag2: 1x100+1x50+2x20+1x5+2x1=197

    print(transfer(bag1, 60, bag2)) # not easy, but possible...
    print("bag1:", strbag(bag1))
    print("bag2:", strbag(bag2))

    return

if __name__ == "__main__":
    main()

"""


# Aula 08

""" 02 

# Devolve o IMC para uma pessoa com peso w e altura h.
def imc(w, h):
    return w/h**2


def main():
    # Lista de pessoas com nome, peso em kg, altura em metro.
    people = [("John", 64.5, 1.757),
        ("Berta", 64.0, 1.612),
        ("Maria", 45.1, 1.715),
        ("Andy", 98.3, 1.81),
        ("Lisa", 46.8, 1.622),
        ("Kelly", 83.2, 1.78)]

    print("People:", people)

    # Esta comprehension define uma lista dos nomes das pessoas em people
    names = [n for n,w,h in people]
        # = [p[0] for p in people]  # equivalente
    print("Names:", names)
    
    # Usando list comprehensions, obtenha: 
    # a) Uma lista com os valores de imc de todas as pessoas.
    imcs = [imc(person[1], person[2]) for person in people]
    print("IMCs:", imcs)

    # b) Uma lista dos tuplos de pessoas com altura superior a 1.7m.
    tallpeople = [person for person in people if person[2] > 1.7]
    print("Tall people:", tallpeople)    

    # c) Uma lista de nomes das pessoas com IMC entre 18 e 25.
    midimc = [person for person in people if 18 < imc(person[1], person[2]) < 25]
    print("Mid-IMC:", midimc)


# O programa começa aqui
main()

"""

""" 03 
def last_name_sep(fname):
    fhandle = open(fname, "r")
    last_names = {}
    for line in fhandle:
        content = line.strip().split(" ")
        last_names.setdefault(content[-1], set())
        last_names[content[-1]].add(content[0])
    return last_names

def main():
    fname = "names.txt"
    last_name_dic = last_name_sep(fname)
    for last_name in last_name_dic:
        print("{} : {}".format(last_name, last_name_dic[last_name]))

main() 
""" 

""" 04

def primesUpTo(n):
    conjunto = set(range(2, n+1))
    m = 2
    while  m ** 2 < n+1:
        if m in conjunto:
            mn = set(range(m**2, n+1, m))
            conjunto -= mn
        m += 1 
    return conjunto

def main():
    # Testing:
    s = primesUpTo(1000)
    print(s)

    # Do some checks:
    assert primesUpTo(30) == {2,3,5,7,11,13,17,19,23,29}
    assert len(primesUpTo(1000)) == 168
    assert len(primesUpTo(7918)) == 999
    assert len(primesUpTo(7919)) == 1000
    print("All tests passed!")

if __name__ == "__main__":
    main()

"""

""" 05

def main():
    A = "reading"
    B = "eating"
    C = "traveling"
    D = "writing"
    E = "running"
    F = "music"
    G = "movies"
    H = "programming"

    interests = {
        "Marco": {A, D, E, F},
        "Anna": {E, A, G},
        "Maria": {G, D, E},
        "Paolo": {B, D, F},
        "Frank": {D, B, E, F, A},
        "Teresa": {F, H, C, D}
        }


    print("a) Table of common interests:")
    commoninterests = {(person1, person2): interests[person1] & interests[person2] for person1 in interests for person2 in interests if person1 < person2}
    print(commoninterests)
    
    print("b) Maximum number of common interests:")
    maxCI = max(len(common) for common in commoninterests.values())
    print(maxCI)
    
    print("c) Pairs with maximum number of matching interests:")
    maxmatches = [pair for pair in commoninterests.keys() if len(commoninterests[pair]) == maxCI]
    print(maxmatches)
    
    print("d) Pairs with low similarity:")
    lowJaccard = [pair for pair in commoninterests.keys() if len(interests[pair[0]] & interests[pair[1]]) / len(interests[pair[0]] | interests[pair[1]]) < 0.25]
    print(lowJaccard)

# Start program:
main()

"""

# Aula 09

""" 02 

import sys 

def countLetters(fname):
    fhandle = open(fname, "r")
    dic = {}

    for line in fhandle:
        content = list(line.lower())
        for char in content:
            if char.isalpha():      
                dic.setdefault(char, 0)
                dic[char] += 1
    fhandle.close()
    return dic

def main():
    fname = sys.argv[1]
    dic = countLetters(fname)
    lst = sorted(dic , key= lambda t: dic[t], reverse=True)
    for letter in lst:
        print(letter, dic[letter])

main()

"""

""" 03

# Tabela classificativa da Primeira Liga de futebol de Portugal em 2018-11-30.
# (Descarregada de https://www.resultados.com/futebol/portugal/primeira-liga/)

tabela = [
    ("Rio Ave", 5, 3, 2, 17, 13),
    ("Tondela", 2, 3, 5, 12, 14),
    ("Moreirense", 5, 1, 4, 11, 14),
    ("Feirense", 2, 3, 5, 7, 11),
    ("Maritimo", 3, 1, 6, 6, 13),
    ("Benfica", 6, 2, 2, 19, 11),
    ("Setubal", 4, 2, 4, 13, 11),
    ("Portimonense", 3, 2, 5, 12, 18),
    ("Guimaraes", 4, 3, 3, 15, 12),
    ("Boavista", 2, 3, 5, 8, 14),
    ("Nacional", 2, 3, 5, 10, 19),
    ("Belenenses", 2, 6, 2, 7, 8),
    ("Santa Clara", 4, 2, 4, 17, 16),
    ("FC Porto", 8, 0, 2, 21, 6),
    ("Braga", 6, 3, 1, 19, 10),
    ("Sporting", 7, 1, 2, 18, 10),
    ("Aves", 3, 1, 6, 11, 15),
    ("Chaves", 2, 1, 7, 9, 17) ]

# Cada registo na tabela classificativa contém:
#   Nome, Vitórias, Empates, Derrotas, Golos Marcados e Golos Sofridos
# Pode usar estes identificadores para os campos:
N,V,E,D,GM,GS = 0,1,2,3,4,5

def printTabela(tabela):
    print()
    print("{:19s} {:>3} {:>3} {:>3} {:>3} {:>3}:{:<3} {:>3}".format(
            "Equipa", "J", "V", "E", "D", "GM", "GS", "P"))
    for reg in tabela:
        nome,v,e,d,gm,gs = reg
        print("{:19s} {:3d} {:3d} {:3d} {:3d} {:3d}:{:<3d} {:3d}".format(
                nome, numJogos(reg), v, e, d, gm, gs, pontos(reg)))

# numJogos é uma função definida por uma expressão lambda que,
# dado um registo de uma equipa, devolve o número de jogos que a equipa jogou.
numJogos = lambda reg: reg[V]+reg[E]+reg[D]

# a)
# Complete a expressão lambda para definir uma função que,
# dado um registo de uma equipa, devolva o número de pontos da equipa.
# (Cada vitória vale 3 pontos, cada empate vale 1 ponto.)
pontos = lambda reg: reg[V] * 3 + reg[E]

def main():
    # Teste:
    print(tabela[3][N], numJogos(tabela[3]))  # Feirense 10?

    print(tabela[-1][N], pontos(tabela[-1]))  # Chaves 7?


    # Mostra a tabela classificativa original, não ordenada:
    printTabela(tabela)
    
    # b)
    # Acrescente os argumentos adequados à função sorted para
    # obter uma tabela ordenada por ordem decrescente de pontos:
    tab = sorted(tabela, key=pontos, reverse=True)
    printTabela(tab)

    # c)
    # Acrescente os argumentos adequados à função sorted para
    # obter uma tabela ordenada por ordem decrescente da diferença GM-GS:
    tab = sorted(tabela, key=lambda reg: reg[GM] - reg[GS], reverse=True)
    printTabela(tab)

    # d)
    # Acrescente os argumentos adequados à função sorted para
    # obter uma tabela ordenada por ordem decrescente de pontos e,
    # se iguais, por ordem da diferença GM-GS:
    tab = sorted(tabela, key=lambda reg: (pontos(reg), reg[GM] - reg[GS]), reverse=True)
    printTabela(tab)

if __name__ == "__main__":
    main()

"""

""" 04

def mediana(lst):
    lst.sort()
    if len(lst)%2 == 0:
        return (lst[len(lst)// 2 - 1] + lst[len(lst) // 2]) / 2
    else:
        return lst[len(lst) // 2]

def main():

    lst1 = [1,2,3,4,5,6,7,8,9,10]
    lst2 = [6,5,4,2,6,8,6,4,2]
    lst3 = [0]

    print(mediana(lst1))
    print(mediana(lst2))
    print(mediana(lst3))

main()

"""

# Aula 10

""" 01

# Calcula o factorial de n, baseado na recorrencia n! = n*(n-1)!.
# Mas não termina!  Detete a causa e corrija o erro.
def fact(n):
    if n <= 1:
        return 1 
    return n*fact(n-1)


# Calcula o maximo divisor comum entre a e b.
# Baseia-se no algoritmo de Euclides.
# Mas não termina!  Detete a causa e corrija o erro.
def gcd(a, b):
    if b == 0:
        return a
    return gcd(b,a%b)


def main():
    print( fact(4) )    # 24
    print( fact(5) )    # 120

    x = 2*27*53*61
    y = 2*2*17*23*53
    print(x, y, gcd(x, y))
    assert gcd(x, y) == 2*53

if __name__ == "__main__":
    main()

"""

""" 02

# Generates all length-3 words with symbols taken from the given alphabet.
def genWords3(symbols):
    return [ x+y+z for x in symbols for y in symbols for z in symbols ]


# Generates all length-n words with symbols taken from the given alphabet.
def genWords(symbols, n):
    if n == 0:
        return [""]
    lst = genWords(symbols, n-1)
    words = [w+c for w in lst for c in symbols]
    return words


def main():
    lstA = genWords3("abc")
    print(lstA)

    lstB = genWords("abc", 3)  # should return the same words, maybe in other order
    print(lstB)
    assert sorted(lstA) == sorted(lstB)

    lstC = genWords("01", 4)  # should return all length-4 binary words
    print(lstC)

if __name__ == "__main__":
    main()

"""

""" 03

import os

def printDirFiles(d):
    lst = os.listdir(d)
    for fname in lst:
        path = os.path.join(d, fname)
        if os.path.isfile(path):
            ftype = "FILE"
        elif os.path.isdir(path):
            ftype = "DIR"
        else:
            ftype = "?"
        print(ftype, path)
    return


def findFiles(path, ext):
    # Complete...
    lst = os.listdir(path)
    files = []
    if len(lst) == 0:
        return []
    else:
        for fname in lst:
            n_path = os.path.join(path,fname)
            if os.path.isfile(n_path):
                if ext in n_path:
                    files.append(n_path[n_path.rfind("/") + 1:])
            if os.path.isdir(n_path):
                return findFiles(n_path, ext)

        return files
def main():
    print("Testing printDirFiles('..'):")
    printDirFiles("..")

    print("\nTesting findFiles('.', '.py'):")
    lst = findFiles(".", ".py")
    print(lst)
    assert isinstance(lst, list)

    print("\nTesting findFiles('..', '.csv'):")
    lst = findFiles("..", ".csv")
    print(lst)

if __name__ == "__main__":
    main()

"""


# Falta o Extra 02 e o Extra 03, mas não me apetece fazer de novo :)) 