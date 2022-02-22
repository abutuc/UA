def primesUpTo(n):
    conjunto = set(range(2, n+1))
    m = 2
    while m**2 < n+1:
        if m in conjunto:
            mn = set(range(m**2, n+1, m))
            conjunto = conjunto -  mn
        m += 1
    return conjunto

# Testing:
s = primesUpTo(1000)
print(s)
# Do some checks:
assert primesUpTo(30) == {2,3,5,7,11,13,17,19,23,29}
assert len(primesUpTo(1000)) == 168
assert len(primesUpTo(7918)) == 999
assert len(primesUpTo(7919)) == 1000
print("All tests passed!")