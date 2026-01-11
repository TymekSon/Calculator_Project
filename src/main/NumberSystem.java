package main;

public enum NumberSystem {
    HEX(16, "0123456789ABCDEF"),
    DEC(10, "0123456789"),
    OCT(8, "01234567"),
    BIN(2, "01");
    
    private final int base;
    private final String allowedChars;
    
    NumberSystem(int base, String allowedChars) {
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
        for (char c : input.toUpperCase().toCharArray()) {
            if (isValidChar(c)) {
                filtered.append(c);
            }
        }
        return filtered.toString();
    }
}
