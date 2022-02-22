def factorial(n):
    assert isinstance(n, int)
    assert n >= 0
    factorial = 1
    for i in range(n):
        factorial *= i + 1
    return factorial

def main():
    while True:
        n = input("x! , input a value for x (input p to end the program),  x= ")
        if n.lower() == "p":
            break
        print(factorial(int(n)))
    print("End of the program.")
main()