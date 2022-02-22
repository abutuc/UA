def input_validation(prompt, mn, mx):
    while True:
        try:
            num = float(input(prompt))
        except:
            print("Not a float!")
            continue
        if  mn<=num<=mx:
            return num
        else:
            print("Value should be in [{}, {}]!".format(mn,mx))
        
def main():
    print(input_validation("val= ", mn=1.3, mx=2.1))

main()