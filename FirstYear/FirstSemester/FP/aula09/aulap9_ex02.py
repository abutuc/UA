import sys

def countLetters(file):
    f_handle = open(file, 'r')
    letters_dict = {}
    for line in f_handle:
        line = line.lower()
        for char in list(line):
            if char.isalpha():
                letters_dict.setdefault(char, 0)
                letters_dict[char] += 1
    f_handle.close()
    return letters_dict

def main():
    file_name = str(sys.argv[1])
    letters_dict = countLetters(file_name)
    tuple_list = list()
    for key in letters_dict:
        tuple_list.append((key,letters_dict[key]))
        
    tuple_list_sorted = sorted(tuple_list, key=lambda tup: tup[1], reverse=True)
    for tup in tuple_list_sorted:
        print(tup[0], tup[1])

main()