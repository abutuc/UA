# NMEC: 103530
# NOME: André Gabriel Butuc

def A(n,k):
    if k == 0:
        return 1
    elif 0 < k <= n:
        return n * A(n-1, k-1)

def main():
    assert(A(2,1) == 2)
    assert(A(5,2) == 20)
    assert(A(5,3) == 60)
    assert(A(10,3) == 720)
    print("It passed all tests!")

main()
