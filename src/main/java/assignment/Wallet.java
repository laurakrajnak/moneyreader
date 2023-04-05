package src.main.java.assignment;

import java.util.ArrayList;
import java.util.Collections;

public class Wallet {
    private ArrayList<Integer> banknotes;
    private int max;
    private int min;

    public Wallet(String[] wallet) {
        this.banknotes = new ArrayList<>();

        for (String value : wallet) {
            if (!value.equals("") && !value.endsWith("m")) {
                setBanknotes(value);
            }
        }
        if (banknotes.isEmpty()) {
            setBanknotes("0");
        }
        this.max = Collections.max(banknotes);
        this.min = Collections.min(banknotes);
    }

    public int getMax() { return max; }

    public int getMin() { return min; }

    public ArrayList<Integer> getBanknotes() { return banknotes; }

    private void setBanknotes(String value) {
        banknotes.add(Integer.parseInt(value));

        if (banknotes.get(banknotes.size() - 1) < 0) {
            banknotes.remove(banknotes.size() - 1);
            System.out.println("error in wallet - negative value of banknote - value was ignored");
        }
    }
}
