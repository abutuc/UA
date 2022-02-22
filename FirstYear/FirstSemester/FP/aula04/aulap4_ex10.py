def isPrime(n):
    if n == 1:
        return False
    i = 2
    while i < n:
        if n % i == 0:
            return False
        i += 1
    return True

def main():
    print("{:<5s}{:>10s}\n".format("Number","IsPrime"))
    for i in range(100):
        print("{:5d}{:>10s}\n".format(i+1, str(isPrime(i+1))))
main()