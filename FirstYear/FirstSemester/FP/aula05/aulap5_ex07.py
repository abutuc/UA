def ispalindrome(s):
    inverted_s = s[::-1]
    answer = ''
    if inverted_s == s:
        answer = "is a palindrome" 
    else:
        answer = "is not a palindrome"
    return answer
def main():
    s = input("Insert string you want to evaluate: ")
    print("{0} {1}".format(s, ispalindrome(s)))

main()