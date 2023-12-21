package de.menouer.numberconverter.service.conversion.converter.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RomanNumeralsToEnglishLanguageNumbersConverterTest {
	
	@Autowired
	private RomanNumeralsToEnglishLanguageNumbersConverter converter;

	@Test
	void romanXShouldBeConvertedToDecimal10() {
		String result = converter.convert("X");
		assertEquals("Ten ", result);
	}
	
	@Test
	void romanMMXXXIShouldBeConvertedToDecimal2031() {
		String result = converter.convert("MMXXXI");
		assertEquals("Two Thousand Thirty One ", result);
	}
	
	@Test
	void romanMMMXXIShouldBeConvertedToDecimal3021() {
		String result = converter.convert("MMMXXI");
		assertEquals("Three Thousand Twenty One ", result);
	}
	
	@Test
	void romanCMXIIShouldBeConvertedToDecimal912() {
		String result = converter.convert("CMXII");
		assertEquals("Nine Hundred Twelve ", result);
	}

}
