def inputFloatlist():
    user_answer = 0
    float_list = []
    while user_answer != '':
        user_answer = input("Number: ")
        if user_answer.isdigit():
            float_list.append(float(user_answer))
    return float_list

def countLower(lst, v):
    count = 0
    for number in lst:
        if number < v:
            count += 1
    return count

def minmax(lst):
    mn = lst[0]
    mx = lst[0]
    for number in lst:
        if number > mx:
            mx = number
        if number < mn:
            mn = number
    return mn, mx

def main():
    num_list = inputFloatlist()
    mn, mx = minmax(num_list)
    v_medio = (mx + mn)/2
    count_lower = countLower(num_list,v_medio)
    print(count_lower)

main()