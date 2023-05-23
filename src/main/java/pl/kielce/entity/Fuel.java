package pl.kielce.entity;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum Fuel {
    DIESEL,
    PETROL,
    LPG,
    ELECTRIC;

    private static final List<Fuel> VALUES = Collections.unmodifiableList(Arrays.asList(values()));
    private static final int SIZE = VALUES.size();
    private static final Random RANDOM = new Random();
    public static Fuel randomFuel() {
        return VALUES.get(RANDOM.nextInt(SIZE));
    }
}




