package com.pluralsight;

import java.util.Scanner;

public class NeighborhoodLibrary {
    public static void main(String[] args) {
        Book[] inventory = new Book[20];
        inventory[0] = new Book(1, "978-3-16-148410-0", "To Kill a Mockingbird", false, null);
        inventory[1] = new Book(2, "978-1-86197-876-9", "1984",false, null);
        inventory[2] = new Book(3, "978-0-7432-7356-5", "The Great Gatsby", false, null);
        inventory[3] = new Book(4, "978-1-5011-8747-2", "Where the Crawdads Sing", false, null);
        inventory[4] = new Book(5, "978-0-14-028333-4", "Pride and Prejudice", false, null);
        inventory[5] = new Book(6, "978-0-316-76948-6", "The Catcher in the Rye", false, null);
        inventory[6] = new Book(7, "978-0-451-53005-8", "Fahrenheit 451", false, null);
        inventory[7] = new Book(8, "978-0-670-81302-8", "Three Daughters of Eve", false, null);
        inventory[8] = new Book(9, "978-0-399-13517-2", "The Road", false, null);
        inventory[9] = new Book(10, "978-1-5011-2631-0", "Before We Were Strangers", false, null);

        Scanner libClerk = new Scanner(System.in);
        boolean running = true;
        while (running) {
            System.out.println("\n Neighborhood Library Inventory System: ");
            System.out.println(" 1 - View Inventory");
            System.out.println(" 2 - Check out a Book");
            System.out.println(" 3 - Check in a Book ");
            System.out.println(" 4 - Quit");
            int choice = libClerk.nextInt();
            libClerk.nextLine();


            switch (choice){
                case 1:
                    viewInventory(inventory);
                    break;

                case 2:
                    checkOutBook(inventory, libClerk);
                    break;
                case 3 :
                    checkInBook(inventory, libClerk);
                    break;
                case 4:
                    running =false;
                    System.out.println("Exiting system. Keep READING  \n Goodbye !!");
                break;
                default:
                    System.out.println(" Invalid choice . Please try again. ");
            }


        }

        libClerk.close();

    }
    public static void viewInventory(Book[] inventory){ /// viewInventory method in the same class
        System.out.println("\n Library Inventory: ");
        for (Book book : inventory){
            if (book!=null){
                System.out.println(book.toString());
            }
        }
    }

    public static void checkOutBook(Book[] inventory, Scanner libClerk){
        System.out.println("\n Enter the ID of the book to check out: ");
        int id = libClerk.nextInt();
        libClerk.nextLine();
        System.out.println(" Enter the name of the person checking out the book: ");


        for (Book book : inventory){
            if(book != null && book.getId()==id){
                if (!book.getIsCheckedOut()){
                    book.checkOut(book.getCheckedOutTo());//tried checked out (name) threw error right at my face // hope this works

                }else {
                    System.out.println(" Book "+ book.getTitle()+ " is already checked out ");
                }
                return;
            }
        }
        System.out.println(" Book with ID number "+ id +" not found");
    }
    public static void checkInBook(Book[] inventory, Scanner scanner) {
        System.out.print("\nEnter the ID of the book to check in: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        for (Book book : inventory) {
            if (book != null && book.getId() == id) {
                if (book.getIsCheckedOut()) {
                    book.checkedIn();
                } else {
                    System.out.println("Book \"" + book.getTitle() + "\" is already checked in.");
                }
                return;
            }
        }
        System.out.println("Book with ID " + id + " not found.");
    }


}
