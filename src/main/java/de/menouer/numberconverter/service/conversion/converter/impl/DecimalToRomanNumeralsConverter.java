package de.menouer.numberconverter.service.conversion.converter.impl;

import org.springframework.stereotype.Service;

import de.menouer.numberconverter.model.NumeralsConversionType;
import de.menouer.numberconverter.service.conversion.converter.NumeralsConverter;

@Service
/**
 * Menouer Notes: Could be used to convert a number expressed in any radix (octal, hexa, ...) to roman numerals
 */
public class DecimalToRomanNumeralsConverter implements NumeralsConverter {
	
	private final RadixToRomanNumeralsConverter radixConverter;
		
	public DecimalToRomanNumeralsConverter(RadixToRomanNumeralsConverter radixConverter) {
		this.radixConverter = radixConverter;
	}

	@Override
	public String convert(String numberToConvertAsString) {
		return radixConverter.convert(numberToConvertAsString, 10);
	}

	@Override
	public boolean isMatching(NumeralsConversionType conversionType) {
		return NumeralsConversionType.DECIMAL_TO_ROMAN == conversionType;
	}

}
