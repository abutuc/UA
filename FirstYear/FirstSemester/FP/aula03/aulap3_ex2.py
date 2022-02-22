def polinomio(x):	
	resultado = (x ** 2) + (2 * x) + 3	
	return resultado

def result_print(x):
	print("p({}) = {}".format(x, polinomio(x)))
	
def main():
	result_print(0)
	result_print(1)
	result_print(2)
	print("p(p(1)) = {}".format(polinomio(polinomio(1))))

main()
