package de.menouer.numberconverter.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import de.menouer.numberconverter.model.AuditLog;

public interface AuditLogRepository extends JpaRepository<AuditLog, Long> {}
