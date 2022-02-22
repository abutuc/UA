# Exercícios ThinkCSPY https://runestone.academy/runestone/books/published/thinkcspy/index.html

# 2.13. Exercises https://runestone.academy/runestone/books/published/thinkcspy/SimplePythonData/Exercises.html

# 3 
time = int(input("Time:"))
time_2_wait = int(input("Time to wait: "))

time += time_2_wait
print(time % 24)


#4
days_week = ["Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"]
leave_day = int(input("Leave day: "))
length_stay = int(input("Length of stay :"))

return_day = (leave_day + length_stay) % 7

print("You will return on {}({})".format(days_week[return_day], return_day))

#5
sentence = "All work and no play makes Jack a dull boy."
words = sentence.split()
same_sentence = ""
for word in words:
    same_sentence += word + " "
print(same_sentence.strip())

#6
print(6 * (1 -2))

#7
P = 10000
n = 12
r = 0.08
years = int(input("Years: "))
final_amount = P * ((1 + (r / n)) ** (n * years))
print("Final amount = {}".format(final_amount))

#8
import math
radius = float(input("Radius of circle: "))
area_circle = math.pi * (radius ** 2)
print("The area of the circle with radius {} is {:.2f}".format(radius, area_circle))

#9
width = float(input("Width: "))
height = float(input("Height: "))
area = width * height
print("The area of the rectangle is {:.1f}".format(area))

#10
miles = float(input("Number of miles driven: "))
gallons = float(input("Number of gallons used: "))
mpg = miles / gallons
print("Your MPG is {:.1f}".format(mpg))

#11
celsius = float(input("Temperature in Celsius: "))
fahrenheit = (celsius * (9/5)) + 32 
print("Temperature in Fahrenheit = {:.1f}".format(fahrenheit))

#12
fahrenheit = float(input("Temperature in Fahrenheit: "))
celsius = (fahrenheit - 32) / (9/5)
print("Temperature in Celsius = {:.1f}".format(celsius))


# 4.11. Exercises https://runestone.academy/runestone/books/published/thinkcspy/PythonTurtle/Exercises.html

#1
for i in range(100):
    print("We like Python's turtles!")

#3
months = ["January","February","March","April","May","June","July","August","September","October","November","December"]
for month in months:
    print("One of the months of the year is {}".format(month))

#4
numbers = [12, 10, 32, 3, 66, 17, 42, 99, 20]
for number in numbers:
    print(number)
print("----------------------------------------")
for n in numbers:
    print("{}{:10}".format(n, n**2))


#5
import turtle

wn = turtle.Screen()

steve = turtle.Turtle()
side_size = 20
shapes = [3,4,6,8]
for shape in shapes:
    for side in range(shape):
        steve.forward(side_size)
        steve.left(360 / shape)
    steve.penup()
    steve.right(90)
    steve.forward(25)
    steve.pendown()

wn.exitonclick()


# 6
import turtle
n_sides = int(input("Number of sides: "))
len_side = float(input("Length of the side: "))
color = input("Color: ")
fill_color = input("Fill color: ")

wn = turtle.Screen()

steve = turtle.Turtle()
steve.color(color)
steve.fillcolor(fill_color)

steve.begin_fill()
for side in range(n_sides):
    steve.forward(len_side)
    steve.left(360 / n_sides)
steve.end_fill()

wn.exitonclick()


#7

import turtle
wn = turtle.Screen()
steve = turtle.Turtle()
angles = [160, -43, 270, -97, -43, 200, -940, 17, -86]
steps = 100
for angle in angles:
    steve.left(angle)
    steve.forward(steps)
print(steve.heading())
wn.exitonclick()

#9

import turtle
wn = turtle.Screen()
steve = turtle.Turtle()
angle = 145
side = 150
for i in range(5):
    steve.forward(side)
    steve.right(angle)
wn.exitonclick()

#10
import turtle

wn = turtle.Screen()
wn.bgcolor("lightgreen")
steve = turtle.Turtle()
steve.shape("turtle")
steve.color("blue")
steve.stamp()
for i in range(12):
    steve.penup()
    steve.forward(100)
    steve.pendown()
    steve.forward(15)
    steve.penup()
    steve.forward(20)
    steve.pendown()
    steve.stamp()
    steve.penup()
    steve.forward(-135)
    steve.right(360/12)
    
