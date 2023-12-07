package de.menouer.numberconverter.api;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.menouer.numberconverter.api.dto.ApiConversionRequestDto;
import de.menouer.numberconverter.api.dto.ApiConversionResponseDto;
import de.menouer.numberconverter.api.dto.ApiConversionTypesResponseDto;
import de.menouer.numberconverter.model.NumeralsConversionType;
import de.menouer.numberconverter.service.conversion.NumberConversionService;
import de.menouer.numberconverter.service.convesiontype.NumeralConversionTypeService;

@RestController
@RequestMapping("api")
public class NumberConverterApi {

	private final NumberConversionService numberConversionService;
	private final NumeralConversionTypeService conversionTypeService;

	public NumberConverterApi(NumberConversionService numberConversionService,
			NumeralConversionTypeService conversionTypeService) {

		this.conversionTypeService = conversionTypeService;
		this.numberConversionService = numberConversionService;
	}

	@GetMapping(value = "/converters", produces = "application/json")
	public List<ApiConversionTypesResponseDto> getConversionTypes() {
		return mapToDto(conversionTypeService.getConversionTypes());
	}

	private List<ApiConversionTypesResponseDto> mapToDto(
			NumeralsConversionType[] conversionTypes) {
		return Arrays.stream(conversionTypes)
				.map(type -> new ApiConversionTypesResponseDto(type.name(),
						type.getDescription()))
				.collect(Collectors.toList());
	}

	@PostMapping(path = "/conversion", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiConversionResponseDto convert(
			@RequestBody ApiConversionRequestDto requestDto) {
		return numberConversionService.processConversionRequest(requestDto);
	}

}
