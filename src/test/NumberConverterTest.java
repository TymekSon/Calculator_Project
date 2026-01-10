package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import main.NumberConverter;

public class NumberConverterTest {
 
 @Test
 void shouldConvertDecimalToHex() {
     assertEquals("FF", NumberConverter.toHex(255, 8));
     assertEquals("0A", NumberConverter.toHex(10, 8));
 }
 
 @Test
 void shouldConvertDecimalToBinary() {
     assertEquals("11111111", NumberConverter.toBinary(255, 8));
     assertEquals("00001010", NumberConverter.toBinary(10, 8));
 }
 
 @Test
 void shouldConvertHexToDecimal() {
     assertEquals(255L, NumberConverter.fromHex("FF"));
     assertEquals(10L, NumberConverter.fromHex("A"));
 }
 
 @Test
 void shouldTruncateToWordSize() {
     assertEquals(0L, NumberConverter.truncateToWordSize(256, 8));
     assertEquals(1L, NumberConverter.truncateToWordSize(257, 8));
 }
}
