package main;

import main.NumericBase;

import java.math.BigInteger;

public class StringNumberConverter {

    public static String convert(
            String input,
            NumericBase fromBase,
            NumericBase toBase,
            int bitSize
    ) {
        if (input == null || input.isEmpty()) return "";

        BigInteger value = new BigInteger(input, fromBase.getBase());

        value = truncateToWordSize(value, bitSize);

        String result = value.toString(toBase.getBase()).toUpperCase();

        return result;
    }

    private static BigInteger truncateToWordSize(BigInteger value, int bitSize) {
        BigInteger mask = BigInteger.ONE.shiftLeft(bitSize).subtract(BigInteger.ONE);
        return value.and(mask);
    }

}
