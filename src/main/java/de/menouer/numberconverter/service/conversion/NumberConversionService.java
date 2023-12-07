package de.menouer.numberconverter.service.conversion;

import de.menouer.numberconverter.api.dto.ApiConversionRequestDto;
import de.menouer.numberconverter.api.dto.ApiConversionResponseDto;

public interface NumberConversionService {
	ApiConversionResponseDto processConversionRequest(ApiConversionRequestDto conversionRequestDto);
}
