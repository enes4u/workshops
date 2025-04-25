import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class MainApp {
    public static void main(String[] args) {
        ArrayList<Product> items = getItems();
        ArrayList<Product> cart_items = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("---Welcome to our Online Store---");

        boolean run1 = true;
        while (run1){
            System.out.println("Choose option from the next menu: ");
            System.out.println("1.Display Products");
            System.out.println("2.Display Cart");
            System.out.println("3.Exit - closes out of the application");
            System.out.print("Enter your choice (1-3): ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    //display products
                    viewAllItems(items, cart_items, scanner);
                    System.out.print("Continue to menu (Hit Enter): ");
                    scanner.nextLine();
                    break;

                case "2":
                    // display cart
                    displayCart(cart_items);
                    System.out.print("Continue to menu (Hit Enter): ");
                    scanner.nextLine();
                    break;

                case "3":
                    System.out.println("Thank you for shopping with us!");
                    System.exit(0); // if we use while loop put false condition right here
                default:
                    System.out.println("invalid choice, try again!");
                    break;
            }
        }

        scanner.close();

    }

    public static ArrayList<Product> getItems() {
        ArrayList<Product> items = new ArrayList<Product>();

        try {
            BufferedReader bufReader = new BufferedReader(new FileReader("src/main/resources/products.csv"));
//            String line;
            String line = bufReader.readLine();//skip header line

            while ((line = bufReader.readLine()) != null) {
                String[] split_part = line.split(Pattern.quote("|"));


                items.add(new Product(split_part[0], split_part[1], Double.parseDouble(split_part[2]), split_part[3]));
            }
        } catch (IOException e) {
            e.printStackTrace();

        }
        return items;

    }

    public static ArrayList<Product> addToCart(ArrayList<Product> items, ArrayList<Product> cart_items,
                                                Scanner scanner) {
//        ArrayList<Products> cart_items = new ArrayList<Products>();

        System.out.print("Enter name of item to add to your cart: ");
        String item_name = scanner.nextLine().toLowerCase();
        Product selected = null;
//        if (products.getName().toLowerCase().contains(keyword)) {
//            System.out.printf("SKU: %s Product Name: %s Price: $%.2f Department: %s \n", product.getSku(),
//                    product.getName(), product.getPrice(), product.getDepartment());

        for (Product products : items) {
            if (products.getName().toLowerCase().contains(item_name)) {
                selected = products;
                break;
            }
        }
        if (selected != null) {
            cart_items.add(selected);
        }


        return cart_items;
    }

    public static ArrayList<Product> removeFromCart(ArrayList<Product> cart_items, Scanner scanner) {
        System.out.print("Enter name of item to remove from your cart: ");
        String item_name = scanner.nextLine();
        Product selected = null;
        boolean remove = false;

        for (int i = 0; i < cart_items.size(); i++) {
            if (cart_items.get(i).getName().equalsIgnoreCase(item_name)) {
                cart_items.remove(i);
                remove = true;
                break;
            }
        }
        if (remove) {
            System.out.println("Product is removed from cart");
        } else {
            System.out.println("Product is not found");
        }


        return cart_items;
    }

    public static void displayCart(ArrayList<Product> cart_items) {
        if (cart_items.isEmpty()) {
            System.out.println("Your cart is empty");
            return;
            //might change to break;

        }
        //either we can put for loop and list everything
        double total = 0;

        for (Product products : cart_items) {
            total += products.getPrice();
            System.out.printf("SKU: %s Product Name: %s Price: $%.2f Department: %s \n", products.getSku(),
                    products.getName(), products.getPrice(), products.getDepartment());
        }
        System.out.println("Your total is: " + total);
    }

    public static void viewAllItems(ArrayList<Product> items, ArrayList<Product> cart_items,
                                    Scanner scanner) {
        for (Product products : items) {
            System.out.printf("SKU: %s Product Name: %s Price: $%.2f Department: %s \n", products.getSku(),
                    products.getName(), products.getPrice(), products.getDepartment());
        }
        boolean run = true;

        while (run) {
            System.out.println("Choose from next option");
            System.out.println("1.Search");
            System.out.println("2.Add");
            System.out.println("3.Go back");
            System.out.print("Enter your choice(1-3): ");
            int choice2 = scanner.nextInt();
            scanner.nextLine();

            switch (choice2) {
                case 1:
                    System.out.print("Enter Product name to find a product: ");
                    String keyword = scanner.nextLine().toLowerCase();

                    boolean found = false;

                    for (Product product : items) {
                        if (product.getName().toLowerCase().contains(keyword)) {
                            System.out.printf("SKU: %s Product Name: %s Price: $%.2f Department: %s \n", product.getSku(),
                                    product.getName(), product.getPrice(), product.getDepartment());
                            found = true;
                        }

                    }
                    if (!found) {
                        System.out.println("Product is not found");
                    }
                    break;
                case 2:
                    cart_items = addToCart(items, cart_items, scanner);

                    break;

                case 3:
                    System.out.println("Returning to the main menu");
                    run = false;
                    break;

            }
        }

    }
}