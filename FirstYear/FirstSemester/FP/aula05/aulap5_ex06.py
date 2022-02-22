def shorten(string):
    capital_letters = list()
    abreviatura = ""
    for i in string:
        if i.isupper():
            capital_letters.append(i)
    for f in capital_letters:
        abreviatura += f 
    return abreviatura

def main():
    print(shorten("Universidade de Aveiro"))
    print(shorten("United Nations Organization"))

main()