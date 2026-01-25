package test;

import main.Calculator;
import main.NumericBase;
import main.WordSize;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MemoryOperationsTest {
	private Calculator calculator;
    
    @BeforeEach
    void setUp() {
        calculator = new Calculator(WordSize.QWORD, NumericBase.DEC);
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
        calculator.memoryStore();
        calculator.inputNumber("5");
        calculator.memoryAdd();
        calculator.memoryRecall();
        assertEquals(15L, calculator.getCurrentValue());
    }
}
