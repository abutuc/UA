def bodyMassIndex(height, weight):
    bmi = weight/ (height**2)
    return bmi

def bmiCategory(imc):
	if imc < 18.5:
		categoria = "Underweight"	
	elif imc < 25:
		categoria = "Normal weight"
	elif imc < 30:
		categoria = "Overweight"
	else:
		categoria = "Obesity"
	return categoria
	
# This is the main function
def main():
    print("Índice de Massa Corporal")
    altura = float(input("Altura (m)? "))
    if altura < 0:
		print("ERRO: altura inválida!")
		exit(1)
    peso = float(input("Peso (kg)? "))
	if peso < 0:
		print("ERRO: peso inválido!")
		exit(1)
    imc = bodyMassIndex(altura, peso)
    cat = bmiCategory(imc)
    print("BMI:", imc, "kg/m2")
    print("BMI category:", cat)
# Program starts executing here
main()

