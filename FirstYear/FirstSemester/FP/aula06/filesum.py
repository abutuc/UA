from tkinter import filedialog
def main():
    name = filedialog.askopenfilename(title="Choose File") 
    total = fileSum(name)
    print("Sum:", total)

def fileSum(filename):
    f_handle = open(filename)
    sum = 0
    for i in f_handle:
        sum += float(i)
    f_handle.close()
    return sum
if __name__ == "__main__":
    main()