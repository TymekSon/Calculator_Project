package main;

public enum WordSize {
    BYTE(8, "Byte"),
    WORD(16, "Word"),
    DWORD(32, "DWord"),
    QWORD(64, "QWord");
    
    private final int bits;
    private final String displayName;
    
    WordSize(int bits, String displayName) {
        this.bits = bits;
        this.displayName = displayName;
    }
    
    public int getBits() {
        return bits;
    }
    
    public String getDisplayName() {
        return displayName;
    }
    
    public long getMaxValue() {
        return (1L << bits) - 1;
    }
    
    public long getMask() {
        return getMaxValue();
    }
}
