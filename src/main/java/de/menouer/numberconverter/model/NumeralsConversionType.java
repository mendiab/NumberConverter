package de.menouer.numberconverter.model;

public enum NumeralsConversionType {
	DECIMAL_TO_ROMAN("Decimal To Roman Numerals Conversion"), 
	BINARY_TO_ROMAN("Binary To Roman Numerals Conversion"), 
	ROMAN_TO_ENGLISH_LANGUAGE("Roman To English Language Conversion"),
	;

	private String description;

	NumeralsConversionType(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
}
