import turtle
def square(t, side):
    for n in range(4):
        t.forward(side)
        t.left(90)


def spiral(t, start, end, incr):
    while True:
        t.forward(start)
        t.left(90)
        start += incr
        if start == end:	
            break

def main():
    print("This program opens a window with a graphical user interface.")
    wn = turtle.Screen()        
    alex = turtle.Turtle()      

    alex.forward(150)           
    alex.left(90)               
    alex.forward(75)            

    beth = turtle.Turtle()      
    beth.shape("turtle")       
    beth.color("blue")          
    beth.up()                   
    beth.goto(-200, 0)          
    beth.down()                 
    square(beth, 100)          

    alex.up()
    alex.goto(-200, -200)
    alex.setheading(0)
    alex.down()
    spiral(alex, 200, 0, -5)

    turtle.exitonclick()
    print("The window was closed. Bye!")

main()
