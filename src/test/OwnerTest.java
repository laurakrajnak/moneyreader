package src.test;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import src.main.java.assignment.Owner;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class OwnerTest {

    @ParameterizedTest
    @MethodSource("setTestValues")
    void findMaxTest(String line, int min, int max) {
        Owner owner = new Owner(line);
        assertEquals(owner.findMax(), max);
    }

    @ParameterizedTest
    @MethodSource("setTestValues")
    void findMinTest(String line, int min, int max) {
        Owner owner = new Owner(line);
        assertEquals(owner.findMin(), min);
    }

    private static Stream<Arguments> setTestValues() {
        return Stream.of(
                Arguments.of("Adam;2m;20;1m;20;5;10;500;15;25", 5, 500),
                        Arguments.of("Fero;1m;8m;2m;30;50;20;100;5m;10", 10, 100),
                        Arguments.of("Lukas;5m;10m;20m;50m;100m;500;1000;200m;50;10", 10, 1000),
                        Arguments.of("Lukas", 0, 0)
        );
    }
}