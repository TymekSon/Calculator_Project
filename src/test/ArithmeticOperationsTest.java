package test;

import main.Calculator;
import main.NumericBase;
import main.WordSize;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ArithmeticOperationsTest {

	private Calculator calculator;
    
    @BeforeEach
    void setUp() {
        calculator = new Calculator(WordSize.QWORD, NumericBase.DEC);
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
}
