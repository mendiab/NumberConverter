package de.menouer.numberconverter.service.conversion.converter.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import de.menouer.numberconverter.service.conversion.converter.NumeralsConverter;

class RadixToRomanNumeralsConverterTest {

	@Test
	void decimalTenShouldBeConvertedToX() {
		NumeralsConverter converter = new RadixToRomanNumeralsConverter(10);
		String result = converter.convert("10");
		assertEquals("X", result);
	}
	
	@Test
	void decimalTwoThousandThirtyOneShouldBeConvertedToMMXXXI() {
		NumeralsConverter converter = new RadixToRomanNumeralsConverter(10);
		String result = converter.convert("2031");
		assertEquals("MMXXXI", result);
	}
	
	@Test
	void binary1000ShouldBeConvertedToVIII() {
		NumeralsConverter converter = new RadixToRomanNumeralsConverter(2);
		String result = converter.convert("1000");
		assertEquals("VIII", result);
	}
	
	@Test
	void binary1001ShouldBeConvertedToIX() {
		NumeralsConverter converter = new RadixToRomanNumeralsConverter(2);
		String result = converter.convert("1001");
		assertEquals("IX", result);
	}

}
