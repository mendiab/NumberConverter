package de.menouer.numberconverter.api;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import de.menouer.numberconverter.api.dto.ApiConversionRequestDto;
import de.menouer.numberconverter.service.auditlog.AuditLogService;

@RestController
public class NumberConverterApi {
	
	private final AuditLogService auditLogService;
	
	public NumberConverterApi(AuditLogService auditLogService) {
		this.auditLogService = auditLogService;
	}
	
	public void convert(@RequestBody ApiConversionRequestDto requestDto) {
		
	}
}
