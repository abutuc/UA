string = input()
lst = string.split(" ")
lst1 = []
for word in lst:
    if word in lst1:
        continue
    else:
        lst1.append(word)
lst1.sort()
print(' '.join(lst1))