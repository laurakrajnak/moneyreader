package src.test;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import src.main.java.assignment.Wallet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WalletTest {

    @ParameterizedTest
    @MethodSource("setTestValues")
    void getMaxTest(String[] line, ArrayList<Integer> banknotes, int min, int max) {
        Wallet wallet = new Wallet(line);
        assertEquals(wallet.getMax(), max);
    }

    @ParameterizedTest
    @MethodSource("setTestValues")
    void getMinTest(String[] line, ArrayList<Integer> banknotes, int min, int max) {
        Wallet wallet = new Wallet(line);
        assertEquals(wallet.getMin(), min);
    }

    @ParameterizedTest
    @MethodSource("setTestValues")
    void getBanknotesTest(String[] line, ArrayList<Integer> banknotes, int min, int max) {
        Wallet wallet = new Wallet(line);
        assertEquals(wallet.getBanknotes(), banknotes);
    }

    private static Stream<Arguments> setTestValues() {
        return Stream.of(
                Arguments.of(new String[]{"2m", "20", "1m", "20", "5", "10", "500", "15", "25"},
                                        new ArrayList<>(Arrays.asList(20, 20, 5, 10, 500, 15, 25)), 5, 500),
                Arguments.of(new String[]{"1m", "8m", "2m", "30", "50", "20", "100", "5m", "10"},
                                        new ArrayList<>(Arrays.asList(30, 50, 20, 100, 10)), 10, 100),
                Arguments.of(new String[]{"5m", "10m", "20m", "50m", "100m", "500", "1000", "200m", "50", "10"},
                                        new ArrayList<>(Arrays.asList(500, 1000, 50, 10)), 10, 1000),
                Arguments.of(new String[]{""},
                                         new ArrayList<>(Arrays.asList(0)), 0, 0)
        );
    }
}