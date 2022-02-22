import turtle
t = turtle.Turtle()
f_handle = open("drawing.txt")

for line in f_handle:
    if len(line.split()) == 2:
        line_elements = line.split()
        x = float(line_elements[0])
        y = float(line_elements[1])
        t.goto(x, y)
    else:
        if line.strip() == "UP":
            t.up()
        if line.strip() == "DOWN":
            t.down()
            
f_handle.close()
turtle.Screen().exitonclick()