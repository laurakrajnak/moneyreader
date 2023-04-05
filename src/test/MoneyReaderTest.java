package src.test;

import src.main.java.assignment.MoneyReader;
import src.main.java.assignment.Owner;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class MoneyReaderTest {

    @org.junit.Test
    public void getOwnersTest() {
        MoneyReader reader = new MoneyReader("src/main/resources/data.csv");
        ArrayList<Owner> owners = reader.getOwners();
        assertEquals("dusan", owners.get(2).getName());
        assertEquals(10, owners.get(7).findMin());
        assertEquals(1000, owners.get(11).findMax());
    }

}