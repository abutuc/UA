import math

def floatInput(prompt, min=-math.inf, max=math.inf):
    trigger = False
    while not trigger:
        num = input(prompt)
        try:
            conversion = float(num)
        except ValueError:
            print("Not a float!")
            continue    
        else:
            if min <= conversion <= max:    
                print(conversion)
                trigger = True       
            else:
                print("Value should be in [{}, {}]!".format(min, max))

def main():
    user_prompt = input("Prompt = ")
    user_min = input("Min (optional):")
    user_max = input("Max (optional):")
    if user_min == "" and user_max=="":
        floatInput(user_prompt)
    elif user_min == "":
        floatInput(user_prompt, max = float(user_max))
    elif user_max == "":
        floatInput(user_prompt, min = float(user_min))
    else:
        floatInput(user_prompt, min = float(user_min), max = float(user_max))

main()