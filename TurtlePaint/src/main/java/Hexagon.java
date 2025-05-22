import java.awt.Color;
import java.awt.Point;

public class Hexagon extends Shape {
    private int side;

    public Hexagon(Turtle turtle, Point location, Color color, int border, int side) {
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

        for (int i = 0; i < 6; i++) {
            turtle.forward(side);
            turtle.turnRight(120);
        }

        turtle.penUp();
    }
}
