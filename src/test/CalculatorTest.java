package test;

import main.NumberSystem;
import main.WordSize;
import main.Calculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    
    private Calculator calculator;
    
    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }
    
    @Test
    void shouldAddTwoNumbers() {
        calculator.inputNumber("10");
        calculator.inputOperator("+");
        calculator.inputNumber("5");
        calculator.calculate();
        assertEquals(15L, calculator.getCurrentValue());
    }
    
    @Test
    void shouldSubtractNumbers() {
        calculator.inputNumber("20");
        calculator.inputOperator("-");
        calculator.inputNumber("8");
        calculator.calculate();
        assertEquals(12L, calculator.getCurrentValue());
    }
    
    @Test
    void shouldMultiplyNumbers() {
        calculator.inputNumber("6");
        calculator.inputOperator("*");
        calculator.inputNumber("7");
        calculator.calculate();
        assertEquals(42L, calculator.getCurrentValue());
    }
    
    @Test
    void shouldDivideNumbers() {
        calculator.inputNumber("20");
        calculator.inputOperator("/");
        calculator.inputNumber("4");
        calculator.calculate();
        assertEquals(5L, calculator.getCurrentValue());
    }
    
    @Test
    void shouldCalculateModulo() {
        calculator.inputNumber("17");
        calculator.inputOperator("%");
        calculator.inputNumber("5");
        calculator.calculate();
        assertEquals(2L, calculator.getCurrentValue());
    }
    
    @Test
    void shouldHandleDivisionByZero() {
        calculator.inputNumber("10");
        calculator.inputOperator("/");
        calculator.inputNumber("0");
        assertThrows(ArithmeticException.class, () -> calculator.calculate());
    }
    
    @Test
    void shouldTruncateToWordSize() {
        calculator.setWordSize(WordSize.BYTE);
        calculator.inputNumber("256"); // przekracza 8-bit
        calculator.calculate();
        assertEquals(0L, calculator.getCurrentValue()); // 256 % 256 = 0
    }
    
    @Test
    void shouldPerformBitwiseAND() {
        calculator.inputNumber("12"); // 1100
        calculator.inputOperator("AND");
        calculator.inputNumber("10"); // 1010
        calculator.calculate();
        assertEquals(8L, calculator.getCurrentValue()); // 1000 = 8
    }
    
    @Test
    void shouldPerformBitwiseOR() {
        calculator.inputNumber("12"); // 1100
        calculator.inputOperator("OR");
        calculator.inputNumber("10"); // 1010
        calculator.calculate();
        assertEquals(14L, calculator.getCurrentValue()); // 1110 = 14
    }
    
    @Test
    void shouldPerformBitwiseXOR() {
        calculator.inputNumber("12"); // 1100
        calculator.inputOperator("XOR");
        calculator.inputNumber("10"); // 1010
        calculator.calculate();
        assertEquals(6L, calculator.getCurrentValue()); // 0110 = 6
    }
    
    @Test
    void shouldPerformBitwiseNOT() {
        calculator.setWordSize(WordSize.BYTE);
        calculator.inputNumber("0");
        calculator.inputOperator("NOT");
        calculator.calculate();
        assertEquals(255L, calculator.getCurrentValue()); // wszystkie bity = 1
    }
    
    @Test
    void shouldPerformLeftShift() {
        calculator.inputNumber("1");
        calculator.inputOperator("<<");
        calculator.inputNumber("3");
        calculator.calculate();
        assertEquals(8L, calculator.getCurrentValue()); // 1 << 3 = 8
    }
    
    @Test
    void shouldPerformRightShift() {
        calculator.inputNumber("16");
        calculator.inputOperator(">>");
        calculator.inputNumber("2");
        calculator.calculate();
        assertEquals(4L, calculator.getCurrentValue()); // 16 >> 2 = 4
    }
    
    @Test
    void shouldWorkWithHexInput() {
        calculator.setNumberSystem(NumberSystem.HEX);
        calculator.inputNumber("FF");
        calculator.calculate();
        assertEquals(255L, calculator.getCurrentValue());
    }
    
    @Test
    void shouldWorkWithBinaryInput() {
        calculator.setNumberSystem(NumberSystem.BIN);
        calculator.inputNumber("1010");
        calculator.calculate();
        assertEquals(10L, calculator.getCurrentValue());
    }
    
    @Test
    void shouldClearCalculator() {
        calculator.inputNumber("123");
        calculator.clear();
        assertEquals(0L, calculator.getCurrentValue());
    }
    
    @Test
    void shouldClearEntry() {
        calculator.inputNumber("123");
        calculator.inputOperator("+");
        calculator.inputNumber("456");
        calculator.clearEntry();
        assertEquals("", calculator.getCurrentInput());
    }
    
    @Test
    void shouldBackspaceLastChar() {
        calculator.inputNumber("123");
        calculator.backspace();
        assertEquals("12", calculator.getCurrentInput());
    }
    
    @Test
    void shouldStoreAndRecallMemory() {
        calculator.inputNumber("42");
        calculator.memoryStore();
        calculator.clear();
        calculator.memoryRecall();
        assertEquals(42L, calculator.getCurrentValue());
    }
    
    @Test
    void shouldAddToMemory() {
        calculator.inputNumber("10");
        System.out.println("1. Po input(10): " + calculator.getCurrentValue());
        
        calculator.memoryStore();
        System.out.println("2. Po memoryStore");
        
        calculator.inputNumber("5");
        System.out.println("3. Po input(5): " + calculator.getCurrentValue());
        
        calculator.memoryAdd();
        System.out.println("4. Po memoryAdd");
        
        calculator.memoryRecall();
        System.out.println("5. Po memoryRecall: " + calculator.getCurrentValue());
        
        assertEquals(15L, calculator.getCurrentValue());
    }
}