wn.exitonclick()

#11
import turtle
import random
wn = turtle.Screen()
steve = turtle.Turtle()
steve.pensize(5)
colors = ["red", "green", "yellow"]
wn.bgcolor("black")

for i in range(50):
    color = random.randint(0,2)
    steve.color(colors[color])
    steve.forward(random.randint(-20, 40))
    steve.left(random.random()*40)
    
wn.exitonclick()

#12
import turtle
steve = turtle.Turtle()
print(type(steve))

#13
import turtle
wn = turtle.Screen()
spider = turtle.Turtle()
n_legs = int(input("Number of legs: "))
leg_size = 100
for leg in range(n_legs):
    spider.forward(leg_size)
    spider.penup()
    spider.forward(-(leg_size))
    spider.left(360 / n_legs)
    spider.pendown()
spider.shape("circle")
wn.exitonclick()

# 5.7. Exercises https://runestone.academy/runestone/books/published/thinkcspy/PythonModules/Exercises.html

#16
import random
n = 10
for i in range(n):
    print(random.random())

#17
import random
counter = 0
while counter <= 10:
    random_number = random.random() * 36
    if 25<=random_number<=35:
        counter += 1
        print(random_number)
    else:
        continue

#18
import math
catA = float(input("Length Side A: "))
catB = float(input("Length Side B: "))
hypotenuse = math.hypot(catA, catB)
print(hypotenuse)

#19
import math

soma = 0
for i in range(1500000):
    soma += ((-1) ** (i)) / ((2 * (i)) + 1)
approx_pi = soma * 4
print(approx_pi)
print(math.pi)

# 6.13. Exercises https://runestone.academy/runestone/books/published/thinkcspy/Functions/Exercises.html

#1
import turtle

def drawSquare(t, sz, iterations):
    """Get turtle t to draw a square of sz side"""
    for i in range(iterations):
        for f in range(4):
            t.forward(sz)
            t.left(90)
        t.penup()
        t.forward(30)
        t.pendown()
    t.penup()
    t.forward(20)
wn = turtle.Screen()
wn.bgcolor("lightgreen")

alex = turtle.Turtle()
alex.color("pink")

drawSquare(alex,20, 5)

wn.exitonclick()

#2
import turtle

def drawSquare(size, turtle):
    for i in range(4):
        turtle.forward(size)
        turtle.left(90)
           
def drawSquares(size, turtle):
    for i in range(5):
        drawSquare(size, turtle)
        turtle.right(90)
        turtle.penup()
        turtle.forward(10)
        turtle.left(90)
        turtle.forward(-10)
        turtle.pendown()
        size += 20
wn = turtle.Screen()
wn.bgcolor("lightgreen")
steve = turtle.Turtle()
steve.color("pink")
steve.pensize(5)
drawSquares(20, steve)
wn.exitonclick()

#3
import turtle
def drawPolly(someTurtle, somesides,somesize):
    for i in range(somesides):
        someTurtle.forward(somesize)
        someTurtle.left(360/somesides)
wn = turtle.Screen()
wn.bgcolor("lightgreen")
tess = turtle.Turtle()
tess.color("magenta")
tess.pensize(3)

drawPolly(tess, 8, 50)
wn.exitonclick()

#4
import turtle
def drawSquare(turtle, size):
    for i in range(4):
        turtle.forward(size)
        turtle.left(90)

def drawSequence(turtle,size):
    for i in range(18):
        drawSquare(turtle,size)
        turtle.left(20)
wn = turtle.Screen()
wn.bgcolor("lightgreen")

steve = turtle.Turtle()
steve.color("blue")
steve.pensize(2)
steve.speed(0)

drawSequence(steve, 70)
wn.exitonclick()

#5
import turtle

def drawStraightSeq(turtle, size):
    turtle.right(90)
    for i in range(100):
        turtle.forward(size)
        turtle.right(90)
        size += 2
    
    
def drawSpiralSeq(turtle, size):
    turtle.right(90)
    for i in range(150):
        turtle.forward(size)
        turtle.right(91)
        size += 1
        
wn = turtle.Screen()
wn.bgcolor("lightgreen")
steve = turtle.Turtle()
steve.color("blue")
steve.speed(0)
drawSpiralSeq(steve, 5)
wn.exitonclick()

#8
import math
def areaOfCircle(r):
    area = math.pi * (r **2)
    return area

