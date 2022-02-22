def countDigits(string):
    chars = list(string)
    count = 0
    for char in chars:
        if char.isdigit():
            count += 1
    return count

def main():
    print(countDigits("23 mil 456"))

main()
