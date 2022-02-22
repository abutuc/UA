# Complete este programa como pedido no guião da aula.

def listContacts(dic):
    """Print the contents of the dictionary as a table, one item per row."""
    print("{:>12s} : {:^22s} : {:>}".format("Numero", "Nome", "Morada"))
    for num in dic:
        print("{:>12s} : {:^22s} : {:>}".format(num, dic[num][0], dic[num][1]))

def addContact(dic):
    name = input("Nome: ")
    morada = input("Morada: ")
    number = input("Número: ")
    dic[number] = (name, morada)

def removeContact(dic):
    number = input("Número para remover: ")
    dic.pop(number)

def findNumber(dic):
    number = input("Número para procurar: ")
    if number in dic:
        print("Nome: {}     Morada: {}".format(dic[number][0], dic[number][1]))
    else:
        print(number)
def filterPartName(contacts, partName):
    """Returns a new dict with the contacts whose names contain partName."""
    contacts_part = {}
    for key in contacts:
        if partName.lower() in contacts[key][0].lower():
            contacts_part[key] = (contacts[key][0], contacts[key][1])
    
    for key in contacts_part:
        print("{}, {} : {}".format(contacts_part[key][0], contacts_part[key][1], key))


def menu():
    """Shows the menu and gets user option."""
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
    """This is the main function containing the main loop."""

    # The list of contacts (it's actually a dictionary!):
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
            findNumber(contactos)
        elif op == 'P':
            partName = input("Parte do nome: ")
            filterPartName(contactos,partName)
        else:
            print("Não implementado!")
        #else:
            #print("Não implementado!")
    

# O programa começa aqui
main()