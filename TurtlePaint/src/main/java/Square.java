import java.awt.Color;
import java.awt.Point;

public class Square extends Shape {
    protected int side;

    public Square(Turtle turtle, Point location, Color color, int border, int side) {
        super(turtle, location, color, border);
        this.side = side;
    }

    @Override
    public void paint() {
        turtle.setColor(color);
        turtle.setPenWidth(border);
        turtle.penUp();
        turtle.goTo(location.x, location.y);
        turtle.penDown();

        for (int i = 0; i < 4; i++) {
            turtle.forward(side);
            turtle.turnRight(90);
        }

        turtle.penUp();
    }
}
