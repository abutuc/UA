def shorten(string):
    words = string.split(' ')
    short = []
    for word in words:
        if word[0].isupper():
            short.append(word[0])
    short_s = ''.join(short)
    return short_s

def main():
    print(shorten("Universidade de Aveiro"))
    print(shorten("United Nations Organization"))

main()