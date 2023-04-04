package src.main.java.assignment;

import src.main.java.assignment.moneyreader.MoneyReader;

public class Main {
    public static void main(String[] args) {
        MoneyReader reader = new MoneyReader("data/data.csv");
        reader.findMaxMin();
    }
}
