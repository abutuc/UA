def intersects(a1, b1, a2, b2):	
	assert a1<=b1
	assert a2<=b2
	intersect = True
	if a1 >= b2:
		intersect = False
	elif b1 <= a2:
		intersect = False
	return intersect 

def main():
	print(intersects(1,4,2,6))
		
main()