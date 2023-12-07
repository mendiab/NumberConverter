package de.menouer.numberconverter.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class AuditLog {

	@Id
	@GeneratedValue
	private Long id;

	@Enumerated(EnumType.STRING)
	private NumeralsConversionType conversionType;

	private LocalDateTime createDate;
	private String numberToConvert;
	private String conversionResult;
	
	public Long getId() {
		return id;
	}

	public NumeralsConversionType getConversionType() {
		return conversionType;
	}

	public void setConversionType(NumeralsConversionType conversionType) {
		this.conversionType = conversionType;
	}

	public LocalDateTime getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDateTime createDate) {
		this.createDate = createDate;
	}

	public String getNumberToConvert() {
		return numberToConvert;
	}

	public void setNumberToConvert(String numberToConvert) {
		this.numberToConvert = numberToConvert;
	}

	public String getConversionResult() {
		return conversionResult;
	}

	public void setConversionResult(String conversionResult) {
		this.conversionResult = conversionResult;
	}

}
