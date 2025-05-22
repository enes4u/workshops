import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class MainApp {
    private static Scanner scanner = new Scanner(System.in);
    private static ArrayList<Shape> shapes = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {
        // This starter code to get you familiar with how
        // the TurtleLogo application works

       /*// The world is your canvas
        World world = new World(200, 200);
        Turtle turtle = new Turtle(world,-100, -100);
        
        int width = 200;
        int height = 180;

        // calculate the hypotenuse (diagonal)
        // a2 + b2 = c2
        double widthSquared = Math.pow(width, 2);
        double heightSquared = Math.pow(height, 2);
        double hypotenuse = Math.sqrt(widthSquared + heightSquared);


        turtle.setPenWidth(10);
        turtle.setColor(Color.BLUE);

        turtle.turnRight(45);
        turtle.forward(hypotenuse);

        turtle.penUp();
        turtle.goTo(100, 100);
        turtle.turnRight(90);

        turtle.penDown();
        turtle.forward(hypotenuse);*/


        System.out.print("Enter canvas width: ");
        int width = scanner.nextInt();
        System.out.print("Enter canvas height: ");
        int height = scanner.nextInt();

        World world = new World(width, height);
        Turtle turtle = new Turtle(world, 0, 0);
    boolean run = true;
        while (run) {
            System.out.println("\nHome Screen");
            System.out.println("1) Add Shape");
            System.out.println("2) Save Image (Implemented)");
            System.out.println("0) Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // clear buffer

            switch (choice) {
                case 1:
                    addShape(turtle);
                    break;
                case 2:
                    savePainting();
                    System.out.println("Save Image - Feature already implemented.");
                    break;
                case 0:
                    for (int i = 3; i > 0; i--) {
                        Thread.sleep(1000); // Sleep for 1 second
                        System.out.print(i + ".. ");}

                    System.out.println("Exiting...");
                    run = false;
                    System.exit(0);
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private static void addShape(Turtle turtle) {
        System.out.println("Select Shape:");
        System.out.println("1. Square\n2. Circle\n3. Triangle");
        int shapeType = scanner.nextInt();

        System.out.print("Enter border width: ");
        int border = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter border color (e.g., red, green, blue): ");
        String colorStr = scanner.nextLine().toLowerCase();
        Color color = getColorFromString(colorStr);

        System.out.print("Enter X coordinate: ");
        int x = scanner.nextInt();
        System.out.print("Enter Y coordinate: ");
        int y = scanner.nextInt();

        Point location = new Point(x, y);

        Shape shape = null;
        switch (shapeType) {
            case 1:
                System.out.print("Enter side length: ");
                int squareSide = scanner.nextInt();
                shape = new Square(turtle, location, color, border, squareSide);
                break;
            case 2:
                System.out.print("Enter radius: ");
                int radius = scanner.nextInt();
                shape = new Circle(turtle, location, color, border, radius);
                break;
            case 3:
                System.out.print("Enter side length: ");
                int triSide = scanner.nextInt();
                shape = new Triangle(turtle, location, color, border, triSide);
                break;
            default:
                System.out.println("Invalid shape type.");
                return;
        }

        shapes.add(shape);
        shape.paint();
    }

    private static void savePainting() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("painting.csv"))) {
            // First line: canvas info (default to 500x500 white background for now)
            writer.println("500|500|white");

            for (Shape shape : shapes) {
                if (shape instanceof Square) {
                    Square s = (Square) shape;
                    writer.printf("square|%d|%d|%d|%s|%d|%d\n",
                            s.location.x, s.location.y, s.border, colorToString(s.color), s.side, 0);
                } else if (shape instanceof Circle) {
                    Circle c = (Circle) shape;
                    writer.printf("circle|%d|%d|%d|%s|%d|0\n",
                            c.location.x, c.location.y, c.border, colorToString(c.color), c.radius);
                } else if (shape instanceof Triangle) {
                    Triangle t = (Triangle) shape;
                    writer.printf("triangle|%d|%d|%d|%s|%d|0\n",
                            t.location.x, t.location.y, t.border, colorToString(t.color), t.side);
                } else if (shape instanceof Hexagon) {
                    Hexagon h = (Hexagon) shape;
                    writer.printf("triangle|%d|%d|%d|%s|%d|0\n",
                            h.location.x, h.location.y, h.border, colorToString(h.color), h.side);
                }
            }

            System.out.println("Painting saved to painting.csv.");
        } catch (IOException e) {
            System.out.println("Failed to save painting: " + e.getMessage());
        }
    }

    private static String colorToString(Color color) {
        if (color.equals(Color.RED)) return "red";
        if (color.equals(Color.GREEN)) return "green";
        if (color.equals(Color.BLUE)) return "blue";
        if (color.equals(Color.BLACK)) return "black";
        if (color.equals(Color.YELLOW)) return "yellow";
        return "gray";
    }



    private static Color getColorFromString(String colorStr) {
        switch (colorStr) {
            case "red": return Color.RED;
            case "green": return Color.GREEN;
            case "blue": return Color.BLUE;
            case "black": return Color.BLACK;
            case "yellow": return Color.YELLOW;
            default: return Color.GRAY;
        }



    }
}
