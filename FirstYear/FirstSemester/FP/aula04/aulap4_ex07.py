def sequence_sum():
    n = 0
    n_sum = 0
    sequence = list()
    while True:
        num = input("Termo {0} = ".format(n+1)) 
        if num == '':
            media = n_sum / n
            return media, sequence
        else:
            num = float(num)
            sequence.append(num)
            n_sum += num
            n += 1
        
def main():
    print("Este programa calcula a média de uma sequência de n termos.\n")
    print("Para terminar a sequência pressione ENTER. \n")
    media, sequencia = sequence_sum()
    print("A média dos termos da sequência {0} é igual a {1}".format(sequencia, media))
  
main()
print("Fim do programa")