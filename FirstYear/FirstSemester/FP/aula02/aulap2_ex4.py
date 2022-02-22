liters = float(input("Liters of fuel: "))
if liters < 0:
	print("ERROR: Invalid input.")
	exit(1)
total_price = liters * 1.40
if liters > 40:
	total_price -= (total_price*0.1)
print("Price to pay: {0:.2f}€".format(total_price))
