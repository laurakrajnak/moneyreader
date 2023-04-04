package src.main.java.assignment.wallet;

import java.util.ArrayList;

public class Wallet {
    private ArrayList<Integer> banknotes;
    private ArrayList<Integer> coins;


    public Wallet(String[] wallet) {
        organizeWallet(wallet);
    }

    public ArrayList<Integer> getBanknotes() {
        return banknotes;
    }

    public ArrayList<Integer> getCoins() {
        return coins;
    }

    public ArrayList<Integer> organizeWallet(String[] wallet) {
        this.banknotes = new ArrayList<>();
        this.coins = new ArrayList<>();

        for (String value : wallet) {
            if (value.endsWith("m")) {
                value = value.substring(0, value.length() - 1);
                separateCoins(value);
            } else if (!value.equals("")){
                separateBanknotes(value);
            }
        }
        return banknotes;
    }

    private ArrayList<Integer> separateBanknotes(String value) {
        banknotes.add(Integer.parseInt(value));

        if (banknotes.get(banknotes.size() - 1) < 0) {
            banknotes.remove(banknotes.size() - 1);
            System.out.println("error in wallet - negative value of banknote - value was ignored");
        }
        return banknotes;
    }

    private ArrayList<Integer> separateCoins(String value) {
        this.coins.add(Integer.parseInt(value));

        if (coins.get(coins.size() - 1) < 0) {
            coins.remove(coins.size() - 1);
            System.out.println("error in wallet - negative value of coin - value was ignored");
        }
        return coins;
    }
}
