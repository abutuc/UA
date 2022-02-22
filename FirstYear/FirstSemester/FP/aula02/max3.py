x1 = float(input("number? "))	# 3
x2 = float(input("number? "))	# 4
x3 = float(input("number? "))	# 6
mx = x1	#3

if x2 > mx:
	mx = x2		# mx = 4;
if x3 > mx:
	mx = x3

print("Maximum:", mx)