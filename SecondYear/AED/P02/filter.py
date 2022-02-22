fhandle_read = open("horowitz_data.txt", 'r')
fhandle_write = open("horowitz_data_v2.txt", 'w')
temp_string=""
count=0
for line in fhandle_read:
    temp_string+=line.strip("\n") + " "
    count+=1
    if (count % 2 == 0):
        temp_string+="\n"
        fhandle_write.write(temp_string)
        temp_string=""

fhandle_write.close()
fhandle_read.close()
    