package de.menouer.numberconverter.service.conversion.converter.impl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import de.menouer.numberconverter.service.conversion.converter.NumeralsConverter;

class RomanNumeralsToEnglishLanguageNumbersConverterTest {

	@Test
	void romanXShouldBeConvertedToDecimal10() {
		NumeralsConverter converter = new RomanNumeralsToEnglishLanguageNumbersConverter();
		String result = converter.convert("X");
		assertEquals("Ten ", result);
	}
	
	@Test
	void romanMMXXXIShouldBeConvertedToDecimal2031() {
		NumeralsConverter converter = new RomanNumeralsToEnglishLanguageNumbersConverter();
		String result = converter.convert("MMXXXI");
		assertEquals("Two Thousand Thirty One ", result);
	}
	
	@Test
	void romanMMMXXIShouldBeConvertedToDecimal3021() {
		NumeralsConverter converter = new RomanNumeralsToEnglishLanguageNumbersConverter();
		String result = converter.convert("MMMXXI");
		assertEquals("Three Thousand Twenty One ", result);
	}
	
	@Test
	void romanCMXIIShouldBeConvertedToDecimal912() {
		NumeralsConverter converter = new RomanNumeralsToEnglishLanguageNumbersConverter();
		String result = converter.convert("CMXII");
		assertEquals("Nine Hundred Twelve ", result);
	}

}
