print("{:>3s}{:>8s}{:>10s}".format("n", "n²", "2**n"))
for n in range(20):
    print("{:3d}{:8d}{:10d}".format((n+1), (n+1)**2, 2**(n+1)))