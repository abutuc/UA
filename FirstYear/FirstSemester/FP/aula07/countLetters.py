import sys

def countLetters(file):
    f_handle = open(file, 'r')
    letters_dict = {}
    for line in f_handle:
        line = line.lower()
        for char in list(line):
            if char.isalpha():
                if char in letters_dict:
                    letters_dict[char] += 1
                else:
                    letters_dict[char] = 1
    f_handle.close()
    return letters_dict

def main():
    file_name = str(sys.argv[1])
    letters_dict = countLetters(file_name)
    tuple_list = list()
    for key in letters_dict:
        tuple_list.append((key,letters_dict[key]))
        
    tuple_list.sort()
    for tup in tuple_list:
        print(tup[0], tup[1])

main()