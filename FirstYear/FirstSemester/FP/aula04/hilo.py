import random
def main():
    secret = random.randrange(1, 101);
    print("Can you guess my secret?")
    nguesses = 0
    while True:
        guess = int(input("Guess: "))
        nguesses += 1
        if guess > secret:
            print("Guess too high.")
        
        elif guess < secret:
            print("Guess too low.")
        
        else:
            print("You guessed it right! Attempts: {0}".format(nguesses))
            break
main()