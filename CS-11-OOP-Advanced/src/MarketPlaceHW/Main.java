package MarketPlaceHW;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Seller seller = new Seller("John");
        Buyer buyer = new Buyer("Alice");

        while (true) {
            System.out.println("1. Add Product");
            System.out.println("2. Remove Product");
            System.out.println("3. Buy Product");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (option) {
                case 1:
                    System.out.print("Enter product name: ");
                    String productName = scanner.nextLine();
                    System.out.print("Enter product price: ");
                    double productPrice = scanner.nextDouble();
                    Product product = new Product(productName, productPrice);
                    seller.addProduct(product);
                    break;
                case 2:
                    System.out.print("Enter product name to remove: ");
                    String removeProductName = scanner.nextLine();
                    for (Product p : seller.getProducts()) {
                        if (p.getName().equals(removeProductName)) {
                            seller.removeProduct(p);
                            break;
                        }
                    }
                    break;
                case 3:
                    System.out.print("Enter product name to buy: ");
                    String buyProductName = scanner.nextLine();
                    for (Product p : seller.getProducts()) {
                        if (p.getName().equals(buyProductName)) {
                            buyer.buyProduct(p, seller);
                            break;
                        }
                    }
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
    }

