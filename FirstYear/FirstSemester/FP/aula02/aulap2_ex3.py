number = int(input("Number: "))
type_number = "odd"
if (number % 2) == 0:
	type_number = "even"
print("{} is {}".format(number, type_number))
