import bisect

def search(e, prefix):
    f_index = bisect.bisect_right(e, prefix)
    while e[f_index][:len(prefix)] == prefix:
         
    print(f_index)
    print(l_index)
    letters = []
    for word in e[f_index:l_index]:
        letters.append(word[len(prefix)])
    return letters


def main():
    f_handle = open("wordlist.txt", "r")
    e = []
    for line in f_handle:
        e.append(line.strip())

    print(search(e, "spr"))
    f_handle.close()
main()