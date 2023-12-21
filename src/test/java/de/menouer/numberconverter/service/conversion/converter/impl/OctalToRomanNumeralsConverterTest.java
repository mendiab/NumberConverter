package de.menouer.numberconverter.service.conversion.converter.impl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class OctalToRomanNumeralsConverterTest {

	@Autowired
	private OctalToRomanNumeralsConverter converter;

	@Test
	void octal10ShouldBeConvertedVIII() {
		String result = converter.convert("10");
		assertEquals("VIII", result);
	}
	
	@Test
	void octal11ShouldBeConvertedToIX() {
		String result = converter.convert("11");
		assertEquals("IX", result);
	}

}
