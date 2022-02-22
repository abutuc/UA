def compareFiles(file1, file2):
    file1_handle = open(file1, 'rb')

    file2_handle = open(file2, 'rb')

    count = 0

    for line in file1_handle:
        if line == file2_handle[count]:
            count += 1
            continue
        
        else:
            file1_handle.close()
            file2_handle.close()
            return "Not equal"

    return "They are equal."




def main():

    compareFiles("thisfile1", "thisfile2")



main()