package src.main.java.assignment;

import java.util.Arrays;

public class Owner {
    private String name;
    private Wallet wallet;

    public Owner(String line) {
        String[] splitLine = line.split(";", 0);
        this.name = splitLine[0];
        this.wallet = new Wallet(Arrays.copyOfRange(splitLine, 1, splitLine.length));
    }

    public String getName() {
        return name;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public int findMax() {
        int max = this.getWallet().getMax();
        System.out.println("Max: " + max);
        return max;
    }

    public int findMin() {
        int min = this.getWallet().getMin();
        System.out.println("Min: " + min);
        return min;
    }
}
