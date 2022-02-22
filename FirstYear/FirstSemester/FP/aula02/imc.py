print("Índice de Massa Corporal")
# Variáveis
altura = float(input("Altura (m)? "))
peso = float(input("Peso (kg)? "))
# Validação dos dados
if altura < 0 or peso < 0:
    print("Dado(s) introduzido(s) inválido(s).")
    exit(1)
#Calcular imc
imc = peso / altura**2
print("IMC:", imc, "kg/m2")
# Determinar a categoria de IMC:
if imc < 18.5:
	categoria = "Magro"	
elif imc < 25:
    categoria = "Saudável"  
elif imc < 30:
	categoria = "Forte"
else:
    categoria = "Obeso"
print("Categoria:", categoria)
