package com.codedifferently.tools;
import java.util.*;

public abstract class RandomNumberFactory {
    private static final Random random = new Random();

    /** @return a random float between the specified min and max numeric range */
    public static Float createFloat(float min, float max) {

        return random.nextFloat() * (max - min) + min;
    }

    /** @return a random integer between the specified min and max numeric range */
    public static Integer createInteger(Integer min, Integer max) {

        return createFloat(min, max).intValue();
    }
}