#13
def sumTo(n):
    n_sum = 0
    for i in range(n):
        n_sum += i+1
    return n_sum

#14
import math
def mySqrt(n):
    old_guess = n/2
    
    while old_guess != math.sqrt(n):
        new_guess = (1/2) * (old_guess + (n/old_guess))
        old_guess = new_guess
        
    return old_guess

#15
def myPi(iters):
    soma = 0
    for i in range(iters):
        soma += ((-1) ** (i)) / ((2 * (i)) + 1)
    approx_pi = soma * 4
    return approx_pi


# 7.10. Exercises https://runestone.academy/runestone/books/published/thinkcspy/Selection/Exercises.html

#3
def getGrade(grade):
    if grade < 60:
        mark = "F"
    elif grade < 70:
        mark = "D"
    elif grade < 80:
        mark = "C"
    elif grade < 90:
        mark = "B"
    else:
        mark = "A"
    return mark

#6
def findHypot(a,b):
    hypotenuse = (a**2 + b**2)**0.5
    return hypotenuse

#7
def is_even(n):
    is_even = False
    if n % 2 == 0:
        is_even = True
    return is_even

#8
def is_odd(n):
    is_odd = False
    if n%2 != 0:
        is_odd = True
    return is_odd

#9
def is_even(n):
    is_even = False
    if n % 2 == 0:
        is_even = True
    return is_even

def is_odd(n):
    if is_even(n):
        return False
    else:
        return True

#10
def is_rightangled(a, b, c):
    if abs((c**2) - (a**2 + b**2)) < 0.001:
        return True
    else:
        return False

#11
def is_rightangled(a, b, c):
    sides = [a, b, c]
    sides.sort()
    a = sides[0]
    b = sides[1]
    c = sides[2]
    if abs((c**2) - (a**2 + b**2)) < 0.001:
        return True
    else:
        return False

#12
def isLeap(year):
    isLeap = False
    if year%4 == 0:
        isLeap = True
    if year%100 == 0:
        isLeap = False
        if year % 400 == 0:
            isLeap = True
    return isLeap

#13
def dateEaster(year):
    special_years = [1954, 1981, 2049, 2076]
    
    if not(1900<=year<=2099):
        print("Year provided is out of range.")
    else:
        a = year % 19
        b = year % 4
        c = year % 7
        d = (19*a + 24) % 30
        e = (2*b + 4*c + 6*d + 5) % 7
        if year in special_years:
            dateofeaster = (22 + d + e) - 7
        else:
            dateofeaster = (22 + d + e)
            
        if dateofeaster > 31:
            print("April {}".format(dateofeaster-31))
        else:
            print("March {}".format(dateofeaster))


# 8.14. Exercises https://runestone.academy/runestone/books/published/thinkcspy/MoreAboutIteration/Exercises.html

#1
import math
def newtonSqrt(n):
    old_guess = n/2
    
    while old_guess != math.sqrt(n):
        new_guess = (1/2) * (old_guess + (n/old_guess))
        old_guess = new_guess
        
    return old_guess
print(newtonSqrt(25))


#2
def print_triangular_numbers(n):
    for i in range(n):
        triangular_number = ((i+1)*(i+2)) / 2
        print("{}{:10}".format(i+1, int(triangular_number)))
    
print_triangular_numbers(5)

#3
def is_prime(n):
    i = 2
    while n > i:
        if n % i == 0:
            return False
        i += 1
    return True
      
#9.22. Exercises https://runestone.academy/runestone/books/published/thinkcspy/Strings/Exercises.html

#2
names = list()
prefixes = "JKLMNOPQ"
suffix = "ack"

for prefix in prefixes:
    if prefix == "O" or prefix == "Q":
        names.append(prefix + "u" + suffix)
    else:    
        names.append(prefix + suffix)
    
names.sort()
for name in names:
    if name != "Quack":
        print(name, end=", ")
    else:
        print(name, end=".")

#3
def count(p):
    lows = "abcdefghijklmnopqrstuvwxyz"
    ups = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
    words = p.split()
    number_of_letters = 0
    number_of_e = 0
    
    for word in words:
        for letter in word:
            if letter in lows or letter in ups:
                number_of_letters += 1
                
                if letter == "e":
                    number_of_e += 1
                    
    print("Your text contains {} alphabetic characters, of which {} ({:.1f}) are 'e'.".format(number_of_letters, number_of_e, (number_of_e/number_of_letters)*100))

