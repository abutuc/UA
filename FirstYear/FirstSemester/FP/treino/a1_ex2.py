def cypher(string, chave):
    original = list("ABCDEFGHIJKLMNOPQRSTUVWXYZ")
    chave = list(chave)
    crypted = ''
    for char in string:
        i = original.index(char.upper())
        crypted += chave[i]
    return crypted

def decypher(string, chave):
    original = list("ABCDEFGHIJKLMNOPQRSTUVWXYZ")
    chave = list(chave)
    decrypted = ''
    for char in string:
        i = chave.index(char.upper())
        decrypted += original[i]
    return decrypted

def main():
    chave = input("Chave: ")
    operation = input("Operation ('c' for 'cypher', 'd' for 'decypher' and 'l' to 'quit the program'): ")
    if operation.lower() == 'c':
        string = input("String to cypher: ")
        print(cypher(string, chave))
    elif operation.lower() == "d":
        string = input("String to decypher: ")
        print(decypher(string, chave))
    elif operation.lower() == "l":
        print("Goodbye.")
        exit(1)
    else:
        print("Enter a valid option.")
        exit(1)
main()