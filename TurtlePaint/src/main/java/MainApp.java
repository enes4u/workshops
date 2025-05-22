import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

public class MainApp {
    private static Scanner scanner = new Scanner(System.in);
    private static ArrayList<Shape> shapes = new ArrayList<>();

    public static void main(String[] args)  {
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

        while (true) {
            System.out.println("\nHome Screen");
            System.out.println("1) Add Shape");
            System.out.println("2) Save Image (Not Implemented)");
            System.out.println("0) Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // clear buffer

            switch (choice) {
                case 1:
                    addShape(turtle);
                    break;
                case 2:
                    System.out.println("Save Image - Feature not implemented yet.");
                    break;
                case 0:
                    System.out.println("Exiting...");
                    return;
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
