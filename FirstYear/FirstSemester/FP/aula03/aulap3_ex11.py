def max_div_comum(a, b):	
	r = a % b
	if r == 0:
		max_div = b		
		print(max_div)	
	elif r > 0:
		max_div_comum(b, r)
		
def main():
	max_div_comum(15, 24)
	
main()
