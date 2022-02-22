def fileSum(file):
    f_handle = open(file, 'r')
    n_sum = 0
    for line in f_handle:
        line = line.strip()
        n_sum += float(line)
    f_hanlde.close()
    return n_sum 

def main():
    n_file = input("File: ")
    n_sum = fileSum(n_file)
    print(n_sum)

main()