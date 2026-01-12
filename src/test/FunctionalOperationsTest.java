package test;

import main.WordSize;
import main.Calculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FunctionalOperationsTest {
    
    private Calculator calculator;
    
    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }
       
    @Test
    void shouldTruncateToWordSize() {
        calculator.setWordSize(WordSize.BYTE);
        calculator.inputNumber("256"); // przekracza 8-bit
        calculator.calculate();
        assertEquals(0L, calculator.getCurrentValue()); // 256 % 256 = 0
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
}
