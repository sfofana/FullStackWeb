package com.sfofana.bank.bank.util;

import java.util.Random;

public class NumberUtils {

    public static double addDouble(Double num1, Double num2) {
        return num1 + num2;
    }

    public static double subtractDouble(Double num1, Double num2) {
        return num1 - num2;
    }

    public static int randomNumber(int upper, int lower) {
        Random random = new Random();
        int range = upper - lower;
        return random.nextInt(range + 1) + lower;
    }
}
