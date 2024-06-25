package co.istad.SRBank.util;

import java.util.HashSet;
import java.util.Set;

public class GenerateNumber {

    private static final Set<Long> generatedNumbers = new HashSet<>();

    public static synchronized long generateUniqueNumber() {
        long number;
        do {
            number = (long) (Math.random() * Long.MAX_VALUE);
        } while (!generatedNumbers.add(number)); // Ensure uniqueness
        return number;
    }

}
