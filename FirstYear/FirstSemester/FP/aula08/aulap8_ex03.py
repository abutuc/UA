def names(file):
    f_handle = open(file, "r")
    dic = {}
    for line in f_handle:
        if len(line) > 5:
            words = line.strip().split(' ')
            dic.setdefault(words[-1], set())
            dic[words[-1]].add(words[0])
    f_handle.close()
    return dic
def main():
    f_name = "names.txt"
    dic = names(f_name)
    for key, value in dic.items():
        print("{:14s}{}".format(str(key), str(value)))

main()