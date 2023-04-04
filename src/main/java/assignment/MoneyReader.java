package src.main.java.assignment;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MoneyReader {
    private Scanner scanFile;
    private ArrayList<Owner> owners;

    public MoneyReader(String path) {
        try {
            this.scanFile = new Scanner(new File(path));
        } catch (FileNotFoundException e) {
            System.out.println("file not found");
            System.exit(0);
        }
        setOwners();
    }

    public ArrayList<Owner> getOwners() { return owners; }

    private void setOwners() {
        this.owners = new ArrayList<>();
        scanFile.useDelimiter(";");

        if (!scanFile.hasNextLine()) {
            System.out.println("file is empty");
            System.exit(0);
        }
        while (scanFile.hasNextLine()) {
            String name = scanFile.next().toLowerCase();
            String[] wallet = scanFile.nextLine().split(";", 0);

            owners.add(new Owner(name, wallet));
        }
    }
}
