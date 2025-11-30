package machine;

import java.util.Scanner;

public class CoffeeMachine {
    private final Scanner scanner = new Scanner(System.in);
    private int coffeeBeans = 120;
    private int water = 400;
    private int milk = 540;
    private int cups = 9;
    private int money = 550;

    public enum CoffeeType {
        ESPRESSO(16, 250, 0, 4),
        LATTE(20, 350, 75, 7),
        CAPPUCCINO(12, 200, 100, 6);

        final int coffeeBeans;
        final int water;
        final int milk;
        final int price;

        CoffeeType(int coffeeBeans, int water, int milk, int price) {
            this.coffeeBeans = coffeeBeans;
            this.water = water;
            this.milk = milk;
            this.price = price;
        }
    }

    public void displayState() {
        System.out.println("The coffee machine has:");
        System.out.printf("%d ml of water%n", water);
        System.out.printf("%d ml of milk%n", milk);
        System.out.printf("%d g of coffee beans%n", coffeeBeans);
        System.out.printf("%d disposable cups%n", cups);
        System.out.printf("$%d of money%n", money);
    }

    public boolean canMakeCoffee(CoffeeType coffeeType) {
        if (water < coffeeType.water) {
            System.out.println("Sorry, not enough water!");
            return false;
        }
        if (milk < coffeeType.milk) {
            System.out.println("Sorry, not enough milk!");
            return false;
        }
        if (coffeeBeans < coffeeType.coffeeBeans) {
            System.out.println("Sorry, not enough coffee beans!");
            return false;
        }
        if (cups < 1) {
            System.out.println("Sorry, not enough cups!");
            return false;
        }
        System.out.println("I have enough resources, making you a coffee!");
        return true;
    }

    public void buyCoffee() {
        System.out.println("What do you want to buy?" +
                " 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:"
        );
        String choice = scanner.next();
        if (choice.equals("back"))
            return;

        CoffeeType coffeeType = switch (choice) {
            case "1" -> CoffeeType.ESPRESSO;
            case "2" -> CoffeeType.LATTE;
            case "3" -> CoffeeType.CAPPUCCINO;
            default -> throw new IllegalStateException();
        };

        if (canMakeCoffee(coffeeType)) {
            coffeeBeans -= coffeeType.coffeeBeans;
            water -= coffeeType.water;
            milk -= coffeeType.milk;
            cups -= 1;
            money += coffeeType.price;
        }
    }

    public void fillMachine() {
        System.out.println("Write how many ml of water you want to add:");
        this.water += scanner.nextInt();
        System.out.println("Write how many ml of milk you want to add:");
        this.milk += scanner.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add:");
        this.coffeeBeans += scanner.nextInt();
        System.out.println("Write how many disposable cups you want to add:");
        this.cups += scanner.nextInt();
    }

    public void takeMoney() {
        int collectedMoney = money;
        money = 0;
        System.out.printf("I gave you $%d%n", collectedMoney);
    }

    public void start() {
        while (true) {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            String command = scanner.next();
            switch (command) {
                case "buy" -> buyCoffee();
                case "fill" -> fillMachine();
                case "take" -> takeMoney();
                case "remaining" -> displayState();
                case "exit" -> {
                    return;
                }
                default -> throw new IllegalStateException();
            }
        }
    }

    public static void main(String[] args) {
        CoffeeMachine coffeeMachine = new CoffeeMachine();
        coffeeMachine.start();
    }
}