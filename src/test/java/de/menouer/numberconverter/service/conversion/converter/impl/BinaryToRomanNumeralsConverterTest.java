package de.menouer.numberconverter.service.conversion.converter.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BinaryToRomanNumeralsConverterTest {
	
	@Autowired
	private BinaryToRomanNumeralsConverter converter;

	@Test
	void binary1000ShouldBeConvertedToVIII() {
		String result = converter.convert("1000");
		assertEquals("VIII", result);
	}
	
	@Test
	void binary1001ShouldBeConvertedToIX() {
		String result = converter.convert("1001");
		assertEquals("IX", result);
	}

}
