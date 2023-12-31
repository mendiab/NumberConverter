package de.menouer.numberconverter.service.conversion.converter.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RomanToDecimalNumeralsConverterTest {
	
	@Autowired
	private RomanToDecimalNumeralsConverter converter;

	@Test
	void romanXShouldBeConvertedToDecimal10() {
		String result = converter.convert("X");
		assertEquals("10", result);
	}
	
	@Test
	void romanMMXXXIShouldBeConvertedToDecimal2031() {
		String result = converter.convert("MMXXXI");
		assertEquals("2031", result);
	}

}
