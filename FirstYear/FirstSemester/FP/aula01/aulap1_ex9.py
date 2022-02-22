hora_i = 6*3600 + 52*60
v1 = 10
v2 = 6
tempo_caminhado = (v1 + 3*v2 + 4*v1)*60
hora_f = (hora_i + tempo_caminhado) // 3600
minuto_f = ((hora_i + tempo_caminhado) % 3600) // 60
print("Horas: {:02d}:{:02d}h".format(hora_f,minuto_f))