import java.awt.Color;
import java.awt.Point;

public class Circle extends Shape {
    protected int radius;

    public Circle(Turtle turtle, Point location, Color color, int border, int radius) {
        super(turtle, location, color, border);
        this.radius = radius;
    }

    @Override
    public void paint() {
        turtle.setColor(color);
        turtle.setPenWidth(border);
        turtle.penUp();
        turtle.goTo(location.x, location.y - radius);
        turtle.penDown();

        int steps = 100;
        double angle = 360.0 / steps;
        double length = 2 * Math.PI * radius / steps;

        for (int i = 0; i < steps; i++) {
            turtle.forward(length);
            turtle.turnRight(angle);
        }

        turtle.penUp();
    }
}