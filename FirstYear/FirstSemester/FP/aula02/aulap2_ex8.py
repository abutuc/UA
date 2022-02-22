CTP = float(input("CTP : "))
CP = float(input("CP : "))
if not(0<=CTP<=20) or not(0<=CP<=20):
	print("Invalid input. Please enter values between [0, 20]")
	exit(1)
if CTP < 6.5 or CP < 6.5:
	nota_final = 66 
else: 
	nota_final = (0.3 *  CTP) + (0.7 * CP)
	if nota_final < 10:
		ATPR = float(input("ATPR: "))
		APR = float(input("APR: "))
		nota_final = (0.3 * ATPR) + (0.7 * APR)
		
print("Nota final: {:.2f}".format(nota_final))
