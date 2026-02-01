package main.ui.ui_elements;

import main.NumericBase;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static main.NumericBase.*;

public enum CalculatorButton {
    DIGIT_0("0", ButtonCategory.DIGIT, new HashSet<>(List.of(DEC, BIN, OCT, HEX))),
    DIGIT_1("1", ButtonCategory.DIGIT, new HashSet<>(List.of(DEC, BIN, OCT, HEX))),
    DIGIT_2("2", ButtonCategory.DIGIT, new HashSet<>(List.of(DEC, OCT, HEX))),
    DIGIT_3("3", ButtonCategory.DIGIT, new HashSet<>(List.of(DEC, OCT, HEX))),
    DIGIT_4("4", ButtonCategory.DIGIT, new HashSet<>(List.of(DEC, OCT, HEX))),
    DIGIT_5("5", ButtonCategory.DIGIT, new HashSet<>(List.of(DEC, OCT, HEX))),
    DIGIT_6("6", ButtonCategory.DIGIT, new HashSet<>(List.of(DEC, OCT, HEX))),
    DIGIT_7("7", ButtonCategory.DIGIT, new HashSet<>(List.of(DEC, OCT, HEX))),
    DIGIT_8("8", ButtonCategory.DIGIT, new HashSet<>(List.of(DEC, HEX))),
    DIGIT_9("9", ButtonCategory.DIGIT, new HashSet<>(List.of(DEC, HEX))),

    HEX_A("A", ButtonCategory.HEX, new HashSet<>(List.of(HEX))),
    HEX_B("B", ButtonCategory.HEX, new HashSet<>(List.of(HEX))),
    HEX_C("C", ButtonCategory.HEX, new HashSet<>(List.of(HEX))),
    HEX_D("D", ButtonCategory.HEX, new HashSet<>(List.of(HEX))),
    HEX_E("E", ButtonCategory.HEX, new HashSet<>(List.of(HEX))),
    HEX_F("F", ButtonCategory.HEX, new HashSet<>(List.of(HEX))),

    PAREN_LEFT("(", ButtonCategory.BRACKET, new HashSet<>(List.of(DEC, BIN, OCT, HEX))),
    PAREN_RIGHT(")", ButtonCategory.BRACKET, new HashSet<>(List.of(DEC, BIN, OCT, HEX))),

    OP_ADD("+", ButtonCategory.OPERATOR, new HashSet<>(List.of(DEC, BIN, OCT, HEX))),
    OP_SUBTRACT("−", ButtonCategory.OPERATOR, new HashSet<>(List.of(DEC, BIN, OCT, HEX))),
    OP_MULTIPLY("*", ButtonCategory.OPERATOR, new HashSet<>(List.of(DEC, BIN, OCT, HEX))),
    OP_DIVIDE("÷", ButtonCategory.OPERATOR, new HashSet<>(List.of(DEC, BIN, OCT, HEX))),
    OP_MOD("Mod", ButtonCategory.OPERATOR, new HashSet<>(List.of(DEC, BIN, OCT, HEX))),
    OP_PERCENT("%", ButtonCategory.OPERATOR, new HashSet<>()),
    OP_SIGN("±", ButtonCategory.OPERATOR, new HashSet<>(List.of(DEC, BIN, OCT, HEX))),
    OP_DECIMAL(",", ButtonCategory.OPERATOR, new HashSet<>()),

    FUNC_SQRT("√", ButtonCategory.FUNCTION, new HashSet<>()),
    FUNC_RECIPROCAL("1/x", ButtonCategory.FUNCTION, new HashSet<>()),

    BIT_ROL("RoL", ButtonCategory.BITWISE, new HashSet<>(List.of(DEC, BIN, OCT, HEX))),
    BIT_ROR("RoR", ButtonCategory.BITWISE, new HashSet<>(List.of(DEC, BIN, OCT, HEX))),
    BIT_OR("Or", ButtonCategory.BITWISE, new HashSet<>(List.of(DEC, BIN, OCT, HEX))),
    BIT_XOR("Xor", ButtonCategory.BITWISE, new HashSet<>(List.of(DEC, BIN, OCT, HEX))),
    BIT_NOT("Not", ButtonCategory.BITWISE, new HashSet<>(List.of(DEC, BIN, OCT, HEX))),
    BIT_AND("And", ButtonCategory.BITWISE, new HashSet<>(List.of(DEC, BIN, OCT, HEX))),
    BIT_LSHIFT("Lsh", ButtonCategory.BITWISE, new HashSet<>(List.of(DEC, BIN, OCT, HEX))),
    BIT_RSHIFT("Rsh", ButtonCategory.BITWISE, new HashSet<>(List.of(DEC, BIN, OCT, HEX))),

    MEM_CLEAR("MC", ButtonCategory.MEMORY, new HashSet<>(List.of(DEC, BIN, OCT, HEX))),
    MEM_RECALL("MR", ButtonCategory.MEMORY, new HashSet<>(List.of(DEC, BIN, OCT, HEX))),
    MEM_STORE("MS", ButtonCategory.MEMORY, new HashSet<>(List.of(DEC, BIN, OCT, HEX))),
    MEM_ADD("M+", ButtonCategory.MEMORY, new HashSet<>(List.of(DEC, BIN, OCT, HEX))),
    MEM_SUBTRACT("M−", ButtonCategory.MEMORY, new HashSet<>(List.of(DEC, BIN, OCT, HEX))),

    CTRL_CLEAR_ENTRY("CE", ButtonCategory.CONTROL, new HashSet<>(List.of(DEC, BIN, OCT, HEX))),
    CTRL_CLEAR("C", ButtonCategory.CONTROL, new HashSet<>(List.of(DEC, BIN, OCT, HEX))),
    CTRL_BACKSPACE("←", ButtonCategory.CONTROL, new HashSet<>(List.of(DEC, BIN, OCT, HEX))),
    CTRL_EQUALS("=", ButtonCategory.CONTROL, new HashSet<>(List.of(DEC, BIN, OCT, HEX))),

    BLANK("", ButtonCategory.BLANK, new HashSet<>());

    public final String label;
    public final ButtonCategory category;
    public final Set<NumericBase> base;

    CalculatorButton(String label, ButtonCategory category, Set<NumericBase> base) {
        this.label = label;
        this.category = category;
        this.base = base;
    }
}