p = '''
"If the automobile had followed the same development cycle as the computer, a
Rolls-Royce would today cost $100, get a million miles per gallon, and explode
once a year, killing everyone inside."
-Robert Cringely
'''

count(p)

#4
def table(n):
    print("       ", end="")
    
    for i in range(n):
        print("{:3}".format(i+1), end=" | ")
    print()
    for i in range(int(n*6.5)):
        print("-", end="")
    print()

    for i in range(n):
        print("{:3}".format(i+1), end ="  | ")
        for f in range(n):
            print("{:3}".format((i+1) * (f+1)), end=" | ")
        print()
        for i in range(int(n*6.5)):
            print("-", end="")
        print()
              
            
table(12)

#5
def numDigits(n):
    integer_string = str(n)
    return len(integer_string)

#6
def reverse(astring):
    lst = list(astring)
    
    lst.reverse()
    string = ''
    for i in lst:
        string += i
    return string

#7
def mirror(mystr):
    lst = list(mystr)
    
    lst.reverse()
    string = ''
    for i in lst:
        string += i
    mirror = mystr + string
    return mirror

#8
def remove_letter(theLetter, theString):
    listtheString = list(theString)
    new_string = ''
    for letter in listtheString:
        if letter == theLetter:
            listtheString.remove(letter)
    for letter in listtheString:
        new_string += letter
    
    return new_string

#9
def is_palindrome(myStr):
    letters = list(myStr)
    letters_reverse = list(myStr)
    letters_reverse.reverse()
    if letters == letters_reverse:
        return True
    else:
        return False

#10
def count(substr,theStr):
    start = 0
    count = 0

    while True:
        start = theStr.find(substr, start)
        if start < 0:
            break

        start += len(substr)
        count += 1

    return count

#11
def remove(substr,theStr):
    if theStr.find(substr) == -1:
        return theStr
    else:
        new_string = theStr[:theStr.find(substr)] + theStr[theStr.find(substr) + len(substr):]
        return new_string

#12
def remove_all(substr,theStr):
    while True:
        if theStr.find(substr) == -1:
            break
        else:
            theStr = theStr[:theStr.find(substr)] + theStr[theStr.find(substr)+len(substr):]
    return theStr

#18
def encrypt(message, cipher):
    alphabet = "abcdefghijklmnopqrstuvwxyz"
    encrypted = ''
    for char in message:
        if char == ' ':
            encrypted += ' '
        else:
            pos = alphabet.index(char)
            encrypted += cipher[pos]
    return encrypted
       
#19

def decrypt(encrypted, cipher):
    alphabet = "abcdefghijklmnopqrstuvwxyz"
    decrypted = ''
    for char in encrypted:
        if char == ' ':
            decrypted += ' '
        else:
            pos = cipher.index(char)
            decrypted += alphabet[pos]
    return decrypted

#20
def remove_dups(astring):
    letters = list()
    new_string = ''
    for letter in astring:
        if letter not in letters:
            letters.append(letter)
    for letr in letters:
        new_string += letr
    return new_string
    
#21
def rot13(mess):
    alphabet = 'abcdefghijklmnopqrstuvwxyz'
    encrypted = ''
    for char in mess:
        if char == ' ':
            encrypted = encrypted + ' '
        else:
            rotated_index = alphabet.index(char) + 13
            if rotated_index < 26:
                encrypted = encrypted + alphabet[rotated_index]
            else:
                encrypted = encrypted + alphabet[rotated_index % 26]
    return encrypted

print(rot13('abcde'))
print(rot13('nopqr'))
print(rot13(rot13('since rot thirteen is symmetric you should see this message')))

#22
def checkout():
    total = 0
    count = 0
    moreItems = True
    while moreItems:
        price = float(input('Enter price of item (0 when done): '))
        if price != 0:
            count = count + 1
            total = total + price
            print('Subtotal: ${:.2f}'.format(total))
        else:
            moreItems = False
    average = total / count
    print('Total items:', count)
    print('Total ${:.2f}'.format(total))
    print('Average price per item: ${:.2f}'.format(average))

checkout()


# 10.31. Exercises https://runestone.academy/runestone/books/published/thinkcspy/Lists/Exercises.html

