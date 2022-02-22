import bisect

def search(lst):
    f_index_ea = bisect.bisect_left(lst, 'ea')
    f_index_eb = bisect.bisect_left(lst, 'eb')

    f_index_tb = bisect.bisect_left(lst, 'tb')
    f_index_tc = bisect.bisect_left(lst, 'tc')

    return (f_index_eb - f_index_ea, f_index_tc - f_index_tb, f_index_tb)

def main():
    f_handle = open("wordlist.txt", "r")
    e = []
    for line in f_handle:
        e.append(line.strip())
    n_ea, n_tb, index_tb = search(e)
    print("{} palavras começam por 'ea'.".format(n_ea))
    print("{} palavras começam por 'tb'.".format(n_tb))
    print("{}".format(e[index_tb][1]))
    
    
main()