package de.menouer.numberconverter.service.conversion.converter.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DecimalToRomanNumeralsConverterTest {
	
	@Autowired
	private DecimalToRomanNumeralsConverter converter;

	@Test
	void decimalTenShouldBeConvertedToX() {
		String result = converter.convert("10");
		assertEquals("X", result);
	}
	
	@Test
	void decimalTwoThousandThirtyOneShouldBeConvertedToMMXXXI() {
		String result = converter.convert("2031");
		assertEquals("MMXXXI", result);
	}

}
