package TasksForSoftUni;

import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double totalPriceWithoutTax = 0;
        double totalTax = 0;

        // Read prices until the customer type is specified
        while (true) {
            String input = scanner.nextLine();

            if (input.equals("special") || input.equals("regular")) {
                break;
            }

            try {
                double partPrice = Double.parseDouble(input);

                if (partPrice < 0) {
                    System.out.println("Invalid price!");
                    continue;
                }

                // Calculate tax for each part
                double tax = 0.2 * partPrice;
                totalTax += tax;
                totalPriceWithoutTax += partPrice;

            } catch (NumberFormatException e) {
                System.out.println("Invalid price!");
            }
        }

        // Check if the total price is zero
        if (totalPriceWithoutTax == 0) {
            System.out.println("Invalid order!");
        } else {
            // Determine the customer type and apply discount if necessary
            String customerType = scanner.nextLine();
            double totalPriceWithTax = totalPriceWithoutTax + totalTax;

            if (customerType.equals("special")) {
                // Apply 10% discount for special customers
                double discount = 0.1;
                double discountAmount = totalPriceWithTax * discount;
                totalPriceWithTax -= discountAmount;
            }

            // Display the receipt
            System.out.printf("Congratulations you've just bought a new computer!%n");
            System.out.printf("Price without taxes: %.2f$%n", totalPriceWithoutTax);
            System.out.printf("Taxes: %.2f$%n", totalTax);
            System.out.println("-----------");
            System.out.printf("Total price: %.2f$%n", totalPriceWithTax);
        }

        // Close the scanner
        scanner.close();
    }
}