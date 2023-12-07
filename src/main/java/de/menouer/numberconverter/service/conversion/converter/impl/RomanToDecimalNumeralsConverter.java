package de.menouer.numberconverter.service.conversion.converter.impl;

import de.menouer.numberconverter.model.RomanNumeral;
import de.menouer.numberconverter.service.conversion.converter.NumeralsConverter;

/**
 * Menouer-Notes: Should be used for in {@link RomanNumeralsToEnglishLanguageNumbersConverter}
 */
public class RomanToDecimalNumeralsConverter implements NumeralsConverter {

	@Override
	public String convert(String numberToConvertAsString) {
		StringBuilder romanNumber = new StringBuilder(numberToConvertAsString);
		int conversionResult = convertWithRecursion(romanNumber);
		return String.valueOf(conversionResult);
	}

	private int convertWithRecursion(StringBuilder romanNumber) {

		if (romanNumber.length() == 0) {
			return 0;
		}

		RomanNumeral longestRomanNumeral = getLongestMostSignificantRomanNumeral(
				romanNumber);

		removeMostSignificantRomanNumeral(romanNumber, longestRomanNumeral);
		
		return longestRomanNumeral.getDecimalValue() + convertWithRecursion(romanNumber);

	}

	private void removeMostSignificantRomanNumeral(StringBuilder romanNumber, RomanNumeral maxRomanSymbol) {
		romanNumber.delete(0, maxRomanSymbol.getRomanDigitSymbols().length());
	}

	private RomanNumeral getLongestMostSignificantRomanNumeral(
			StringBuilder romanNumber) {
		RomanNumeral longestRomanNumeral = null;

		for (RomanNumeral romanNumeral : RomanNumeral.values()) {
			if (romanNumber.indexOf(romanNumeral.getRomanDigitSymbols(), 0) == 0) {
				if (longestRomanNumeral == null || romanNumeral
						.getRomanDigitSymbols().length() > longestRomanNumeral
								.getRomanDigitSymbols().length()) {
					longestRomanNumeral = romanNumeral;
				}
			}
		}
		return longestRomanNumeral;
	}
	
	

}
