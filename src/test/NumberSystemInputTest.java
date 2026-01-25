package test;

import main.Calculator;
import main.NumericBase;
import main.WordSize;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class NumberSystemInputTest {
	private Calculator calculator;
    
    @BeforeEach
    void setUp() {
        calculator = new Calculator(WordSize.QWORD, NumericBase.DEC);
    }
    
    @Test
    void shouldWorkWithOctalInput() {
    	calculator.setBase(NumericBase.OCT);
    	calculator.inputNumber("45");
    	calculator.calculate();
    	assertEquals(37L, calculator.getCurrentValue());
    }
       
    @Test
    void shouldWorkWithHexInput() {
        calculator.setBase(NumericBase.HEX);
        calculator.inputNumber("FF");
        calculator.calculate();
        assertEquals(255L, calculator.getCurrentValue());
    }
    
    @Test
    void shouldWorkWithBinaryInput() {
        calculator.setBase(NumericBase.BIN);
        calculator.inputNumber("1010");
        calculator.calculate();
        assertEquals(10L, calculator.getCurrentValue());
    }
}
