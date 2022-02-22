import turtle

def drawing(file, turtle):
    f_handle = open(file, 'r')
    for line in f_handle:
        if line.strip() == "UP":
            turtle.penup()
        elif line.strip() == "DOWN":
            turtle.pendown()
        else:
            coords = line.strip().split(' ')
            turtle.goto(int(coords[0]), int(coords[1]))
    f_handle.close()

def main():
    wn = turtle.Screen()
    steve = turtle.Turtle()
    drawing("drawing.txt", steve)
    wn.exitonclick()

main()
