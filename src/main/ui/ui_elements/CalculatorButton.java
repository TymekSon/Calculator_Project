package main.ui.ui_elements;

public enum CalculatorButton {
    DIGIT_0("0", ButtonCategory.DIGIT),
    DIGIT_1("1", ButtonCategory.DIGIT),
    DIGIT_2("2", ButtonCategory.DIGIT),
    DIGIT_3("3", ButtonCategory.DIGIT),
    DIGIT_4("4", ButtonCategory.DIGIT),
    DIGIT_5("5", ButtonCategory.DIGIT),
    DIGIT_6("6", ButtonCategory.DIGIT),
    DIGIT_7("7", ButtonCategory.DIGIT),
    DIGIT_8("8", ButtonCategory.DIGIT),
    DIGIT_9("9", ButtonCategory.DIGIT),

    HEX_A("A", ButtonCategory.HEX),
    HEX_B("B", ButtonCategory.HEX),
    HEX_C("C", ButtonCategory.HEX),
    HEX_D("D", ButtonCategory.HEX),
    HEX_E("E", ButtonCategory.HEX),
    HEX_F("F", ButtonCategory.HEX),

    PAREN_LEFT("(", ButtonCategory.BRACKET),
    PAREN_RIGHT(")", ButtonCategory.BRACKET),

    OP_ADD("+", ButtonCategory.OPERATOR),
    OP_SUBTRACT("−", ButtonCategory.OPERATOR),
    OP_MULTIPLY("*", ButtonCategory.OPERATOR),
    OP_DIVIDE("÷", ButtonCategory.OPERATOR),
    OP_MOD("Mod", ButtonCategory.OPERATOR),
    OP_PERCENT("%", ButtonCategory.OPERATOR),
    OP_SIGN("±", ButtonCategory.OPERATOR),
    OP_DECIMAL(",", ButtonCategory.OPERATOR),

    FUNC_SQRT("√", ButtonCategory.FUNCTION),
    FUNC_RECIPROCAL("1/x", ButtonCategory.FUNCTION),

    BIT_ROL("RoL", ButtonCategory.BITWISE),
    BIT_ROR("RoR", ButtonCategory.BITWISE),
    BIT_OR("Or", ButtonCategory.BITWISE),
    BIT_XOR("Xor", ButtonCategory.BITWISE),
    BIT_NOT("Not", ButtonCategory.BITWISE),
    BIT_AND("And", ButtonCategory.BITWISE),
    BIT_LSHIFT("Lsh", ButtonCategory.BITWISE),
    BIT_RSHIFT("Rsh", ButtonCategory.BITWISE),

    MEM_CLEAR("MC", ButtonCategory.MEMORY),
    MEM_RECALL("MR", ButtonCategory.MEMORY),
    MEM_STORE("MS", ButtonCategory.MEMORY),
    MEM_ADD("M+", ButtonCategory.MEMORY),
    MEM_SUBTRACT("M−", ButtonCategory.MEMORY),

    CTRL_CLEAR_ENTRY("CE", ButtonCategory.CONTROL),
    CTRL_CLEAR("C", ButtonCategory.CONTROL),
    CTRL_BACKSPACE("←", ButtonCategory.CONTROL),
    CTRL_EQUALS("=", ButtonCategory.CONTROL),

    BLANK("", ButtonCategory.BLANK);

    public final String label;
    public final ButtonCategory category;

    CalculatorButton(String label, ButtonCategory category) {
        this.label = label;
        this.category = category;
    }
}
