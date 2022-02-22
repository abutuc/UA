import math
catA = float(input("Cateto A: "))
catB = float(input("Cateto B: "))
hipotenusa = math.hypot(catA, catB)
angle = math.degrees(math.acos(catA/hipotenusa))
print("Hipotenusa: {}; Ângulo entre o cateto A e a hipotenusa: {:.2f}º".format(hipotenusa, angle))
