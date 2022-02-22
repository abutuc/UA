def string_2_list_tuple(string):
    lst = string.split(",")
    tup = tuple(lst)
    return lst, tup

def main():
    string = input("Sequence: ")
    lst, tup = string_2_list_tuple(string)
    print(lst)
    print(tup)

main()