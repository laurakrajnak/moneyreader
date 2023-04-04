package src.main.java.assignment;

public class Owner {
    private String name;
    private Wallet wallet;

    public Owner(String name, String[] wallet) {
        this.name = name;
        this.wallet = new Wallet(wallet);
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
