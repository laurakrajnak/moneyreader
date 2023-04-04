package src.main.java.assignment.moneyreader;

import src.main.java.assignment.walletowner.WalletOwner;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class MoneyReader {
    private Scanner scanInput;
    private Scanner scanFile;
    private String name;
    private ArrayList<WalletOwner> owners;

    public MoneyReader(String path) {
        this.scanInput = new Scanner(System.in);
        try {
            this.scanFile = new Scanner(new File(path));
        } catch (FileNotFoundException e) {
            System.out.println("file not found");
            System.exit(0);
        }
        this.owners = new ArrayList<>();
        createWalletOwners();
    }

    private String setName() {
        System.out.println("\nInput the name (or 0 if you want to end the program): ");
        String name = scanInput.nextLine().toLowerCase();
        if (name.equals("0")) {
            System.exit(0);
        }
        return name;
    }

    public void findMaxMin() {
        this.name = setName();

        for (WalletOwner owner : owners) {
            if (owner.getName().equals(this.name)) {
                printMaxMin(owner);
                findMaxMin();
            }
        }
        System.out.println("No person with name " + name);
        findMaxMin();
    }

    private ArrayList<WalletOwner> createWalletOwners() {
        scanFile.useDelimiter(";");
        if (!scanFile.hasNextLine()) {
            System.out.println("file is empty");
            System.exit(0);
        }
        while (scanFile.hasNextLine()) {
            WalletOwner walletOwner = new WalletOwner(scanFile.next().toLowerCase(), scanFile.nextLine().split(";", 0));
            owners.add(walletOwner);
        }
        return owners;
    }

    private void printMaxMin(WalletOwner owner) {
        System.out.println("Max banknote: " + Collections.max(owner.getWallet().getBanknotes()));
        System.out.println("Min banknote: " + Collections.min(owner.getWallet().getBanknotes()));
        System.out.println("Max coin: " + Collections.max(owner.getWallet().getCoins()));
        System.out.println("Min coin: " + Collections.min(owner.getWallet().getCoins()));
    }
}
