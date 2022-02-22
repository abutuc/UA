print("Kryptonite phase classifier")
# Variáveis
T = float(input("Temperature (K)? "))
P = float(input("Pressure (kPa)? "))
# Phase
if (T > 400 and P > 50):
	phase = "Liquid"	
elif P < 0.125 * T:
	phase = "Gas"
else:
	phase = "Solid"	
print("At {:.1f} K and {:.3f} kPa, Kryptonite is in the {} phase.".format(T, P, phase))