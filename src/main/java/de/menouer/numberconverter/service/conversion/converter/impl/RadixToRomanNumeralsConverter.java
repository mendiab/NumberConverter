package de.menouer.numberconverter.service.conversion.converter.impl;

import org.springframework.stereotype.Service;

import de.menouer.numberconverter.model.RomanNumeral;

@Service
/**
 * Menouer Notes: Could be used to convert a number expressed in any radix (octal, hexa, ...) to roman numerals
 */
public class RadixToRomanNumeralsConverter {

	public String convert(String numberToConvertAsString, int radix) {

		StringBuilder conversionResult = new StringBuilder();
		int numberToConvert = convertStringToNumber(numberToConvertAsString, radix);

		for (RomanNumeral romanNumber : RomanNumeral.values()) {
			int romanNumberDecimalValue = romanNumber.getDecimalValue();

			while (numberToConvert >= romanNumberDecimalValue) {
				numberToConvert -= romanNumberDecimalValue;
				conversionResult.append(romanNumber.getRomanDigitSymbols());
			}

			if (numberToConvert == 0) {
				break;
			}
		}

		return conversionResult.toString();

	}

	private int convertStringToNumber(String numberToConvertAsString, int radix) {
		int numberToConvert = Integer.parseInt(numberToConvertAsString, radix);
		return numberToConvert;
	}

}
