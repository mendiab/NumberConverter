package de.menouer.numberconverter.service.auditlog;

import de.menouer.numberconverter.model.AuditLog;

public interface AuditLogService {
	void saveAuditLog(AuditLog auditLog);
}
