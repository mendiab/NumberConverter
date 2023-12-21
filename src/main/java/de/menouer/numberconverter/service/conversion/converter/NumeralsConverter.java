package de.menouer.numberconverter.service.conversion.converter;

import de.menouer.numberconverter.model.NumeralsConversionType;

public interface NumeralsConverter {
	String convert(String numberToConvertAsString);

	boolean isMatching(NumeralsConversionType type);
}
