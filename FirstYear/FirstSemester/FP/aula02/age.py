age = int(input("Age? "))
if age > 0:
	print("Age:", age)
else:
	print("Invalid input")
	exit(1)
if age < 13 :
    cat = "child"
elif age < 20:
	cat = "teenager"
else:
	cat = "adult"
print("Category:", cat)