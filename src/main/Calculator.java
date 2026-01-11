package main;

public class Calculator {
    
    private WordSize wordSize = WordSize.DWORD;
    private NumberSystem numberSystem = NumberSystem.DEC;
    private String currentInput = "";
    private long accumulator = 0;
    private String currentOperator = null;
    private long memory = 0;
    private boolean startNewNumber = false;
    
    public void setWordSize(WordSize wordSize) {
        this.wordSize = wordSize;
        accumulator = truncate(accumulator);
    }
    
    public void setNumberSystem(NumberSystem numberSystem) {
        this.numberSystem = numberSystem;
    }
    
    public void inputNumber(String number) {
        // KLUCZOWA POPRAWKA: Jeśli trzeba zacząć nowy numer, wyczyść input
        if (startNewNumber) {
            currentInput = "";
            startNewNumber = false;
        }
        
        String filtered = numberSystem.filterInput(number);
        currentInput += filtered;
    }
    
    public void inputOperator(String operator) {
        if (!currentInput.isEmpty()) {
            calculate();
        }
        currentOperator = operator;
        startNewNumber = true;  // Następna liczba będzie nowa
    }
    
    public void calculate() {
        long value = parseCurrentInput();
        
        if (currentOperator == null) {
            accumulator = value;
        } else {
            accumulator = performOperation(accumulator, value, currentOperator);
        }
        
        accumulator = truncate(accumulator);
        currentInput = "";
        currentOperator = null;
        startNewNumber = true;  // Po obliczeniu, następna liczba będzie nowa
    }
    
    public long getCurrentValue() {
        if (!currentInput.isEmpty()) {
            return truncate(parseCurrentInput());
        }
        return accumulator;
    }
    
    public String getCurrentInput() {
        return currentInput;
    }
    
    public String getDisplayValue() {
        long value = getCurrentValue();
        
        switch (numberSystem) {
            case HEX:
                return NumberConverter.toHex(value, wordSize.getBits());
            case BIN:
                return NumberConverter.toBinary(value, wordSize.getBits());
            case OCT:
                return NumberConverter.toOctal(value, wordSize.getBits());
            case DEC:
            default:
                return String.valueOf(value);
        }
    }
    
    public String getBinaryRepresentation() {
        return NumberConverter.toBinary(getCurrentValue(), wordSize.getBits());
    }
    
    public void clear() {
        currentInput = "";
        accumulator = 0;
        currentOperator = null;
        startNewNumber = false;
    }
    
    public void clearEntry() {
        currentInput = "";
    }
    
    public void backspace() {
        if (!currentInput.isEmpty()) {
            currentInput = currentInput.substring(0, currentInput.length() - 1);
        }
    }
    
    public void memoryStore() {
        memory = getCurrentValue();
        startNewNumber = true;  // POPRAWKA: Po zapisie do pamięci, następna liczba będzie nowa
    }
    
    public void memoryRecall() {
        accumulator = memory;
        currentInput = String.valueOf(memory);
        startNewNumber = false;
    }
    
    public void memoryClear() {
        memory = 0;
    }
    
    public void memoryAdd() {
        memory = truncate(memory + getCurrentValue());
        startNewNumber = true;  // POPRAWKA: Po dodaniu do pamięci, następna liczba będzie nowa
    }
    
    public void memorySubtract() {
        memory = truncate(memory - getCurrentValue());
        startNewNumber = true;  // POPRAWKA: Po odjęciu od pamięci, następna liczba będzie nowa
    }
    
    public void negate() {
        if (!currentInput.isEmpty()) {
            long value = parseCurrentInput();
            value = -value;
            currentInput = String.valueOf(truncate(value));
        } else {
            accumulator = truncate(-accumulator);
        }
    }
    
    private long parseCurrentInput() {
        if (currentInput.isEmpty()) {
            return 0;
        }
        
        try {
            switch (numberSystem) {
                case HEX:
                    return NumberConverter.fromHex(currentInput);
                case BIN:
                    return NumberConverter.fromBinary(currentInput);
                case OCT:
                    return NumberConverter.fromOctal(currentInput);
                case DEC:
                default:
                    return Long.parseLong(currentInput);
            }
        } catch (NumberFormatException e) {
            return 0;
        }
    }
    
    private long performOperation(long left, long right, String operator) {
        switch (operator) {
            case "+":
                return left + right;
            case "-":
                return left - right;
            case "*":
                return left * right;
            case "/":
                if (right == 0) {
                    throw new ArithmeticException("Division by zero");
                }
                return left / right;
            case "%":
                if (right == 0) {
                    throw new ArithmeticException("Division by zero");
                }
                return left % right;
            case "AND":
                return left & right;
            case "OR":
                return left | right;
            case "XOR":
                return left ^ right;
            case "NOT":
                return ~left;
            case "<<":
                return left << right;
            case ">>":
                return left >> right;
            case "ROL":
                return rotateLeft(left, (int) right);
            case "ROR":
                return rotateRight(left, (int) right);
            default:
                return right;
        }
    }
    
    private long rotateLeft(long value, int shift) {
        int bits = wordSize.getBits();
        shift = shift % bits;
        value = truncate(value);
        return truncate((value << shift) | (value >>> (bits - shift)));
    }
    
    private long rotateRight(long value, int shift) {
        int bits = wordSize.getBits();
        shift = shift % bits;
        value = truncate(value);
        return truncate((value >>> shift) | (value << (bits - shift)));
    }
    
    private long truncate(long value) {
        return NumberConverter.truncateToWordSize(value, wordSize.getBits());
    }
}