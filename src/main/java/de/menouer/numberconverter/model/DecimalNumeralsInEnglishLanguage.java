package de.menouer.numberconverter.model;

public enum DecimalNumeralsInEnglishLanguage {
	
	ZERO(0, "0",  ""),
	ONE(1, "1", "One"),
	TWO(2, "2", "Two"),
	THREE(3, "3", "Three"),
	FOUR(4, "4", "Four"),
	FIVE(5, "5", "Five"),
	SIX(6, "6", "Six"),
	SEVEN(7, "7", "Seven"),
	EIGHT(8, "8", "Eight"),
	NINE(9, "9", "Nine"),
	
	TEN(10, "10", "Ten"),
	ELEVEN(11, "11", "Eleven"),
	TWELVE(12, "12", "Twelve"),
	THIRTEEN(13, "13", "Thirteen"),
	FOURTEEN(14, "14", "Fourteen"),
	FIFTEEN(15, "15", "Fifteen"),
	SIXTEEN(16, "16", "Sixteen"),
	SEVENTEEN(17, "17", "Seventeen"),
	EIGHTTEEN(18, "18", "Eightteen"),
	NINETEEN(19, "19", "Nineteen"),
	
	TWENTY(20, "20", "Twenty"),
	THIRTY(30, "30", "Thirty"),
	FOURTY(40, "40", "Fourty"),
	FIFTY(50, "50", "Fifty"),
	SIXTY(60, "60", "Sixty"),
	SEVENTY(70, "70", "Seventy"),
	EIGHTY(80, "80", "Eighty"),
	NINETY(90, "90", "Ninety"),
	;
	
	
	DecimalNumeralsInEnglishLanguage(int decimalValue, String decimalValueAsString, String wordInEnglishLanguage) {
        this.decimalValue = decimalValue;
        this.decimalValueAsString = decimalValueAsString;
        this.wordInEnglishLanguage = wordInEnglishLanguage;
    }

    private int decimalValue;
    private String decimalValueAsString;
    private String wordInEnglishLanguage;
    
	public int getDecimalValue() {
		return decimalValue;
	}
	public String getWordInEnglishLanguage() {
		return wordInEnglishLanguage;
	}
	
	public String getDecimalValueAsString() {
		return decimalValueAsString;
	}
    
}
