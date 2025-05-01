package calculator;

import java.util.Scanner;

public class Main {
    /**
     * Stage 1:
     * This method displays the prices of various products.
     */
    private static void printProducts() {
        double bubblegumPrice = 2;
        double ToffeePrice = 0.2;
        double IceCreamPrice = 5;
        double MilkChocolatePrice = 4;
        double DoughnutPrice = 2.5;
        double PancakePrice = 3.2;

        System.out.println("Prices:");
        System.out.println("Bubblegum: $" + bubblegumPrice);
        System.out.println("Toffee: $" + ToffeePrice);
        System.out.println("Ice cream: $" + IceCreamPrice);
        System.out.println("Milk chocolate: $" + MilkChocolatePrice);
        System.out.println("Doughnut: $" + DoughnutPrice);
        System.out.println("Pancake: $" + PancakePrice);
    }

    /**
     * Stage 2:
     * This method calculates the total income from the sales of various products.
     *
     * @return total income
     */
    private static double calculateIncome() {
        double bubblegumEarnings = 202;
        double ToffeeEarnings = 118;
        double IceCreamEarnings = 2250;
        double MilkChocolateEarnings = 1680;
        double DoughnutEarnings = 1075;
        double PancakeEarnings = 80;
        double income = bubblegumEarnings + ToffeeEarnings + IceCreamEarnings
                + MilkChocolateEarnings + DoughnutEarnings + PancakeEarnings;

        System.out.println("Earned amount:");
        System.out.println("Bubblegum: $" + bubblegumEarnings);
        System.out.println("Toffee: $" + ToffeeEarnings);
        System.out.println("Ice cream: $" + IceCreamEarnings);
        System.out.println("Milk chocolate: $" + MilkChocolateEarnings);
        System.out.println("Doughnut: $" + DoughnutEarnings);
        System.out.println("Pancake: $" + PancakeEarnings);
        System.out.println("\nIncome: $" + income);
        return income;
    }

    /**
     * Stage 3:
     * This method calculates the net income by subtracting staff and other expenses
     * from the total income.
     */
    private static void calculateNetIncome() {
        double income = calculateIncome();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Staff expenses:");
        double staffExpenses = scanner.nextDouble();
        System.out.println("Other expenses:");
        double otherExpenses = scanner.nextDouble();
        scanner.close();

        double netIncome = income - staffExpenses - otherExpenses;
        System.out.printf("Net income: $%.2f\n", netIncome);
    }

    public static void main(String[] args) {
        // printProducts();
        calculateNetIncome();
    }
}
