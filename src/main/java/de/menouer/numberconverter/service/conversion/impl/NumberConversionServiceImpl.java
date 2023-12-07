package de.menouer.numberconverter.service.conversion.impl;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import de.menouer.numberconverter.api.dto.ApiConversionRequestDto;
import de.menouer.numberconverter.api.dto.ApiConversionResponseDto;
import de.menouer.numberconverter.model.AuditLog;
import de.menouer.numberconverter.model.NumeralsConversionType;
import de.menouer.numberconverter.repository.AuditLogRepository;
import de.menouer.numberconverter.service.conversion.NumberConversionService;
import de.menouer.numberconverter.service.conversion.converter.NumeralsConverter;
import de.menouer.numberconverter.service.conversion.converter.impl.RadixToRomanNumeralsConverter;
import de.menouer.numberconverter.service.conversion.converter.impl.RomanNumeralsToEnglishLanguageNumbersConverter;

@Service
public class NumberConversionServiceImpl implements NumberConversionService {

    private final AuditLogRepository auditLogRepository;

    public NumberConversionServiceImpl(AuditLogRepository auditLogRepository) {
        this.auditLogRepository = auditLogRepository;
    }

    @Override
    public ApiConversionResponseDto processConversionRequest(ApiConversionRequestDto conversionRequestDto) {
        NumeralsConverter converter = createConverter(conversionRequestDto.conversionType());
        String conversionResult = converter.convert(conversionRequestDto.numberToConvert());
        saveAuditLog(conversionRequestDto, conversionResult);
        return new ApiConversionResponseDto(conversionResult);
    }

    private void saveAuditLog(ApiConversionRequestDto conversionRequestDto, String conversionResult) {
        AuditLog auditLog = new AuditLog();
        NumeralsConversionType type = NumeralsConversionType.valueOf(conversionRequestDto.conversionType());
        auditLog.setConversionType(type);
        auditLog.setCreateDate(LocalDateTime.now());
        auditLog.setNumberToConvert(conversionRequestDto.numberToConvert());
        auditLog.setConversionResult(conversionResult);
        auditLogRepository.save(auditLog);
    }

    private NumeralsConverter createConverter(String conversionType) {
        NumeralsConversionType type = NumeralsConversionType.valueOf(conversionType);
        return switch(type) {
            case DECIMAL_TO_ROMAN -> new RadixToRomanNumeralsConverter(10);
            case BINARY_TO_ROMAN -> new RadixToRomanNumeralsConverter(2);
            case ROMAN_TO_ENGLISH_LANGUAGE -> new RomanNumeralsToEnglishLanguageNumbersConverter();
        };
    }

}
