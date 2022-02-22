
# Defina as funções aqui...



def main():
    # Lista de pessoas com nome, peso em kg, altura em metro.
    people = [("John", 64.5, 1.757),
        ("Berta", 64.0, 1.612),
        ("Maria", 45.1, 1.715),
        ("Andy", 98.3, 1.81),
        ("Lisa", 46.8, 1.622),
        ("Kelly", 83.2, 1.78)]

    # Imprime os dados numa tabela com 4 colunas: nome, peso, altura e IMC.
    printTable(people)
    
    # Pede e devolve um valor, mas só aceita se estiver no intervalo certo.
   limit = inputBetween("altura limite? ", 1.1, 2.5)

    # Extrai uma lista de pessoas com altura superior a limit.
    tallpeople = selectTaller(people, limit)
    #print(tallpeople)
    
    # Mostra uma tabela só com as pessoas altas.
    printTable(tallpeople)


# O programa começa aqui
if __name__ == "__main__":
    main()




# CODE CHECK CODE 

# NMEC: 
# NOME: 

"""
A função main no programa imctable.py define uma lista com pesos e alturas de
várias pessoas e invoca diversas funções para processar e mostrar esses dados.
Defina as funções que faltam para que o programa funcione corretamente.
"""

# Defina as funções aqui...

"""
A função printTable deve imprimir uma tabela com 4 colunas:
nome, peso, altura e índice de massa corporal (IMC).
O IMC pode ser calculado por peso/altura².
As colunas numéricas devem aparecer ajustadas à direita e com um número fixo
de casas decimais, como no exemplo abaixo.

   Nome                 Peso Altura    IMC
   John                   64   1.76   20.9
   Berta                  64   1.61   24.6
"""
def printTable(lst):
   print("{:<20s}{:>8s}{:>8s}{:>8s}".format("Nome", "Peso", "Altura", "IMC"))
   for i in lst:
      imc = float(i[1] / (i[2])**2)
      print("{:20s}{:8}{:8.2f}{:8.1f}".format(i[0], round(i[1]), i[2], imc))
   print()

"""
A função inputBetween deve pedir e devolver um valor introduzido pelo utilizador,
mas apenas se estiver dentro dos limites indicados.
Senão, deve avisar e voltar a pedir o valor até que a condição se verifique.
"""
def inputBetween(prompt, minimo, maximo):
   
   while True:
      user_input = float(input(prompt))
      
      if minimo <= user_input <= maximo:
         return user_input
      
      else:
         print("Value must be in [{}, {}]! ".format(minimo, maximo))
         continue
   
"""
A função selectTaller deve devolver uma lista com os registos das pessoas
mais altas do que o limite dado.
"""
def selectTaller(people, limit):
   tall_people = []
   
   for person in people:
      if person[2] > limit:
         tall_people.append(person)
      else:
         continue
   
   return tall_people
   


def main():
   # Lista de pessoas com nome, peso em kg, altura em metro.
   people = [("John", 64.5, 1.757),
      ("Berta", 64.0, 1.612),
      ("Maria", 45.1, 1.715),
      ("Andy", 98.3, 1.81),
      ("Lisa", 46.8, 1.622),
      ("Kelly", 83.2, 1.78)]

   # Imprime os dados numa tabela com 4 colunas: nome, peso, altura e IMC.
   printTable(people)
   
   # Pede e devolve um valor, mas só aceita se estiver no intervalo certo.
   limit = inputBetween("altura limite? ", 1.1, 2.5)
   
   # Extrai uma lista de pessoas com altura superior a limit.
   tallpeople = selectTaller(people, limit)
   print(tallpeople)

   # Mostra uma tabela só com as pessoas altas.
   printTable(tallpeople)


# O programa começa aqui
if __name__ == "__main__":
   main()

