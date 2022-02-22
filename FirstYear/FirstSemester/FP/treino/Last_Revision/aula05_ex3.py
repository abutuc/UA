def telToName(tel, telList, nameList):
    if tel not in telList:
        return tel
    else:
        for i, number in enumerate(telList):
            if number == tel:
                return nameList[i]

def nameToTels(string, telList, nameList):
    correspondence = []
    for i, name in enumerate(nameList):
        if string.lower() in name.lower():
            correspondence.append(telList[i])
    return correspondence

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