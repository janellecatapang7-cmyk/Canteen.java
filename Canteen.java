import java.util.Scanner;
public class Canteen {
public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);

    String[] menuItems = {"Fried Noodles", "Waffle", "Takoyaki", "Fries", "Soft Drinks"};
    double[] prices = {40.00, 35.00, 70.00, 50.00, 25.00};

    int totalItems = 0;
    double totalBeforeDiscount = 0;
    double totalDiscount = 0;

    char orderAgain = 'Y';

    System.out.println("======= CANTEEN MENU =======");

    for (int i = 0; i < menuItems.length; i++) {
        System.out.printf("%d. %-15s - $%.2f%n",
                i + 1, menuItems[i], prices[i]);
    }

    System.out.println();

    while (orderAgain == 'Y' || orderAgain == 'y') {

        System.out.print("Enter item number: ");
        int itemNumber = scanner.nextInt();

        System.out.print("Enter quantity: ");
        int quantity = scanner.nextInt();

        if (itemNumber < 1 || itemNumber > 5 ||
                quantity < 1 || quantity > 10) {

            System.out.println();
            System.out.println(
                "Invalid order! Please enter a valid item and quantity."
            );

            System.out.println();
            System.out.print("Do you want to order again? (Y/N): ");
            orderAgain = scanner.next().charAt(0);

            System.out.println();
            continue;
        }

        System.out.print("Are you a student? (Y/N): ");
        char student = scanner.next().charAt(0);

        boolean isStudent = student == 'Y' || student == 'y';

        double subtotal = prices[itemNumber - 1] * quantity;
        double discount = 0;

        if (isStudent && subtotal >= 500) {
            discount = subtotal * 0.15;
        }
        else if (isStudent) {
            discount = subtotal * 0.10;
        }
        else if (subtotal >= 500) {
            discount = subtotal * 0.05;
        }

        double orderTotal = subtotal - discount;

        System.out.println();
        System.out.printf("Subtotal: $%.2f%n", subtotal);
        System.out.printf("Discount: $%.2f%n", discount);
        System.out.printf("Order total: $%.2f%n", orderTotal);

        totalItems = totalItems + quantity;
        totalBeforeDiscount = totalBeforeDiscount + subtotal;
        totalDiscount = totalDiscount + discount;

        System.out.println();
        System.out.print("Do you want to order again? (Y/N): ");
        orderAgain = scanner.next().charAt(0);

        System.out.println();
    }

    System.out.println("===== ORDER SUMMARY =====");
    System.out.println("Total items: " + totalItems);
    System.out.printf("Total before discount: $%.2f%n",
            totalBeforeDiscount);
    System.out.printf("Total discount: $%.2f%n",
            totalDiscount);

    double finalAmount = totalBeforeDiscount - totalDiscount;

    System.out.printf("Final amount: $%.2f%n", finalAmount);
    System.out.println("Thank you for ordering!");

    scanner.close();
}
}

