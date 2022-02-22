def countdown(N):
	if N > 0:
		print(N, end=" ")	
	if N == 0:
		print(0)
		return				
	countdown(N-1)	
def main():
	countdown(10)	
main()
