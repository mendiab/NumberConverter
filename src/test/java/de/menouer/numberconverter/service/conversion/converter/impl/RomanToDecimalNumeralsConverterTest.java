package de.menouer.numberconverter.service.conversion.converter.impl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import de.menouer.numberconverter.service.conversion.converter.NumeralsConverter;

class RomanToDecimalNumeralsConverterTest {

	@Test
	void romanXShouldBeConvertedToDecimal10() {
		NumeralsConverter converter = new RomanToDecimalNumeralsConverter();
		String result = converter.convert("X");
		assertEquals("10", result);
	}
	
	@Test
	void romanMMXXXIShouldBeConvertedToDecimal2031() {
		NumeralsConverter converter = new RomanToDecimalNumeralsConverter();
		String result = converter.convert("MMXXXI");
		assertEquals("2031", result);
	}

}
