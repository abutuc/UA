segundos = int(input("Tempo em segundos: "))

minutos = segundos // 60 
segundos_resto = segundos % 60

horas = minutos // 60
minutos_resto = minutos % 60

print("{:02d}:{:02d}:{:02d}".format(horas, minutos_resto, segundos_resto))
