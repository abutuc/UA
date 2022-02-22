def max2(x1,x2):
	maior = x1
	if x2 > maior:
		maior = x2
	return maior

def max3(x1, x2, x3):
	return max2(max2(x1,x2), x3)
		
def main():
	print(max3(4,7,2))
	print(max3(500, -2, -1))

main()
