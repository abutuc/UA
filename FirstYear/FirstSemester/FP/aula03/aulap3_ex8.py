
def hms2sec(h, m, s):
	sec = (h * 60 * 60) + (m * 60) + s
	
	return sec


def main():
	print(hms2sec(1, 2, 3))
	
	
main()