#2
myList = []
myList.append(76)
myList.append(92.3)
myList.append("hello")
myList = myList + [True]
myList = myList + [4]
myList = myList + [76]

#3
myList = [76, 92.3, 'hello', True, 4, 76]
myList.append("apple")
myList.append(76)
myList.insert(3, "cat")
myList.insert(0, 99)

print(myList.index("hello"))
print(myList.count(76))
myList.remove(76)
myList.pop(myList.index(True))

print(myList)

#4
def average(numlist):
    num_sum = 0
    for number in numlist:
        num_sum += number
    average = num_sum / len(numlist)
    return average

#5
def max(lst):
    max_num = lst[0]
    for num in lst:
        if num > max_num:
            max_num = num
    return max_num

#6
def sum_of_squares(xs):
    num_sum = 0
    for number in xs:
        num_sum += number**2
    return num_sum

#7
def countOdd(lst):
    count = 0
    for number in lst:
        if number%2 != 0:
            count +=1  
    return count

#8
def sumEven(lst):
    num_sum = 0
    for number in lst:
        if number%2 == 0:
            num_sum += number
    return num_sum

#9
def sumNegatives(lst):
    num_sum = 0
    for number in lst:
        if number < 0:
            num_sum += number
    return num_sum

#10
def countWords(lst):
    count = 0
    for word in lst:
        if len(word) == 5:
            count += 1
    return count

#11
def sumUntilEven(lst):
    num_sum = 0
    for number in lst:
        if number%2 == 0:
            break
        else:
            num_sum += number
    return num_sum

#12
def count(lst):
    count = 0
    for word in lst:
        count +=1
        if word == "sam":
            break
    return count

print(count(["hey", "wassup", "sam", "how", "the", "sam"]))

#13
def count(obj, lst):
    count = 0
    for elem in lst:
        if obj == elem:
            count += 1
    return count

def obj_in(obj, lst):
    for elem in lst:
        if obj == elem:
            return True
    return False

def reverse(lst):
    reverse_list = list()
    for elem in range(len(lst)-1,-1,-1):
        reverse_list.append(lst[elem])
    return reverse_list
        
def index(obj, lst):
    for ind,elem in enumerate(lst):
        if obj == elem:
            return ind
def insert(obj, ind, lst):
    lst = lst[:ind]+[obj]+lst[ind:]
    return lst

lst = [0, 1, 1, 2, 2, 3, 4, 5, 6, 7, 8, 9]
print(count(1, lst))
print(obj_in(4, lst))
print(reverse(lst))
print(index(2, lst))
print(insert('cat', 4, lst))

#14
def replace(s, old, new):
    words = s.split()
    for i,word in enumerate(words):
        start = 0
        while True:
            if word.find(old) == -1:
                break
            else:
                ind = word.find(old, start)
                word = word[:ind] + new + word[ind + len(old):]
                start += len(old)
        words.pop(i)
        words.insert(i, word)
    string = ''
    for word in words:
        if len(words) == 1:
            string += word
        else:
            string += word + ' '
    return string
    
print(replace('Mississippi', 'i', 'I'))
s = 'I love spom!  Spom is my favorite food.  Spom, spom, spom, yum!'
print(replace(s, 'om', 'am'))
print(replace(s, 'o', 'a'))

#17
import random

randlist = []
for i in range(100):
    randlist.append(random.randint(0, 1000))
print(randlist)

# 11.9. Exercises https://runestone.academy/runestone/books/published/thinkcspy/Files/Exercises.html

#1
f_handle = open("studentdata.txt", "r")
for line in f_handle:
    elements = line.split()
    if len(elements) > 7:
        print(elements[0])
f_handle.close()

#2
f_handle = open("studentdata.txt", "r")
for line in f_handle:
    sum_scores = 0
    elements = line.split()
    for element in elements[1:]:
        sum_scores += float(element)
    n_scores = len(elements[1:])
    average = sum_scores / n_scores
    print("{:10}{:4.1f}".format(elements[0], average))
    
f_handle.close()

#3
f_handle = open("studentdata.txt", "r")
for line in f_handle:
    elements = line.split()
    scores = []
    for element in elements[1:]:
        scores.append(int(element))
    max_score = max(scores)
    min_score = min(scores)
    print("Name: {:10}Max Score: {:<10}Min Score: {:<10}".format(elements[0], max_score, min_score))
    
f_handle.close()
