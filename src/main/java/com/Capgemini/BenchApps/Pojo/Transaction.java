package com.Capgemini.BenchApps.Pojo;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Transaction {
	
	
	private String customerId;
	private BigDecimal amount;
    private LocalDate transactionDate;

    public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public LocalDate getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(LocalDate transactionDate) {
		this.transactionDate = transactionDate;
	}
	
}
