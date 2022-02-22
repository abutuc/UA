def isSubList(sub, lst):
    for i in range(len(lst)):
        if lst[i:(i+ len(sub))] == sub:
            value = True
            break
        else:
            value = False
            continue
    return value




print(isSubList([1,2,4], [3,1,2,4,7]))
print(isSubList([1,2,4,7,2,1], [3,1,2,4,7]))
print(isSubList([2,1], [3,1,2,4,7]))
print(isSubList([3,1,2,4,7], [3,1,2,4,7]))