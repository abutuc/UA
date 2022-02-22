
# Define the function containsDoubles here,
# so that it passes all the tests below.
def containsDoubles(string):
    string_lower = string.lower()
    char_list = list(string_lower)
    for i in range(len(char_list)-1):
        if char_list[i] == char_list[i+1] :
            return True
    return False

# Test function
assert containsDoubles("pool") == True
assert containsDoubles("polo") == False
assert containsDoubles("erro") == True
assert containsDoubles("connosco") == True
assert containsDoubles("banana") == False

# Add a few more tests below
assert containsDoubles("aaaaaaaaa") == True
assert containsDoubles("AaAaAaAa") == True

# If the program reaches this point...
print("All tests passed!")


# This function should read lines from the given file
# and return a list of lines that contain doubles (consecutive repeated chars).
def findLinesWithDoubles(fname):
    f_handle = open(fname, "r")
    word_list = []
    for i in f_handle:
        if containsDoubles(i.strip()):
            word_list.append(i.strip())
    
    f_handle.close()
    return word_list

# Program:

# This should show a list of all English words with double letters.
lst = findLinesWithDoubles("wordlist.txt")
print(lst)

# You may download files with Portuguese words from:
# http://natura.di.uminho.pt/download/sources/Dictionaries/wordlists/LATEST/
# But you may need to open them with the argument: encoding="latin1".

