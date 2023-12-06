package de.menouer.numberconverter.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;

import jakarta.persistence.Entity;

@Entity
public record AuditLog(
		@Id
		Long id,
		String conversionType, 
		LocalDateTime happenedAt,
		String numberToConvert, 
		String conversionResult) {}
