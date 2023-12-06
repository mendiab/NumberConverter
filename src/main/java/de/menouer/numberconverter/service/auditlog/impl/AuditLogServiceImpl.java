package de.menouer.numberconverter.service.auditlog.impl;

import de.menouer.numberconverter.model.AuditLog;
import de.menouer.numberconverter.repository.AuditLogRepository;
import de.menouer.numberconverter.service.auditlog.AuditLogService;

public class AuditLogServiceImpl implements AuditLogService {
	
	private final AuditLogRepository repository;
	
	public AuditLogServiceImpl(AuditLogRepository repository) {
		this.repository = repository;
	}

	@Override
	public void saveAuditLog(AuditLog auditLog) {
		repository.save(auditLog);
	}
	
}
