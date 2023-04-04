package src.main.java.assignment.walletowner;

import src.main.java.assignment.wallet.Wallet;

public class WalletOwner {
    private String name;
    private Wallet wallet;

    public WalletOwner(String name, String[] wallet) {
        this.name = name;
        this.wallet = new Wallet(wallet);
    }

    public String getName() {
        return name;
    }

    public Wallet getWallet() {
        return wallet;
    }
}
