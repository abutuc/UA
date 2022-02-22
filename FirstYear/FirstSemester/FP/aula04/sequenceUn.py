Un = 100                    
number_shown = 0
while True:
    if Un < 0:
        break
    print(Un)
    number_shown +=1
    Un = 1.01*Un - 1.01
print("Number of printed terms: {}".format(number_shown))