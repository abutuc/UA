def ispalindrome(s):
    reversed_s = s[::-1]
    ispalindrome = False
    if s == reversed_s:
        ispalindrome = True
    return ispalindrome

def main():
    print(ispalindrome("ana"))
    print(ispalindrome("anan"))

main()