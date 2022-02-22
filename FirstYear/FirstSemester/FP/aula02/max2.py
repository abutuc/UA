import string
from xmlrpc.client import boolean


x1 = float(input("number? "))
x2 = float(input("number? "))
mx = x1
if x2 > mx:
	mx = x2
print("Maximum:", mx)


Tipos de dados:
- int
- float
- string
- boolean

Dados Compostos:
list
tuple
dict
set
frozenset