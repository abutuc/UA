def telToName(tel, telList, nameList):
    index = 0 
    isNumber = tel in telList
    if not isNumber:
        return tel
    else:
        for i in telList:
            if tel == i:
                index = telList.index(i)
                break
        return nameList[index]

def nameToTels(partName, telList, nameList):
    index_match = list()
    for i in nameList:
        if partName.lower() in i.lower():
            index_match.append(nameList.index(i))
        else:
            continue
    tels = list()
    for i in index_match:
        tels.append(telList[i])
    return tels

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