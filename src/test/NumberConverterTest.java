package test;
import main.NumberConverter;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class NumberConverterTest {
    
    @Test
    void shouldConvertDecimalToHex() {
        assertEquals("FF", NumberConverter.toHex(255, 8));
        assertEquals("0A", NumberConverter.toHex(10, 8));
    }
    
    @Test
    void shouldConvertDecimalToBinary() {
        assertEquals("11111111", NumberConverter.toBinary(255, 8));
        assertEquals("1010", NumberConverter.toBinary(10, 8));
    }
    
    @Test
    void shouldConvertDecimalToOctal() {
        assertEquals("377", NumberConverter.toOctal(255, 8));
        assertEquals("012", NumberConverter.toOctal(10, 8));
    }
    
    @Test
    void shouldConvertHexToDecimal() {
        assertEquals(255L, NumberConverter.fromHex("FF"));
        assertEquals(10L, NumberConverter.fromHex("A"));
    }
    
    @Test
    void shouldConvertBinaryToDecimal() {
        assertEquals(255L, NumberConverter.fromBinary("11111111"));
        assertEquals(10L, NumberConverter.fromBinary("1010"));
    }
    
    @Test
    void shouldConvertOctalToDecimal() {
        assertEquals(255L, NumberConverter.fromOctal("377"));
        assertEquals(8L, NumberConverter.fromOctal("10"));
    }
    
    @Test
    void shouldHandleDifferentWordSizes() {
        // 8-bit
        assertEquals("FF", NumberConverter.toHex(255, 8));
        // 16-bit
        assertEquals("00FF", NumberConverter.toHex(255, 16));
        // 32-bit
        assertEquals("000000FF", NumberConverter.toHex(255, 32));
    }
    
    @Test
    void shouldTruncateToWordSize() {
        // 256 w 8-bitach = 0 (overflow)
        long result = NumberConverter.truncateToWordSize(256, 8);
        assertEquals(0L, result);
        
        // 257 w 8-bitach = 1
        result = NumberConverter.truncateToWordSize(257, 8);
        assertEquals(1L, result);
    }
}