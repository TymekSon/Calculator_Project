package test;

import main.NumericBase;
import main.WordSize;
import main.Calculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BitOperationsTest {
	private Calculator calculator;
    
    @BeforeEach
    void setUp() {
        calculator = new Calculator(WordSize.QWORD, NumericBase.DEC);
    }
    
    @Test
    void shouldPerformBitwiseAND() {
        calculator.inputNumber("12"); // 1100
        calculator.inputOperator("And");
        calculator.inputNumber("10"); // 1010
        calculator.calculate();
        assertEquals(8L, calculator.getCurrentValue()); // 1000 = 8
    }
    
    @Test
    void shouldPerformBitwiseOR() {
        calculator.inputNumber("12"); // 1100
        calculator.inputOperator("Or");
        calculator.inputNumber("10"); // 1010
        calculator.calculate();
        assertEquals(14L, calculator.getCurrentValue()); // 1110 = 14
    }
    
    @Test
    void shouldPerformBitwiseXOR() {
        calculator.inputNumber("12"); // 1100
        calculator.inputOperator("Xor");
        calculator.inputNumber("10"); // 1010
        calculator.calculate();
        assertEquals(6L, calculator.getCurrentValue()); // 0110 = 6
    }
    
    @Test
    void shouldPerformBitwiseNOT() {
        calculator.setWordSize(WordSize.BYTE);
        calculator.inputNumber("0");
        calculator.inputOperator("Not");
        calculator.calculate();
        assertEquals(255L, calculator.getCurrentValue()); // wszystkie bity = 1
    }
    
    @Test
    void shouldPerformLeftShift() {
        calculator.inputNumber("1");
        calculator.inputOperator("Lsh");
        calculator.inputNumber("3");
        calculator.calculate();
        assertEquals(8L, calculator.getCurrentValue()); // 1 << 3 = 8
    }
    
    @Test
    void shouldPerformRightShift() {
        calculator.inputNumber("16");
        calculator.inputOperator("Rsh");
        calculator.inputNumber("2");
        calculator.calculate();
        assertEquals(4L, calculator.getCurrentValue()); // 16 >> 2 = 4
    }
}
