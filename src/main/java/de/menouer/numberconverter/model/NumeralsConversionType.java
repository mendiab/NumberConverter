package de.menouer.numberconverter.model;

public enum NumeralsConversionType {
	DECIMAL_TO_ROMAN("Decimal To Roman Numerals Conversion"), 
	BINARY_TO_ROMAN("Binary To Roman Numerals Conversion"), 
	OCTAL_TO_ROMAN("Octal To Roman Numerals Conversion"),
	ROMAN_TO_ENGLISH_LANGUAGE("Roman To English Language Conversion"),
	// Menouer-Notes: ROMAN_TO_DECIMAL wasn't asked in the challenge.
	// It was just added for UI-Tests. It should be used in RomanNumeralsToEnglishLanguageNumbersConverter
	ROMAN_TO_DECIMAL("Roman To Decimal Numerals Conversion"),
	;

	private String description;

	NumeralsConversionType(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
}
