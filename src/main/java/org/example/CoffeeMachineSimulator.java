package org.example;
import java.util.Scanner;
public class CoffeeMachineSimulator {

    private int water;
    private int milk;
    private int beans;
    private int money;
    private int espressoPrice;
    private int lattePrice;
    private int cappuccinoPrice;
    private int espressoWater;
    private int espressoBeans;
    private int latteWater;
    private int latteMilk;
    private int latteBeans;
    private int cappuccinoWater;
    private int cappuccinoMilk;
    private int cappuccinoBeans;
    private int espressoCount;
    private int latteCount;
    private int cappuccinoCount;

    public CoffeeMachineSimulator(int water, int milk, int beans, int money,int espressoPrice, int lattePrice, int cappuccinoPrice, int espressoWater, int espressoBeans, int latteWater, int latteMilk, int latteBeans, int cappuccinoWater, int cappuccinoMilk, int cappuccinoBeans) {
        this.water = water;
        this.milk = milk;
        this.beans = beans;
        this.money = money;
        this.espressoPrice = espressoPrice;
        this.lattePrice = lattePrice;
        this.cappuccinoPrice = cappuccinoPrice;
        this.espressoWater = espressoWater;
        this.espressoBeans = espressoBeans;
        this.latteWater = latteWater;
        this.latteMilk = latteMilk;
        this.latteBeans = latteBeans;
        this.cappuccinoWater = cappuccinoWater;
        this.cappuccinoMilk = cappuccinoMilk;
        this.cappuccinoBeans = cappuccinoBeans;
        this.espressoCount = 0;
        this.latteCount = 0;
        this.cappuccinoCount = 0;
    }

    public void buyEspresso() {
        if (water < espressoWater) {
            System.out.println("Sorry, not enough water!");
            return;
        }
        if (beans < espressoBeans) {
            System.out.println("Sorry, not enough beans!");
            return;
        }
        water -= espressoWater;
        beans -= espressoBeans;
        money += espressoPrice;
        espressoCount++;
        System.out.println("Here is your Espresso. Enjoy!");
    }

    public void buyLatte() {
        if (water < latteWater) {
            System.out.println("Sorry, not enough water!");
            return;
        }
        if (milk < latteMilk) {
            System.out.println("Sorry, not enough milk!");
            return;
        }
        if (beans < latteBeans) {
            System.out.println("Sorry, not enough beans!");
            return;
        }
        water -= latteWater;
        milk -= latteMilk;
        beans -= latteBeans;
        money += lattePrice;
        latteCount++;
        System.out.println("Here is your Latte. Enjoy!");
    }

    public void buyCappuccino() {
        if (water < cappuccinoWater) {
            System.out.println("Sorry, not enough water!");
            return;
        }
        if (milk < cappuccinoMilk) {
            System.out.println("Sorry, not enough milk!");
            return;
        }
        if (beans < cappuccinoBeans) {
            System.out.println("Sorry, not enough beans!");
            return;
        }
        water -= cappuccinoWater;
        milk -= cappuccinoMilk;
        beans -= cappuccinoBeans;
        money += cappuccinoPrice;
        cappuccinoCount++;
        System.out.println("Here is your Cappuccino. Enjoy!");
    }
    public void fillMachine() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many ml of water do you want to add?");
        int waterToAdd = scanner.nextInt();
        water += waterToAdd;
        System.out.println("How many ml of milk do you want to add?");
        int milkToAdd = scanner.nextInt();
        milk += milkToAdd;
        System.out.println("How many grams of coffee beans do you want to add?");
        int beansToAdd = scanner.nextInt();
        beans += beansToAdd;
        System.out.println("How much money do you want to add to the machine?");
        int moneyToAdd = scanner.nextInt();
        money += moneyToAdd;
        System.out.println("The machine has been refilled!");
    }

    public void showStatus() {
        System.out.println("The coffee machine has:");
        System.out.println(water + " ml of water");
        System.out.println(milk + " ml of milk");
        System.out.println(beans + " g of coffee beans");
        System.out.println(money + " of money");
    }

    public void showCount() {
        System.out.println("Espresso: " + espressoCount);
        System.out.println("Latte: " + latteCount);
        System.out.println("Cappuccino: " + cappuccinoCount);
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("What would you like to do?");
            System.out.println("1. Buy Espresso (" + espressoPrice + ")");
            System.out.println("2. Buy Latte (" + lattePrice + ")");
            System.out.println("3. Buy Cappuccino (" + cappuccinoPrice + ")");
            System.out.println("4. Fill Machine");
            System.out.println("5. Show Status");
            System.out.println("6. Show Count");
            System.out.println("7. Exit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    buyEspresso();
                    break;
                case 2:
                    buyLatte();
                    break;
                case 3:
                    buyCappuccino();
                    break;
                case 4:
                    fillMachine();
                    break;
                case 5:
                    showStatus();
                    break;
                case 6:
                    showCount();
                    break;
                case 7:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }


    public static void main(String[] args) {
        CoffeeMachineSimulator machine = new CoffeeMachineSimulator(400, 540, 120, 550, 4, 7, 6, 250, 16, 350, 75, 20, 200, 100, 12);
        machine.run();
    }
}
