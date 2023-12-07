package de.menouer.numberconverter.model;

public enum RomanNumeral {
	
    THOUSAND(1000, "M"),
    NINE_HUNDRED(900, "CM"),
    FIVE_HUNDRED(500, "D"),
    FOUR_HUNDRED(400, "CD"),
    HUNDRED(100, "C"),
    NINETY(90, "XC"),
    FIFTY(50, "L"),
    FORTY(40, "XL"),
    TEN(10, "X"),
    NINE(9, "IX"),
    FIVE(5, "V"),
    FOUR(4, "IV"),
    ONE(1, "I"),
    ;

    RomanNumeral(int decimalValue, String romanDigit) {
        this.decimalValue = decimalValue;
        this.romanDigitSymbols = romanDigit;
    }

    private int decimalValue;
    private String romanDigitSymbols;

    public int getDecimalValue() {
        return decimalValue;
    }

    public String getRomanDigitSymbols() {
        return romanDigitSymbols;
    }
    
}
