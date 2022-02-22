string = input()
numbers = string.split(',')
divisible = []
for number in numbers:
    if int(number) % 5 == 0:
        divisible.append(number)
print(','.join(divisible))