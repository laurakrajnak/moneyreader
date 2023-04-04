package src.main.java.assignment;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MoneyReader reader = new MoneyReader("src/main/resources/data.csv");
        boolean found = false;

        while (true) {
            System.out.println("\nInput the name (or 0 if you want to end the program): ");
            String name = sc.nextLine().toLowerCase();

            if (name.equals("0")) {
                System.exit(0);
            }

            for (Owner owner : reader.getOwners()) {
                if (owner.getName().equals(name)) {
                    owner.findMax();
                    owner.findMin();
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println("No person with name " + name);
            }
        }
    }
}
