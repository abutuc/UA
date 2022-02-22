
def sec2hms(sec):
	h = sec // 3600
	
	resto = sec % 3600
	
	m = resto // 60 
	
	s = resto % 60
	
	return h, m, s


def main():
	print(sec2hms(3723))

main()
