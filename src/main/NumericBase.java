package main;

public enum NumericBase {
    HEX(16, "0123456789ABCDEF"),
    DEC(10, "0123456789"),
    OCT(8, "01234567"),
    BIN(2, "01");
    
    private final int base;
    private final String allowedChars;
    
    NumericBase(int base, String allowedChars) {
        this.base = base;
        this.allowedChars = allowedChars;
    }
    
    public int getBase() {
        return base;
    }
    
    public boolean isValidChar(char c) {
        return allowedChars.indexOf(Character.toUpperCase(c)) >= 0;
    }
    
    public String filterInput(String input) {
        StringBuilder filtered = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char c = Character.toUpperCase(input.charAt(i));

            if (c == '-' && i == 0) {
                filtered.append(c);
            } else if (isValidChar(c)) {
                filtered.append(c);
            }
        }
        return filtered.toString();
    }
}
