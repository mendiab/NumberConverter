package de.menouer.numberconverter.service.conversion.converter.impl;

import de.menouer.numberconverter.model.DecimalNumeralsInEnglishLanguage;
import de.menouer.numberconverter.service.conversion.converter.NumeralsConverter;

public class RomanNumeralsToEnglishLanguageNumbersConverter
		implements
			NumeralsConverter {

	@Override
	public String convert(String romaNumeralToConvertAsString) {		
		RomanToDecimalNumeralsConverter romanToDecimalConverter = new RomanToDecimalNumeralsConverter();
		String convertedNumberInDecimal = romanToDecimalConverter.convert(romaNumeralToConvertAsString);
		int numberInDecimal = Integer.parseInt(convertedNumberInDecimal);
		if (numberInDecimal == 0) {
			return "Zero";
		}
		return convertWithRecursion(convertedNumberInDecimal);
	}
	
	private String convertWithRecursion(String convertedNumberInDecimal) {
		
		if (Integer.parseInt(convertedNumberInDecimal) == 0) {
			return "";
		}
		
		int currentTenPower = convertedNumberInDecimal.length() - 1;
		if ( currentTenPower % 3 == 2) {
			for (DecimalNumeralsInEnglishLanguage n : DecimalNumeralsInEnglishLanguage.values()) {
				if (
					n.getDecimalValueAsString().charAt(0) == convertedNumberInDecimal.charAt(0)
					&& n.getDecimalValueAsString().length() == 1
					) {
					int numberInDecimal = Integer.parseInt(convertedNumberInDecimal) - (int)Math.pow(10, currentTenPower)*n.getDecimalValue();
					return String.format("%s Hundred ", n.getWordInEnglishLanguage()) + convertWithRecursion(String.valueOf(numberInDecimal));
				}
			}
		}
		
		DecimalNumeralsInEnglishLanguage decimalNumeral = null;
		if (currentTenPower % 3 == 1) {
			for (DecimalNumeralsInEnglishLanguage n : DecimalNumeralsInEnglishLanguage.values()) {
				if (convertedNumberInDecimal.indexOf(n.getDecimalValueAsString(), 0) == 0) {
					if (decimalNumeral == null || decimalNumeral.getDecimalValue() < n.getDecimalValue()) {
						if (n.getDecimalValue() > 1 && n.getDecimalValueAsString().length() == 1) {
							decimalNumeral = findNumeralWithValue(10*n.getDecimalValue());
						} else {
							decimalNumeral = n;
						}
					}
				}
			}
			int numberInDecimal = Integer.parseInt(convertedNumberInDecimal) - (int)Math.pow(10, currentTenPower + 1 - decimalNumeral.getDecimalValueAsString().length())*decimalNumeral.getDecimalValue();
			String unit = decimalNumeral.getDecimalValueAsString().length() == 2 && currentTenPower > 1 ? "Thousand" : "";
			if (unit.isEmpty()) {
				return String.format("%s ", decimalNumeral.getWordInEnglishLanguage()) + convertWithRecursion(String.valueOf(numberInDecimal));
			} else {
				return String.format("%s %s ", decimalNumeral.getWordInEnglishLanguage(), unit) + convertWithRecursion(String.valueOf(numberInDecimal));
			}
			
		}
		
		if (currentTenPower % 3 == 0) {
			for (DecimalNumeralsInEnglishLanguage n : DecimalNumeralsInEnglishLanguage.values()) {
				if (
					n.getDecimalValueAsString().charAt(0) == convertedNumberInDecimal.charAt(0)
					&& n.getDecimalValueAsString().length() == 1
					) {
					int numberInDecimal = Integer.parseInt(convertedNumberInDecimal) - (int)Math.pow(10, currentTenPower)*n.getDecimalValue();
					String unit = currentTenPower > 2 ? "Thousand" : "";
					
					if (unit.isEmpty()) {
						return String.format("%s ", n.getWordInEnglishLanguage()) + convertWithRecursion(String.valueOf(numberInDecimal));
					} else {
						return String.format("%s %s ", n.getWordInEnglishLanguage(), unit) + convertWithRecursion(String.valueOf(numberInDecimal));
					}
					
				}
			}			
		}
		
		throw new IllegalArgumentException("DecimalNumeralsInEnglishLanguage not found");
		
	}

	private DecimalNumeralsInEnglishLanguage findNumeralWithValue(int n) {
		for (DecimalNumeralsInEnglishLanguage numeral : DecimalNumeralsInEnglishLanguage.values()) {
			if (numeral.getDecimalValue() == n) {
				return numeral;
			}
		}
		throw new IllegalArgumentException("DecimalNumeralsInEnglishLanguage not found");
	}

}
