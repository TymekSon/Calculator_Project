package main;

public class NumberConverter {
    
    public static String toHex(long value, int bitSize) {
        value = truncateToWordSize(value, bitSize);
        String hex = Long.toHexString(value).toUpperCase();
        return padLeft(hex, bitSize / 4, '0');
    }
    
    public static String toBinary(long value, int bitSize) {
        value = truncateToWordSize(value, bitSize);
        String binary = Long.toBinaryString(value);
        return padLeft(binary, bitSize, '0');
    }
    
    public static String toOctal(long value, int bitSize) {
        value = truncateToWordSize(value, bitSize);
        String octal = Long.toOctalString(value);
        int octalDigits = (bitSize + 2) / 3;
        return padLeft(octal, octalDigits, '0');
    }
    
    public static long fromHex(String hex) {
        return Long.parseLong(hex, 16);
    }
    
    public static long fromBinary(String binary) {
        return Long.parseLong(binary, 2);
    }
    
    public static long fromOctal(String octal) {
        return Long.parseLong(octal, 8);
    }

    public static long truncateToWordSize(long value, int bitSize) {
        if (bitSize >= 64) {
            return value;
        }
        long mask = (1L << bitSize) - 1;
        return value & mask;
    }
    
    private static String padLeft(String str, int length, char padChar) {
        if (str.length() >= length) return str;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length - str.length(); i++) {
            sb.append(padChar);
        }
        sb.append(str);
        return sb.toString();
    }
}