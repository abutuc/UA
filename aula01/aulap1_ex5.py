moradores = 4
pisos = 4
altura_piso = 3
elevador_percorre_p_d = 4
velocidade_elevador = 1
ano = 365
elevador_distancia_percorrida = 0
for i in range(moradores-1):
    elevador_distancia_percorrida += (i+1)*3*4*365

horas = elevador_distancia_percorrida / 3600
elevador_distancia_percorrida = elevador_distancia_percorrida / 1000
print("O elevador percorreu {}km e esteve em funcionamento {}h no espaço de um ano.".format(elevador_distancia_percorrida, horas))